package com.bank.transactions.service.impl;

import com.bank.transactions.data.dao.TransactionRepository;
import com.bank.transactions.service.TransactionProcessor;
import com.bank.transactions.service.TransactionProcessorValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class TransactionProcessorImplUnitTest {
    private final TransactionRepository repositoryMock = mock(TransactionRepository.class);
    private final TransactionProcessorValidator validatorMock = mock(TransactionProcessorValidator.class);

    private final TransactionProcessor transactionProcessor = new TransactionProcessorImpl(repositoryMock, validatorMock);

    @Test
    void checkNullTransactionProcess() {
        assertDoesNotThrow(() -> transactionProcessor.processTransaction(null));
    }
}