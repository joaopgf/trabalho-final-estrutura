public class PilhaSimples implements IEstruturaSimples {
    private int tamanho;
    private Object[] pilha;

    public PilhaSimples(int tamanho) {
        this.tamanho = tamanho;
        pilha = new Object[tamanho];
    }

//    public boolean cheia() {
//        for (int i = 0; i < tamanho; i++) {
//            if (pilha[i] == null) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void empilha(String conteudo){
//        if(cheia()){
//            System.out.println("A pilha está cheia !");
//        } else{
//            for (int i = 0; i < tamanho; i++) {
//                if(pilha[i] == null){
//                    pilha[i] = conteudo;
//                    return;
//                }
//            }
//        }
//    }
//
//    public void desempilha(){
//        if(pilha[0] == null){
//            System.out.println("A pilha está vazia !");
//        } else{
//            for (int i = tamanho - 1; i > 0 ; i--) {
//                if(pilha[i] != null){
//                    pilha[i] = null;
//                    return;
//                }
//            }
//        }
//    }
//
//    public void visualizar(){
//        if(pilha[0] == null){
//            System.out.println("A pilha está vazia !");
//        } else{
//            for (int i = 0; i < tamanho; i++) {
//                System.out.println(pilha[i]);
//            }
//        }
//    }
//
//    public void verQtdDeValores(){
//        int quantidade = 0;
//        for (int i = 0; i < this.tamanho; i++) {
//            if(pilha[i] != null) {
//                quantidade++;
//            }
//        }
//        System.out.println("A pilha possui " + quantidade + " valores.");
//    }

    @Override
    public void inserirElemento(Object elemento) { //J
        if(estaCheia()){
            System.out.println("A pilha está cheia !");
        } else{
            for (int i = 0; i < tamanho; i++) {
                if(pilha[i] == null){
                    pilha[i] = elemento;
                    System.out.println("Elemento " + elemento + " inserido no índice [" + i + "]");
                    return;
                }
            }
        }
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) { //J
        if(indice <= tamanho -1){
            pilha[indice] = elemento;
            System.out.println("Elemento " + elemento + " adicionado no índice [" + indice + "]");
            if ( indice != 0 && pilha[indice - 1] == null ){
                for (int i = 0; i < tamanho; i++) {
                    if(pilha[i] == null){
                        pilha[i] = elemento;
                        pilha[indice] = null;
                        System.out.println("Elemento " + elemento + " alterado para o índice [" + i + "] devido ao espaço livre.");
                        return;
                    }
                }
            }
        } else {
            System.out.println("ìndice para inserir elemeno inválido !");
        }
    }

    @Override
    public void inserirSequencia(Object elementos) {
        if(!(elementos instanceof Object[])) {
            System.out.println("Só pode inserir elementos se for um vetor de objetos");
            return;
        }

        Object[] sequencia = (Object[]) elementos;

        for (Object elemento : sequencia) {
            if (estaCheia()) {
                System.out.println("A pilha esta cheia! Só deu para inseir os elementos do tamanho do vetor");
                break;
            }

            for (int i = 0; i < tamanho; i++) {
                if(pilha[i] == null){
                    pilha[i] = elemento;
                    System.out.println("Elemento " + elemento + " inserido no índice [" + i + "] !");
                    break;
                }
            }
        }
    }

    @Override
    public boolean removerElemento() {//J
        if(estaVazia()){
            System.out.println("A pilha está vazia !");
        } else{
            for (int i = tamanho - 1; i > 0 ; i--) {
                if(pilha[i] != null){
                    pilha[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object removerIndice(int indice) {//J
        if(indice <= tamanho - 1){
            pilha[indice] = null;
            if(indice < tamanho - 1){
                for (int i = indice; i < tamanho - 1; i++) {
                    if(pilha[i + 1] != null){
                        pilha[i] = pilha[i + 1];
                    }

                }
                pilha[quantidadeElementos() - 1] = null;
            }
            return null;
        }
        System.out.println("Índice para remover inválido !");
        return null;
    }

    @Override
    public void removerSequencia(Object elementos) {
        if(!(elementos instanceof Object[])) {
            System.out.println("Só pode inserir elementos se for um vetor de objetos");
            return;
        }

        Object[] sequencia = (Object[]) elementos;

        for (Object elemento : sequencia) {
            boolean removido = false;

            for (int i = 0; i < tamanho; i++) {
                if(pilha[i].equals(elemento)){
                    pilha[i] = null;
                    removido = true;
                    System.out.println("Elemento " + elemento + " removido no índice [" + i + "] !");
                    if(i < tamanho - 1){
                        for (int j = i; j < tamanho - 1; j++) {
                            if (pilha[j + 1] != null) {
                                pilha[j] = pilha[j + 1];
                            }
                        }
                        pilha[quantidadeElementos() - 1] = null;
                    }
                    i--;
                    break;
                }
            }
            if (!removido) {
                System.out.println("Elemento não encontrado!!");
            }
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {//J
        int qtd = 0;
        for (int i = 0; i < tamanho; i++) {
            if (elemento.equals(pilha[i])) {
                pilha[i] = null;
                System.out.println("Elemento " + elemento + " removido da pilha no índice [" + i + "]");
                qtd ++;
                if(i < tamanho - 1){
                    for (int j = i; j < tamanho - 1; j++) {
                        if (pilha[j + 1] != null) {
                            pilha[j] = pilha[j + 1];
                        }
                    }
                    pilha[quantidadeElementos() - 1] = null;
                }
                i--;
            }
        }
        if (qtd > 0){
            return;
        }
        System.out.println("O elemento " + elemento + " não existe na pilha !");
    }

    @Override
    public boolean estaCheia() {//J
        for (int i = 0; i < tamanho; i++) {
            if (pilha[i] == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean estaVazia() {//J
        for (int i = 0; i < tamanho; i++) {
            if (pilha[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean buscarElemento(Object elemento) {//J
        int qtd = 0;
        for (int i = 0; i < tamanho; i++) {
            if (elemento.equals(pilha[i])) {
                System.out.println("O elemento " + elemento + " existe na pilha e está no índice [" + i + "]");
                qtd ++;
            }
        }
        if (qtd > 0){
            return true;
        }
        System.out.println("O elemento " + elemento + " não existe na pilha !");
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice) {
        if(indice <= tamanho - 1){
            System.out.println("O índice [" + indice + "] contém o objeto " + pilha[indice] + " na pilha.");
        } else {
            System.out.println("Índice inválido para busca !");
        }
        return null;
    }

    @Override
    public void ordenarCrescente() {//J
        if (estaVazia()){
            System.out.println("A lista está vazia !");
            return;
        }
        Object menorValor;
        int indiceValor;
        for (int i = 0; i < tamanho - 1; i++) {
            menorValor = pilha[i];
            indiceValor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (Double.parseDouble((String) pilha[j]) < Double.parseDouble((String) menorValor) && pilha[j] != null) {
                    menorValor = pilha[j];
                    indiceValor = j;
                }
            }
            pilha[indiceValor] = pilha[i];
            pilha[i] = menorValor;
        }
        System.out.println("A pilha foi ordenada de maneira crescente.");
        exibir();
    }

    @Override
    public void ordenarDecrescente() {//J
        if (estaVazia()){
            System.out.println("A lista está vazia !");
            return;
        }
        Object maiorValor;
        int indiceValor;
        for (int i = 0; i < tamanho - 1; i++) {
            maiorValor = pilha[i];
            indiceValor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if ((Double.parseDouble((String) pilha[j]) > Double.parseDouble((String) maiorValor))  && pilha[j] != null) {
                    maiorValor = pilha[j];
                    indiceValor = j;
                }
            }
            pilha[indiceValor] = pilha[i];
            pilha[i] = maiorValor;
        }
        System.out.println("A pilha foi ordenada de maneira decrescente.");
        exibir();
    }

    @Override
    public int quantidadeElementos() {
        int quantidade = 0;
        for (int i = 0; i < this.tamanho; i++) {
            if(pilha[i] != null) {
                quantidade++;
            }
        }
        return quantidade;
    }

    @Override
    public void dobrarCapacidade() {
        int novoTamanho = tamanho * 2;
        Object[] novaPilha = new Object[novoTamanho];

        for (int i = 0; i < tamanho; i++) {
            novaPilha[i] = pilha[i];
        }


        pilha = novaPilha;
        tamanho = novoTamanho;

        System.out.println("A capacidade da pilha foi dobrada para " + tamanho + " elementos!");
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        for (int i = 0; i < tamanho; i++) {
            if (pilha[i] == elementoAntigo) {
                pilha[i] = elementoNovo;
                System.out.println("Elemento alterado com sucesso ! " + elementoAntigo + " -> " + elementoNovo);
                return;
            }
        }
        System.out.println("O elemento " + elementoAntigo + " não existe na pilha !");
    }

    @Override
    public void limpar() {
        if(estaVazia()){
            System.out.println("A pilha já está vazia.");
        } else {
            for (int i = 0; i < tamanho; i++) {
                pilha[i] = null;
            }
        }
    }
    @Override
    public void exibir() {
        if(estaVazia()){
            System.out.println("A pilha está vazia !");
        } else{
            for (int i = 0; i < tamanho; i++) {
                System.out.println("Pilha [" + i + "] = " + pilha[i]);
            }
            System.out.println("A pilha possui " + quantidadeElementos() + " valores.");
        }
    }

    @Override
    public Object obterPrimeiroElemento() {
        if(estaVazia()){
            System.out.println("A pilha está vazia !");
        } else {
            System.out.println("O primeiro elemento da pilha é: " + pilha[0]);
        }
        return null;
    }

    @Override
    public Object obterUltimoElemento() {
        if(estaVazia()){
            System.out.println("A pilha está vazia !");
        } else {
            for (int i = tamanho - 1; i > 0 ; i--) {
                if(pilha[i] != null) {
                    System.out.println("O último elemento da pilha é: " + pilha[i] + " e ele está " +
                            "no índice [" + i + "]");
                    return null;
                }
            }
        }
        return null;
    }
}