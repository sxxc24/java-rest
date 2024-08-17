package com.Destroyer_BLUE.Project.blue1.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="school")
public class School {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="sch_id")
    private Integer id;
    @Column(name="sch_name")
    private String name;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference // this says student need to serialized with respect to reference school
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
