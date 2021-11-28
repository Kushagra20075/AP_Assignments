public final class Normal_Ladder extends Ladder_Floors{
    Normal_Ladder(int floornum){
        super(floornum, "Ladder Floor");
        jump();
        pointchanger();
    }
    @Override
    public void jump(){
        this.setjump(12);
    }
    @Override
    public void pointchanger() {
        this.setPoints(2);
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
