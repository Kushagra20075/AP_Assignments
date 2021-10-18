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
            System.out.println("-------------------------------------------");
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
    public void viewgrade(ArrayList<Assessment> assessments) {
        System.out.println("Graded Submissions");
        System.out.println("---------------------------");
        for(Assessment ass : assessments){

            if(ass.is_graded(this)){
                ass.printer(this);
            }
        }
        System.out.println("UnGraded Submissions");
        System.out.println("---------------------------");
        for(Assessment ass : assessments){
            if(!ass.is_graded(this)&&ass.is_submitted(this)){
                ass.printer_ungraded(this);
            }
        }
    }
    public void submit(Assessment ass, Submission sub , Student User) {
        if(ass.check_Submission(sub)){
            if(this!=User){System.out.println("What is happening");}
            ass.submit(User,sub);
        }
        else{
            System.out.println("Wong Submission Format");
        }
    }
}
