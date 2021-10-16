import java.util.HashMap;

public class Student implements Logger {

    private String name;
    HashMap <Assessment,Integer> assessments = new HashMap<>();


    Student(String name){
        this.name= name;
    }

    void add_Assessment(Assessment ass){
        if(assessments.containsKey(ass)){
            System.out.println("Faaltu harkat mt kro");
        }
        else {
            assessments.put(ass,-1);
        }
    }

    HashMap <Assessment,Integer> function(){
        return assessments;
    }


    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int WhoAmI(){
        return 0;
    }
}
