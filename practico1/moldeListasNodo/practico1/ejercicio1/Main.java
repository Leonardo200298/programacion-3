package practico1.ejercicio1;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> miLista = new MySimpleLinkedList<>();
        miLista.insertFront(1);
        miLista.insertFront(4);
        miLista.insertFront(2);
        System.out.println(miLista.toString());
       
        System.out.println(miLista.get(1));
        
       
    }
}
