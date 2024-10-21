package entidades;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private double pressaoArterial;
    private double frequenciaCardiaca;
    private String dietaAlimentar;
    private List<String> atividadesFisicas = new ArrayList<>();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public void setFrequenciaCardiaca(double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public void setDietaAlimentar(String dietaAlimentar) {
        this.dietaAlimentar = dietaAlimentar;
    }

    public double calculoIMC() {
        return peso / (altura * altura);
    }

    public String monitoramentoPaciente() {
        String atividades = String.join(", ", atividadesFisicas);
        return "Nome: " + nome +
                ", Idade: " + idade +
                ", Peso: " + peso +
                ", Altura: " + altura +
                ", Pressão Arterial: " + pressaoArterial +
                ", Frequência Cardíaca: " + frequenciaCardiaca +
                ", Dieta Alimentar: " + dietaAlimentar +
                ", Atividades Físicas: " + atividades +
                ", IMC: " + String.format("%.2f", calculoIMC());
    }

    public void registrarAtividadeFisica(String atividade) {
        atividadesFisicas.add(atividade);
    }
}