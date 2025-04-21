import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListRecipesComponent } from './components/list-recipes/list-recipes.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ListRecipesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'recipes-frontend';
}
