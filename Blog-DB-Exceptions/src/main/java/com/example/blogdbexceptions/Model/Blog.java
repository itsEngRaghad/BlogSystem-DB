package com.example.blogdbexceptions.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Blog {
    // id:pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    title :String
    @NotEmpty(message = "title shouldn't be empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String title;

//category : String check (health or education or programming)
    @NotEmpty(message = "category can't be empty")
    @Column(columnDefinition = "varchar(25) not null check ( category='health' or category='programming' or category='education')")
    private String category;

//body : String max 300 letters
    @NotEmpty(message = "body can't be empty")
    @Column(columnDefinition = "varchar(300) not null")
    private String body;

//isPublished: boolean default false

    @Column(columnDefinition = " boolean not null default false")
    private boolean isPublished=false;

}
