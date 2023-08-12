package br.solutis.squad7.livraria;
import br.solutis.squad7.livraria.livros.*;


import java.util.*;

public class LivrariaVirtual{
    private final int MAX_IMPRESSOS = 10;
    private final int MAX_ELETRONICOS = 20;
    private final int MAX_VENDAS = 50;

    private List<Impresso> impressos;
    private List<Eletronico> eletronicos;
    private List<Venda> vendas;

    private int numImpressos;
    private int numEletronicos;
    private int numVendas;


    public LivrariaVirtual() {
        impressos = new ArrayList<>();
        eletronicos = new ArrayList<>();
        vendas = new ArrayList<>();
    }
    public void cadastrarLivro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione o tipo de livro a ser cadastrado:\n1. Livro Impresso\n2. Livro Eletrônico\n3. Ambos\nEscolha uma opção: ");
        int opcao = sc.nextInt();

        if (opcao != 1 && opcao != 2 && opcao != 3) {
            System.out.println("Opção inválida.");
            return;
        }

        if ((opcao == 1 && impressos.size() >= MAX_IMPRESSOS) || (opcao == 2 && eletronicos.size() >= MAX_ELETRONICOS)) {
            System.out.println("Não é possível cadastrar mais livros. Capacidade máxima atingida.");
            return;
        }

        if (opcao == 1 || opcao == 3) {
            if (impressos.size() >= MAX_IMPRESSOS) {
                System.out.println("Não é possível cadastrar mais livros impressos. Capacidade máxima atingida.");
            } else {
                System.out.print("Digite o título do livro impresso: ");
                String titulo = sc.next();
                System.out.print("Digite o autor(es) do livro impresso: ");
                String autores = sc.next();
                System.out.print("Digite a editora do livro impresso: ");
                String editora = sc.next();
                System.out.print("Digite o preço do livro impresso: ");
                float preco = sc.nextFloat();
                System.out.print("Digite o frete do livro impresso: ");
                float frete = sc.nextFloat();
                System.out.print("Digite o estoque do livro impresso: ");
                int estoque = sc.nextInt();
                impressos.add(new Impresso(titulo, autores, editora, preco, frete, estoque));
                System.out.println("Livro impresso cadastrado com sucesso!");
            }
        }

        if (opcao == 2 || opcao == 3) {
            if (eletronicos.size() >= MAX_ELETRONICOS) {
                System.out.println("Não é possível cadastrar mais livros eletrônicos. Capacidade máxima atingida.");
            } else {
                System.out.print("Digite o título do livro eletrônico: ");
                String titulo = sc.next();
                System.out.print("Digite o autor(es) do livro eletrônico: ");
                String autores = sc.next();
                System.out.print("Digite a editora do livro eletrônico: ");
                String editora = sc.next();
                System.out.print("Digite o preço do livro eletrônico: ");
                float preco = sc.nextFloat();
                System.out.print("Digite o tamanho do livro eletrônico: ");
                float tamanho = sc.nextFloat();
                eletronicos.add(new Eletronico(titulo, autores, editora, preco, tamanho));
                System.out.println("Livro eletrônico cadastrado com sucesso!");
            }
        }
    }


    public void realizarVenda() {
        String cliente;
        int qtdLivros;
        int opcao;

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        cliente = sc.next();
        System.out.println("Quantidade de livros a ser comprado: ");
        qtdLivros = sc.nextInt();
        System.out.print("Digite a opção de venda:\n1. Livro Impresso\n2. Livro Eletrônico\n3. Ambos\nEscolha uma opção: ");
        opcao = sc.nextInt();

        if (opcao != 1 && opcao != 2 && opcao != 3) {
            System.out.println("Opção inválida.");
            return;
        }
        if (opcao == 3) {
            listarLivrosImpressos();
            listarLivrosEletronicos();

            Venda venda = new Venda();
            venda.setCliente(cliente);

            for (int i = 0; i < qtdLivros; i++) {
                System.out.print("Digite o tipo do livro a ser comprado (1 - Impresso, 2 - Eletrônico): ");
                int tipoLivro = sc.nextInt();

                if (tipoLivro == 1) {
                    System.out.print("Digite o ID do livro impresso: ");
                    int idImpresso = sc.nextInt();
                    Impresso livroImpresso = getImpressoById(idImpresso);
                    if (livroImpresso != null) {
                        venda.addLivro(livroImpresso, i);
                    } else {
                        System.out.println("Livro impresso não encontrado.");
                        i--; // Decrementar o contador para repetir a iteração
                    }
                } else if (tipoLivro == 2) {
                    System.out.print("Digite o ID do livro eletrônico: ");
                    int idEletronico = sc.nextInt();
                    Eletronico livroEletronico = getEletronicoById(idEletronico);
                    if (livroEletronico != null) {
                        venda.addLivro(livroEletronico, i);
                    } else {
                        System.out.println("Livro eletrônico não encontrado.");
                        i--; // Decrementar o contador para repetir a iteração
                    }
                } else {
                    System.out.println("Tipo de livro inválido.");
                    i--; // Decrementar o contador para repetir a iteração
                }
            }

            vendas.add(venda);
            System.out.println("Venda realizada com sucesso!");
        }

    }

    public void listarLivrosImpressos() {
        System.out.println("Lista de Livros Impressos:");
        System.out.println("+------+---------------------+----------------------+-------+---------+");
        System.out.println("| ID   | Título              | Autores              | Preço | Estoque |");
        System.out.println("+------+---------------------+----------------------+-------+---------+");
        for (Impresso impresso : impressos) {
            System.out.printf("| %-4d | %-19s | %-20s | %-5.2f | %-7d |%n",
                    impresso.getId(), impresso.getTitulo(), impresso.getAutores(), impresso.getPreco(), impresso.getEstoque());
        }
        System.out.println("+------+---------------------+----------------------+-------+---------+");
    }

    public void listarLivrosEletronicos() {
        System.out.println("Lista de Livros Eletrônicos:");
        System.out.println("+------+---------------------+----------------------+-------+---------+");
        System.out.println("| ID   | Título              | Autores              | Preço | Tamanho |");
        System.out.println("+------+---------------------+----------------------+-------+---------+");
        for (Eletronico eletronico : eletronicos) {
            System.out.printf("| %-4d | %-19s | %-20s | %-5.2f | %-7d |%n",
                    eletronico.getId(), eletronico.getTitulo(), eletronico.getAutores(), eletronico.getPreco(), eletronico.getTamanho());
        }
        System.out.println("+------+---------------------+----------------------+-------+---------+");
    }

    public void listarVendas() {
        System.out.println("Lista de Vendas:");
        System.out.println("+------+---------+------------+------------+");
        System.out.println("| Venda| Cliente | Valor Total| Número Livros |");
        System.out.println("+------+---------+------------+------------+");
        for (Venda venda : vendas) {
            System.out.printf("| %-4d | %-7s | %-10.2f | %-12d |%n",
                    venda.getNumero(), venda.getCliente(), venda.getValor(), venda.listarLivros().size());
        }
        System.out.println("+------+---------+------------+------------+");
    }

    public void listarLivros() {
        System.out.println("Listagem de Livros:");
        System.out.println("+--------+---------------------+----------------------+-------+---------+---------+");
        System.out.println("| Tipo   | Título              | Autores              | Preço | Estoque | Tamanho |");
        System.out.println("+--------+---------------------+----------------------+-------+---------+---------+");

        for (Impresso impresso : impressos) {
            System.out.printf("| Impresso | %-19s | %-20s | %-5.2f | %-7d |         |%n",
                    impresso.getTitulo(), impresso.getAutores(), impresso.getPreco(), impresso.getEstoque());
        }

        for (Eletronico eletronico : eletronicos) {
            System.out.printf("| Eletrônico | %-17s | %-20s | %-5.2f |         | %-7d |%n",
                    eletronico.getTitulo(), eletronico.getAutores(), eletronico.getPreco(), eletronico.getTamanho());
        }

        System.out.println("+--------+---------------------+----------------------+-------+---------+---------+");
    }

    private Impresso getImpressoById(int id) {
        for (Impresso impresso : impressos) {
            if (impresso.getId() == id) {
                return impresso;
            }
        }
        return null;
    }

    private Eletronico getEletronicoById(int id) {
        for (Eletronico eletronico : eletronicos) {
            if (eletronico.getId() == id) {
                return eletronico;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LivrariaVirtual livraria = new LivrariaVirtual();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Listar Livros");
            System.out.println("4. Listar Vendas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    livraria.cadastrarLivro();
                    break;
                case 2:
                    livraria.realizarVenda();
                    break;
                case 3:
                    livraria.listarLivros();
                    break;
                case 4:
                    livraria.listarVendas();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5);
    }
}


