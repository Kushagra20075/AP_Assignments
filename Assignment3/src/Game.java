import java.lang.reflect.Array;

public class Game {
    Player player;
    Floor[] floors ;
    int dicenum;

    Game(String name){
        System.out.println("The game setup is ready");
        player = new Player(name);
        //Hardcoding the Constructor itself
        floors = new Floor[14];
        floors[0] = null;
        floors[1] = new Empty_Floor(1);
        //elevator
        floors[2] = null;
        floors[3] = new Empty_Floor(3);
        floors[4] = new Empty_Floor(4);
        //Snake
        floors[5] = new Normal_Cobra(5);
        floors[6] = new Empty_Floor(6);
        floors[7] = new Empty_Floor(7);
        //Ladder
        floors[8] = null;
        floors[9] = new Empty_Floor(9);
        floors[10] = new Empty_Floor(10);
        //King_Cobra
        floors[11] = new King_Cobra(11);
        floors[12] = new Empty_Floor(12);
        floors[13] = new Empty_Floor(13);
        dicenum = 0;
    }

    void roll(){
        this.dicenum = player.roll();
        System.out.println("Dice gave " + this.dicenum);
    }

    public static void main(String[] args) throws Exception{
        Game gm = new Game();
        Dice ds = new Dice();
        System.out.println(ds);
        System.out.println(ds);
        System.out.println(ds);
        C obj = new C();
        obj.func();
    }
}
