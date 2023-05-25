package br.edu.ifs.ED.lista;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> {

    No<T> noInicioLista;
    No<T> noFimLista;
    int contadorNos = 0;
    public ListaEnc(){
        noInicioLista = new No<>();
        noFimLista = new No<>();
    }

    @Override
    public void incluir(T elemento) throws Exception {
        if (noInicioLista.getDado() == null) {
            noInicioLista.setDado(elemento);
            noInicioLista.setProx(noFimLista);
            contadorNos++;
        } else {
            No<T> novoNo = new No<>();
            noFimLista.setDado(elemento);
            noFimLista.setProx(novoNo);
            noFimLista = novoNo;
            contadorNos++;
        }
    }


    public T get(int posicao)  throws Exception {
        if (posicao > contadorNos - 1 || posicao < 0) {
            throw new Exception("Posição solicitada não existe na lista");
        } else {
            No<T> auxiliar = noInicioLista;

            for (int i = 0; i < posicao; i++) {
                auxiliar = auxiliar.getProx();
            }
            return auxiliar.getDado();
        }
    }


    public int getPosElemento(T elemento)  throws Exception {
        No<T> auxiliar = noInicioLista;
        for (int i = 0; i < contadorNos; i++) {
            if (auxiliar.getDado().equals(elemento)) {
                return i;
            }
            auxiliar = auxiliar.getProx();
        }

        return -1;
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        if (noInicioLista.getDado() == null) {
            noInicioLista.setDado(elemento);
            noInicioLista.setProx(noFimLista);
            contadorNos++;
        } else {
            No<T> novoInicio = new No<>();
            novoInicio.setDado(elemento);
            novoInicio.setProx(noInicioLista);
            noInicioLista = novoInicio;
            contadorNos++;
        }
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao > contadorNos - 1 || posicao < 0) {
            throw new Exception("Posição solicitada não existe na lista");
        } else if (posicao == contadorNos) {
            incluir(elemento);
        } else if (posicao == 0) {
            incluirInicio(elemento);
        } else {
            No<T> auxiliar = noInicioLista;
            for (int i = 0; i < posicao - 1; i++) {
                auxiliar = auxiliar.getProx();
            }
            No<T> novoNo = new No<>();
            novoNo.setDado(elemento);
            novoNo.setProx(auxiliar.getProx());
            auxiliar.setProx(novoNo);

            if (posicao == contadorNos) {
                noFimLista = novoNo;
            }

            contadorNos++;
        }
    }

    @Override
    public T remover(int posicao) throws Exception {
        if (posicao > contadorNos - 1 || posicao < 0) {
            throw new Exception("Posição solicitada não existe na lista");
        } else if (contadorNos == 1) {
            limpar();
        } else {
            No<T> auxiliar = noInicioLista;

            for (int i = 0; i < posicao - 1; i++) {
                auxiliar = auxiliar.getProx();
            }

            if (posicao == 0) {
                //se for o primeiro da lista
                noInicioLista = noInicioLista.getProx();
            } else if (posicao + 1 <= contadorNos - 1) {
                //se for qualquer outro entre o início e o fim
                auxiliar.setProx(auxiliar.prox.prox);
            } else {
                //se for o fim da lista
                auxiliar.setProx(noFimLista);
            }

            contadorNos--;
        }
        String msg = "este numero foi removido";
        return (T) msg;
    }

    @Override
    public int getTamanho() {

        return contadorNos;
    }

    public void limpar() {
        noInicioLista = new No<>();
        noFimLista = new No<>();
        contadorNos = 0;
    }



    @Override
    public boolean contem(T elemento) throws Exception {
        No<T> auxiliar = noInicioLista;

        while (auxiliar.getProx() != null) {
            if (auxiliar.dado.equals(elemento)) {
                return true;
            }
            auxiliar = auxiliar.getProx();
        }

        return false;
    }

}
