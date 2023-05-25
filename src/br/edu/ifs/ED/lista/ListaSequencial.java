package br.edu.ifs.ED.lista;

public class ListaSequencial<T extends Comparable<T>> extends Lista<T>{


    T[] lista;
    int qtdMax;
    int finalLista;
    Class<T> dataType;
    public ListaSequencial(Class<T> dataType){
        super();
        qtdMax = 10;
        this.dataType = dataType;
        this.lista = (T[]) java.lang.reflect.Array.newInstance(dataType, qtdMax);
        finalLista = 0;
    }

    @Override
    public void limpar() {
        // cria uma nova matriz genérica com o tamanho máximo definido pela variável "qtdMax"
        // O tipo da matriz é definido pelo parâmetro de tipo "T", que é convertido para um array de tipo usando "java.lang.reflect.Array.newInstance()"
        // O resultado é atribuído à variável "lista" do objeto atual da classe.
        this.lista = (T[]) java.lang.reflect.Array.newInstance(dataType, qtdMax);

        // finalLista é uma variável de instância que controla a última posição válida na lista.
        // Definir seu valor como 0 indica que a lista está vazia.
        finalLista = 0;
    }
    @Override
    public T get(int posicao) throws Exception {
        // se a posição for negativa e posição for maior do que a quantidade da lista
        // exibe uma mensagem de erro
        if (posicao < 0 || posicao > finalLista) {
            throw new Exception("Posição solicitada não existe na lista");
        } else {
            // senão vai retornar a posição da lista
            return (T) lista[posicao];
        }
    }
    @Override
    public int getPosElemento(T elemento) throws Exception {
        int pos = 0;
        // Percorre todos os elementos na lista
        for (Object i : lista) {
            // Se o elemento atual não for nulo
            if (i != null) {
                // Se o elemento atual for igual ao elemento fornecido como parâmetro
                if (i.equals(elemento)) {
                    return pos;
                }
            }
            // Incrementa a posição atual
            pos++;
        }
        // Se o elemento não for encontrado em toda a lista, retorna -1
        return -1;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        //se o tamanho da lista adicionando mais um que vai ser o elemento do parametro for menor do que o tamanho da lista que no caso é 10
        if (finalLista + 1 < lista.length) {
            // vai adicionar o elemento na posição 0
            lista[finalLista] = elemento;
            // e depois vai aumentar essa variavel pois quando for incluir outro numero
            // em vez de começar na posição 0 vai começar da posição 1 em diante
            finalLista++;
        } else {
            //
            throw new Exception("Lista cheia");
        }
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        //se o tamanho da lista adicionando mais um que vai ser o elemento do parametro for menor do que o tamanho da lista que no caso é 10
        if (finalLista + 1 < lista.length) {

            // Desloca os elementos para a direita para abrir espaço para o novo elemento
            for (int i = finalLista; i >= 0; i--) {
                lista[i + 1] = lista[i];
            }
            // Insere o novo elemento na primeira posição que foi aberta no passo acima
            lista[0] = elemento;
            finalLista++;
        } else {
            throw new Exception("Lista cheia");
        }
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {

        // Verifica se a posição é válida
        if (posicao < 0 || posicao > finalLista) {
            throw new IllegalArgumentException("Posição inválida: " + posicao);
        }

        // Verifica se a lista está cheia
        if (finalLista == qtdMax) {
            throw new Exception("Lista cheia na posição " + posicao);
        }

        // Desloca os elementos para a direita para abrir espaço para o novo elemento
        for (int i = finalLista - 1; i > posicao; i--) {
            lista[i + 1] = lista[i];
        }

        // Insere o novo elemento na posição especificada
        lista[posicao] = elemento;

        // Aumenta o tamanho da lista
        finalLista++;
    }


    @Override
    public T remover(int posicao) throws Exception {
        // se a posição parametrizada pelo usuario for negativa ou
        // apontar para uma posição que não tenha na lista
        if (posicao < 0 || posicao >= finalLista) {
            throw new IllegalArgumentException("Posição inválida: " + posicao);
        }
        // Armazena o elemento que será removido da lista
        // Para que mais pra frente possa ser exibido
        T removido = lista[posicao];
        // Move os elementos seguintes uma posição para trás
        // preenchendo a posição que será removida
        for (int i = posicao+1; i < finalLista; i++) {

            lista[i-1] = lista[i];
        }
        // Define a última posição como nula
        // E diminui o tamanho da lista
        lista[finalLista-1] = null;
        finalLista--;
        // Retorna o elemento removido da lista
        return removido;
    }

    @Override
    public int getTamanho() {
        // esse finalLista representa o tamanho da lista
        return finalLista;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        // vai percorrer a lista
        for (Object i : lista) {
            // se não for nulo
            if (i != null) {
                // se o i que é o indice para percorrer a lista for igual ao elemento digitado pelo usuário
                if (i.equals(elemento)) {
                    // retorna verdadeiro
                    return true;
                }
            }
        }
        // retorna falso
        return false;
    }
}
