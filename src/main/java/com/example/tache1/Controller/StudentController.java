package com.example.tache1.Controller;

import com.example.tache1.Model.Address;
import com.example.tache1.Model.Student;
import com.example.tache1.Service.StudentImplementService;
import com.example.tache1.StudentDTO.studentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    StudentImplementService studentImplementService;

    @PostMapping("/save-student")
    public Student saveStudent(@RequestBody Student student) {
        return studentImplementService.saveStudent(student);
    }

    @GetMapping("/list-student")
    public List<Student> STUDENT_LIST() {
        return studentImplementService.STUDENT_LIST();
    }

    @PutMapping("/update-student/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentImplementService.update(id, student);
    }

    @DeleteMapping("/delete-student")
    public void deleteStudent(@PathVariable Long id) {
        studentImplementService.deleteStudent(id);
    }

    @PostMapping("/save-address")
    public Address saveAddress(@RequestBody Address address) {
        return studentImplementService.saveAddress(address);
    }

    @GetMapping("/list-Address")
    public List<Address> ADDRESS_LIST() {
        return studentImplementService.ADDRESS_LIST();
    }

    @PutMapping("/update-address/{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        return studentImplementService.updateAddress(id, address);
    }

    @DeleteMapping("/delete-address/{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        studentImplementService.deleteAddress(id);
    }

    @PutMapping("/affect-address-to-student/{id}")
    public Student affectSaddressToStudent(@PathVariable("id") Long id, @RequestBody List<Long> idadd) {
        return studentImplementService.affectSaddressToStudent(id, idadd);
    }
    @GetMapping("/list-student-Dto")
    public List<studentDto> getStudentDto(){
        return studentImplementService.getStudentDto();
    }
    @GetMapping("/student-Dto/{id}")
    public studentDto getDtoById(@PathVariable Long id){
        return studentImplementService.getDtoById(id);
    }
}
