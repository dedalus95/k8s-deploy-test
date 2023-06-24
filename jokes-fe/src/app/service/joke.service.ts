import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.development";
import {Observable} from "rxjs";
import {Joke} from "../model/joke";

@Injectable({
  providedIn: 'root'
})
export class JokeService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getJoke():Observable<Joke> {
    return this.httpClient.get<Joke>(environment.baseUrl + '/api/jokes/random');
  }
}
