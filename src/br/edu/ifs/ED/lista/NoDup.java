package br.edu.ifs.ED.lista;

public class NoDup<T>  {
    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NoDup<T> getProx() {
        return prox;
    }

    public void setProx(NoDup<T> prox) {
        this.prox = prox;
    }

    public NoDup<T> getAnt() {
        return ant;
    }

    public void setAnt(NoDup<T> ant) {
        this.ant = ant;
    }

    public T dado;
    public NoDup <T> prox;
    public NoDup <T> ant;

}
