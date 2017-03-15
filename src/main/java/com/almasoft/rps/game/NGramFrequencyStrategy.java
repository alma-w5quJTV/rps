package com.almasoft.rps.game;

import com.almasoft.rps.model.History;
import com.almasoft.rps.model.RPS;
import com.sun.javafx.sg.prism.NGAmbientLight;

import java.util.*;

/**
 * Created by andrey on 15.03.17.
 */
public class NGramFrequencyStrategy implements Strategy {

    // 2-code ngram --> Map {3-code ngram -> NGram}
    private Map<String, Map<String, NGram>> frequency = new HashMap<>();

    @Override
    public RPS makeTheMove(History history) {
        // 1) update frequency if possible
        updateFrequency(history);

        // 2) take 2 last user moves, and chose ngram with highest probability
        NGram current = extractLastTwoMovesNGram(history);
        if(current != null) { //
            //System.out.println("current" + current);
            Map<String, NGram> table = frequency.get(current.code2gram());
            if(table != null) {

                NGram maxProbableNgram = new ArrayList<>(table.values()).stream().max(new Comparator<NGram>() {
                    @Override
                    public int compare(NGram o1, NGram o2) {
                        return o1.freq > o2.freq ? 1 :
                                (o1.freq == o2.freq ? 0 : -1);
                    }
                }).get();

                RPS maxPropableUserTake = RPS.valueOfCode(maxProbableNgram.ngram[2]);
                return RPS.findWinMoveAgainst(maxPropableUserTake);
            }
        }

        // if we have a lack of history just return random move
        return RPS.valueOfOrdinal((int) (Math.random() * 3));
    }

    private NGram extractNgram(History history, int depth) {
        int size = history.size();

        if(size < depth) return null;

        NGram retVal = new NGram();
        retVal.ngram = new char[depth];

        for (int i = 0; i < depth; i ++){
            retVal.ngram[i] =  history.getMove(size - depth + i).userMove.code();
        }
        return retVal;
    }

    private NGram extractLastTwoMovesNGram(History history) {
        return extractNgram(history, 2);
    }

    private void updateFrequency(History history) {
        NGram ngram = extractNgram(history, 3);

        if(ngram != null) {
            //update frq table
            Map<String, NGram> bucket = frequency.get(ngram.code2gram());
            if(bucket == null) {
                bucket = new HashMap<>();
                frequency.put(ngram.code2gram(), bucket);
            }

            NGram tableNgram = bucket.get(ngram.code());
            if(tableNgram == null){
                tableNgram = new NGram(ngram.code());
                bucket.put(ngram.code(), tableNgram);
            }

            tableNgram.freq ++;
            //System.out.println(frequency);
        }
    }
    private class NGram {
        char[] ngram = new char[3];

        int freq = 0;

        public NGram() {
        }

        public NGram(String code) {
            ngram = code.toCharArray();
        }

        public String code2gram() {
            return String.valueOf(new char[]{ngram[0], ngram[1]});
        }
        public String code() {
            return String.valueOf(ngram);
        }

        @Override
        public String toString() {
            return code() +
                    ": " + freq;
        }
    }
}
