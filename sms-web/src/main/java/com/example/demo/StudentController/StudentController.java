package com.example.demo.StudentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Course;
import com.example.demo.modal.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value ="/smscloud")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/student", method = RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		
		return studentService.save(student);
	}
	
	@RequestMapping(value="/student", method = RequestMethod.GET)
	public List<Student> fetch(){
		return  studentService.fetch();
	}
	
	/*@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> fetch(@PathVariable Integer id){
		if (id<=0) {
			return ResponseEntity.badRequest().build();
		}
		else {
			Student student =  studentService.fetch(id);
			if(student == null)
				return ResponseEntity.notFound().build();
			else 
				return ResponseEntity.ok(student);
		}
		
	}*/
	
	@RequestMapping(value="/student/{id}/course", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> fetch(@PathVariable Integer id){
		if (id<=0) {
			return ResponseEntity.badRequest().build();
		}
		else {
			Student student =  studentService.fetch(id);
			if(student == null)
				return ResponseEntity.notFound().build();
			else 
				return ResponseEntity.ok(student.getCourses());
		}
		
	}

}