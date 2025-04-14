import java.util.Scanner;

public class MainPilhaSimples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu = 0;

        System.out.println("Qual o tamanho da pilha?");
        int tamanho = sc.nextInt();
        if(tamanho < 1){
            do{
                System.out.println("O tamaho deve ser maior que 0 !");
                tamanho = sc.nextInt();
            }while(tamanho < 1);
        }
        PilhaSimples pilha = new PilhaSimples(tamanho);
        System.out.println("Pilha criada !");

        System.out.println("Olá, o que você gostaria de fazer ?");
        System.out.println("1: inserir elemento");
        System.out.println("2: inserir elemento com índice");
        System.out.println("3: inserir sequência");
        System.out.println("4: remover elemento");
        System.out.println("5: remover elemento por índice");
        System.out.println("6: remover sequência");
        System.out.println("7: remover todas as ocorrências");
        System.out.println("8: buscar elemento");
        System.out.println("9: buscar elemento por índice");
        System.out.println("10: ordenar pilha de forma crescente");
        System.out.println("11: ordenar pilha de forma decrescente");
        System.out.println("12: editar um elemento");
        System.out.println("13: limpar pilha");
        System.out.println("14: exibir pilha");
        System.out.println("15: obter primeiro elemento");
        System.out.println("16: obter ultimo elemento");
        System.out.println("17: dobrar capacidade");
        System.out.println("0: sair");

        do{
            menu = sc.nextInt();
            switch (menu){
                case 0:
                    System.out.println("Saindo...");
                    break;

                case 1:
                    System.out.println("Digite o elemento que deseja inserir:");
                    pilha.inserirElemento(sc.next());
                    break;

                case 2:
                    System.out.println("Digite o elemento que deseja inserir:");
                    Object elemento = sc.next();
                    System.out.println("Agora digite o índice:");
                    int indice = sc.nextInt();
                    if (indice < 0 || indice >= tamanho){
                        do{
                            System.out.println("Índice inválido ! Tente de novo:");
                            indice = sc.nextInt();
                        }while(indice < 0 || indice >= tamanho);
                    }
                    pilha.inserirElementoIndice(elemento,indice);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("Digite os elementos que deseja inserir separados por espaço:");
                    String linha = sc.nextLine();
                    String[] elementos = linha.split(" "); // separa por espaço
                    pilha.inserirSequencia(elementos);
                    break;

                case 4:
                    pilha.removerElemento();
                    System.out.println("Último objeto removido da pilha !");
                    break;

                case 5:
                    System.out.println("Digite o índice:");
                     indice = sc.nextInt();
                    if (indice < 0 || indice >= tamanho){
                        do{
                            System.out.println("Índice inválido ! Tente de novo:");
                            indice = sc.nextInt();
                        }while(indice < 0 || indice >= tamanho);
                    }
                    pilha.removerIndice(indice);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.println("Digite os elementos que deseja remover separados por espaço: ");
                    String linhaRemover = sc.nextLine();
                    String[] elementosRemover = linhaRemover.split(" ");
                    pilha.removerSequencia(elementosRemover);
                    break;

                case 7:
                    System.out.println("Digite o objeto a ser removido:");
                    pilha.removerTodasOcorrencias(sc.next());
                    break;

                case 8:
                    System.out.println("Digite o objeto a ser buscado na pilha:");
                    pilha.buscarElemento(sc.next());
                    break;

                case 9:
                    System.out.println("Digite o índice para buscar o elemento:");
                    indice = sc.nextInt();
                    if (indice < 0 || indice >= tamanho){
                        do{
                            System.out.println("Índice inválido ! Tente de novo:");
                            indice = sc.nextInt();
                        }while(indice < 0 || indice >= tamanho);
                    }
                    pilha.buscarElementoIndice(indice);
                    break;

                case 10:
                    pilha.ordenarCrescente();
                    break;

                case 11:
                    pilha.ordenarDecrescente();
                    break;

                case 12:
                    System.out.println("Digite o elemento que deseja editar:");
                    String elementoAntigo = sc.next();
                    System.out.println("Agora digite o novo elemento:");
                     String elemento2 = sc.next();
                     pilha.editarElemento(elementoAntigo,elemento2);
                     break;

                case 13:
                    System.out.println("A pilha foi limpada !");
                    pilha.limpar();
                    break;

                case 14:
                    pilha.exibir();
                    break;

                case 15:
                    pilha.obterPrimeiroElemento();
                    break;

                case 16:
                    pilha.obterUltimoElemento();
                    break;

                case 17:
                    pilha.dobrarCapacidade();
                    break;

                default:
                    System.out.println("Índice inválido ! Tente de novo:");
            }
        }while(menu != 0);
    }
}