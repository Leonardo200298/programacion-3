package practico2;

public class Ejercicio4 {
    public static void main(String[] args) {
        
    }
    public static int fibonacciSeis(int n){
        if (n == 5) {
            return n;
        }
        if (n> 5 && n> -1) {
            return 0;
        }
        return fibonacciSeis(n) * fibonacciSeis(n+n-1);
    }
}
