package com.pratice.recipes.Recipe;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeRequest {

    private String name;
    private String description;
    private String instructions;
    private String ingredients;
    private String tags;

}
