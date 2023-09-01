package ru.strelchm.sbrackets.service;

import ru.strelchm.sbrackets.service.impl.stack.RemoveOperationResult;

public interface BracketPairStack {
    void add();

    RemoveOperationResult remove();

    boolean isEmpty();

    void markEachElementAsNotEmpty();
}
