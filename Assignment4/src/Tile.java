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
    Soft_Toy cloner(){
        return toy.clone();
    }
    String name(){
        return toy.getName();
    }
}
