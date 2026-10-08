import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {NewMemberForm} from './member/new-member-form/new-member-form'; 
import { NewBookForm } from './book/new-book-form/new-book-form';

@Component({
  imports: [RouterOutlet, NewMemberForm, NewBookForm],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontend');
}
