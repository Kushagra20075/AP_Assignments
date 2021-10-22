import java.util.Random;

public class Dice {
    private int face;
    Random rn;
    Dice(){
        face = 0;
        rn = new Random();
    }
    public int Roll(){
        this.face = 1 + rn.nextInt(2);
        return this.face;
    }
}
