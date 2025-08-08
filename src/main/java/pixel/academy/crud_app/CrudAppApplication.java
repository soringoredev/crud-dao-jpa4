package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};

	}

	private void createStudent(StudentDAO studentDAO) {

		// cream un obiect Student
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("John","Doe", "john@pixelacademy.md");

		// salvam obiectul Student in baza de date folosind DAO
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		// afisam ID-ul studentului salvat
		System.out.println("Saved student. Generated id: " + newStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 st");
		Student nasureSt109 = new Student("Maloren", "Levit", "iep@p.djrd");
		Student nasure4St109 = new Student("Maloren", "Levit", "iep@p.djrd");

		System.out.println("Savex");
	studentDAO.save(nasure4St109);
	studentDAO.save(nasureSt109);

	}


}
