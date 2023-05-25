package br.edu.ifs.ED.lista;


public class ListaDEInt extends ListaDupEnc<Integer>{
    NoDupInt inicio;
    NoDupInt fim;
    int qtd;
    @Override
    public String toString(){
        NoDupInt temp = inicio;
        String resposta = "";
        while (temp!=null){
            resposta += temp.dado + " ";
            temp = temp.prox;
        }
        return resposta;
    }
    public ListaDEInt(){
        inicio = fim = null;
        qtd = 0;
    }
    @Override
    public void incluirInicio(Integer elemento) throws Exception {
        NoDupInt novo = new NoDupInt();
        novo.dado = elemento;
        if ( inicio == null ){
            fim = novo;
        } else {
            novo.prox = inicio;
            inicio.ant = novo;
        }
        inicio = novo;
        qtd ++;
    }
    @Override
    public void incluir(Integer elemento) throws Exception {
        NoDupInt novo = new NoDupInt();
        novo.dado = elemento;
        if ( inicio == null){
            inicio = fim = novo;
        } else {
            novo.ant = fim;
            fim.prox = novo;
            fim = novo;
        }
        qtd++;
    }

    @Override
    public void limpar() {
        inicio = fim = null;
        qtd = 0;
    }

    @Override
    public int getTamanho() {
        return this.qtd;
    }


    @Override
    public void incluir(Integer elemento, int posicao) throws Exception {
        if ( posicao > qtd || posicao < 0){
            throw new Exception();
        }
        NoDupInt aux = inicio;
        int i = 0;
        while ( i < posicao ){
            aux = aux.prox;
            i++;
        }
        NoDupInt novo = new NoDupInt();
        novo.prox = aux.prox;
        novo.ant = aux;
        aux.prox = novo;
        novo.prox.ant = novo;
        qtd++;
    }
}
