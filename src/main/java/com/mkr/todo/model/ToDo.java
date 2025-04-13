package com.mkr.todo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="title",  nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column (name="is_completed", nullable = false)
    private boolean isCompleted;


    public ToDo(String title, String description, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public boolean isCompleted() {
//        return isCompleted;
//    }
//
//    public void setCompleted(boolean completed) {
//        isCompleted = completed;
//    }
}