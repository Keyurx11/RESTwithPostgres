package com.example.restwithpostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentDTOService {
    @Autowired
    private StudentRepository studentRepository;

    private StudentDTO convertToStudentDTO(Student student) {
        StudentDTO sDTO = new StudentDTO();
        sDTO.setStudentid(student.getId());
        sDTO.setName(student.getName());
        sDTO.setAddress(student.getAddress());
        sDTO.setDob(student.getDob());
        sDTO.setShortcode(student.getCourse().getdegreetype().getShortcode());
        sDTO.setCoursename(student.getCourse().getcoursename().getcoursename());
        return sDTO;
    }

    //Return all students in the StudentDTO format
    public List<StudentDTO> getAllStudentDTO() {
        return ((List<Student>) studentRepository.findAll()).stream().map(this::convertToStudentDTO).collect(Collectors.toList());
    }

    //Return a single student by ID
    public StudentDTO getStudentDTOById(int id) {
        List<StudentDTO> studentDTOList = getAllStudentDTO();
        for (StudentDTO sDTO : studentDTOList) {
            if (sDTO.getStudentid() == id) {
                return sDTO;
            }
        }
        return null;
    }
}
