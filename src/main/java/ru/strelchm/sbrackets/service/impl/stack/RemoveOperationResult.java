package ru.strelchm.sbrackets.service.impl.stack;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.strelchm.sbrackets.service.impl.stack.RemoveOperationResult.RemoveResultType.FAILED;
import static ru.strelchm.sbrackets.service.impl.stack.RemoveOperationResult.RemoveResultType.SUCCESS;

@AllArgsConstructor
public class RemoveOperationResult {
    private RemoveResultType type;
    private RemoveFailureReason failureReason;

    public RemoveOperationResult(RemoveResultType type) {
        this.type = type;
    }

    public String getErrorMessage() {
        if (isSuccess()) {
            throw new UnsupportedOperationException();
        }
        return failureReason.getErrorMessage();
    }

    public boolean isSuccess() {
        return type == SUCCESS;
    }

    static RemoveOperationResult success() {
        return new RemoveOperationResult(SUCCESS);
    }

    static RemoveOperationResult failure(RemoveFailureReason failureReason) {
        return new RemoveOperationResult(FAILED, failureReason);
    }

    @Getter
    @AllArgsConstructor
    enum RemoveFailureReason {
        IS_EMPTY("String contains closed bracket without opened"),
        BRACKETS_WITHOUT_TEXT("String contains brackets without text");

        private final String errorMessage;
    }

    enum RemoveResultType {
        SUCCESS,
        FAILED;
    }
}
