package com.almasoft.rps.model;

/**
 * Created by andrey on 15.03.17.
 */
public class GameRule {
    /**
     * Desides whether a wins, loss, or draw b
     */
    public TakeResult desideResult(RPS a, RPS b) {
        return a == b ? TakeResult.DRAW :
                (a.wins(b) ? TakeResult.WIN : TakeResult.LOSS);
    }
}
