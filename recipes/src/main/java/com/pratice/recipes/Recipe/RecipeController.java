package com.pratice.recipes.Recipe;

import com.pratice.recipes.Recipe.Exception.RecipeAlreadyExist;
import com.pratice.recipes.Recipe.Exception.RecipeNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j(topic = "RecipeController")
@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeResponse>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getRecipes());
    }

    @GetMapping("{id}")
    public ResponseEntity<RecipeResponse> getRecipe(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.getRecipe(id));
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<RecipeResponse>> getRecipeByName(@RequestParam String name) {
        return ResponseEntity.ok(recipeService.getRecipesByName(name));
    }

    @GetMapping("/searchByDescription")
    public ResponseEntity<List<RecipeResponse>> getRecipeByDescription(@RequestParam String description) {
        return ResponseEntity.ok(recipeService.getRecipesByDescription(description));
    }

    @GetMapping("/searchByTag")
    public ResponseEntity<List<RecipeResponse>> getRecipeByTag(@RequestParam String tag) {
        return ResponseEntity.ok(recipeService.getRecipesByTag(tag));
    }

    @GetMapping("/searchByIngredients")
    public ResponseEntity<List<RecipeResponse>> getRecipeByIngredients(@RequestParam String ingredients) {
        return ResponseEntity.ok(recipeService.getRecipesByIngredients(ingredients));
    }

    @GetMapping("/searchByAnything")
    public ResponseEntity<List<RecipeResponse>> getRecipeByAny(@RequestParam String text) {
        return ResponseEntity.ok(recipeService.getRecipesByAny(text));
    }



    @PostMapping
    public ResponseEntity<RecipeResponse> createRecipe(@RequestBody RecipeRequest recipe) {
        return ResponseEntity.ok(recipeService.createRecipe(recipe));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Integer id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok("Ok");
    }

    @PutMapping("{id}")
    public ResponseEntity<RecipeResponse> updateRecipe(@PathVariable Integer id, @RequestBody RecipeRequest recipe) {
        return ResponseEntity.ok(recipeService.updateRecipe(id, recipe));
    }

    @ExceptionHandler(RecipeNotFound.class)
    private ResponseEntity<String> handleRecipeNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RecipeAlreadyExist.class)
    private ResponseEntity<String> handleRecipeAlreadyExist(Exception ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<String> handleDuplicateKeySQLException() {
        return handleRecipeAlreadyExist(new RecipeAlreadyExist());
    }

    // Complete control and return an HTTP page
    //    @ExceptionHandler(NoSuchElementException.class)
    //    @ResponseStatus(HttpStatus.NOT_FOUND)
    //    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
    //        log.error("Request: " + req.getRequestURL() + " raised " + ex);
    //        ModelAndView mav = new ModelAndView();
    //        mav.addObject("exception", ex);
    //        mav.addObject("url", req.getRequestURL());
    //        mav.setViewName("error");
    //        return mav;
    //    }


}
