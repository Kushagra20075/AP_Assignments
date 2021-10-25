public final class Empty_Floor extends Floor{
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
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int getFloornum(){
        return this.floornum;
    }
}
