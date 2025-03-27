package practico2;

public class Ejercicio1 {
    public static void main(String[] args) {
        int [] arr = {8,5,3,3,1,4,7};
        boolean verificador = false;
        verificador = estaOrdenado(0, arr);
                System.out.println("Expresion: " + verificador);
    }
        
    public static boolean estaOrdenado(int i, int[] arr) {
        if (i >= arr.length) {
            return true;
        }
        if (arr[i] <= arr[i+1]) {
            return false;
        }
        return estaOrdenado(i+1, arr);
    }
}
