public abstract class Floor {
    protected int floornum;
    protected int points;
    protected int jumptofloor;
    protected String name;
    Floor(int floornum , String Name){
        this.floornum = floornum;
        this.points = 0;
        this.jumptofloor = 0;
        this.name = Name;
    }
    public abstract String getName();
    public abstract int getFloornum();
    public abstract void setjump(int jumpno);
    public abstract int getJumptofloor();
    public abstract int getPoints();
    public abstract void setPoints(int points);
    public abstract void jump();
    public abstract void pointchanger();
}
