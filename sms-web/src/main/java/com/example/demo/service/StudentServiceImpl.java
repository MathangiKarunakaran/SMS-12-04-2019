package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Student;
import com.example.demo.modal.Telephone;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;
	
	
	@Override
	public Student save(Student student) {
		for (Telephone telephone : student.getTelephones()) {
				telephone.setStudent(student);
		}
		return studentRepository.save(student);
	}

	@Override
	public List<Student> fetch() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	public Student fetch(Integer id) {
		Optional <Student> student = studentRepository.findById(id);
		if (student.isPresent())
			return student.get();
		else
			return null;
	}

}
