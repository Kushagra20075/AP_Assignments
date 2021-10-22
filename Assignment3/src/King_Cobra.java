public class King_Cobra extends Floor {
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
}
