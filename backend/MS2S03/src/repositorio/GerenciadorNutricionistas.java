package repositorio;

import entidades.Nutricionista;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorNutricionistas {
    private static List<Nutricionista> nutricionistas = new ArrayList<>();

    public static List<Nutricionista> listar() {
        return nutricionistas;
    }

    public static Nutricionista buscarPorId(int id) {
        return nutricionistas.get(id);
    }

    public static void adicionar(Nutricionista nutricionista) {
        for (Nutricionista n : nutricionistas) {
            if (n.getNome().equals(nutricionista.getNome())) {
                System.out.println("O nome do nutricionista já existe.");
                return;
            }
        }
        nutricionistas.add(nutricionista);
        GerenciadorFuncionarios.adicionar(nutricionista);
    }

    public static void remover(int id) {
        Nutricionista nutricionista = nutricionistas.remove(id);
        GerenciadorFuncionarios.remover(GerenciadorFuncionarios.listar().indexOf(nutricionista));
    }

    public static void alterar(int id, Nutricionista nutricionista) {
        Nutricionista oldNutricionista = nutricionistas.set(id, nutricionista);
        int funcionarioIndex = GerenciadorFuncionarios.listar().indexOf(oldNutricionista);
        GerenciadorFuncionarios.alterar(funcionarioIndex, nutricionista);
    }
}