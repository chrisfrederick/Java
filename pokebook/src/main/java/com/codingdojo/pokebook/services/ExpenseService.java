package com.codingdojo.pokebook.services;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    //Returns all expenses
    public List<Expense> allExpenses(){
        return (List<Expense>)expenseRepository.findAll();
    }

    //creates a new expense
    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    //Finds an expense by ID
    public Expense findExpense(Long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return optionalExpense.get();
        }else{
            return null;
        }
    }

    //Updates an existing expense
    public Expense updateExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    //Deletes an expense by ID
    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }
}
