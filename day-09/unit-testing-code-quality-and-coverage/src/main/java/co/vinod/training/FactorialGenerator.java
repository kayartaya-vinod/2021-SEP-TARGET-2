package co.vinod.training;

public class FactorialGenerator {

    public Long factorial(Object num) throws FactorialException {
        if(num==null){
            return null;
        }

        long f = 1;
        Long n = Long.valueOf(num.toString());
        if(n<0){
            throw new FactorialException("Factorial of negative value does not exist");
        }
        while (n > 1) {
            f *= n--;
        }
        return f;
    }
}
