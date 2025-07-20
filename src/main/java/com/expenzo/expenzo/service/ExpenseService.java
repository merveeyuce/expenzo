package com.expenzo.expenzo.service;

import com.expenzo.expenzo.entity.Expense;
import java.util.List;

/**
 * Service interface for Expense operations.
 * Defines business logic methods related to Expense entity.
 */
public interface ExpenseService {
    /**
     * Adds a new expense record.
     * @param expense Expense object to add.
     * @return The saved Expense.
     */
    Expense addExpense(Expense expense);

    /**
     * Retrieves all expenses for a given user ID.
     * @param userId ID of the user.
     * @return List of expenses.
     */
    List<Expense> getExpensesByUserId(Long userId);

    /**
     * Deletes an expense by its ID.
     * @param expenseId ID of the expense to delete.
     */
    void deleteExpense(Long expenseId);

    /**
     * Updates an existing expense.
     * @param expense Expense object with updated data.
     * @return Updated Expense object.
     */
    Expense updateExpense(Expense expense);
}
