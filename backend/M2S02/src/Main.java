import entidades.Paciente;
import repositorio.RepositorioPaciente;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 - Cadastrar um novo paciente");
            System.out.println("2 - Listar todos os pacientes");
            System.out.println("3 - Alterar informações do paciente");
            System.out.println("4 - Mostrar informações de um paciente");
            System.out.println("5 - Registrar atividade física para um paciente");
            System.out.println("6 - Remover paciente");
            System.out.println("7 - Sair");
            System.out.println("Escolha uma opção:");
            int opcao = readInt();
            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    alterarPaciente();
                    break;
                case 4:
                    mostrarPaciente();
                    break;
                case 5:
                    registrarAtividadeFisica();
                    break;
                case 6:
                    removerPaciente();
                    break;
                case 7:
                    System.out.println("\nSaindo do programa...");
                    break;
                default:
                    System.out.println("\nOpção inválida");
            }
            if (opcao == 7) {
                break;
            }
        }
    }

    private static void cadastrarPaciente() {
        Paciente paciente = new Paciente();
        System.out.println("\nDigite o nome do paciente:");
        paciente.setNome(scanner.nextLine());
        System.out.println("Digite a idade do paciente:");
        paciente.setIdade(readInt());
        System.out.println("Digite o peso do paciente:");
        paciente.setPeso(readDouble());
        System.out.println("Digite a altura do paciente:");
        paciente.setAltura(readDouble());
        System.out.println("Digite a pressão arterial do paciente:");
        paciente.setPressaoArterial(readDouble());
        System.out.println("Digite a frequência cardíaca do paciente:");
        paciente.setFrequenciaCardiaca(readDouble());
        System.out.println("Digite a dieta alimentar do paciente:");
        paciente.setDietaAlimentar(scanner.nextLine());
        RepositorioPaciente.adicionar(paciente);
    }

    private static void listarPacientes() {
        List<Paciente> pacientes = RepositorioPaciente.listar();
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente p = pacientes.get(i);
            System.out.println("\nID: " + i + ", Nome: " + p.getNome());
        }
    }

    private static void alterarPaciente() {
        System.out.println("\nDigite o id do paciente que deseja alterar:");
        int idAlterar = readInt();
        Paciente pacienteAlterar = RepositorioPaciente.buscarPorId(idAlterar);
        if (pacienteAlterar != null) {
            System.out.println("Digite o novo peso do paciente:");
            pacienteAlterar.setPeso(readDouble());
            System.out.println("Digite a nova altura do paciente:");
            pacienteAlterar.setAltura(readDouble());
            System.out.println("Digite a nova pressão arterial do paciente:");
            pacienteAlterar.setPressaoArterial(readDouble());
            System.out.println("Digite a nova frequência cardíaca do paciente:");
            pacienteAlterar.setFrequenciaCardiaca(readDouble());
            System.out.println("Digite a nova dieta alimentar do paciente:");
            pacienteAlterar.setDietaAlimentar(scanner.nextLine());
            RepositorioPaciente.alterar(idAlterar, pacienteAlterar);
        }
    }

    private static void mostrarPaciente() {
        System.out.println("\nDigite o id do paciente que deseja visualizar:");
        int idVisualizar = readInt();
        Paciente pacienteVisualizar = RepositorioPaciente.buscarPorId(idVisualizar);
        if (pacienteVisualizar != null) {
            System.out.println(pacienteVisualizar.monitoramentoPaciente());
        }
    }

    private static void registrarAtividadeFisica() {
        System.out.println("\nDigite o id do paciente que deseja registrar uma atividade física:");
        int idAtividade = readInt();
        Paciente pacienteAtividade = RepositorioPaciente.buscarPorId(idAtividade);
        if (pacienteAtividade != null) {
            System.out.println("Digite a atividade física:");
            String atividade = scanner.nextLine();
            pacienteAtividade.registrarAtividadeFisica(atividade);
        }
    }

    private static void removerPaciente() {
        System.out.println("\nDigite o id do paciente que deseja remover:");
        int idRemover = readInt();
        RepositorioPaciente.remover(idRemover);
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro válido.");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }
    }
}