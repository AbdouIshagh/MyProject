package com.example.tache1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_address",joinColumns = @JoinColumn(name = "ids"),
            inverseJoinColumns = @JoinColumn(name = "ida"))
    List<Address> addressList;


}

