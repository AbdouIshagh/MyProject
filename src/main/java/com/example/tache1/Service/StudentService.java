package com.example.tache1.Service;

import com.example.tache1.Model.Address;
import com.example.tache1.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student saveStudent(Student student);

    List<Student> STUDENT_LIST();

    Student update(Long id,Student student);

    void deleteStudent(Long id);
    Address saveAddress(Address address);

    List<Address> ADDRESS_LIST();

    Address updateAddress(Long id,Address address);

    void deleteAddress(Long id);

    Student affectSaddressToStudent(Long id ,List<Long>idAdd);
}
