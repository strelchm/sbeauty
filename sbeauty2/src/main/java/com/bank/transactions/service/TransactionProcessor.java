
package com.bank.transactions.service;

import com.bank.transactions.data.model.Transaction;

public interface TransactionProcessor {

    void processTransaction(Transaction transaction);
}
