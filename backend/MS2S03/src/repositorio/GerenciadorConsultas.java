package repositorio;

import entidades.Consulta;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorConsultas {
    private static List<Consulta> consultas = new ArrayList<>();

    public static List<Consulta> listar() {
        return consultas;
    }

    public static Consulta buscarPorId(int id) {
        return consultas.get(id);
    }

    public static void adicionar(Consulta consulta) {
        consulta.getNomeNutricionista().setNumeroConsultas(consulta.getNomeNutricionista().getNumeroConsultas() + 1);
        consultas.add(consulta);
    }

    public static void remover(int id) {
        consultas.remove(id);
    }

    public static void alterar(int id, Consulta consulta) {
        consultas.set(id, consulta);
    }
}