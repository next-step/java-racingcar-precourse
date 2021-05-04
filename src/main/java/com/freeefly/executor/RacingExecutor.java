package com.freeefly.executor;

import com.freeefly.util.RNG;

import static com.freeefly.config.RacingConfig.PROCEED_NUMBER_BOUND;
import static com.freeefly.config.RacingConfig.PROCEED_SUCCESS_NUMBER_BOUND;

public class RacingExecutor {
    public Boolean proceed(Integer proceedNumber) {
        if (proceedNumber >= PROCEED_SUCCESS_NUMBER_BOUND) {
            return true;
        }
        return false;
    }
}
