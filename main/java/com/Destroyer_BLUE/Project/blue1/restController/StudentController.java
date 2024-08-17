package com.Destroyer_BLUE.Project.blue1.restController;

import com.Destroyer_BLUE.Project.blue1.recordsDTO.StudentDTO;
import com.Destroyer_BLUE.Project.blue1.recordsResponse.ResponseStudentDTO;
import com.Destroyer_BLUE.Project.blue1.service.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    private StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @PostMapping("student/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String SaveStudent(@RequestBody StudentDTO studentDTO) {
       return studentMapper.addStudent(studentDTO);
    }


    @GetMapping("student/get")
    public List<ResponseStudentDTO> getStudents() {
        return studentMapper.ShowStudents();
    }


}
