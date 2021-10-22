public class Empty_Floor extends Floor{
    Empty_Floor(int floornum){
        super(floornum , "Empty Floor");
        jump();
        pointchanger();
    }
    @Override
    public void jump() {
        int floor = this.getFloornum();
        this.setjump(-1);
    }
    @Override
    public void pointchanger() {
        this.setPoints(1);
    }
}
