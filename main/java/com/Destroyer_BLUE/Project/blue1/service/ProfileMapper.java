package com.Destroyer_BLUE.Project.blue1.service;

import com.Destroyer_BLUE.Project.blue1.models.Student;
import com.Destroyer_BLUE.Project.blue1.models.StudentProfile;
import com.Destroyer_BLUE.Project.blue1.recordsDTO.StudentProfileDTO;
import com.Destroyer_BLUE.Project.blue1.recordsResponse.ResponseStudentProfileDTO;
import com.Destroyer_BLUE.Project.blue1.repository.StudentProfileRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileMapper {
    private StudentProfileRepo studentProfileRepo;
    public ProfileMapper(StudentProfileRepo studentProfileRepo) {
        this.studentProfileRepo = studentProfileRepo;
    }

    public StudentProfile toStudentProfileDTO(StudentProfileDTO studentProfileDTO) {
        var studentProfile = new StudentProfile();
        studentProfile.setBio(studentProfileDTO.pro_bio());
        var student = new Student();
        student.setId(studentProfileDTO.std_id());
        studentProfile.setStudent(student);
        return studentProfile;
    }

    public ResponseStudentProfileDTO toResponseStudentProfileDTO(StudentProfile studentProfile) {
        return new ResponseStudentProfileDTO(studentProfile.getStdId(),studentProfile.getBio(),studentProfile.getName());
    }

    public List<ResponseStudentProfileDTO> listProfile(){
        return studentProfileRepo.findAll()
                .stream()
                .map(this::toResponseStudentProfileDTO)
                .collect(Collectors.toList());
    }

    public void addProfile(StudentProfileDTO studentProfile) {
        studentProfileRepo.save(toStudentProfileDTO(studentProfile));
    }

}
