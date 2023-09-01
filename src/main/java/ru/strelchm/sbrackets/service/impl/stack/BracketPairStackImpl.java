package ru.strelchm.sbrackets.service.impl.stack;

import lombok.extern.slf4j.Slf4j;
import ru.strelchm.sbrackets.model.BracketPair;
import ru.strelchm.sbrackets.service.BracketPairStack;

import java.util.LinkedList;

import static ru.strelchm.sbrackets.service.impl.stack.RemoveOperationResult.RemoveFailureReason.BRACKETS_WITHOUT_TEXT;
import static ru.strelchm.sbrackets.service.impl.stack.RemoveOperationResult.RemoveFailureReason.IS_EMPTY;

/**
 * Bracket stack
 */
@Slf4j
public class BracketPairStackImpl implements BracketPairStack {
    private final LinkedList<BracketPair> stack = new LinkedList<>();

    public void add() {
        stack.add(new BracketPair());
    }

    public RemoveOperationResult remove() {
        if (stack.isEmpty()) {
            return RemoveOperationResult.failure(IS_EMPTY);
        }

        if (!stack.getLast().isContainsText()) {
            return RemoveOperationResult.failure(BRACKETS_WITHOUT_TEXT);
        }

        stack.removeLast();
        return RemoveOperationResult.success();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void markEachElementAsNotEmpty() {
        if (!stack.isEmpty()) {
            stack.forEach(BracketPair::setContainsText);
        }
    }
}
