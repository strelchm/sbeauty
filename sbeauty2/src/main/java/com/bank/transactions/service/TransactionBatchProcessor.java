package com.bank.transactions.service;

import com.bank.transactions.data.model.Transaction;

import java.util.Collection;

public interface TransactionBatchProcessor {

    void processTransactions(Collection<Transaction> transactions);
}
