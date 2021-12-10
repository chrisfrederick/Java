package com.codingdojo.pokebook.controllers;


import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expense/new")
    public String newExpense(@ModelAttribute("expense") Expense expense){
        return "new.jsp";
    }

    @PostMapping("/expenses")
    public String create(
            @Valid
            @ModelAttribute("expense") Expense expense, BindingResult result){
        if(result.hasErrors()){
            return "new.jsp";
        }else{
            expenseService.createExpense(expense);
            return "redirect:/expense";
        }
    }

    @GetMapping("/expense/{expenseId}")
    public String getExpenseById(
            Model model,
            @PathVariable(value = "expenseId")Long expenseID
    ){
        Expense expense = expenseService.findExpense(expenseID);
        model.addAttribute("expense", expense);
        return "index.jsp";
    }


    @GetMapping("/expense")
    public String index(Model model){
        List<Expense> expense = expenseService.allExpenses();
        model.addAttribute("expense", expense);
        return "index.jsp";
    }

    @GetMapping("/expense/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }

    @PutMapping("/expense/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result){
        if(result.hasErrors()){
            return "edit.jsp";
        }else{
            System.out.println(expense.getId());
            expenseService.updateExpense(expense);
            return "redirect:/expense";
        }
    }
}
