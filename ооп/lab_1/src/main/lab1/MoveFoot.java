package lab1;

class MoveFoot implements MoveStrategy {
    @Override
    public int move(int energy) {
        if ((energy - 15) >= 0){
            System.out.println(" ушел ногами.");
            return -15;
        }
        else{
            System.out.println(" устал.");
            return 0;
        }
    }
}
