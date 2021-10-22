public class Normal_Cobra extends Floor{
    Normal_Cobra(int floornum){
        super(floornum , "Cobra Floor");
        jump();
        pointchanger();
    }
    @Override
    public void jump() {
        this.setjump(1);
    }
    @Override
    public void pointchanger() {
        this.setPoints(-2);
    }
}
