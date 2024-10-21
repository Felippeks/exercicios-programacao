import { CanActivateChildFn, Router } from '@angular/router';

export const authChildGuard: CanActivateChildFn = (childRoute, state) => {
  {
    const isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    const isIdNumber = !isNaN(Number(childRoute.paramMap.get('id')));
    if (!isLoggedIn || !isIdNumber) {
      const router = new Router();
      router.navigate(['/login']);
      return false;
    }
    return true;
  }
};
