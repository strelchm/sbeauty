
package com.bank.transactions.service.impl;

import com.bank.transactions.data.model.Transaction;
import com.bank.transactions.service.TransactionProcessorValidator;
import com.bank.transactions.util.Logger;
import org.springframework.stereotype.Component;

import static com.bank.transactions.data.model.TransactionStatus.PENDING;

@Component
public class TransactionProcessorValidatorImpl implements TransactionProcessorValidator {

    private final Logger logger;

    public TransactionProcessorValidatorImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean validate(Transaction transaction) {
        if (!transaction.isPending()) {
            logger.log("Transaction is in %s and is not in %s status".formatted(transaction.getStatus(), PENDING));
            return false;
        }
        if (transaction.hasLargeAmount()) {
            logger.log("Processing large transaction: " + transaction.getId());
        }
        return true;
    }
}
