package ru.strelchm.sbrackets.stack;

/**
 * Stack of elements
 * @param <E> - element type
 */
public interface Stack<E> {
    void push(E newElement);

    E pop();

    boolean isEmpty();
}
