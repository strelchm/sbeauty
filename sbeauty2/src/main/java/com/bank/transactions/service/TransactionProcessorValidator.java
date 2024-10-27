
package com.bank.transactions.service;

import com.bank.transactions.data.model.Transaction;

public interface TransactionProcessorValidator {

    boolean validateForProcessing(Transaction transaction);
}
