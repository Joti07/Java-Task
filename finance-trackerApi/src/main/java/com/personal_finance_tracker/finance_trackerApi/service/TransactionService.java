package com.example.finance.service;

import com.example.finance.model.Transaction;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private List<Transaction> transactions = new ArrayList<>();
    private Long nextId = 1L;

    // Create (POST)
    public Transaction addTransaction(Transaction transaction) {
        transaction.setId(nextId++);
        transactions.add(transaction);
        return transaction;
    }

    // Read (GET all)
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    // Read (GET by ID)
    public Transaction getTransactionById(Long id) {
        return transactions.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Update (PUT)
    public Transaction updateTransaction(Long id, Transaction updated) {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            if (t.getId().equals(id)) {
                t.setTitle(updated.getTitle());
                t.setAmount(updated.getAmount());
                t.setType(updated.getType());
                return t;
            }
        }
        return null;
    }

    // Delete (DELETE)
    public boolean deleteTransaction(Long id) {
        return transactions.removeIf(t -> t.getId().equals(id));
    }

    // Optional (Filter by type)
    public List<Transaction> getTransactionsByType(String type) {
        return transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
