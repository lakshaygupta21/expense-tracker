package spring.expense.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.expense.tracker.model.Expense;
import spring.expense.tracker.model.StudentModel;
import spring.expense.tracker.repository.ExpenseRepository;

@RestController
public class ExpenseController {

	
	@Autowired
	public ExpenseRepository expenseRepository;
	
	
	@GetMapping(value = "/get-expenses/{id}")
	public List<Expense> getAllExpensesOfStudent(@PathVariable("id") Long id){
		return expenseRepository.findAllByStudentId(id);
	}
	
	@PostMapping(path = "/create-expense",  
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Expense>createExpense(@RequestBody Expense expenseBody) {
		try {		
		Expense expense = (Expense) expenseRepository.save(expenseBody);
		return new ResponseEntity<>(expense, HttpStatus.CREATED);			
		}catch(Exception e) {
			return null;
		}
	}
}
