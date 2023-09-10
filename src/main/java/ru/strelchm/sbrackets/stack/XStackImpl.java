package ru.strelchm.sbrackets.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

import static ru.strelchm.sbrackets.stack.RemoveOperationResult.RemoveFailureReason.BRACKETS_WITHOUT_TEXT;
import static ru.strelchm.sbrackets.stack.RemoveOperationResult.RemoveFailureReason.IS_EMPTY;

/**
 * Bracket stack
 */
@Slf4j
public class XStackImpl extends LinkedList<BracketPair> implements Stack {
    public void push() {
        this.add(new BracketPair());
    }

    public RemoveOperationResult popIfPossible() {
        if (this.isEmpty()) {
            return RemoveOperationResult.failure(IS_EMPTY);
        }

        if (!this.getLast().isContainsText()) {
            return RemoveOperationResult.failure(BRACKETS_WITHOUT_TEXT);
        }

        this.removeLast();

        return RemoveOperationResult.success();
    }

    public void markAll() {
        this.forEach(BracketPair::mark);
    }
}
