package com.pratice.recipes.Recipe;

import com.pratice.recipes.Recipe.Exception.RecipeNotFound;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j(topic = "RecipeService")
@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository repository;

    public List<RecipeResponse> getRecipes() {
        return repository.findAll().stream()
                .map(recipe ->
                        RecipeResponse
                                .builder()
                                .id(recipe.getId())
                                .name(recipe.getName())
                                .description(recipe
                                        .getDescription())
                                .instructions(recipe
                                        .getInstructions())
                                .ingredients(recipe
                                        .getIngredients())
                                .tags(recipe.getTags())
                                .createAt(recipe.getCreated_at())
                                .updateAt(recipe.getUpdated_at())
                                .build())
                .collect(Collectors.toList());
    }

    public RecipeResponse getRecipe(Integer id) {
        return repository.findById(id)
                .map(recipe ->
                        RecipeResponse.builder()
                                .id(recipe.getId())
                                .name(recipe.getName())
                                .description(recipe.getDescription())
                                .instructions(recipe.getInstructions())
                                .ingredients(recipe.getIngredients())
                                .tags(recipe.getTags())
                                .createAt(recipe.getCreated_at())
                                .updateAt(recipe.getUpdated_at())
                                .build())
                .orElseThrow();
    }

    public RecipeResponse createRecipe(RecipeRequest recipe) {
        RecipeModel saved = repository.save(RecipeModel.builder()
                .name(recipe.getName())
                .description(recipe.getDescription())
                .instructions(recipe.getInstructions())
                .ingredients(recipe.getIngredients())
                .tags(recipe.getTags())
                .build());

        return RecipeResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .instructions(saved.getInstructions())
                .ingredients(saved.getIngredients())
                .tags(saved.getTags())
                .createAt(saved.getCreated_at())
                .updateAt(saved.getUpdated_at())
                .build();
    }

    public RecipeResponse updateRecipe(Integer id, RecipeRequest recipe) {
        RecipeModel existingRecipe = repository.findById(id).orElseThrow(RecipeNotFound::new);

        existingRecipe.setName(recipe.getName());
        existingRecipe.setDescription(recipe.getDescription());
        existingRecipe.setInstructions(recipe.getInstructions());
        existingRecipe.setIngredients(recipe.getIngredients());
        existingRecipe.setTags(recipe.getTags());

        RecipeModel saved = repository.save(existingRecipe);

        return RecipeResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .instructions(saved.getInstructions())
                .ingredients(saved.getIngredients())
                .tags(saved.getTags())
                .createAt(saved.getCreated_at())
                .updateAt(saved.getUpdated_at())
                .build();
    }

    public void deleteRecipe(Integer id) {
        if (!repository.existsById(id)) {
            throw new RecipeNotFound();
        }
        repository.deleteById(id);
    }

    public List<RecipeResponse> getRecipesByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).stream()
                .map(recipe ->
                        RecipeResponse
                                .builder()
                                .id(recipe.getId())
                                .name(recipe.getName())
                                .description(recipe
                                        .getDescription())
                                .instructions(recipe
                                        .getInstructions())
                                .ingredients(recipe
                                        .getIngredients())
                                .tags(recipe.getTags())
                                .createAt(recipe.getCreated_at())
                                .updateAt(recipe.getUpdated_at())
                                .build())
                .collect(Collectors.toList());
    }

    public List<RecipeResponse> getRecipesByDescription(String description) {
        return repository.findByDescriptionContainsIgnoreCase(description).stream()
                .map(recipe ->
                        RecipeResponse
                                .builder()
                                .id(recipe.getId())
                                .name(recipe.getName())
                                .description(recipe
                                        .getDescription())
                                .instructions(recipe
                                        .getInstructions())
                                .ingredients(recipe
                                        .getIngredients())
                                .tags(recipe.getTags())
                                .createAt(recipe.getCreated_at())
                                .updateAt(recipe.getUpdated_at())
                                .build())
                .collect(Collectors.toList());
    }

    public List<RecipeResponse> getRecipesByTag(String tag) {
        return repository.findByTagsContainsIgnoreCase(tag).stream()
                .map(recipe ->
                        RecipeResponse
                                .builder()
                                .id(recipe.getId())
                                .name(recipe.getName())
                                .description(recipe
                                        .getDescription())
                                .instructions(recipe
                                        .getInstructions())
                                .ingredients(recipe
                                        .getIngredients())
                                .tags(recipe.getTags())
                                .createAt(recipe.getCreated_at())
                                .updateAt(recipe.getUpdated_at())
                                .build())
                .collect(Collectors.toList());
    }

    public List<RecipeResponse> getRecipesByIngredients(String ingredients) {
        return repository.findByIngredientsContainingIgnoreCase(ingredients).stream()
                .map(recipe ->
                        RecipeResponse
                                .builder()
                                .id(recipe.getId())
                                .name(recipe.getName())
                                .description(recipe
                                        .getDescription())
                                .instructions(recipe
                                        .getInstructions())
                                .ingredients(recipe
                                        .getIngredients())
                                .tags(recipe.getTags())
                                .createAt(recipe.getCreated_at())
                                .updateAt(recipe.getUpdated_at())
                                .build())
                .collect(Collectors.toList());
    }

    public List<RecipeResponse> getRecipesByAny(String any) {
        return repository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrTagsContainingIgnoreCaseOrIngredientsContainingIgnoreCase(any,any,any,any).stream()
                .map(recipe ->
                        RecipeResponse
                                .builder()
                                .id(recipe.getId())
                                .name(recipe.getName())
                                .description(recipe
                                        .getDescription())
                                .instructions(recipe
                                        .getInstructions())
                                .ingredients(recipe
                                        .getIngredients())
                                .tags(recipe.getTags())
                                .createAt(recipe.getCreated_at())
                                .updateAt(recipe.getUpdated_at())
                                .build())
                .collect(Collectors.toList());
    }




}
