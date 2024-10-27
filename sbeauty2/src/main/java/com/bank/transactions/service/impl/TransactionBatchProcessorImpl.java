
package com.bank.transactions.service.impl;

import com.bank.transactions.data.model.Transaction;
import com.bank.transactions.service.TransactionBatchProcessor;
import com.bank.transactions.service.TransactionProcessor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TransactionBatchProcessorImpl implements TransactionBatchProcessor {

    private final TransactionProcessor transactionProcessor;

    public TransactionBatchProcessorImpl(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    @Override
    public void processTransactions(Collection<Transaction> transactions) {
        transactions.parallelStream().forEach(transactionProcessor::processTransaction);
    }
}
