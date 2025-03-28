package practico2;

public class Ejercicio2 {
    public static void main(String[] args) {
        int [] arr = {2,3,5,6,7,8};
        int elemento = 10, inicio =0, fin = arr.length - 1;
        System.out.println("El elemento " + elemento + " esta en el array? " + buscarElementoRecursivo(arr,elemento,inicio,fin));
    }

    public static boolean buscarElementoRecursivo(int [] arr, int ele, int ini, int fin){
        int mitad = (ini + fin)/2;
        if(ini>fin){
            return false;
        }
        if (arr[mitad] == ele) {
            return true;
        }
        if (arr[mitad] < ele) {
            return buscarElementoRecursivo(arr, ele, mitad + 1, fin);
        }
        return buscarElementoRecursivo(arr, ele, ini, mitad - 1);
    }
}