package practico2;

public class Ejercicio1 {
    public static void main(String[] args) {
        int [] arr = {8,5,3,3,1,4,7};
        boolean verificador = false;
        verificador = estaOrdenado(0, arr);
        System.out.println("Expresion: " + verificador);
    }
        
    public static boolean estaOrdenado(int i, int[] arr) {
        //caso base, el numero ingresado es mayor a la longitud del array, por lo tanto el array esta ordenado
        if (i >= arr.length) {
            return true;
        }
        //condicion de corte, si el elemento no es mayor a su consecutivo devuelve falso
        if (arr[i] <= arr[i+1]) {
            return false;
        }
        //caso recursivo, mientras que el elemento sea mayor a su consecutivo la funcion sigue llamandose a 
        //si misma incrementando el valor del indice para recorrer el array
        return estaOrdenado(i+1, arr);
    }
}
