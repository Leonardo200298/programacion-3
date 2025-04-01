package practico2;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[] arreglo = {-2,-1,0,2,4,6,9};
        System.out.println(mismoValorIndice(arreglo, 0));
    }

    public static boolean mismoValorIndice(int[] arr, int i) {

        if (i >= arr.length) { 
            return false;
        }
        if (arr[i] > i) {
            return false;
        }
        if (arr[i] == i) { 
            return true;
        }

        return mismoValorIndice(arr, i+1); 
    }
}
