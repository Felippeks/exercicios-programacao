import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtividadesItemComponent } from './atividades-item.component';

describe('AtividadesItemComponent', () => {
  let component: AtividadesItemComponent;
  let fixture: ComponentFixture<AtividadesItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AtividadesItemComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AtividadesItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
