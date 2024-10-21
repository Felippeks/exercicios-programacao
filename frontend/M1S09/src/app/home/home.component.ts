import { Component, Input } from '@angular/core';
import { CardComponent } from '../card/card.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CardComponent, CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  listaProd = [
    { nome: 'Carros', preco: 200000, imagem: './assets/product1.jpg' },
    {
      nome: 'Rodas',
      preco: 400,
      imagem:
        'https://http2.mlstatic.com/D_NQ_NP_627143-MLB54800786887_042023-O.webp',
    },
    {
      nome: 'Oleo',
      preco: 200,
      imagem:
        'https://a-static.mlcdn.com.br/450x450/oleo-de-motor-15w40-semissintetico-ipiranga-gm-fiat-volkswagen/fsautopecas/0ea16ffe418511ec80d24201ac185039/3bfb698b7b6f61be73c781a08bdbaabc.jpeg',
    },
    {
      nome: 'Filtro de ar',
      preco: 100,
      imagem:
        'https://strikebrasil.com/wp-content/uploads/2020/12/trocar-filtro-de-ar-comum.jpg',
    },
    {
      nome: 'Pneus',
      preco: 500,
      imagem:
        'https://static3.tcdn.com.br/img/img_prod/798095/pneu_225_40r19_89y_fr_contisportcontact_5_ssr_run_flat_533_1_3cf4584302611cac0e4445f3828f38f0.jpg',
    },
  ];

  listaFiltrada = [...this.listaProd];
  EndSearch = '';

  pesquisar() {
    if (this.EndSearch) {
      this.listaFiltrada = this.listaProd.filter((produto) =>
        produto.nome.toLowerCase().includes(this.EndSearch.toLowerCase()),
      );
    } else {
      this.listaFiltrada = [...this.listaProd];
    }
  }
}
