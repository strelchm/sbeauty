package com.bank.transactions.service.impl.batch;

import com.bank.transactions.data.model.Transaction;
import com.bank.transactions.service.TransactionBatchProcessor;
import com.bank.transactions.service.TransactionProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@ConditionalOnProperty(prefix = "transaction.processor", name = "type", havingValue = "SIMPLE")
public class SimpleTransactionBatchConcurrentProcessorImpl implements TransactionBatchProcessor {

    private final TransactionProcessor transactionProcessor;

    public SimpleTransactionBatchConcurrentProcessorImpl(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    @Override
    public void processTransactions(Collection<Transaction> transactions) {
        transactions.forEach(transactionProcessor::processTransaction);
    }
}
