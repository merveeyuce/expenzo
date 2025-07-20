package com.expenzo.expenzo.service.impl;

import com.expenzo.expenzo.entity.Expense;
import com.expenzo.expenzo.repository.ExpenseRepository;
import com.expenzo.expenzo.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of ExpenseService interface.
 * Contains business logic for managing Expense entities.
 */
@Service
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        Optional<Expense> existingExpenseOpt = expenseRepository.findById(expense.getId());
        if (existingExpenseOpt.isPresent()) {
            Expense existingExpense = existingExpenseOpt.get();

            if (expense.getUser() != null &&
                    !existingExpense.getUser().getId().equals(expense.getUser().getId())) {
                throw new IllegalArgumentException("Cannot change the owner of the expense");
            }

            existingExpense.setAmount(expense.getAmount());
            existingExpense.setDate(expense.getDate());
            existingExpense.setDescription(expense.getDescription());

            return expenseRepository.save(existingExpense);
        }else {
            throw new RuntimeException("Expense not found with id " + expense.getId());
        }
    }
}
