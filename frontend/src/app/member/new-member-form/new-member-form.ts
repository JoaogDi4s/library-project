import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Member } from '../member';

@Component({
  selector: 'new-member-form',
  imports: [ReactiveFormsModule],
  templateUrl: './new-member-form.html',
  styleUrl: './new-member-form.css',
})
export class NewMemberForm {
  private fb = inject(FormBuilder);
  private http = inject(HttpClient);

  form = this.fb.nonNullable.group({
    name: ['', [Validators.required, Validators.maxLength(100)]],
    email: ['', [Validators.required, Validators.email, Validators.maxLength(100)]],
    phone: ['', [Validators.required, Validators.pattern(/^[0-9]{10,15}$/)]],
  });

  salvar() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.http.post<Member>('/members', this.form.getRawValue()).subscribe({
      next: (membro) => {
        console.log('Membro criado com id', membro.id);
        this.form.reset();
      },
      error: (err) => console.error('Erro ao salvar', err),
    });
  }
}