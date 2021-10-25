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
    @Override
    public void setPoints(int points) {
        this.points = points;
    }
    @Override
    public int getPoints() {
        return points;
    }
    @Override
    public int getJumptofloor() {
        return this.jumptofloor;
    }
    @Override
    public void setjump(int jumpno){
        this.jumptofloor = jumpno;
    }

}
