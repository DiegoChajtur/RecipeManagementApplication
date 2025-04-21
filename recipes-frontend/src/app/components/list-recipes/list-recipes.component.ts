import { Component, inject, Input } from '@angular/core';
import { RecipesService } from '../../services/recipes.service';
import { Observable } from 'rxjs';
import { Recipe } from '../../interfaces/recipe';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-list-recipes',
  imports: [AsyncPipe],
  templateUrl: './list-recipes.component.html',
  styleUrl: './list-recipes.component.css'
})
export class ListRecipesComponent {
  private recipeService = inject(RecipesService);

  recipes$!: Observable<Recipe[]>;
  
  constructor(){
    this.recipes$ = this.recipeService.getAllRecipes();
  }
  
  search(){
    const searchText = ((document.getElementById("searchBox") as HTMLInputElement).value);
    this.recipes$ = this.recipeService.searchRecipe(searchText)
  }

}
