package com.Destroyer_BLUE.Project.blue1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="StudentProfile")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pro_id")
    private Integer id;
    @Column(name="pro_bio")
    private String bio;

    @OneToOne
    @JoinColumn(name="std_id")
    @JsonBackReference
    private Student student;

    public Integer getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName(){return student.getName();}

    public Integer getStdId(){return student.getId();}
    @Override
    public String toString() {
        return "StudentProfile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", student=" + student +
                '}';
    }
}
