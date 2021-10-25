public final class King_Cobra extends Snake_Floor {
    King_Cobra(int floornum){
        super(floornum , "King Cobra Floor");
        jump();
        pointchanger();
    }
    @Override
    public void jump() {
        this.setjump(3);
    }
    @Override
    public void pointchanger() {
        this.setPoints(-4);
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
