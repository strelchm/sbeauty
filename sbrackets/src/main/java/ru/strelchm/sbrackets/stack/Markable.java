package ru.strelchm.sbrackets.stack;

/**
 * Provides possibility of marking element for later finding marked elements in collection
 */
public interface Markable {
    void mark();

    boolean isMarked();
}
