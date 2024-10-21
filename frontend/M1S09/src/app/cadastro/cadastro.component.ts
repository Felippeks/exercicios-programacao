import { Component } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css',
})
export class CadastroComponent {
  Cadastroform!: FormGroup;

  constructor(private router: Router) {
    this.Cadastroform = new FormGroup({
      name: new FormControl('', Validators.required),
      usercode: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      confirmPassword: new FormControl('', Validators.required),
    });
  }

  cadastrarOk() {
    if (this.Cadastroform.invalid) {
      const mensagemErro = 'Por favor, preencha todos os campos obrigatórios.';
      console.error(mensagemErro);
      alert(mensagemErro);
      return;
    }

    const senha = this.Cadastroform.get('password')?.value;
    const confirmacaoSenha = this.Cadastroform.get('confirmPassword')?.value;

    if (senha === confirmacaoSenha) {
      const codigoUsuario = this.Cadastroform.get('usercode')?.value;
      localStorage.setItem('codigoUsuario', codigoUsuario);
      localStorage.setItem('senha', senha);

      this.router.navigate(['/login']);
    } else {
      const mensagemErro =
        'As senhas não coincidem. Por favor, tente novamente.';
      console.error(mensagemErro);
      alert(mensagemErro);
    }
  }
}
