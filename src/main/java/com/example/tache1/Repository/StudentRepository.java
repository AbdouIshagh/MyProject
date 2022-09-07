package com.example.tache1.Repository;

import com.example.tache1.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findAllByIdIn(List<Long> ids);

    @Query(nativeQuery = true, value = "SELECT * FROM STUDENT WHERE ID IN(:id) ")
    Student findStudentId(Long id);

    @Query(nativeQuery = true, value = "select S.id, S.first_Name, S.last_Name, S.date_of_birth, A.country, A.city, A.zip_code\n" +
            "FROM student S\n" +
            "JOIN student_address_list sal on S.id = sal.student_id\n" +
            "    JOIN address a on a.id = sal.address_list_id\n" +
            "WHERE country like (:country)")
    List<Student> FindByCountry(String country);
}
