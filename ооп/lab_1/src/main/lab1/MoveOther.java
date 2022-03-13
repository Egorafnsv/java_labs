package lab1;

class MoveOther implements MoveStrategy {
    @Override
    public int move(int energy) {
        if ((energy + 25) < 100){
            System.out.println(" отдохнул.");
            return 25;
        }
        else{
            System.out.println(" полностью отдохнул.");
            return 100;
        }
    }
}
