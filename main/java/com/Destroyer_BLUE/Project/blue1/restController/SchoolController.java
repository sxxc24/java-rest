package com.Destroyer_BLUE.Project.blue1.restController;

import com.Destroyer_BLUE.Project.blue1.recordsDTO.SchoolDTO;
import com.Destroyer_BLUE.Project.blue1.recordsResponse.ResponseSchoolDTO;
import com.Destroyer_BLUE.Project.blue1.service.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {


    private SchoolMapper schoolMapper;

    @Autowired
    public SchoolController(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    @PostMapping("school/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String saveSchool(@RequestBody SchoolDTO school) {
     return schoolMapper.addSchool(school);
    }

    @GetMapping("school/get")
    public List<ResponseSchoolDTO> showSchool(){
        return schoolMapper.listSchool();
    }

}
