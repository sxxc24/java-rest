package com.Destroyer_BLUE.Project.blue1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="std_id")
    private Integer id;
    @Column(name="std_name")
    private String name;
    @Column(name="std_mail", unique=true)
    private String mail;
    @Column(name="std_age")
    private Integer age;

    @OneToOne(cascade=CascadeType.ALL,mappedBy = "student")
    @JsonManagedReference
    private StudentProfile profile;

    @ManyToOne
    @JoinColumn(name="sch_id")
    @JsonBackReference // says doesnt need to serealize school
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student() {}

    public Student(Integer age, String mail, String name) {
        this.age = age;
        this.mail = mail;
        this.name = name;
    }

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchName(){
        return school.getName();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                '}';
    }
}
