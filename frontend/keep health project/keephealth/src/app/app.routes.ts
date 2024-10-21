import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { CadastroComponent } from './components/cadastro/cadastro.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { AuthGuardRouter } from './components/shared/guardas/guardas.guard';

import { ProfileComponent } from './components/profile/profile.component';
import { authChildGuard } from './components/shared/guardas/auth-child.guard';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardRouter] },
  { path: 'cadastro', component: CadastroComponent },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [AuthGuardRouter],
  },
  {
    path: 'diet',
    loadChildren: () =>
      import('./components/diet/diets.module').then((m) => m.DietsModule),
    canActivate: [AuthGuardRouter],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
