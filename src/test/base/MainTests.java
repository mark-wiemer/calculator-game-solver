package base;

import org.junit.jupiter.api.Test;

import java.util.List;

import base.CalculatorGame;
import base.Main;
import base.State;
import rules.Rule;
import rules.StoreRule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class MainTests {
    @Test
    void testCleanUp() {
        boolean[] appliedArray = { false, false, true, true, false };
        Rule storeRule = new StoreRule(0);
        List<State> list = new ArrayList<State>();
        list.add(new State(new CalculatorGame(
            0, // must be 0, always pad 0s => no limit, always valid
            1, // must not be 0 => game never is over
            appliedArray.length,
            new Rule[] {
                storeRule
            },
            null
        )));

        // Construct list of states
        for (boolean applied : appliedArray) {
            State last = list.get(list.size() - 1);
            CalculatorGame lastGame = last.getGame();
            CalculatorGame successorGame = null;
            if (applied) successorGame = storeRule.apply(lastGame);
            else successorGame = storeRule.update(lastGame);
            String transitionString = CalculatorGame.transitionString(
                storeRule,
                applied
            );
            State successorState = new State(
                successorGame,
                last,
                transitionString
            );
            list.add(successorState);
        }

        Main.cleanUp(list);

        assertEquals(4, list.size());
    }
}
