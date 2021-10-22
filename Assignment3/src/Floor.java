public abstract class Floor {
    int floornum;
    int points;
    Floor(int floornum){
        this.floornum = floornum;
        this.points = 0;
    }
    public int getFloornum(){
        return this.floornum;
    }

    public void setFloornum(int floornum){
        this.floornum = floornum;
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
