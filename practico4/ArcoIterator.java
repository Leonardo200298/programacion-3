package practico4;

import java.util.Iterator;

public class ArcoIterator<T> implements Iterator<Integer> {
    private Iterator<Arco<T>> itArco;

    public ArcoIterator(Iterator<Arco<T>> itArco) {
        this.itArco = itArco;
    }

    @Override
    public boolean hasNext() {
        return itArco.hasNext();
    }

    @Override
    public Integer next() {
        return this.itArco.next().getVerticeDestino();
    }

}
