package com.example.tache1.Controller;

import com.example.tache1.Model.Address;
import com.example.tache1.Model.Student;
import com.example.tache1.Service.StudentImplement;
import com.example.tache1.StudentDTO.studentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentImplement studentImplement;

    @PostMapping("/save-student")
    public Student save(@RequestBody Student student) {
        return studentImplement.save(student);
    }

    @PostMapping("/save-address")
    public Address save(@RequestBody Address address) {
        return studentImplement.save(address);
    }

    @PutMapping("/update-address/{id}/{zipcod}")
    public Address updateAddress(@PathVariable("id") Long id, @PathVariable Long zipcod) {
        return studentImplement.updateAddress(id, zipcod);
    }

    @PutMapping("/update-student-affectAddresses/{id}")
    public Student affectAddresses(@PathVariable Long id, @RequestBody List<Long> idAdd) {
        return studentImplement.affectAddresses(id, idAdd);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentImplement.findAllStudents();
    }

    @GetMapping("/find-By-id/{id}")
    public Student findById(@PathVariable Long id) {
        return studentImplement.findById(id);
    }

    @GetMapping("/find-address-By-id/{id}")
    public Address findAddById(@PathVariable Long id) {
        // this is a comment
        return studentImplement.findAddressById(id);
    }

    @GetMapping("/testt")
    public List<studentDto> DtoTest() {
        return studentImplement.DtoTest();
    }

    @GetMapping("/Addresses")
    public List<Address> findAllAddresses() {
        return studentImplement.findAllAddresses();
    }

   @PutMapping("/update-Address/{id}")
    public Address UpdateAddress(@PathVariable Long id, @RequestBody Address address) {
       return studentImplement.UpdateAddress(id, address);
    }

}
