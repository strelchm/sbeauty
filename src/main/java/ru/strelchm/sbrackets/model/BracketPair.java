package ru.strelchm.sbrackets.model;

import lombok.Getter;

@Getter
public class BracketPair {
    boolean containsText = false;

    public void setContainsText() {
        containsText = true;
    }
}
