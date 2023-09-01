package ru.strelchm.sbrackets.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.strelchm.sbrackets.service.BracketsVerificationService;
import ru.strelchm.sbrackets.service.impl.stack.BracketPairStackImpl;
import ru.strelchm.sbrackets.service.impl.stack.RemoveOperationResult;

@Slf4j
@Component
public class BracketsVerificationServiceImpl implements BracketsVerificationService {

    public static final char LEFT_PARENTHESES = '(';
    public static final char RIGHT_PARENTHESES = ')';

    @Override
    public boolean verify(@NonNull String text) {
        BracketPairStackImpl stack = new BracketPairStackImpl();

        for (char value : text.toCharArray()) {
            if (value == LEFT_PARENTHESES) {
                stack.add();
            } else if (value == RIGHT_PARENTHESES) {
                RemoveOperationResult removeOperationResult = stack.remove();
                if (!removeOperationResult.isSuccess()) {
                    log.warn(removeOperationResult.getErrorMessage());
                    return false;
                }
            } else {
                stack.markEachElementAsNotEmpty();
            }
        }

        boolean empty = stack.isEmpty();
        if (!empty) {
            log.warn("String contains open brackets without closed");
        }
        return empty;
    }
}
