package com.example.tache1.Service;

import com.example.tache1.Model.Address;
import com.example.tache1.Model.Student;
import com.example.tache1.Repository.AddressRepository;
import com.example.tache1.Repository.StudentRepository;
import com.example.tache1.StudentDTO.studentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentImplement implements StudentRep {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;


    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Student affectAddresses(Long id, List<Long> idAdd) {
        Student student = studentRepository.findById(id).get();
        List<Address> addresses = addressRepository.findAllByIdIn(idAdd);
        if (student.getAddressList() != null) {
            student.getAddressList().addAll(addresses);
        } else {
            student.setAddressList(addresses);
        }

        return studentRepository.save(student);
    }

    @Override
    public Long totalSutdents() {
        return studentRepository.count();
    }

    @Override
    public Address updateAddress(Long id, Long zipcod) {
        Address address = addressRepository.findById(id).get();
        address.setZipCode(zipcod);
        return addressRepository.save(address);
    }

    public List<studentDto> DtoTest() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertOdTo)
                .collect(Collectors.toList());

    }

    private studentDto convertOdTo(Student student) {
        studentDto studentDto = new studentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setCountry(student.getAddressList().stream().map(Address::getCountry).collect(Collectors.toList()));
        studentDto.setCity(student.getAddressList().stream().map(Address::getCity).collect(Collectors.toList()));
        return studentDto;
    }

}
