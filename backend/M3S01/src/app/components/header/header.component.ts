import { Component, OnInit, OnDestroy } from '@angular/core';
import { FavoritesService } from '../../services/favorites.service';
import { RouterModule, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  favoriteCount: number = 0;
  private favoritesSubscription: Subscription | any;

  constructor(private favoritesService: FavoritesService, private router: Router) {}

  ngOnInit(): void {
    this.updateFavoriteCount();
    this.favoritesSubscription = this.favoritesService.getFavoritesObservable().subscribe(favorites => {
      this.favoriteCount = favorites.length;
    });
  }

  ngOnDestroy(): void {
    if (this.favoritesSubscription) {
      this.favoritesSubscription.unsubscribe();
    }
  }

  updateFavoriteCount(): void {
    this.favoriteCount = this.favoritesService.getFavorites().length;
  }

  showFavorites(event: Event): void {
    event.preventDefault();
    this.router.navigate(['/listing'], { queryParams: { favorites: 'true' } });
  }
}