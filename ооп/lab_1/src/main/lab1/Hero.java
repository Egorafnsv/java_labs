package lab1;

public class Hero {
    private final String name;
    private boolean place = true;
    private int energy = 100;
    private MoveStrategy moveStrategy;

    public Hero(String name){
        this.name = name;
        SetStrategy(new MoveOther(), "отсутствует.");
    }

    public void SetStrategy(MoveStrategy moveStrategy, String method){
        this.moveStrategy = moveStrategy;
        System.out.println("Текущий способ передвижения: " + method);
    }

    public void move(){
        int move_status;

        System.out.print(this.name);
        move_status = moveStrategy.move(energy);
        if(move_status < 0){
            this.place = !this.place;
            energy += move_status;
        }
        else if (move_status == 100){
            energy = 100;
        }
        else
        {
            energy += move_status;
        }
        whereHero();
    }

    private void whereHero(){
        if (this.place) {
            System.out.println(name + " в точке А");
        }
        else {
            System.out.println(name + " в точке Б");
        }
        System.out.println("Уровень энергии: " + energy);
    }
}
