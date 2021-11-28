import java.util.Scanner;

public class Game {
    private final Player player;
    private final Tile_Carpet carpet;
    private final random_generator<Integer , String> randomizer;
    private final Calculator<Integer,String> calculator;

    Game(){
        player = new Player();
        carpet = new Tile_Carpet();
        calculator = new Calculator<Integer, String>() {
            @Override
            Integer calculateI(Integer x, Integer y) {
                return x/y;
            }

            @Override
            String calculateS(String str1, String str2) {
                return str1+str2;
            }
        };
        randomizer = new random_generator<Integer, String>() {
            @Override
            Integer randomnum() {
                return 1;
            }

            @Override
            String randomstring() {
                return "hello";
            }
        };

    }

    int getrandomnum(){
        return randomizer.randomnum();
    }

    String getrandomstring(){
        return randomizer.randomstring();
    }

    int hop(){
        return player.hop();
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
                                if(choice.equals("integer") || choice.equals("integers")){

                                    int a =0 ,b =0;
                                    boolean flag1 =true;
                                    while(flag1){
                                        try{
                                            a = game.getrandomnum();
                                            b = game.getrandomnum();
                                            if(b==0){
                                                throw new DivideByZeroException();
                                            }
                                            flag1 =false;
                                        }
                                        catch(DivideByZeroException e){
                                            flag1 =true;
                                        }
                                    }
                                    System.out.println("Calculate the result of " + a + " divided by " + b );
                                    int ans = s1.nextInt();
                                    int solution = game.calculateI(a,b);

                                    if(ans!=solution){
                                        throw new WrongAnswerException("Incorrect Answer");
                                    }
                                    else{
                                        game.wintoy(k);
                                    }
                                }
                                else if(choice.equals("string") || choice.equals("strings")){
                                    String a , b;
                                    a = game.getrandomstring();
                                    b = game.getrandomstring();
                                    System.out.println("Calculate the concatenation of strings " + a + " and " + b);
                                    String ans = s1.nextLine();
                                    String solution = game.calculateS(a,b);
                                    if(!ans.equals(solution)){
                                        throw new WrongAnswerException("Incorrect Answer");
                                    }
                                    else{
                                        game.wintoy(k);
                                    }
                                }
                                else{
                                    throw new WrongChoiceException("The choice must be between Integer and String");
                                }
                                flag = false;
                            }
                            catch(WrongChoiceException e){
                                System.out.println(e.getMessage());
                            }
                            catch(WrongAnswerException e){
                                System.out.println(e.getMessage());
                                System.out.println("You did not win any Soft Toy");
                                flag = false;
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

    private String calculateS(String a, String b) {
        return calculator.calculateS(a,b);
    }

    private int calculateI(int a, int b) {
        return calculator.calculateI(a,b);
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
