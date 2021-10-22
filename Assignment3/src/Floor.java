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

    public String getName(){
        return this.name;
    }
    public int getFloornum(){
        return this.floornum;
    }

    public void setjump(int jumpno){
        this.jumptofloor = jumpno;
    }

    public int getJumptofloor(){
        return this.jumptofloor;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public abstract void jump();
    public abstract void pointchanger();
}
