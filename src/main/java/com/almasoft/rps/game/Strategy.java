package com.almasoft.rps.game;

import com.almasoft.rps.model.History;
import com.almasoft.rps.model.RPS;

/**
 * Created by andrey on 15.03.17.
 */
public interface Strategy {
    RPS makeTheMove(History history);
}
