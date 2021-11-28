import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Student implements Logger {
    private String name;

    Student(String name){
        this.name= name;
    }



    public void viewgrade(ArrayList<Assessment> assessments) {
        System.out.println("Graded Submissions");
        for(Assessment ass : assessments){

            if(ass.is_graded(this)){
                ass.printer(this);
                System.out.println();
            }
        }
        System.out.println("---------------------------");
        System.out.println();
        System.out.println("UnGraded Submissions");
        for(Assessment ass : assessments){
            if(!ass.is_graded(this)&&ass.is_submitted(this)){
                ass.printer_ungraded(this);
                System.out.println();
            }
        }
        System.out.println("---------------------------");
        System.out.println();
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

    @Override
    public Student Logout() {
        return this;
    }

    @Override
    public void view_comments(ArrayList<Comment> comments) {
        for(Comment comm : comments){
            comm.view();
        }
    }

    @Override
    public void addComment(ArrayList<Comment> comment , String comm) {
        Date date = new Date();
        Comment comobj = new Comment(comm,this,date);
        comment.add(comobj);
    }

    @Override
    public void viewassessments(ArrayList<Assessment> assessments) {
        for(int i=0;i<assessments.size();i++){
            Assessment ass = assessments.get(i);
            if(!ass.is_closed())
                ass.view_Assessment(i);
            System.out.println("-------------------------------------------");
        }
    }

}
