package spring.expense.tracker.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.expense.tracker.model.Due;
import spring.expense.tracker.model.Expense;
import spring.expense.tracker.repository.DueRepository;

@RestController
public class DueController {

	@Autowired
	private DueRepository dueRepository;
	
	@GetMapping(value = "/get-dues/{id}/{due_type}")
	public List<Due> getAllDuesOfStudent(@PathVariable("id") Long id, @PathVariable("due_type") String due_type){
		
		//due_type = fifo
		if(due_type.equals("fifo"))
		return dueRepository.findAllByStudentIdOrderByCreatedAtAsc(id);
		
		
		//due_type = lifo
		if(due_type.equals("lifo"))
		return dueRepository.findAllByStudentIdOrderByCreatedAtDesc(id);
		
		return dueRepository.findAllByStudentId(id);
		
		
		
	}
	
	@PostMapping(value="/create-due", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Due> recordDue(@RequestBody Due dueBody) {
		try {		
			Due due = (Due) dueRepository.save(dueBody);
			return new ResponseEntity<>(due, HttpStatus.CREATED);			
			}catch(Exception e) {
				return null;
			}
	}
	
	
	
	@PutMapping(value="/settle-dues", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Due> settleDues(@Valid @RequestBody Due dueBody) {
		try {		
			Due due =  dueRepository.findById(dueBody.getId()).orElseThrow(()-> new Exception());
			due.setAmount(0);
			
			final Due dueUpdated = dueRepository.save(due);
			return new ResponseEntity<>(dueUpdated, HttpStatus.CREATED);			
			}catch(Exception e) {
				return null;
			}
	}
}
