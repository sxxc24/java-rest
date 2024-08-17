package com.Destroyer_BLUE.Project.blue1.service;

import com.Destroyer_BLUE.Project.blue1.models.School;
import com.Destroyer_BLUE.Project.blue1.models.Student;
import com.Destroyer_BLUE.Project.blue1.recordsDTO.StudentDTO;
import com.Destroyer_BLUE.Project.blue1.recordsResponse.ResponseStudentDTO;
import com.Destroyer_BLUE.Project.blue1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentMapper {

    private StudentRepository studentRepository;

    @Autowired
    public StudentMapper(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student toStudentDTO(StudentDTO studentDTO) {
        var student = new Student();
        student.setName(studentDTO.std_name());
        student.setMail(studentDTO.std_mail());
        student.setAge(studentDTO.std_age());

        var school = new School();
        school.setId(studentDTO.sch_id());
        student.setSchool(school);

        return student;
    }
    public ResponseStudentDTO toResponseStudentDTO(Student student) {
        return new ResponseStudentDTO(student.getName(),student.getMail(), student.getSchName());
    }
    public List<ResponseStudentDTO> ShowStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toResponseStudentDTO)
                .collect(Collectors.toList());
    }

    public String addStudent(StudentDTO studentDTO) {
        var Student= studentRepository.save(toStudentDTO(studentDTO));
        return "Student id : "+Student.getId();
    }
}
