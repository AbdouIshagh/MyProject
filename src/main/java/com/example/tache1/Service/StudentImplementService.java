package com.example.tache1.Service;

import com.example.tache1.Model.Address;
import com.example.tache1.Model.Student;
import com.example.tache1.Repository.AddressRepository;
import com.example.tache1.Repository.StudentRepository;
import com.example.tache1.StudentDTO.studentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Student update(Long id,Student student) {
        Student student1 = studentRepository.findById(id).get();
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setDateOfBirth(student.getDateOfBirth());
        student1.setAddressList(student.getAddressList());
        return studentRepository.save(student1);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> ADDRESS_LIST() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Long id,Address address) {
        Address address1=addressRepository.findById(id).get();
        address1.setCountry(address.getCountry());
        address1.setCity(address.getCity());
        address1.setZipCode(address.getZipCode());
        return addressRepository.save(address1);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Student affectSaddressToStudent(Long id, List<Long> idadd) {
        Student student=studentRepository.findById(id).get();
        List<Address>addressList=addressRepository.findAllByIdIn(idadd);
        if (student.getAddressList()!=null){
            student.getAddressList().addAll(addressList);
        }
        else student.setAddressList(addressList);
        return studentRepository.save(student);
    }
    public List<studentDto> getStudentDto(){
       List<Student>students=studentRepository.findAll();
        return students.stream().map(this::stDto).toList();
    }
    public studentDto getDtoById(Long id){
        Student student=studentRepository.findById(id).get();
        return stDto(student);
    }

    private studentDto stDto(Student student){
        studentDto studentDto=new studentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        return studentDto;
    }
}
