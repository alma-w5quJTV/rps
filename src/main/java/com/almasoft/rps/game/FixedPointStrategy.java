package com.almasoft.rps.game;

import com.almasoft.rps.game.Strategy;
import com.almasoft.rps.model.History;
import com.almasoft.rps.model.RPS;

/**
 * Created by andrey on 15.03.17.
 */
public class FixedPointStrategy implements Strategy {
    private final RPS point;

    public FixedPointStrategy(RPS point) {
        this.point = point;
    }

    @Override
    public RPS makeTheMove(History history) {
        return point;
    }
}
