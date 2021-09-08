package com.example.schoolcoursemanagementsystem.Repository;

import com.example.schoolcoursemanagementsystem.Entity.Guardian;
import com.example.schoolcoursemanagementsystem.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest - Helps flush db after test
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("DavE")
                .lastName("bUBA")
                .studentEmail("davID@gmail.com")
                .studentAge(23)
//                .guardianName("Gbenga")
//                .guardianEmail("gbeng@yahoo.com")
//                .guardianPhoneNumber("99999999999")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void allStudents() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("List of Students  " + studentList);
    }

    @Test
    public void saveWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Mamu Muh")
                .email("dasg@gggnhnj.com")
                .phoneNumber("8674657474")
                .build();
        Student  student = Student.builder()
                .firstName("Naomi")
                .lastName("Akans")
                .studentEmail("nao@hjoH.com")
                .studentAge(23)
                .guardian(guarclear
                        dian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void findStartWithFirstNames(){
        List<Student> students = studentRepository.findByFirstName("Muazu");
        System.out.println("First names "+ students);
    };

    @Test
    public void findBylastName(){
       List<Student> students = studentRepository.findByLastName("mal");
        System.out.println("First name" + students);
    };

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Buharri");
        System.out.println("Guardians names " + students);
    };
//
//    @Test
//    public void findByFirstNameContains(){
//        Student student = (Student) studentRepository.findByFirstNameContain("Ka");
//        System.out.println("Contains First name "+ student);
//    };
//
    @Test
    public void findByLastNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Lst name Not null " + students);
    };

    @Test
    public void getStudentByEmail(){
        Student student = studentRepository.getStudentByEmail("abu@hjo.com");
        System.out.println(student.getFirstName() +" "+ student.getLastName());
    }

    @Test
    public void getStudentFirstNameByEmail(){
        String name = studentRepository.getStudentFirstNameByEmail("abu@hjo.com");
        System.out.println(name);
    }


    @Test
    public void getAllStudent(){
        List<Student> students = studentRepository.getAllStudents();
        System.out.println(students);
    }

    @Test
    public void getAllStudentByFirstName(){
        List<Student> students = studentRepository.getAllStudentsByFirstName("Kali");
        System.out.println(students);
    }

    @Test
    public void getAllStudentByLastNameUsingEmail(){
        String student = studentRepository.getAllStudentsByFirstNameWithEmail("kali@hjoH.com");
        System.out.println(student);
    }

    @Test
    public void changeNFirstNameUsingEmail(){
        studentRepository.updateNameUsingEmail("Adamu","kali@hjoH.com");
    }
}