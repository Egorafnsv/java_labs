package lab4;

public class ThisIsClass {

    @ThisIsAnnotation(2)
    private void printHello(String name){
        System.out.println("HELLO, " + name);
    }

    @OtherAnnotation(3)
    @ThisIsAnnotation(5)
    private void printUnofficialHello(String name){
        System.out.println("ZDAROVA, " + name);
    }

    @OtherAnnotation(4)
    private void printRussianHello(String name){
        System.out.println("PRIVET, " + name);
    }
}
