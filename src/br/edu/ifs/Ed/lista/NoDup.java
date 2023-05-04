package br.edu.ifs.Ed.lista;

public class NoDup<T> {
    public T valor;
    public NoDup<T> proximo;
    public NoDup<T> anterior;

    public NoDup(T elemento) {
        valor = elemento;
    }

}