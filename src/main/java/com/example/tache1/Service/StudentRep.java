package com.example.tache1.Service;

import com.example.tache1.Model.Address;
import com.example.tache1.Model.Student;

import java.util.List;

public interface StudentRep {
    Student save(Student student);
    Address save(Address address);
    List<Student> findAllStudents();
    List<Address> findAllAddresses();
    void deleteStudentById(Long id);
    void deleteAddressById(Long id);
    Student findStudentById(Long id);
    Address findAddressById(Long id);
    Student affectAddresses(Long id, List<Long> ida);
    Long totalSutdents();
    Address updateAddress(Long id, Long zipcod);
    Address UpdateAddress(Long id,Address address);



}
