package br.edu.ifs.ED.lista;

public class ListaDupEnc<T extends Comparable<T>> extends Lista<T>{

    NoDup<T> inicio;
    NoDup<T> fim;
    int contadorNos;

    public ListaDupEnc(){
        inicio = null;
        fim = null;
        contadorNos = 0;
    }

    @Override
    public void incluir(T elemento) throws Exception {

        NoDup<T> novoNo = new NoDup<>();
        novoNo.setDado(elemento);


        if (inicio == null && fim == null ) {
            inicio = novoNo;
            fim = novoNo;

        }

        else{
            fim.setProx(novoNo);
            novoNo.setAnt(fim);
            fim = novoNo;

        }

        contadorNos++;

    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        NoDup<T> novoNo = new NoDup<>();
        novoNo.setDado(elemento);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;

        }

        else {
            inicio.setAnt(novoNo);
            novoNo.setProx(inicio);
            inicio = novoNo;
        }

        contadorNos++;

    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao < 0 || posicao > contadorNos) {
            throw new Exception("Posição inválida");
        }

        if (posicao == 0) {
            incluirInicio(elemento);

        }

        if (posicao == contadorNos) {
            incluir(elemento);

        }

        NoDup<T> novoNo = new NoDup<>();
        novoNo.setDado(elemento);
        NoDup<T> noAnterior = inicio;

        for (int i = 0; i < posicao - 1; i++) {
            noAnterior = noAnterior.getProx();
        }

        NoDup<T> noPosterior = noAnterior.getProx();

        noAnterior.setProx(novoNo);
        novoNo.setAnt(noAnterior);
        novoNo.setProx(noPosterior);
        noPosterior.setAnt(novoNo);

        contadorNos++;
    }

    @Override
    public T get(int posicao) throws Exception {

        if (posicao < 0 || posicao >= contadorNos) {
            throw new Exception("Posição solicitada não existe na lista");
        }

        NoDup<T> noAtual = inicio;

        for (int i = 0; i < posicao; i++) {
                noAtual = noAtual.getProx();
            }
        System.out.println(noAtual.getDado());
        return noAtual.getDado();

    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        NoDup<T> auxiliar = inicio;

        for (int i = 0; i < contadorNos; i++) {
            if (auxiliar.getDado().equals(elemento)) {
                return i;
            }
            auxiliar = auxiliar.getProx();
        }


        return -1;

    }

    @Override
    public T remover(int posicao) throws Exception {
        if (posicao < 0 || posicao >= contadorNos) {
            throw new Exception("Posição inválida");
        }
        NoDup<T> noRemovido;

        if (contadorNos == 1) {
            noRemovido = inicio;
            inicio = null;
            fim = null;

        }

        else if (posicao == 0) {
            noRemovido = inicio;
            inicio = noRemovido.getProx();
            inicio.setAnt(null);

        }

        else if (posicao == contadorNos - 1) {
            noRemovido = fim;
            fim = noRemovido.getAnt();
            fim.setProx(null);

        }

        else {
            NoDup<T> noAnterior = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                noAnterior = noAnterior.getProx();
            }

            noRemovido = noAnterior.getProx();
            noAnterior.setProx(noRemovido.getProx());
            noRemovido.getProx().setAnt(noAnterior);
        }

        contadorNos--;
        System.out.println(noRemovido.getDado());
        return noRemovido.getDado();

    }

    @Override
    public void limpar() {
        inicio = null;
        fim = null;
        contadorNos = 0;
        System.out.println("Lista limpa com sucesso");

    }

    @Override
    public int getTamanho() {
        return contadorNos;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        NoDup<T> noAtual = inicio;
        while (noAtual != null) {
            if (noAtual.getDado().equals(elemento)) {
                return true;
            }
            noAtual = noAtual.getProx();
        }
        return false;

    }

    @Override
    public Lista<T> subLista(int posInicial, int posFinal) throws Exception {
        if (posInicial < 0 || posFinal >= contadorNos || posInicial > posFinal) {
            throw new Exception("Intervalo inválido");
        }

        Lista<T> subLista = new ListaDupEnc<>();
        NoDup<T> atual = inicio;
        int posicao = 0;

        while (atual != null) {
            if (posicao >= posInicial && posicao <= posFinal) {
                subLista.incluir(atual.getDado());
            }

            atual = atual.getProx();
            posicao++;
        }
        System.out.println(subLista);
        return subLista;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        NoDup<T> atual = inicio;

        while (atual != null) {
            sb.append(atual.getDado()).append(" ");
            atual = atual.getProx();
        }

        return sb.toString();
    }

}
