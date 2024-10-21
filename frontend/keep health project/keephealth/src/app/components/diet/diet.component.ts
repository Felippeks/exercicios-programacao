// diet.component.ts
import { Component, OnInit } from '@angular/core';
import './diets.mock';
import { CommonModule } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';
import { SharedModule } from '../shared/shared.module';

export interface Diets {
  id: number;
  name: string;
  description: string;
  qttCalories: number;
  qttDaysFeed: number;
  imageLink: string;
}

@Component({
  selector: 'app-diet',
  standalone: true,
  templateUrl: './diet.component.html',
  styleUrl: './diet.component.scss',
  imports: [
    SharedModule,
    CommonModule,
    ReactiveFormsModule,
    RouterOutlet,
    RouterModule,
  ],
})
export class DietComponent implements OnInit {
  listLoad: Diets[] = [];
  list: Diets[] = [];
  inputPesquisa = new FormControl('');

  ngOnInit() {
    let dietsData = localStorage.getItem('diets');
    if (dietsData) {
      this.listLoad = JSON.parse(dietsData) as Diets[];
      this.list = this.listLoad;
    } else {
      alert('Dieta não encontrada');
    }

    this.inputPesquisa.valueChanges.subscribe((val) => {
      this.pesquisa(val || '');
    });
  }

  pesquisa(val: string) {
    if (val.length > 0) {
      this.list = this.listLoad.filter((x) =>
        x.name.toLowerCase().includes(val.toLowerCase()),
      );
    } else {
      this.list = this.listLoad;
    }
  }

  constructor(private router: Router) {}
  goToDetails(id: number) {
    this.router.navigate(['/diet', id]);
  }
}
