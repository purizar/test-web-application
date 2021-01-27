package com.test.student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.clase.service.ClaseService;
import com.test.model.Clase;
import com.test.model.Student;
import com.test.student.service.StudentService;

@Controller
@SessionAttributes("name")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private ClaseService serviceClase;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	

	@RequestMapping(value = "/list-students", method = RequestMethod.GET)
	public String showStudentsList(ModelMap model) {
		model.addAttribute("students", service.retrieveStudents());
		return "list-students";
	}
		
	@RequestMapping(value = "/add-student", method = RequestMethod.GET)
	public String showStudentPage(ModelMap model) {
		model.addAttribute("student", new Student(0,"","", new ArrayList<Clase>()));
		return "student";
	}

	@RequestMapping(value = "/add-student", method = RequestMethod.POST)
	public String addStudent(ModelMap model, @Valid Student student, BindingResult result) {
		
		if (result.hasErrors())
			return "student";
		
		service.addStudent(student.getLastName(), student.getFirstName());
				
		model.clear();
		return "redirect:/list-students";
	}
	
	@RequestMapping(value = "/delete-student", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam int id) {
		service.deleteStudent(id);

		return "redirect:/list-students";
	}
	
	@RequestMapping(value = "/update-student", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("student", service.retrieveStudent(id));
		return "student";
	}

	@RequestMapping(value = "/update-student", method = RequestMethod.POST)
	public String updateStudent(ModelMap model, @Valid Student student,
			BindingResult result) {
		if (result.hasErrors())
			return "student";
		
		service.updateStudent(student);

		model.clear();
		return "redirect:/list-students";
	}
	
	@RequestMapping(value = "/asig-clases", method = RequestMethod.GET)
	public String showAsigClases(ModelMap model) {
		model.addAttribute("students", service.retrieveStudents());
		return "list-students-asig";
	}
	
	@RequestMapping(value = "/assign-classes", method = RequestMethod.GET)
	public String showAsigClasesSt(ModelMap model, @RequestParam int id) {
		model.addAttribute("student", service.retrieveStudent(id));
		return "list-student-clases";
	}
	
	@RequestMapping(value = "/add-clase-student", method = RequestMethod.GET)
	public String showClasesStudent(ModelMap model, @RequestParam int id) {
		
		Student student= service.retrieveStudent(id);
		List<Clase> vAllClases = 	serviceClase.retrieveClases();
		List<Clase> vNewClases = 	new ArrayList<Clase>();
		System.out.println(id);
		for (Clase clase : vAllClases) {
			for (Clase claseEst : student.getClases()) {
				if (!clase.getCode().equalsIgnoreCase(claseEst.getCode())) {
					vNewClases.add(clase);
					
				}
		    }
		}
		
		Iterator<Clase> iterator = vNewClases.iterator();
		while (iterator.hasNext()) {
			Clase clase = iterator.next();
			System.out.println(clase.getCode());
		}
		model.addAttribute("student", student);
		model.addAttribute("clases", vNewClases);
		return "asign-clases";
	}
	
	@RequestMapping(value = "/add-clase-student", method = RequestMethod.POST)
	public String asigClasesStudent(ModelMap model,@RequestParam int idStudent, @RequestParam String[] codes) {
		
		Student student= service.retrieveStudent(idStudent);
		
		//List<String> listCodes = codes;
		for (String code : codes) {
			Clase clase =  serviceClase.retrieveClase(code);
			student.getClases().add(clase);

		}
		
		model.addAttribute("student", student);

		return "list-student-clases";
	}
	
	@RequestMapping(value = "/delete-clase-student", method = RequestMethod.GET)
	public String deleteClasesStudent(ModelMap model, @RequestParam int id, @RequestParam String code) {
		
		Student student= service.retrieveStudent(id);
		
		Iterator<Clase> iterator = student.getClases().iterator();
		while (iterator.hasNext()) {
			Clase clase = iterator.next();
			if (clase.getCode().equalsIgnoreCase(code)) {
				iterator.remove();
			}
		}
			
		model.addAttribute("student", student);
		return "list-student-clases";
	}
	

}