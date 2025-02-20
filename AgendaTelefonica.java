import java.util.ArrayList;
import java.util.Scanner;

class Contato {
    String nome;
    String numero;

    Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }
}

public class AgendaTelefonica {
    static ArrayList<Contato> contatos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarContato();
                    break;
                case 2:
                    listarContatos();
                    break;
                case 3:
                    excluirContato();
                    break;
                case 4:
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 4);
    }

    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Listar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarContato() {
        System.out.print("\nDigite o nome do contato: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o número do contato: ");
        String numero = scanner.nextLine();

        Contato novoContato = new Contato(nome, numero);
        contatos.add(novoContato);

        System.out.println("Contato cadastrado com sucesso!");
    }

    public static void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("\nNenhum contato cadastrado.");
        } else {
            System.out.println("\nContatos cadastrados:");
            for (int i = 0; i < contatos.size(); i++) {
                Contato contato = contatos.get(i);
                System.out.println((i + 1) + ". Nome: " + contato.nome + " | Número: " + contato.numero);
            }
        }
    }

    public static void excluirContato() {
        if (contatos.isEmpty()) {
            System.out.println("\nNenhum contato cadastrado para excluir.");
        } else {
            listarContatos();
            System.out.print("\nDigite o número do contato que deseja excluir: ");
            int indice = scanner.nextInt();

            if (indice > 0 && indice <= contatos.size()) {
                contatos.remove(indice - 1);
                System.out.println("Contato excluído com sucesso!");
            } else {
                System.out.println("Opção inválida. Nenhum contato foi excluído.");
            }
        }
    }
}
