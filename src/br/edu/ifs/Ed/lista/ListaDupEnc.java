package br.edu.ifs.Ed.lista;

public class ListaDupEnc<T extends Comparable<T>> extends Lista<T> {
    public int tamanho;
    public NoDup<T> primeiro;
    public NoDup<T> ultimo;
    public NoDup<T> anterior;

    public void incluir(T elemento) throws Exception {
        NoDup<T> Elemento = new NoDup<>(elemento);
        NoDup aux = primeiro;
        if (this.tamanho == 0) {
           primeiro = Elemento;
           anterior = null;
           tamanho++;
        } else {
            ultimo.proximo = Elemento;
            Elemento.anterior = ultimo;
            tamanho++;
        }
        ultimo = Elemento;
    }


    public void incluirInicio(T elemento) throws Exception {
        NoDup<T> Elemento = new NoDup<>(elemento);
        Elemento.proximo = primeiro;
        primeiro.anterior = Elemento;
        primeiro = Elemento;
        tamanho++;
    }


    public void incluir(T elemento, int posicao) throws Exception {
        throw new Exception("Não implementado");

    }


    public T get(int posicao) throws Exception {
        throw new Exception("Não implementado");

    }


    public int getPosElemento(T elemento) throws Exception {
        throw new Exception("Não implementado");

    }


    public void remover(int posicao) throws Exception {
        throw new Exception("Não implementado");

    }


    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean contem(T elemento) throws Exception {
        if (tamanho == 0){
            throw new Exception("Lista Vazia");
        }

        NoDup aux = this.primeiro;
        while (aux != null){
            if (elemento == aux.valor){
                throw new Exception("Existe");
            }
            aux = aux.proximo;
        }throw new Exception("Não existe");
    }

    public void imprimir() {
        NoDup aux = this.primeiro;
        while (aux != null) {
            System.out.print(aux.valor + "  -->  ");
            aux = aux.proximo;
        }System.out.printf("Null");
    }
}
