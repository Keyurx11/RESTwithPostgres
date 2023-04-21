package com.example.restwithpostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StudentDetailsRepository {
    @Autowired
    private StudentDTOService studentDTOService;

    @GetMapping("/studentdetails")
    public List<StudentDTO> getAllStudentDetails() {
        return studentDTOService.getAllStudentDTO();
    }

    @GetMapping("/studentdetails/{id}")
    public StudentDTO getStudentByID(@PathVariable("id") int studentId) {
        StudentDTO sDTO = studentDTOService.getStudentDTOById(studentId);
        if (sDTO != null) {
            return sDTO;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student ID not found.");
    }
}
