import { Component } from '@angular/core';
import { CalculatorService } from '../service/calculator.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  num1: number = 0;
  num2: number = 0;
  resultado: number | string = 0;

  constructor(private calculatorService: CalculatorService) {}

  somar() {
    this.resultado = this.calculatorService.somar(this.num1, this.num2);
  }

  subtrair() {
    this.resultado = this.calculatorService.subtrair(this.num1, this.num2);
  }

  dividir() {
    try {
      this.resultado = this.calculatorService.dividir(this.num1, this.num2);
    } catch (error: any) {
      this.resultado = error.message;
    }
  }

  multiplicar() {
    this.resultado = this.calculatorService.multiplicar(this.num1, this.num2);
  }

  reset() {
    this.num1 = 0;
    this.num2 = 0;
    this.resultado = 0;
  }

  onInputChange() {
    this.num1 = isNaN(Number(this.num1)) ? 0 : Number(this.num1);
    this.num2 = isNaN(Number(this.num2)) ? 0 : Number(this.num2);
  }
}