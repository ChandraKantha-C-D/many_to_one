package many_to_one_uni.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni.dto.School;
import many_to_one_uni.dto.Student;

public class StudentDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
		}
	
	public void saveStudent(Student student ) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		School school=student.getSchool();
		entityManager.merge(school);
		entityManager.merge(student);
		entityTransaction.commit();
	}
	
	public void updateStudent(int student_id , Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Student getStudent = entityManager.find(Student.class, student_id);
		if(getStudent!=null) {
		entityTransaction.begin();
		student.setStudent_id(student_id);
		
		
		entityManager.merge(student);
		
		entityTransaction.commit();
		
		}else {
			System.out.println("School not found");
		}
		}
	public void deleteStudent(int student_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Student getStudent = entityManager.find(Student.class, student_id);
		
		if(getStudent!=null) {
		entityTransaction.begin();
		
		entityManager.remove(getStudent);
		
		
		entityTransaction.commit();
		
		}else {
			System.out.println("School not found");
		}
	}
	public Student getStudentById(int student_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		return entityManager.find(Student.class, student_id);
		
		
	}
	

}


