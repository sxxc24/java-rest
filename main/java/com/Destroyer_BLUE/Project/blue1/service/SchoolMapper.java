package com.Destroyer_BLUE.Project.blue1.service;

import com.Destroyer_BLUE.Project.blue1.models.School;
import com.Destroyer_BLUE.Project.blue1.recordsDTO.SchoolDTO;
import com.Destroyer_BLUE.Project.blue1.recordsResponse.ResponseSchoolDTO;
import com.Destroyer_BLUE.Project.blue1.repository.SchoolRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolMapper {
    private SchoolRepository schoolRepository;
    public SchoolMapper(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School toSchoolDTO(SchoolDTO schoolDTO) {
        var school = new School();
        school.setName(schoolDTO.sch_name());
        return school;
    }
    public ResponseSchoolDTO toResponseSchoolDTO(School school) {
        return new ResponseSchoolDTO(school.getName());
    }


    public String addSchool(@RequestBody SchoolDTO school) {
        var School = schoolRepository.save(toSchoolDTO(school));
        return "School id : "+School.getId();
    }

    public List<ResponseSchoolDTO> listSchool(){
        return schoolRepository.findAll()
                .stream()
                .map(this::toResponseSchoolDTO)
                .collect(Collectors.toList());
    }
}
