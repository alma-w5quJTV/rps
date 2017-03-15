package com.almasoft.rps.model;

/**
 * Created by andrey on 15.03.17.
 */
public enum RPS {
    Rock('r', 0),
    Paper('p', 1),
    Scissors('s', 2);

    private final char code;
    private final int ordinal;

    RPS(char code, int ordinal) {
        this.code = code;
        this.ordinal = ordinal;
    }

    public char code() {
        return code;
    }
    /**
     * @param arg
     * @return true if this item beats passed as argument item
     */
    boolean wins(RPS arg) {
        switch (this) {
            case Rock:
                return arg == Scissors;
            case Paper:
                return arg == Rock;
            case Scissors:
                return arg == Paper;
        }
        throw new IllegalArgumentException();
    }

    /**
     *
     * @return move that wins userTake
     */
    public static RPS findWinMoveAgainst(RPS userTake) {
        switch (userTake) {
            case Rock:
                return Paper;
            case Paper:
                return Scissors;
            case Scissors:
                return Rock;
        }
        throw new IllegalArgumentException();
    }
    public static RPS valueOfCode(char c) {
        switch (c) {
            case 'r':
            case 'R':
                return Rock;
            case 'p':
            case 'P':
                return Paper;
            case 's':
            case 'S':
                return Scissors;
        }
        throw new IllegalArgumentException();
    }
    public static RPS valueOfOrdinal(int ord) {
        switch (ord) {
            case 0:
                return Rock;
            case 1:
                return Paper;
            case 2:
                return Scissors;
        }
        throw new IllegalArgumentException();
    }


}
