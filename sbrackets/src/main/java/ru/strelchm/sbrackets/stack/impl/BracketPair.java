package ru.strelchm.sbrackets.stack.impl;

import lombok.Getter;
import ru.strelchm.sbrackets.stack.Markable;

@Getter
public class BracketPair implements Markable {
    private boolean containsText = false;

    @Override
    public void mark() {
        containsText = true;
    }

    @Override
    public boolean isMarked() {
        return containsText;
    }
}
