import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bucket {
    private ArrayList<Soft_Toy> toys;
    Bucket(){
        toys = new ArrayList<Soft_Toy>();
    }

    void add_toy(Soft_Toy toy){
        toys.add(toy);
    }
    void print(){
        if(toys.size()==0){
            System.out.println("No toys were won by you");
        }
        else{
            System.out.println("Soft Toys won by you are:");
            for(int i=0;i<toys.size()-1;i++){
                Soft_Toy a = toys.get(i);
                System.out.print(a + ",");
            }
            Soft_Toy a = toys.get(toys.size()-1);
            System.out.print(a);
        }
    }
}
