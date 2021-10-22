public class Player {
    String Name;
    int points;
    Floor currfloor;
    Dice dice;
    Player(String Name){
        this.Name = Name;
        this.points = 0;
        this.currfloor = null;
        this.dice = new Dice();
    }

    int roll(){
        return dice.Roll();
    }



}
