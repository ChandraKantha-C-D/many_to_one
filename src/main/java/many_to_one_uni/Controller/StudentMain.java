package many_to_one_uni.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni.dto.School;
import many_to_one_uni.dto.Student;

public class StudentMain {

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setStudent_name("Ram");
		student1.setAddress("Bng");
		
		Student student2 = new Student();
		student2.setStudent_name("Ram");
		student2.setAddress("Bng");
		
		Student student3 = new Student();
		student3.setStudent_name("Ram");
		student3.setAddress("Bng");
		
		School school = new School();
		school.setSchool_name("Sai Angel's");
		school.setSchool_fee("50000");
		school.setLandmark("Bng");
		
		student1.setSchool(school);
		student2.setSchool(school);
		student3.setSchool(school);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.merge(school);
		entityManager.merge(student1);
		entityManager.merge(student2);
		entityManager.merge(student3);
	
		entityTransaction.commit();
		

	}

}
