package practico2;

public class Ejercicio3 {
    public static void main(String[] args) {
        int entero = 26;
        System.out.println(deEnteroABinario(entero));
    }
    public static String deEnteroABinario(int entero){
        if (entero == 1) {
            return "1";
        }
        if (entero == 0) {
            return "0";
        }
        return deEnteroABinario(entero/2) + deEnteroABinario(entero%2);
    }
}
