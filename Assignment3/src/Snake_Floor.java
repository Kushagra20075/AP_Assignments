public abstract class Snake_Floor extends Floor {
    Snake_Floor(int floornum, String Name) { super(floornum, Name); }
    @Override
    public abstract void jump();
    @Override
    public abstract void pointchanger();
    @Override
    public abstract void setPoints(int points);
    @Override
    public abstract int getPoints();
    @Override
    public abstract int getJumptofloor();
    @Override
    public abstract void setjump(int jumpno);
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int getFloornum(){
        return this.floornum;
    }
}
