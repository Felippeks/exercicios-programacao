import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Atividade } from '../components/shared/sidebar/atividades-item/atividades-item.component';

@Injectable({
  providedIn: 'root',
})
export class AtividadesService {
  private atividadesSubject = new BehaviorSubject<Atividade[]>(
    this.getAtividadesFromLocalStorage(),
  );
  atividades$ = this.atividadesSubject.asObservable();

  addAtividade(atividade: Atividade) {
    const atividades = this.getAtividadesFromLocalStorage();
    atividades.push(atividade);
    localStorage.setItem('atividades', JSON.stringify(atividades));
    this.atividadesSubject.next(atividades);
  }

  private getAtividadesFromLocalStorage(): Atividade[] {
    const atividades = localStorage.getItem('atividades');
    return atividades ? JSON.parse(atividades) : [];
  }
}
