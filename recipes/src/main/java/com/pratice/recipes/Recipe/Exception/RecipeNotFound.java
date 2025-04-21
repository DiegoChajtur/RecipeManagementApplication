package com.pratice.recipes.Recipe.Exception;

public class RecipeNotFound extends RuntimeException {
    public RecipeNotFound() {
        super("Recipe Not Found");
    }

    public RecipeNotFound(String message) {
        super(message);
    }
}
