package repositorio;

import entidades.Paciente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioPaciente {
    private static List<Paciente> pacientes = new ArrayList<>();


    public RepositorioPaciente() {
    }

    public RepositorioPaciente(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public static void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static void remover(int id) {
        if (id >= 0 && id < pacientes.size()) {
            pacientes.remove(id);
        } else {
            System.out.println("\nID inválido");
        }
    }

    public static Paciente buscarPorId(int id) {
        if (id >= 0 && id < pacientes.size()) {
            return pacientes.get(id);
        } else {
            System.out.println("\nID inválido");
            return null;
        }
    }

    public static List<Paciente> listar() {
        return Collections.unmodifiableList(pacientes);
    }

    public static void alterar(int id, Paciente paciente) {
        if (id >= 0 && id < pacientes.size()) {
            pacientes.set(id, paciente);
        } else {
            System.out.println("\nID inválido");
        }
    }
}