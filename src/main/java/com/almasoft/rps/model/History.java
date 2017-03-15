package com.almasoft.rps.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrey on 15.03.17.
 */
public class History {

    List<Move> history = new LinkedList<>();

    public void addMove(RPS robotMove, RPS userMove) {
        history.add(new Move(robotMove, userMove));
    }

    public int size() {
        return history.size();
    }

    public Move getMove(int i) {
        return history.get(i);
    }

    public static class Move {
        public RPS robotMove;
        public RPS userMove;
        public Move(RPS robotMove, RPS userMove) {
            this.robotMove = robotMove;
            this.userMove = userMove;
        }
    }
}
