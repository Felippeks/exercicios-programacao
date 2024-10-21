import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AtividadesService } from '../../../../services/atividades.service';
import { ImagemAtividadeService } from '../../../../services/imagem-atividade-service.service';

export interface Atividade {
  tipo: string;
  data: Date;
  distancia?: number;
  tempo?: number;
}

@Component({
  selector: 'app-atividades-item',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './atividades-item.component.html',
  styleUrl: './atividades-item.component.scss',
})
export class AtividadesItemComponent implements OnInit {
  atividades: Atividade[] = [];

  constructor(
    private atividadesService: AtividadesService,
    private imagemAtividadeService: ImagemAtividadeService,
  ) {}

  ngOnInit() {
    this.atividadesService.atividades$.subscribe((atividades) => {
      this.atividades = atividades;
    });
  }

  getAtividades() {
    const atividades = localStorage.getItem('atividades');
    if (atividades) {
      this.atividades = JSON.parse(atividades);
    }
  }

  getImagemAtividade(tipo: string) {
    return this.imagemAtividadeService.getImagem(tipo);
  }

  excluirAtividade(index: number) {
    this.atividades.splice(index, 1);
    localStorage.setItem('atividades', JSON.stringify(this.atividades));
  }
}
