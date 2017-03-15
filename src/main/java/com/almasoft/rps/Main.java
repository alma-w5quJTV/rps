package com.almasoft.rps;

import com.almasoft.rps.game.NGramFrequencyStrategy;
import com.almasoft.rps.game.RPSGame;
import com.almasoft.rps.game.FixedPointStrategy;
import com.almasoft.rps.model.RPS;

/**
 * Created by andrey on 15.03.17.
 */
public class Main {

    public static void main(String[] args) {
//        RPSGame game = new RPSGame(new FixedPointStrategy(RPS.Paper));
        RPSGame game = new RPSGame(new NGramFrequencyStrategy());

        new Cli(game).start();
    }
}
