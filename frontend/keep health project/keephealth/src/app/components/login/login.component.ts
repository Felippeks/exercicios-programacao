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
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
  imports: [ReactiveFormsModule],
})
export class LoginComponent {
  loginForm = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  constructor(private router: Router) {}

  onLogin() {
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;

      const userData = JSON.parse(localStorage.getItem('userData') || '{}');

      if (email && userData.email === email && userData.password === password) {
        localStorage.setItem('isLoggedIn', 'true');
        this.router.navigate(['/home']);
      } else {
        alert('Usuário ou senha inválidos');
      }
    } else {
      alert('Por favor, preencha todos os campos corretamente!');
    }
  }

  onForgotPassword() {
    const email = this.loginForm.get('email')?.value;

    const userData = JSON.parse(localStorage.getItem('userData') || '{}');

    if (email && userData.email === email) {
      userData.password = 'a1b2c4d4';
      localStorage.setItem('userData', JSON.stringify(userData));

      alert(
        'Sua senha foi alterada para a senha padrão: a1b2c4d4. Por favor, prossiga utilizando essa senha.',
      );
    } else {
      alert('Email não encontrado');
    }
  }

  onRegister() {
    this.router.navigate(['/cadastro']);
  }
}
