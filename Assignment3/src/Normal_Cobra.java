public final class Normal_Cobra extends Snake_Floor{
    Normal_Cobra(int floornum){
        super(floornum , "Cobra Floor");
        jump();
        pointchanger();
    }
    @Override
    public void jump() {
        this.setjump(1);
    }
    @Override
    public void pointchanger() {
        this.setPoints(-2);
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
