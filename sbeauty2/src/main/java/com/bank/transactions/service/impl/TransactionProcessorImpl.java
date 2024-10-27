
package com.bank.transactions.service.impl;

import com.bank.transactions.data.dao.TransactionRepository;
import com.bank.transactions.data.model.Transaction;
import com.bank.transactions.service.TransactionProcessor;
import com.bank.transactions.service.TransactionProcessorValidator;
import com.bank.transactions.util.Logger;
import org.springframework.stereotype.Component;

import static com.bank.transactions.data.model.TransactionStatus.*;

@Component
public class TransactionProcessorImpl implements TransactionProcessor {

    private final TransactionRepository repository;
    private final TransactionProcessorValidator validator;
    private final Logger logger;

    public TransactionProcessorImpl(TransactionRepository repository, TransactionProcessorValidator validator, Logger logger) {
        this.repository = repository;
        this.validator = validator;
        this.logger = logger;
    }

//    @Async
    @Override
    public void processTransaction(Transaction transaction) {
        if (validator.validate(transaction)) {
            return;
        }
        try {
            transaction.setStatus(IN_PROGRESS);
            repository.updateTransaction(transaction);
            transaction.setStatus(PROCESSED);
        } catch (Exception e) {
            transaction.setStatus(ERROR);
            logger.log("Error processing transaction: " + e.getMessage());
        }
    }
}
