package com.example.tache1.Service;

import com.example.tache1.Model.Address;
import com.example.tache1.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student saveStudent(Student student);

    List<Student> STUDENT_LIST();

    Student update(Long id);

    void deleteStudent(Long id);
    Student saveAddress(Student student);

    List<Address> ADDRESS_LIST();

    Address updateAddress(Address address);

    void deleteAddress(Long id);
}
