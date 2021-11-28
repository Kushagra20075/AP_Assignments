public class Soft_Toy implements Cloneable {
    private String name;
    Soft_Toy(String name){
        this.name = name;
    }
    public Soft_Toy clone() {
        try{
            Soft_Toy toy = (Soft_Toy) super.clone();
            return toy;
        } catch (CloneNotSupportedException e){
            return null;
        }
    }
    String getName(){
        return this.name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
