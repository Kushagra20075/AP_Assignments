public class King_Cobra extends Cobra_Floor {
    King_Cobra(int floornum){
        super(floornum);
        jump();
        pointchanger();
    }
    @Override
    public void jump() {
        this.setFloornum(3);
    }
    @Override
    public void pointchanger() {
        this.setPoints(-4);
    }
}
