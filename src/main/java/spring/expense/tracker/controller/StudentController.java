package spring.expense.tracker.controller;

import java.util.Optional;

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

import spring.expense.tracker.model.StudentModel;
import spring.expense.tracker.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping(value = "/student/{id}")
	public Optional getStudent(@PathVariable("id") Long id) {
		return studentRepository.findById(id);
	}
	
	@PostMapping(path = "/register",  
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentModel>registerStudent(@RequestBody String name) {
		try {
		StudentModel newStudent = new StudentModel(name);
		StudentModel student = (StudentModel) studentRepository.save(newStudent);
		return new ResponseEntity<>(student, HttpStatus.CREATED);			
		}catch(Exception e) {
			return null;
		}
	}
}
