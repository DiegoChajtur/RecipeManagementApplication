package com.pratice.recipes.Recipe.Exception;

public class RecipeAlreadyExist extends RuntimeException {
    public RecipeAlreadyExist() {
        super("Recipe Already Exist");
    }

    public RecipeAlreadyExist(String message) {
        super(message);
    }
}
