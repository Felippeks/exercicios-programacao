import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CalculatorComponent } from './calculator.component';
import { CalculatorService } from '../service/calculator.service';
import { FormsModule } from '@angular/forms';

describe('CalculatorComponent', () => {
  let component: CalculatorComponent;
  let fixture: ComponentFixture<CalculatorComponent>;
  let calculatorService: CalculatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [FormsModule, CalculatorComponent], 
      providers: [CalculatorService]
    }).compileComponents();

    fixture = TestBed.createComponent(CalculatorComponent);
    component = fixture.componentInstance;
    calculatorService = TestBed.inject(CalculatorService);
    fixture.detectChanges();
  });

  it('deve atualizar o resultado corretamente ao somar dois números', () => {
    component.num1 = 5;
    component.num2 = 3;
    component.somar();
    expect(component.resultado).toBe(8);
  });

  it('deve atualizar as variáveis num1 e num2 ao digitar no input', () => {
    const compiled = fixture.nativeElement;
    const input1 = compiled.querySelector('input[placeholder="Número 1"]');
    const input2 = compiled.querySelector('input[placeholder="Número 2"]');
  
    input1.value = '7';
    input1.dispatchEvent(new Event('input'));
    input2.value = '9';
    input2.dispatchEvent(new Event('input'));
  
    fixture.detectChanges();
  
    expect(component.num1).toBe(7);
    expect(component.num2).toBe(9);
  });

  it('deve somar corretamente dois números negativos', () => {
    component.num1 = -4;
    component.num2 = -6;
    component.somar();
    expect(component.resultado).toBe(-10);
  });

  it('deve dividir corretamente números decimais', () => {
    component.num1 = 7.5;
    component.num2 = 2.5;
    component.dividir();
    expect(component.resultado).toBe(3);
  });

  it('deve dividir corretamente números muito grandes', () => {
    component.num1 = Number.MAX_SAFE_INTEGER;
    component.num2 = 1;
    component.dividir();
    expect(component.resultado).toBe(Number.MAX_SAFE_INTEGER);
  });

  it('não deve permitir entrada de valores não numéricos', () => {
    const compiled = fixture.nativeElement;
    const input1 = compiled.querySelector('input[placeholder="Número 1"]');
    
    input1.value = 'abc'; 
    input1.dispatchEvent(new Event('input'));
  
    fixture.detectChanges();
    expect(component.num1).toBe(0);
  });

  it('deve resetar num1, num2 e resultado para zero', () => {
    component.num1 = 10;
    component.num2 = 5;
    component.resultado = 15;
    
    component.reset(); 

    expect(component.num1).toBe(0);
    expect(component.num2).toBe(0);
    expect(component.resultado).toBe(0);
  });

  it('deve desabilitar o botão de multiplicação quando num1 ou num2 for zero', () => {
    component.num1 = 0;
    fixture.detectChanges();
    
    const button = fixture.nativeElement.querySelector('button[disabled]');
    expect(button).not.toBeNull();
    expect(button.disabled).toBeTruthy();
  });

  it('deve exibir o resultado da soma no template', () => {
    component.num1 = 7;
    component.num2 = 3;
    component.somar();
    fixture.detectChanges();
  
    const resultadoElement = fixture.nativeElement.querySelector('p');
    expect(resultadoElement.textContent).toContain('Resultado: 10');
  });
});