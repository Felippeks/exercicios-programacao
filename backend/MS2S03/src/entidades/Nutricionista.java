package entidades;

import java.util.ArrayList;
import java.util.List;

public class Nutricionista extends Funcionario {
    private List<String> certificacoes = new ArrayList<>();
    private int numeroConsultas;
    private int tempoExperiencia;

    public Nutricionista() {
    }

    public Nutricionista(String nome, int idade, Endereco endereco, double salario, List<String> certificacoes, int numeroConsultas, int tempoExperiencia) {
        super(nome, idade, endereco, salario);
        this.certificacoes = certificacoes;
        this.numeroConsultas = numeroConsultas;
        this.tempoExperiencia = tempoExperiencia;
    }

    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public int getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(int tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public void adicionarAnoExperiencia() {
        this.tempoExperiencia += 1;
    }

    public void adicionarCertificacao(String certificacao) {
        this.certificacoes.add(certificacao);
    }
}