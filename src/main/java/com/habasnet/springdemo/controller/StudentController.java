package com.habasnet.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.habasnet.springdemo.model.Student;
import com.habasnet.springdemo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/student")
	public String getStudentForm(Model model) {
		model.addAttribute("studentmodel", new Student());
		return "studentForm";
	}

	@PostMapping(value = "/student")
	public String saveStudent(@ModelAttribute Student student) {

		studentService.addStudent(student);
		return "redirect:/student";
	}

	@GetMapping("/studentList")
	public String getAll(Model model) {

		model.addAttribute("studentList", studentService.getAllStudent());

		return "studentList";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") long sid) {

		studentService.deleteStudent(sid);
		return "redirect:/studentList";
	}

	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") long sid, Model model) {

		model.addAttribute("studentmodel", studentService.getStudentById(sid));

		return "editForm";
	}

	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student) {

		studentService.updateStudent(student);
		return "redirect:/studentList";
	}
}
