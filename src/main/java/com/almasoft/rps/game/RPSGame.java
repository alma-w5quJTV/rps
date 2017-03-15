package com.almasoft.rps.game;

import com.almasoft.rps.model.GameRule;
import com.almasoft.rps.model.History;
import com.almasoft.rps.model.RPS;
import com.almasoft.rps.model.TakeResult;

/**
 * Stateful object that represents current play session. Holds current robot move, as well as history of user moves.
 * <p>
 * Represents business logic of game rules
 */
public class RPSGame {

    private Strategy strategy = null;
    private History history = new History();
    private GameRule rule = new GameRule();

    private RPS robotMove = null;

    public RPSGame(Strategy strategy) {
        this.strategy = strategy;
    }

    public RPS makeRobotMove() {
        robotMove = strategy.makeTheMove(history);
        return robotMove;
    }

    /**
     * @param userMove
     * @return result from user viewpoint
     */
    public TakeResult makeGameCycle(RPS userMove) {
        if (robotMove == null) {
            throw new IllegalStateException("Robot move has to be done prior call this method");
        }

        history.addMove(robotMove, userMove);

        return rule.desideResult(userMove, robotMove);
    }
}
