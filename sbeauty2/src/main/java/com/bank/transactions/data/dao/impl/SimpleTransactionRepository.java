
package com.bank.transactions.data.dao.impl;

import com.bank.transactions.data.dao.TransactionRepository;
import com.bank.transactions.data.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class SimpleTransactionRepository implements TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void updateTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public Collection<Transaction> getTransactions() {
        return transactions;
    }
}

