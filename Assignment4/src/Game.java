import java.util.Locale;
import java.util.Scanner;

public class Game {
    private Player player;
    private Tile_Carpet carpet;
    Game(){
        player = new Player();
        carpet = new Tile_Carpet();
    }

    int hop(){
        int k = player.hop();
        return k;
    }

    boolean iseven(int i) throws WrongIndexException{
        return carpet.iseven(i-1);
    }


    public static void main(String []args) throws Exception {
        // IO Exception maybe;
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        System.out.println("Hit Enter to initialise the game");
        s1.nextLine();
        Game game = new Game();
        System.out.println("Game is ready");
        String[] arr =new String[]{"first","second","third" , "fourth","fifth"};
        for(int i=0;i<5;i++){
            System.out.println("Hit Enter for your " + arr[i] + " hop");
            s2.nextLine();
            // 21 or greater tile exception
                int k = game.hop();
                try{
                    if (k>=21){
                        throw new MuddyPoolException("You are too Energetic and zoomed past all the tiles. Muddle Puddle Splash!");
                    }
                    System.out.println("You landed on Tile " + k);
                    if(!game.iseven(k)) {
                        Boolean flag =true;
                        while(flag){
                            System.out.println("Question answer round. Integer or Strings ?");
                            String choice;
                            choice = s2.nextLine();
                            choice = choice.toLowerCase();
                            try{
                                if(!choice.equals("integer") && !choice.equals("string") && !choice.equals("integers") && !choice.equals("strings")){
                                    throw new WrongChoiceException("The choice must be between Integer and String");
                                }
                                flag = false;
                            }
                            catch(WrongChoiceException e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    else{
                        game.wintoy(k);
                    }
                }
                catch(MuddyPoolException e){
                    System.out.println(e.getMessage());
                }

        }
        game.endgame();
    }

    private void endgame() {
        player.gameOver();
    }

    private void wintoy(int k) throws WrongIndexException {
        Soft_Toy toy = carpet.cloner(k-1);
        System.out.println("You won a " + toy + " soft toy");
        player.addtoy(toy);
    }
}
