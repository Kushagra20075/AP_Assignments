public final class King_Cobra extends Cobra_Floors {
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
