package rules;

import base.Config;
import base.Game;

public class SubtractRule extends Rule {
    public Game apply(Game game) {
        return new Game(
            game.getValue() - getOperand1(),
            game.getGoal(),
            game.getMovesLeft() - 1,
            game.getValidRules(),
            game.getPortals()
        );
    }

    public SubtractRule(int operand1) {
        super(Config.SUBTRACT, operand1);
    }
}
