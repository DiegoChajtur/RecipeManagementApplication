package com.pratice.recipes.Recipe;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RecipeResponse {
    private Integer id;
    private String name;
    private String description;
    private String instructions;
    private String ingredients;
    private String tags;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
