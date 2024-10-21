package entidades;

import java.time.LocalDateTime;

public class Consulta {
    private static int idCounter = 0;
    private int id;
    private Nutricionista nomeNutricionista;
    private String nomePaciente;
    private LocalDateTime dataHora;
    private boolean consultaRealizada;

    public Consulta() {
        this.id = idCounter++;
    }

    public Consulta(Nutricionista nomeNutricionista, String nomePaciente, LocalDateTime dataHora, boolean consultaRealizada) {
        this.id = idCounter++;
        this.nomeNutricionista = nomeNutricionista;
        this.nomePaciente = nomePaciente;
        this.dataHora = dataHora;
        this.consultaRealizada = consultaRealizada;
    }

    public int getId() {
        return id;
    }

    public Nutricionista getNomeNutricionista() {
        return nomeNutricionista;
    }

    public void setNomeNutricionista(Nutricionista nomeNutricionista) {
        this.nomeNutricionista = nomeNutricionista;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }
}