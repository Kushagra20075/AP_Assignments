import java.util.ArrayList;
import java.util.HashMap;

public class Student implements Logger {

    private String name;


    Student(String name){
        this.name= name;
    }

    @Override
    public void view_lectures(ArrayList<Material> material) {
        for (Material mat : material) {
            mat.view();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int WhoAmI(){
        return 0;
    }

    @Override
    public void view_Assessment(ArrayList<Assessment> assessments) {
        for(int i=0;i<assessments.size();i++){
            Assessment ass = assessments.get(i);
            ass.view_Assessment(i);
        }
    }
}
