import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recipe } from '../interfaces/recipe';

@Injectable({
  providedIn: 'root'
})
export class RecipesService {
  private BASE_URL = "http://localhost:8080/api/recipes"
  private SEARCH_URL = `${this.BASE_URL}/searchByAnything`
  private http = inject(HttpClient);
  private HEADERS = { headers: { 'Accept': 'application/json' } }

  constructor() { }

  getAllRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.BASE_URL);
  }

  searchRecipe(search:string): Observable<Recipe[]> {
    const searchParams = new URLSearchParams();
    searchParams.append("text", search);
    return this.http.get<Recipe[]>(`${this.SEARCH_URL}?${searchParams}`, this.HEADERS);
  }

}
