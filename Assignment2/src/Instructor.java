import java.util.ArrayList;

public class Instructor implements Logger {

    private String name;
    Instructor(){
        this.name="";
    }

    void add(Material lecturemat,ArrayList<Material> material){
        material.add(lecturemat);
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int WhoAmI(){
        return 1;
    }
}
