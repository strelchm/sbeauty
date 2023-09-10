package ru.strelchm.sbrackets.stack;

public interface Stack<T, R> {
    void push(T newElement);

    R popIfPossible();

    boolean isEmpty();
}
