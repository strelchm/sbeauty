package com.bank.transactions.load;

import com.bank.transactions.data.model.Transaction;
import com.bank.transactions.service.TransactionBatchProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.bank.transactions.data.model.TransactionStatus.PENDING;
import static com.bank.transactions.utils.RandomObjectGenerator.getRandomString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class TransactionProcessLoadTest {

    @Autowired
    private TransactionBatchProcessor transactionBatchProcessor;

    @Test
    void testProcessTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            transactions.add(new Transaction(getRandomString(), BigDecimal.valueOf(5000), LocalDate.parse("2023-01-01"), PENDING));
        }
        for (int i = 0; i < 1_000_000; i++) {
            transactions.add(new Transaction(getRandomString(), BigDecimal.valueOf(1000), LocalDate.parse("2023-04-05"), PENDING));
        }

        assertDoesNotThrow(() -> transactionBatchProcessor.processTransactions(transactions));
    }
}
