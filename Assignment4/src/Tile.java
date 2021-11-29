public class Tile {
    private Soft_Toy toy;
    private Boolean even;
    Tile(String name ,Boolean iseven ){
        toy = new Soft_Toy(name);
        even = iseven;
    }
    Boolean iseven(){
        return this.even;
    }
    void cloner(Player player){
        Soft_Toy cloned = toy.clone();
        player.addtoy(cloned);
        System.out.println("You won a " + cloned + " soft toy");
    }
    String name(){
        return toy.getName();
    }
}
