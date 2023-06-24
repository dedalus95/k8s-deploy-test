import { Component } from '@angular/core';
import { JokeService } from '../service/joke.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(
    private jokeService: JokeService
  ) {}
  selectedJoke: string = "";
  randomJoke() {
    return this.jokeService.getJoke().pipe().subscribe(
      (joke) => {
        this.selectedJoke = joke.jokeDescription;
      }
    )
  }
}


