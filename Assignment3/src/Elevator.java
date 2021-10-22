public class Elevator extends Floor {

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
