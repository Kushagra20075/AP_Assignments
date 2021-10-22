import java.util.Scanner;

public class Game {
    private final Player player;
    private final Floor[] floors;
    private int dicenum;

    Game(String name){
        System.out.println("The game setup is ready");
        player = new Player(name);
        //Hardcoding the Constructor itself
        floors = new Floor[14];
        floors[0] = new Empty_Floor(0);
        floors[1] = new Empty_Floor(1);
        //elevator
        floors[2] = new Elevator(2);
        floors[3] = new Empty_Floor(3);
        floors[4] = new Empty_Floor(4);
        //Snake
        floors[5] = new Normal_Cobra(5);
        floors[6] = new Empty_Floor(6);
        floors[7] = new Empty_Floor(7);
        //Ladder
        floors[8] = new Normal_Ladder(8);
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
    int jump(){
        if(player.getfloornum()==-1&&dicenum==2){
            System.out.println("Game cannot start until you get 1");
            return -1;
        }
        else if(player.getfloornum()+dicenum>13){
            System.out.println("Player cannot move");
            return -1;
        }
        Floor currfloor = floors[player.getfloornum() + dicenum ];
        this.dicenum = 0;
        System.out.println("Player position Floor - " + currfloor.getFloornum());
        //print message
        System.out.println(player.getName() + " has reached an " + currfloor.getName());
        pointsprinter(currfloor, player);
        player.setCurrfloor(currfloor);
        System.out.println();
        if(player.getfloornum()+dicenum == 13){
            System.out.println("Game Over");
            System.out.println(player.getName() + " accumulated " + player.getPoints() + " Points" );
            return 1;
        }
        if(currfloor.getJumptofloor()==-1){
            return 0;
        }
        Floor jumpfloor = floors[player.getjumpnum()];
        player.setCurrfloor(jumpfloor);
        this.dicenum=0;
        jump();
        return 0;
    }

    private void pointsprinter(Floor currfloor, Player player) {
        player.addpoints(currfloor.getPoints());
        System.out.println("Total Points " + player.getPoints());
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        String name;
        System.out.println("Enter your name and press Enter");
        name = reader.nextLine();
        Game gm = new Game(name);
        boolean cont = true;
        while(cont){
            System.out.print("Hit Enter to roll the dice");
            reader.nextLine();
            gm.roll();
            int x = gm.jump();
            if(x==1){
                cont=false;
            }
        }
        System.out.println("---------------------------------------");
    }
}
