package com.test.student.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.model.Clase;
import com.test.model.Student;

@Service
public class StudentService {
	
	private static List<Student> students = new ArrayList<Student>();
	private static int studentCount = 3;
	
	private static List<Clase> clases = new ArrayList<Clase>();
	private static List<Clase> clasesNew = new ArrayList<Clase>();


	static {
		clases.add(new Clase("MAT-001", "Calculo I", "Area de Matemáticas primer nivel"));
		clases.add(new Clase("FIS-001", "Fisica I", "Area de Física primer nivel"));
		clases.add(new Clase("MAT-103", "Estadística I", "Area de Matemáticas - Estadística"));
	}

	static {
		students.add(new Student(1, "Urizar Orquides", "Paola", clases));
		students.add(new Student(2, "Perez Soto", "Juan", clases));
		students.add(new Student(3, "Quispe", "Maria", clases));
	}

	public List<Student> retrieveStudents() {
		/*List<Estudent> filteredTodos = new ArrayList<Estudent>();
		for (Estudent student : students) {
			if (student.getUser().equals(user))
				filteredTodos.add(todo);
		}*/
		return students;
	}

	public void addStudent(String lastName, String firstName) {
		students.add(new Student(++studentCount, lastName, firstName, clasesNew));
	}

	public void deleteStudent(int id) {
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Student retrieveStudent(int id) {
		for (Student student : students) {
			if (student.getId() == id)
				return student;
		}
		return null;
	}
	
	public void updateStudent(Student student) {
		for (Student stud : students) {
		if (stud.getId() == student.getId())
			students.remove(stud);
		}
		students.add(student);
	}
}