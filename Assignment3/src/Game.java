import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public final class Game {
    private final ArrayList<Player> players;
    private Player player;
    private final Floor[] floors;
    private int dicenum;
    private int points;

    Game(){
        players = new ArrayList<>();
        this.player = null;
        this.dicenum=0;
        this.points=0;
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
    }

    void newGame(String name){
        player = new Player(name);
        players.add(player);
        this.points=0;
        dicenum = 0;
        System.out.println("The game setup is ready");
    }

    boolean ishighscore(){
        Player max = this.player;
        for(int i=0;i<players.size();i++){
            if(max.getPoints()<=players.get(i).getPoints()){
                return false;
            }
        }
        return true;
    }

    void highscore(){
        Player max = null;
        for(int i=0;i<players.size();i++){
            if(max==null || max.getPoints()<players.get(i).getPoints()){
                max = players.get(i);
            }
        }
        if(max!=null){
            System.out.println("Highscore \nPlayer : " + max.getName() + "\nScore :" + max.getPoints());
        }
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
        pointsprinter(currfloor);
        player.setCurrfloor(currfloor);
        System.out.println();
        if(player.getfloornum()+dicenum == 13){
            player.addpoints(this.points);
            System.out.println("Game Over");
            System.out.println(player.getName() + " accumulated " + player.getPoints() + " Points" );
            if(ishighscore()){
                System.out.println("Congrats you have the set the new highscore");
                System.out.println();
            }
            else{
                System.out.println("Don't be disheartened you can try again");
                System.out.println();
            }

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

    private void pointsprinter(Floor currfloor) {
        this.points = this.points + currfloor.getPoints();
        System.out.println("Total Points " + this.points);
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);
        Game gm = new Game();


        boolean cont = true;
        boolean cont2 = true;
        while(cont){
            String name;
            System.out.println("Enter your name and press Enter");
            name = reader2.nextLine();
            gm.newGame(name);
            cont2 = true;
            while(cont2){
                System.out.print("Hit Enter to roll the dice");
                reader.nextLine();
                gm.roll();
                int x = gm.jump();
                if(x==1){
                    cont2 = false;
                    gm.highscore();
                    System.out.println("---------------------------------------");
                    System.out.println();
                    int ch =0;
                    System.out.println("1. Start new Game ");
                    System.out.println("Press any other key to exit");
                    ch = reader.nextInt();
                    if(ch!=1){
                        cont = false;
                    }
                }
            }
        }
        System.out.println("---------------------------------------");
    }
}
