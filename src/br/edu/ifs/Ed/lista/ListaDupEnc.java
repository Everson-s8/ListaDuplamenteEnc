package br.edu.ifs.Ed.lista;

import java.util.Comparator;

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
        if (tamanho == 0){
            throw new Exception("Lista Vazia");
        }
        if (posicao > tamanho | posicao < 0){
            throw new Exception("A posicao e maior que o tamanho da lista, nao existindo valor nessa posicao");
        }
        if (posicao == 0){
            incluirInicio(elemento);
            throw new Exception("O valor foi colocado na posicao 0");
        }
        if (posicao == tamanho-1){
           incluir(elemento);
        }
        NoDup<T> Elemento = new NoDup<>(elemento);
        NoDup aux = primeiro.proximo;
        for (int i = 1; i < tamanho-1 ; i++) {
            if (posicao == i){
                aux.anterior.proximo = Elemento;
                Elemento.anterior = aux.anterior;
                aux.anterior = Elemento;
                Elemento.proximo = aux;

            }
           aux = aux.proximo;
        }
    }


    public T get(int posicao) throws Exception {
        if (tamanho == 0){
            throw new Exception("Lista Vazia");
        }
        if (posicao > tamanho | posicao < 0){
            throw new Exception("A posicao e maior que o tamanho da lista, nao existindo valor nessa posicao");
        }
        NoDup aux = this.primeiro;
        for (int i = 0; i < tamanho ; i++) {
            if (i == posicao){
                throw new Exception("O elemento da posicao" + "   " + posicao + "é :" + aux.valor);
            }else {
               aux = aux.proximo;
            }
        } throw new Exception("Elemento não existe");

    }


    public int getPosElemento(T elemento) throws Exception {
        if (tamanho == 0){
            throw new Exception("Lista Vazia");
        }
        NoDup aux = this.primeiro;
        int cont = 0;
        while (aux != null){
            if (elemento == aux.valor){
                throw new Exception("O elemento está na posicao:" + cont);
            }
            aux = aux.proximo;
            cont++;
        } throw new Exception("Elemento não existe");

    }


    public void remover(int posicao) throws Exception {
        if (tamanho == 0){
            throw new Exception("Lista Vazia");
        }
        if (posicao > tamanho | posicao < 0){
            throw new Exception("A posicao e maior que o tamanho da lista, nao existindo valor nessa posicao");
        }
        NoDup aux = primeiro.proximo;

            if (posicao == 0){
                primeiro = primeiro.proximo;
                primeiro.anterior = null;
                tamanho--;
                throw new Exception("Valor no primeiro indice, removido com sucesso");
            }
            if (posicao == tamanho-1){
                ultimo = ultimo.anterior;
                ultimo.proximo = null;
                tamanho--;
                throw new Exception("Valor no ultimo indice, removido com sucesso");
            }
        for (int i = 1; i < tamanho-1 ; i++) {
            if (posicao == i){
                aux.proximo.anterior = aux.anterior;
                aux.anterior.proximo = aux.proximo;
                tamanho--;
                throw new Exception("Valor no indice" + "  " + i + "  " + "removido com sucesso");
            }
            aux = aux.proximo;
        }
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

