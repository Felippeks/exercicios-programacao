package repositorio;

import entidades.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFuncionarios {
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static List<Funcionario> listar() {
        return funcionarios;
    }

    public static Funcionario buscarPorId(int id) {
        return funcionarios.get(id);
    }

    public static void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public static void remover(int id) {
        funcionarios.remove(id);
    }

    public static void alterar(int id, Funcionario funcionario) {
        funcionarios.set(id, funcionario);
    }
}