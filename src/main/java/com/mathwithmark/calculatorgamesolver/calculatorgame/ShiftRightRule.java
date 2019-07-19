package com.mathwithmark.calculatorgamesolver.calculatorgame;

public class ShiftRightRule extends ShiftRule {
    protected void rotate(int[] digits) {
        rotateRight(digits);
    }

    public ShiftRightRule() {
        super(false); // not left
    }
}