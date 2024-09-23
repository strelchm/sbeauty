package ru.strelchm.sbrackets.stack.impl;

import lombok.extern.slf4j.Slf4j;
import ru.strelchm.sbrackets.stack.BracketPairStack;
import ru.strelchm.sbrackets.stack.BracketPairStackException;
import ru.strelchm.sbrackets.stack.Markable;

import java.util.LinkedList;

import static ru.strelchm.sbrackets.stack.BracketPairStackException.BracketPairStackExceptionReason.BRACKETS_WITHOUT_TEXT;
import static ru.strelchm.sbrackets.stack.BracketPairStackException.BracketPairStackExceptionReason.IS_EMPTY;

/**
 * Bracket stack
 */
@Slf4j
public class BracketPairStackImpl extends LinkedList<BracketPair> implements BracketPairStack {
    @Override
    public BracketPair pop() {
        if (this.isEmpty()) {
            throw new BracketPairStackException(IS_EMPTY);
        } else if (!this.getFirst().isMarked()) {
            throw new BracketPairStackException(BRACKETS_WITHOUT_TEXT);
        }

        return this.removeFirst();
    }

    @Override
    public void markAll() {
        this.forEach(Markable::mark);
    }
}
