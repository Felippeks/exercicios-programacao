import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ImagemAtividadeService {
  private imagens: { [key: string]: string } = {
    Corrida:
      'https://cdn.icon-icons.com/icons2/1539/PNG/512/3289577-fast-run-running_107103.png',
    Caminhada:
      'https://cdn.icon-icons.com/icons2/1364/PNG/512/pedestrianwalking_89238.png',
    Natação:
      'https://cdn.icon-icons.com/icons2/1364/PNG/512/swimmingman_89145.png',
    Ciclismo:
      'https://cdn.icon-icons.com/icons2/37/PNG/512/regularcycling_sport_regula_3648.png',
    Musculação:
      'https://wallpapers.com/images/hd/pilates-reformer-workout-silhouette-zscylpjjafcdrqoz.png',
    Yoga: 'https://cdn.icon-icons.com/icons2/37/PNG/512/yoga_3632.png',
    Pilates: 'https://static.thenounproject.com/png/995-200.png',
  };

  getImagem(tipo: string) {
    return this.imagens[tipo];
  }
}
