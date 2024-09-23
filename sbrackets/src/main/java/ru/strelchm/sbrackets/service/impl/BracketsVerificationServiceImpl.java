package ru.strelchm.sbrackets.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.strelchm.sbrackets.service.BracketsVerificationService;
import ru.strelchm.sbrackets.stack.BracketPairStackException;
import ru.strelchm.sbrackets.stack.impl.BracketPair;
import ru.strelchm.sbrackets.stack.BracketPairStack;
import ru.strelchm.sbrackets.stack.impl.BracketPairStackImpl;

@Slf4j
@Component
public class BracketsVerificationServiceImpl implements BracketsVerificationService {

    public static final char LEFT_PARENTHESES = '(';
    public static final char RIGHT_PARENTHESES = ')';

    @Override
    public boolean verify(@NonNull String text) {
        BracketPairStack stack = new BracketPairStackImpl();
        String errorMessage = null;

        try {
            for (char value : text.toCharArray()) {
                switch (value) {
                    case LEFT_PARENTHESES -> stack.push(new BracketPair());
                    case RIGHT_PARENTHESES -> stack.pop();
                    default -> stack.markAll();
                }
            }
        } catch (BracketPairStackException ex) {
            errorMessage = ex.getMessage();
        }

        boolean error = errorMessage != null;
        if (!error && !stack.isEmpty()) {
            errorMessage = "String contains open brackets without closed";
            error = true;
        }

        if (error) {
            log.warn(errorMessage);
        }

        return !error;
    }
}
