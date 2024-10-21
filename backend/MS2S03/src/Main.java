import entidades.*;
import repositorio.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Nutricionista nutricionista1 = new Nutricionista("João", 30, new Endereco("Rua A", "Estado A", "Cidade A", 123, "12345-678"), 5000.0, new ArrayList<>(List.of("Certificação A", "Certificação B")), 100, 5);
        Nutricionista nutricionista2 = new Nutricionista("Maria", 35, new Endereco("Rua B", "Estado B", "Cidade B", 456, "23456-789"), 5500.0, new ArrayList<>(List.of("Certificação C", "Certificação D")), 200, 7);
        GerenciadorNutricionistas.adicionar(nutricionista1);
        GerenciadorNutricionistas.adicionar(nutricionista2);

        Consulta consulta1 = new Consulta(nutricionista1, "Paciente 1", LocalDateTime.now(), false);
        Consulta consulta2 = new Consulta(nutricionista2, "Paciente 2", LocalDateTime.now().plusDays(1), false);
        GerenciadorConsultas.adicionar(consulta1);
        GerenciadorConsultas.adicionar(consulta2);

        while (true) {
            System.out.println("\n1 - Cadastrar um novo paciente");
            System.out.println("2 - Listar todos os pacientes");
            System.out.println("3 - Alterar informações do paciente");
            System.out.println("4 - Mostrar informações de um paciente");
            System.out.println("5 - Registrar atividade física para um paciente");
            System.out.println("6 - Remover paciente");
            System.out.println("7 - Cadastrar um novo funcionário");
            System.out.println("8 - Cadastrar um novo nutricionista");
            System.out.println("9 - Criar consulta");
            System.out.println("10 - Listar funcionários");
            System.out.println("11 - Listar consultas");
            System.out.println("12 - Realizar consulta");
            System.out.println("13 - Sair");
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
                    cadastrarFuncionario();
                    break;
                case 8:
                    cadastrarNutricionista();
                    break;
                case 9:
                    criarConsulta();
                    break;
                case 10:
                    listarFuncionarios();
                    break;
                case 11:
                    listarConsultas();
                    break;
                case 12:
                    realizarConsulta();
                    break;
                case 13:
                    System.out.println("\nSaindo do programa...");
                    break;
                default:
                    System.out.println("\nOpção inválida");
            }
            if (opcao == 13) {
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

    private static void cadastrarFuncionario() {
        Funcionario funcionario = new Funcionario();
        System.out.println("\nDigite o nome do funcionário:");
        funcionario.setNome(scanner.nextLine());
        System.out.println("Digite a idade do funcionário:");
        funcionario.setIdade(readInt());
        System.out.println("Digite o salário do funcionário:");
        funcionario.setSalario(readDouble());
        System.out.println("Digite o endereço do funcionário:");
        Endereco endereco = new Endereco();
        System.out.println("Digite o logradouro:");
        endereco.setLogradouro(scanner.nextLine());
        System.out.println("Digite o estado:");
        endereco.setEstado(scanner.nextLine());
        System.out.println("Digite a cidade:");
        endereco.setCidade(scanner.nextLine());
        System.out.println("Digite o número:");
        endereco.setNumero(readInt());
        System.out.println("Digite o CEP:");
        endereco.setCep(scanner.nextLine());
        funcionario.setEndereco(endereco);
        GerenciadorFuncionarios.adicionar(funcionario);
    }

    private static void cadastrarNutricionista() {
        Nutricionista nutricionista = new Nutricionista();
        while (true) {
            System.out.println("\nDigite o nome do nutricionista:");
            String nome = scanner.nextLine();
            if (nomeNutricionistaExiste(nome)) {
                System.out.println("O nome do nutricionista já existe. Por favor, insira um nome diferente.");
            } else {
                nutricionista.setNome(nome);
                break;
            }
        }
        System.out.println("Digite a idade do nutricionista:");
        nutricionista.setIdade(readInt());
        System.out.println("Digite o salário do nutricionista:");
        nutricionista.setSalario(readDouble());
        System.out.println("Digite o número de consultas do nutricionista:");
        nutricionista.setNumeroConsultas(readInt());
        System.out.println("Digite o tempo de experiência do nutricionista (em anos):");
        nutricionista.setTempoExperiencia(readInt());
        System.out.println("Digite o número de certificações do nutricionista:");
        int numCertificacoes = readInt();
        for (int i = 0; i < numCertificacoes; i++) {
            System.out.println("Digite a certificação " + (i + 1) + ":");
            String certificacao = scanner.nextLine();
            nutricionista.adicionarCertificacao(certificacao);
        }
        System.out.println("Digite o endereço do nutricionista:");
        Endereco endereco = new Endereco();
        System.out.println("Digite o logradouro:");
        endereco.setLogradouro(scanner.nextLine());
        System.out.println("Digite o estado:");
        endereco.setEstado(scanner.nextLine());
        System.out.println("Digite a cidade:");
        endereco.setCidade(scanner.nextLine());
        System.out.println("Digite o número:");
        endereco.setNumero(readInt());
        System.out.println("Digite o CEP:");
        endereco.setCep(scanner.nextLine());
        nutricionista.setEndereco(endereco);
        GerenciadorNutricionistas.adicionar(nutricionista);
    }
    private static boolean nomeNutricionistaExiste(String nome) {
        for (Nutricionista nutricionista : GerenciadorNutricionistas.listar()) {
            if (nutricionista.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    private static void criarConsulta() {
        Consulta consulta = new Consulta();
        System.out.println("\nDigite o nome do nutricionista:");
        String nomeNutricionista = scanner.nextLine();
        Nutricionista nutricionista = null;
        for (Funcionario funcionario : GerenciadorFuncionarios.listar()) {
            if (funcionario instanceof Nutricionista && funcionario.getNome().equals(nomeNutricionista)) {
                nutricionista = (Nutricionista) funcionario;
                break;
            }
        }
        if (nutricionista == null) {
            System.out.println("Nutricionista não encontrado.");
            return;
        }
        consulta.setNomeNutricionista(nutricionista);
        System.out.println("Digite o nome do paciente:");
        consulta.setNomePaciente(scanner.nextLine());
        System.out.println("Digite a data e hora da consulta no formato yyyy-MM-ddTHH:mm:");
        LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine());
        consulta.setDataHora(dataHora);
        GerenciadorConsultas.adicionar(consulta);
    }

    private static void listarFuncionarios() {
        List<Funcionario> funcionarios = GerenciadorFuncionarios.listar();
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
    }

    private static void listarConsultas() {
        List<Consulta> consultas = GerenciadorConsultas.listar();
        for (Consulta consulta : consultas) {
            System.out.println("ID: " + consulta.getId());
            System.out.println("Data e hora: " + consulta.getDataHora());
            System.out.println("Nutricionista: " + consulta.getNomeNutricionista().getNome());
            System.out.println("Paciente: " + consulta.getNomePaciente());
            System.out.println("Consulta realizada: " + (consulta.isConsultaRealizada() ? "Sim" : "Não"));
        }
    }

    private static void realizarConsulta() {
        System.out.println("\nDigite o id da consulta que deseja realizar:");
        int id = readInt();
        Consulta consulta = GerenciadorConsultas.buscarPorId(id);
        if (consulta != null) {
            consulta.setConsultaRealizada(true);
            GerenciadorConsultas.alterar(id, consulta);
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}