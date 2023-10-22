package baseball.config;

import baseball.domain.Errors;

public class Config {

    private static final int MAX_NUMBERS = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    static {
        if ( MAX_NUMBERS == 0 || (START_INCLUSIVE + MAX_NUMBERS - 1) > END_INCLUSIVE || MAX_NUMBERS > END_INCLUSIVE) throw new IllegalArgumentException(Errors.MSG_EXCEPTION_INVALID_RANGE);
    }

    public static int getMaxNumbers() {
        return MAX_NUMBERS;
    }

    public static int getStartInclusive() { return START_INCLUSIVE; }

    public static boolean isInvalidRange(int input) {
        return input < getStartInclusive() || input > Config.getEndInclusive();
    }

    public static int getEndInclusive() {
        return END_INCLUSIVE;
    }

}
