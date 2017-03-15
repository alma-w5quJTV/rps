package com.almasoft.rps;

import com.almasoft.rps.model.GameRule;
import com.almasoft.rps.model.RPS;
import com.almasoft.rps.model.TakeResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by andrey on 15.03.17.
 */
public class GameTest {
    @Test public void testSolver(){
        GameRule rule = new GameRule();

        Assert.assertEquals(TakeResult.WIN, rule.desideResult(RPS.Paper, RPS.Rock));
        Assert.assertEquals(TakeResult.LOSS, rule.desideResult(RPS.Rock, RPS.Paper));

        Assert.assertEquals(TakeResult.WIN, rule.desideResult(RPS.Scissors, RPS.Paper));
        Assert.assertEquals(TakeResult.LOSS, rule.desideResult(RPS.Paper, RPS.Scissors));

        Assert.assertEquals(TakeResult.WIN, rule.desideResult(RPS.Rock, RPS.Scissors));
        Assert.assertEquals(TakeResult.LOSS, rule.desideResult(RPS.Scissors, RPS.Rock));

        Assert.assertEquals(TakeResult.DRAW, rule.desideResult(RPS.Scissors, RPS.Scissors));
        Assert.assertEquals(TakeResult.DRAW, rule.desideResult(RPS.Rock, RPS.Rock));
        Assert.assertEquals(TakeResult.DRAW, rule.desideResult(RPS.Paper, RPS.Paper));
    }
}
