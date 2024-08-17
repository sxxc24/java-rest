package com.Destroyer_BLUE.Project.blue1.restController;

import com.Destroyer_BLUE.Project.blue1.recordsDTO.StudentProfileDTO;
import com.Destroyer_BLUE.Project.blue1.recordsResponse.ResponseStudentProfileDTO;
import com.Destroyer_BLUE.Project.blue1.service.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    private ProfileMapper profileMapper;

    @Autowired
    public ProfileController(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    @PostMapping("profile/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveProfile(@RequestBody StudentProfileDTO studentProfile) {
        profileMapper.addProfile(studentProfile);
    }

    @GetMapping("profile/get")
    public List<ResponseStudentProfileDTO> ShowProfile(){
        return profileMapper.listProfile();
    }
}
