package practico2punto1;

public class Main {
    public static void main(String[] args) {
        /* prueba main */
        Tree arbol = new Tree();
        arbol.add(5);
        arbol.add(2);
        arbol.add(3);
        arbol.add(4);
        arbol.add(9);
        arbol.add(8);

        arbol.imprimirPreOrden(arbol.getRootNode());

    }
}
