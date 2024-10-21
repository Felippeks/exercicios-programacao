import { TestBed } from '@angular/core/testing';
import { CalculatorService } from './calculator.service';

describe('CalculatorService', () => {
  let service: CalculatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalculatorService);
  });

  it('deve retornar o valor correto ao subtrair dois números', () => {
    const resultado = service.subtrair(10, 5);
    expect(resultado).toBe(5);
  });

  it('deve retornar o valor correto ao multiplicar dois números', () => {
    const resultado = service.multiplicar(4, 5);
    expect(resultado).toBe(20);
  });
  
  it('deve retornar o valor correto ao dividir dois números', () => {
    const resultado = service.dividir(10, 2);
    expect(resultado).toBe(5);
  });
  
  it('deve lançar erro ao tentar dividir por zero', () => {
    expect(() => service.dividir(10, 0)).toThrowError('Divisão por zero');
  });
  
  it('deve retornar o valor correto ao subtrair números negativos', () => {
    const resultado = service.subtrair(-10, -5);
    expect(resultado).toBe(-5);
  });

  it('deve multiplicar corretamente números decimais', () => {
    const resultado = service.multiplicar(1.5, 2.5);
    expect(resultado).toBe(3.75);
  });

  it('deve somar corretamente números muito grandes', () => {
    const resultado = service.somar(Number.MAX_SAFE_INTEGER, 1);
    expect(resultado).toBe(Number.MAX_SAFE_INTEGER + 1);
  });

  it('deve retornar Infinity ao dividir um número positivo por um valor próximo de zero', () => {
    const resultado = service.dividir(10, Number.MIN_VALUE);
    expect(resultado).toBe(Infinity);
  });
  
});
