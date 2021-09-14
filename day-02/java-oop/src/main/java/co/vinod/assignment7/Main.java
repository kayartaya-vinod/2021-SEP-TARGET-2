package co.vinod.assignment7;

public class Main {

    static double pow(double a, int b) {
        double p = 1;
        for(int i=0; i<b; i++){
            p *=a;
        }
        return p;
    }

    static long factorial(int n) {
        long f = 1;
        while (n > 1) {
            f *= n--;
        }
        return f;
    }


    static double sine(int x) {
        double r = x * Math.PI / 180.0 ;
        double s = 0;
        int j = 1;
        for(int i=1; i<=20; i+=2){
            s += j* pow(r, i) / factorial(i);
            j *= -1;
        }

        return s;
    }

    public static void main(String[] args) {
        int degree = 45;
        double s = sine(degree);
        System.out.printf("sine(%d) is %f\n", degree, s);

    }
}
