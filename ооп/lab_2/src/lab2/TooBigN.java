package lab2;

public class TooBigN extends Exception{
    private int m;
    private int n;

    TooBigN(int m, int n){
        this.m = m;
        this.n = n;
    }

    @Override
    public String toString(){
        return "M or N are too large (> 1 000 000): M = " + m + ", N = " + n;
    }
}
