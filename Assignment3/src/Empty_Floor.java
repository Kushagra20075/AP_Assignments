public class Empty_Floor extends Floor{
    Empty_Floor(int floornum){
        super(floornum);
    }
    @Override
    public void jump() {
        int floor = this.getFloornum();
        setFloornum(floor + 1);
    }
    @Override
    public void pointchanger() {
        this.setPoints(1);
    }
}
