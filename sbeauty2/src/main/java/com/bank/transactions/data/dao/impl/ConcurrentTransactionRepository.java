
package com.bank.transactions.data.dao.impl;

import com.bank.transactions.data.dao.TransactionRepository;
import com.bank.transactions.data.model.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.Collection;
import java.util.Map;

@Primary
@Repository
public class ConcurrentTransactionRepository implements TransactionRepository {

    private final Map<String, Transaction> transactions = new ConcurrentReferenceHashMap<>();

    @Override
    public void updateTransaction(Transaction transaction) {
        transactions.put(transaction.getId(), transaction);
    }

    @Override
    public Collection<Transaction> getTransactions() {
        return transactions.values();
    }
}
