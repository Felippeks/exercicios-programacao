import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CarsService } from '../../services/cars.service';
import { CommonModule } from '@angular/common';
import { FavoritesService } from '../../services/favorites.service';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  car: any;
  isFavorite: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private carsService: CarsService,
    private favoritesService: FavoritesService
  ) {}

  ngOnInit(): void {
    const carId = this.route.snapshot.paramMap.get('id');
    if (carId) {
      this.carsService.getById(carId).subscribe(data => {
        this.car = data;
        this.isFavorite = this.favoritesService.isFavorite(carId);
      });
    }
  }

  toggleFavorite() {
    if (this.car) {
      if (this.isFavorite) {
        this.favoritesService.removeFavorite(this.car.id);
      } else {
        this.favoritesService.addFavorite(this.car.id);
      }
      this.isFavorite = !this.isFavorite;
    }
  }
}