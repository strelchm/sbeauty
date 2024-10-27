package com.bank.transactions;

import com.bank.transactions.data.model.Transaction;
import com.bank.transactions.service.TransactionBatchProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.bank.transactions.data.model.TransactionStatus.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransactionProcessorTest {

    @Autowired
    private TransactionBatchProcessor transactionBatchProcessor;

    @Test
    void testProcessTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1", BigDecimal.valueOf(5000), "2023-01-01", PENDING));
        transactions.add(new Transaction("2", BigDecimal.valueOf(15000), "2023-01-02", PENDING));
        transactions.add(new Transaction("3", BigDecimal.valueOf(2000), "2023-01-03", COMPLETED));

        transactionBatchProcessor.processTransactions(transactions);

        assertEquals(PROCESSED, transactions.get(0).getStatus());
        assertEquals(PROCESSED, transactions.get(1).getStatus());
        assertEquals(COMPLETED, transactions.get(2).getStatus());
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getId() + " Status: " + transaction.getStatus());
        }
    }

    @Test
    void testProcessTransactions1() {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            transactions.add(new Transaction(getRandomString(), BigDecimal.valueOf(5000), "2023-01-01", PENDING));
        }
        for (int i = 0; i < 1000_000; i++) {
            transactions.add(new Transaction(getRandomString(), BigDecimal.valueOf(5000), "2023-01-01", PENDING));
        }

        System.err.println(LocalDateTime.now());
        transactionBatchProcessor.processTransactions(transactions);
        System.err.println(LocalDateTime.now());
//        assertEquals(PROCESSED, transactions.get(0).getStatus());
    }

    private String getRandomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

}
