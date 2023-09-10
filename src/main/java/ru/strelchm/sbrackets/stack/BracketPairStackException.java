package ru.strelchm.sbrackets.stack;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Throws during problems during stack operations
 */
public class BracketPairStackException extends RuntimeException {
    public BracketPairStackException(BracketPairStackExceptionReason reason) {
        super(reason.errorMessage);
    }

    @Getter
    @AllArgsConstructor
    public enum BracketPairStackExceptionReason {
        IS_EMPTY("String contains closed bracket without opened"),
        BRACKETS_WITHOUT_TEXT("String contains brackets without text");

        private final String errorMessage;
    }
}
