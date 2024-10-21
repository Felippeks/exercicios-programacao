import { Component } from '@angular/core';
import { AtividadesService } from '../../../services/atividades.service';
interface Atividade {
  tipo: string;
  data: Date;
  distancia?: number;
  tempo?: number;
}
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss',
})
export class SidebarComponent {
  visible = false;
  tiposAtividade = [
    'Corrida',
    'Caminhada',
    'Natação',
    'Ciclismo',
    'Musculação',
    'Yoga',
    'Pilates',
  ];
  atividade: Atividade = { tipo: '', data: new Date() };
  atividades: Atividade[] = [];

  showDialog() {
    this.visible = true;
  }
  constructor(private atividadesService: AtividadesService) {}

  salvarAtividade() {
    if (this.atividade.tipo && this.atividade.data) {
      this.atividadesService.addAtividade(this.atividade);
      this.atividade = { tipo: '', data: new Date() };
      this.visible = false;
    } else {
      alert('Por favor, preencha todos os campos necessários.');
    }
  }
}
