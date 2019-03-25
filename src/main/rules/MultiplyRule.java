package rules;

import base.Config;
import base.Game;

public class MultiplyRule extends Rule {
    public Game apply(Game game) {
        return new Game(
            game.getValue() * getOperand1(),
            game.getGoal(),
            game.getMovesLeft() - 1,
            game.getValidRules(),
            game.getPortals()
        );
    }

    public MultiplyRule(int operand1) {
        super(Config.MULTIPLY, operand1);
    }
}