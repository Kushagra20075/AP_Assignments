public abstract class Ladder_Floors extends Floor{
    Ladder_Floors(int floornum, String Name) {
        super(floornum, Name);
    }
    @Override
    public abstract void jump();

    @Override
    public abstract void pointchanger();
}
