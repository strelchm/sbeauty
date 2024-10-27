
package com.bank.transactions.service.impl;

import com.bank.transactions.data.model.Transaction;
import com.bank.transactions.service.TransactionBatchProcessor;
import com.bank.transactions.service.TransactionProcessor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ForkJoinPool;

@Service
public class TransactionBatchProcessorImpl implements TransactionBatchProcessor {

    private final TransactionProcessor transactionProcessor;
    private final ForkJoinPool transactionProcessingThreadPool;

    public TransactionBatchProcessorImpl(TransactionProcessor transactionProcessor, ForkJoinPool transactionProcessingThreadPool) {
        this.transactionProcessor = transactionProcessor;
        this.transactionProcessingThreadPool = transactionProcessingThreadPool;
    }

    @Override
    public void processTransactions(Collection<Transaction> transactions) {
        transactionProcessingThreadPool.execute(() -> {
            transactions.parallelStream()
                    .forEach(transactionProcessor::processTransaction);
        });
    }
}
