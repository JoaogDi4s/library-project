import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Book } from '../book';

@Component({
  imports: [ReactiveFormsModule],
  selector: 'new-book-form',
  styleUrl: './new-book-form.css',
  templateUrl: './new-book-form.html',
})
export class NewBookForm {
  private fb = inject(FormBuilder);
  private http = inject(HttpClient);

  form = this.fb.nonNullable.group({
    title: ['', [Validators.required, Validators.maxLength(100)]],
    author: ['', [Validators.required, Validators.maxLength(100)]],
    year: ['', [Validators.required, Validators.min(0)]],
    genre: ['', [Validators.required, Validators.maxLength(100)]]
  });

  salvar() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.http.post<Book>('/books', this.form.getRawValue()).subscribe({
      next: (book) => {
        console.log('Book created with id', book.id);
        this.form.reset();
      },
      error: (err) => console.error('Error saving book', err),
    });
  }
}