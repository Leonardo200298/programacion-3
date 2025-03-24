package practico1.ejercicio1;

public class DoubleLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int tamanio;

    public DoubleLinkedList() {
        this.first = null;
        this.tamanio = 0;
        this.last = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        if (this.first != null) {
            this.first.setPrev(tmp);

        }
        this.first = tmp;
        this.tamanio++;
    }

    public T extractFront() {
        if (this.first == null) {
            return null;
        }
        T aux = this.first.getInfo();
        if (this.first.getNext() == null) {
            this.first = null;
        }
        Node<T> temp = this.first.getNext();
        if (temp != null) {
            temp.setPrev(null);
            temp.setNext(null);
            this.first = temp;   
        }
        this.tamanio--;
        return aux;
    }

    public boolean isEmpty() {

        return this.first == null;
    }

    public T get(int index) {
        if (index < 0 || index >= this.tamanio) {
            return null;
        }
        
        int conI = 0;
        int conF = this.tamanio - 1;
        Node<T> i = this.first;
        Node<T> f = this.last;
    
        while (conI <= conF) {
            if (conI == index) {
                return i.getInfo();
            }
            if (conF == index) {
                return f.getInfo();
            }
    
            i = i.getNext();
            f = f.getPrev();
            conI++;
            conF--;
        }
        
        return null; 
    }
    
    public int size() {
		return this.tamanio;
	}
}
