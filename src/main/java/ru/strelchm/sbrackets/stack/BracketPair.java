package ru.strelchm.sbrackets.stack;

import lombok.Getter;

@Getter
class BracketPair {
    private boolean containsText = false;

    public void mark() {
        containsText = true;
    }
}
