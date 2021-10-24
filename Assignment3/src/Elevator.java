public final class Elevator extends Ladder_Floors {
    Elevator(int floornum){
        super(floornum , "Elevator Floor");
        jump();
        pointchanger();
    }
    @Override
    public void jump(){
        this.setjump(10);
    }
    @Override
    public void pointchanger() {
        this.setPoints(4);
    }
}
