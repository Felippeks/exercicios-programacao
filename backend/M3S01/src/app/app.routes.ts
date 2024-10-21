import { Routes } from '@angular/router';
import { ListingComponent } from './pages/listing/listing.component';
import { DetailsComponent } from './pages/details/details.component';

export const routes: Routes = [
  { path: '', redirectTo: '/listing', pathMatch: 'full' },
  { path: 'listing', component: ListingComponent },
  { path: 'details/:id', component: DetailsComponent },
  { path: 'favorites', component: ListingComponent, data: { favorites: true } },
  { path: '**', redirectTo: '/listing' }
];