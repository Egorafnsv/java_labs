package lab1;

class MoveFly implements MoveStrategy {
    @Override
    public int move(int energy) {
        if ((energy - 10) >= 0){
            System.out.println(" взял и улетел.");
            return -10;
        }
        else{
            System.out.println(" устал.");
            return 0;
        }
    }
}
