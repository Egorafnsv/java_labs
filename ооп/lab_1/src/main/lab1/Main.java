package lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Имя героя: ");
        Hero myHero = new Hero(input.nextLine());

        String userChoice;

        System.out.println("""
                    \nВыберите способ передвижения для героя: 'foot', 'horse', 'fly', 'sofa';
                    Переместиться: 'move';
                    Завершите работу: 'exit'.""");

        do {
            userChoice = input.nextLine();
            switch (userChoice){
                case "horse" -> myHero.SetStrategy(new MoveHorse(), "лошадь.");
                case "foot" -> myHero.SetStrategy(new MoveFoot(), "пешком.");
                case "fly" -> myHero.SetStrategy(new MoveFly(), "на крыльях.");
                case "sofa" -> myHero.SetStrategy(new MoveOther(), "диван.");
                case "move" -> myHero.move();
                case "exit" -> System.out.println("Завершение...");
                default -> System.out.println("Ничего не произошло.");
            }
        } while (!userChoice.equals("exit"));

        input.close();
    }
}
