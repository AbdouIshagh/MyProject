package com.example.tache1.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class studentDto {
    private Long id;
    private String firstName;
    private List<String> country;
    private List<String>  city;
}
