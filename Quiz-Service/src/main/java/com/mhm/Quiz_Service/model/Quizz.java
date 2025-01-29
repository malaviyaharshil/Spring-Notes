package com.mhm.Quiz_Service.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionType;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Component
public class Quizz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ElementCollection
    private List<Integer> questions;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Integer> questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

