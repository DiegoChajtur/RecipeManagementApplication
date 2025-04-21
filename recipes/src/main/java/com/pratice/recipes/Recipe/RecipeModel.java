package com.pratice.recipes.Recipe;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RecipeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column(length = 1048576)
    private String description;

    @Column(length = 1048576)
    private String instructions;

    @Column(length = 1048576)
    private String ingredients;

    @Column(length = 1048576)
    private String tags;

    @Column( updatable = false)
    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    @PrePersist
    public void onPrePersist() {
        this.setCreated_at(LocalDateTime.now());
        this.setUpdated_at(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        this.setUpdated_at(LocalDateTime.now());
    }

}
