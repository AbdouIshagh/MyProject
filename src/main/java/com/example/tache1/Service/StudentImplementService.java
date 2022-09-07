package com.example.tache1.Service;

import com.example.tache1.Model.Address;
import com.example.tache1.Model.Student;
import com.example.tache1.Repository.AddressRepository;
import com.example.tache1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImplementService implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> STUDENT_LIST() {
        return studentRepository.findAll();
    }

    @Override
    public Student update(Long id) {
        Student student1=studentRepository.findById(id).get();
        Student student=new Student();
        student.setFirstName(student1.getFirstName());
        student.setLastName(student1.getLastName());
        student.setDateOfBirth(student1.getDateOfBirth());
        student.setAddressList(student1.getAddressList());
        return student;
    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public Student saveAddress(Student student) {
        return null;
    }

    @Override
    public List<Address> ADDRESS_LIST() {
        return null;
    }

    @Override
    public Address updateAddress(Address address) {
        return null;
    }

    @Override
    public void deleteAddress(Long id) {

    }
}
