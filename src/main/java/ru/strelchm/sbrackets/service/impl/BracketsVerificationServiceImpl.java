package ru.strelchm.sbrackets.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.strelchm.sbrackets.stack.Stack;
import ru.strelchm.sbrackets.service.BracketsVerificationService;
import ru.strelchm.sbrackets.stack.BracketPairStackImpl;
import ru.strelchm.sbrackets.stack.RemoveOperationResult;

@Slf4j
@Component
public class BracketsVerificationServiceImpl implements BracketsVerificationService {

    public static final char LEFT_PARENTHESES = '(';
    public static final char RIGHT_PARENTHESES = ')';

    @Override
    public boolean verify(@NonNull String text) {
        Stack stack = new BracketPairStackImpl();

        for (char value : text.toCharArray()) {
            switch (value) {
                case LEFT_PARENTHESES -> stack.push();
                case RIGHT_PARENTHESES -> {
                    RemoveOperationResult removeOperationResult = stack.popIfPossible();
                    if (!removeOperationResult.isSuccess()) {
                        log.warn(removeOperationResult.getErrorMessage());
                        return false;
                    }
                }
                default -> stack.markAll();
            }
        }

        boolean empty = stack.isEmpty();
        if (!empty) {
            log.warn("String contains open brackets without closed");
        }
        return empty;
    }
}
