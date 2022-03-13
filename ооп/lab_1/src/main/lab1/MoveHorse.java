package lab1;

class MoveHorse implements MoveStrategy {
    @Override
    public int move(int energy) {
        if ((energy - 5) >= 0){
            System.out.println(" использовал коня.");
            return -5;
        }
        else{
            System.out.println(" устал.");
            return 0;
        }
    }
}
