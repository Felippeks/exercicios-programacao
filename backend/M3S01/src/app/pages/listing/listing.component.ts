import { Component, OnInit } from '@angular/core';
import { CarsService } from '../../services/cars.service';
import { CardComponent } from "../../components/card/card.component";
import { FavoritesService } from '../../services/favorites.service';
import { SearchComponent } from "../../components/search/search.component";
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-listing',
  standalone: true,
  imports: [CommonModule, CardComponent, SearchComponent],
  templateUrl: './listing.component.html',
  styleUrls: ['./listing.component.css']
})
export class ListingComponent implements OnInit {
  cars: any[] = [];
  filteredCars: any[] = [];
  showOnlyFavorites: boolean = false;

  constructor(
    private carsService: CarsService,
    private favoritesService: FavoritesService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.carsService.listAll().subscribe(data => {
      this.cars = data.map(car => ({
        ...car,
        isFavorite: this.favoritesService.isFavorite(car.id)
      }));
      this.filteredCars = this.cars;
    });

    this.route.queryParams.subscribe(params => {
      this.showOnlyFavorites = params['favorites'] === 'true';
      this.filterCars();
    });
  }

  onSearch(term: string): void {
    this.filteredCars = this.cars.filter(car =>
      car.name.toLowerCase().includes(term.toLowerCase())
    );
  }

  filterCars(): void {
    if (this.showOnlyFavorites) {
      this.filteredCars = this.cars.filter(car => car.isFavorite);
    } else {
      this.filteredCars = this.cars;
    }
  }
}