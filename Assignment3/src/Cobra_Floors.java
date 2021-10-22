public abstract class Cobra_Floors extends Floor {
    Cobra_Floors(int floornum, String Name) {
        super(floornum, Name);
    }
    @Override
    public abstract void jump();
    @Override
    public abstract void pointchanger();
}

