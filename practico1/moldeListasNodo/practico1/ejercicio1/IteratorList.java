package practico1.ejercicio1;

import java.util.Iterator;

public class IteratorList<T> implements Iterator<T>{
    private Node<T> nodo;

    public IteratorList(Node<T> nodo) {
        this.nodo = nodo;
    }

    @Override
    public boolean hasNext() {
        return this.nodo.getNext() != null;
    }

    @Override
    public T next() {
        T temp = nodo.getInfo();
        nodo = nodo.getNext();
        return temp;
    }

    
}