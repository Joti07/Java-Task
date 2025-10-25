package com.example.finance.controller;

import com.example.finance.model.Transaction;
import com.example.finance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    // 1 GET all
    @GetMapping
    public List<Transaction> getAllTransactions(@RequestParam(required = false) String type) {
        if (type != null) {
            return service.getTransactionsByType(type);
        }
        return service.getAllTransactions();
    }

    // 2 GET by ID
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    // 3 POST (Add)
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }

    // 4 PUT (Update)
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return service.updateTransaction(id, transaction);
    }

    // 5 DELETE
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        boolean removed = service.deleteTransaction(id);
        return removed ? "Transaction deleted successfully!" : "Transaction not found!";
    }
}
