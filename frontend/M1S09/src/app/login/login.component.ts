import { Component } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginform!: FormGroup;

  constructor(private router: Router) {
    this.loginform = new FormGroup({
      usercode: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  cadastrar() {
    this.router.navigate(['/cadastro']);
  }

  verificarCamposPreenchidos() {
    const usercode = this.loginform.get('usercode')?.value;
    const password = this.loginform.get('password')?.value;

    if (usercode && password) {
      this.router.navigate(['']);
    }
  }
}
