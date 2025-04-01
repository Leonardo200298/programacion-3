package practico2;

public class Ejercicio4 {
    public static void main(String[] args) {
        
    }
    public static int fibonacci(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
