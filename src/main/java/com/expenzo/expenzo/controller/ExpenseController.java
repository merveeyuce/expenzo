package com.expenzo.expenzo.controller;

import com.expenzo.expenzo.entity.Expense;
import com.expenzo.expenzo.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ExpenseController handles HTTP requests related to expense operations.
 * All operations are delegated to the ExpenseService.
 */
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    /**
     * Creates a new expense.
     * @param expense The expense to be created
     * @return The created expense with HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense createdExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
    }

    /**
     * Retrieves all expenses for a specific user.
     * @param userId ID of the user
     * @return List of expenses with HTTP 200 status
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getExpensesByUser(@PathVariable Long userId) {
        List<Expense> expenses = expenseService.getExpensesByUserId(userId);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    /**
     * Updates an existing expense by its ID.
     * @param id ID of the expense to update
     * @param expense Updated expense data
     * @return The updated expense with HTTP 200 status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        expense.setId(id);
        Expense updatedExpense = expenseService.updateExpense(expense);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }

    /**
     * Deletes an expense by its ID.
     * @param id ID of the expense to delete
     * @return HTTP 204 No Content if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
