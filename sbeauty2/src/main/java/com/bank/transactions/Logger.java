
package com.bank.transactions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Logger {

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
