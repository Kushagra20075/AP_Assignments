public final class Player {
    private final String Name;
    private int points;
    private Floor currfloor;
    private final Dice dice;
    Player(String Name){
        this.Name = Name;
        this.points = 0;
        this.currfloor = null;
        this.dice = new Dice();
    }

    String getName(){
        return this.Name;
    }

    int getjumpnum(){
        if(currfloor==null){
            return -1;
        }
        return currfloor.getJumptofloor();
    }

    int getfloornum(){
        if(currfloor==null){
            return -1;
        }
        return currfloor.getFloornum();
    }

    void setCurrfloor(Floor floor){
        this.currfloor = floor;
    }

    int roll(){
        return dice.Roll();
    }


    public void addpoints(int points) {
        this.points = this.points + points;
    }

    public int getPoints() {
        return this.points;
    }
}
