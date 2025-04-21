package com.pratice.recipes.Recipe;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeModel, Integer> {
    List<RecipeModel> findByNameContainingIgnoreCase(String name);

    List<RecipeModel> findByDescriptionContainsIgnoreCase(String description);

    List<RecipeModel> findByTagsContainsIgnoreCase(String tags);

    List<RecipeModel> findByIngredientsContainingIgnoreCase(String ingredients);

    List<RecipeModel> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrTagsContainingIgnoreCaseOrIngredientsContainingIgnoreCase(String name, String description, String tags, String ingredients);



}
