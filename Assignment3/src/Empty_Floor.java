public class Empty_Floor extends Floor{
    Empty_Floor(int floornum){
        super(floornum , "Empty Floor");
        jump();
        pointchanger();
    }
    @Override
    public void jump() {
        this.jumptofloor = -1;
    }
    @Override
    public void pointchanger() {
        this.setPoints(1);
    }
}
