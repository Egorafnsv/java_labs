package lab2;

public class DivByZero extends ArithmeticException{
    private int i;
    private int j;

    DivByZero(int i, int j){
        this.i = i + 1;
        this.j = j + 1;
    }

    @Override
    public String toString(){
        return "Incorrect operation: division by zero. Index: (" + i + "; " + j + ").";
    }
}
