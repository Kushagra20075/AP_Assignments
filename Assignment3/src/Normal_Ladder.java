public class Normal_Ladder extends Ladder_Floors{
    Normal_Ladder(int floornum){
        super(floornum, "Ladder Floor");
        jump();
        pointchanger();
    }
    @Override
    public void jump(){
        this.setjump(12);
    }
    @Override
    public void pointchanger() {
        this.setPoints(2);
    }
}
