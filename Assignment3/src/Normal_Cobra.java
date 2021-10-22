public class Normal_Cobra extends Cobra_Floor{
    Normal_Cobra(int floornum){
        super(floornum);
        jump();
        pointchanger();
    }
    @Override
    public void jump() {
        this.setFloornum(1);
    }
    @Override
    public void pointchanger() {
        this.setPoints(-2);
    }
}
