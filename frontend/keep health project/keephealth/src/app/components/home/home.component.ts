import { Component, OnInit } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { AtividadesItemComponent } from '../shared/sidebar/atividades-item/atividades-item.component';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
  imports: [SharedModule, AtividadesItemComponent],
})
export class HomeComponent implements OnInit {
  userData: any;
  constructor() {}

  ngOnInit(): void {
    this.userData = JSON.parse(localStorage.getItem('userData') || '{}');
  }
}
