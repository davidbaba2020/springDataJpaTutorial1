package com.example.schoolcoursemanagementsystem.Repository;

import com.example.schoolcoursemanagementsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByLastNameNotNull();
//    List<StudentRepository> findByFirstNameContain(String firstName);
    List<Student> findByGuardianName(String guardinName);

    //JPQL
    @Query("SELECT s FROM Student s WHERE s.studentEmail =?1")
    Student getStudentByEmail(String Email);

    //JPQL
    @Query("SELECT s.firstName FROM Student s WHERE s.studentEmail =?1")
    String getStudentFirstNameByEmail(String Email);


    //Native Querry to DB
    @Query(
            value = "SELECT * FROM tbl_student",
            nativeQuery = true
    )
    List<Student> getAllStudents();

    //Native Querry to DB
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.first_name =?1",
            nativeQuery = true
    )
    List<Student> getAllStudentsByFirstName(String firstName);

    //Natiive named param
    @Query(
            value = "SELECT s.first_name FROM tbl_student s WHERE s.student_email= :emailId",
            nativeQuery = true
    )
    String getAllStudentsByFirstNameWithEmail(@Param("emailId") String emailId);

    //Natiive named param for update
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name =?1 WHERE student_email= ?2",
            nativeQuery = true
    )
    int updateNameUsingEmail(String firstName, String studentEmail);
}

