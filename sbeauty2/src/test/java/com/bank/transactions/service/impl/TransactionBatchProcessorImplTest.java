package com.bank.transactions.service.impl;

import com.bank.transactions.data.model.Transaction;
import com.bank.transactions.service.TransactionBatchProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.bank.transactions.data.model.TransactionStatus.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionBatchProcessorImplTest {

    @Autowired
    private TransactionBatchProcessor transactionBatchProcessor;

    @Test
    void testProcessTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1", BigDecimal.valueOf(5000), LocalDate.parse("2023-01-01"), PENDING));
        transactions.add(new Transaction("2", BigDecimal.valueOf(15000), LocalDate.parse("2023-01-02"), PENDING));
        transactions.add(new Transaction("3", BigDecimal.valueOf(2000), LocalDate.parse("2023-01-03"), COMPLETED));

        transactionBatchProcessor.processTransactions(transactions);

        assertEquals(PROCESSED, transactions.get(0).getStatus());
        assertEquals(PROCESSED, transactions.get(1).getStatus());
        assertEquals(COMPLETED, transactions.get(2).getStatus());
    }
}