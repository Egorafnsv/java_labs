
public class Main {
    public static void main(String[] args) {
        double a = 1234567890;
        double b = 0.00000001;
        double sum = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            sum += b;
        }
        sum += a;
        System.out.println(a);
        System.out.println(sum > a); //? Что будет выведено? Объясните результат. Исправьте алгоритм
    }
}
