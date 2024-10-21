import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FavoritesService {
  private storageKey = 'favorites';
  private favoritesSubject = new BehaviorSubject<string[]>(this.getFavorites());

  constructor() {}

  getFavorites(): string[] {
    const favorites = localStorage.getItem(this.storageKey);
    return favorites ? JSON.parse(favorites) : [];
  }

  addFavorite(id: string): void {
    const favorites = this.getFavorites();
    if (!favorites.includes(id)) {
      favorites.push(id);
      localStorage.setItem(this.storageKey, JSON.stringify(favorites));
      this.favoritesSubject.next(favorites);
    }
  }

  removeFavorite(id: string): void {
    let favorites = this.getFavorites();
    favorites = favorites.filter(favoriteId => favoriteId !== id);
    localStorage.setItem(this.storageKey, JSON.stringify(favorites));
    this.favoritesSubject.next(favorites);
  }

  isFavorite(id: string): boolean {
    return this.getFavorites().includes(id);
  }

  getFavoritesObservable() {
    return this.favoritesSubject.asObservable();
  }
}