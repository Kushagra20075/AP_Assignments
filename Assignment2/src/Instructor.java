import java.util.ArrayList;
import java.util.Date;

public class Instructor implements Logger {

    private String name;

    Instructor(String name){
        this.name=name;
    }

    void add(Material lecturemat,ArrayList<Material> material){
        material.add(lecturemat); }

    void close(Assessment assessment , ArrayList<Assessment> assessments){
        for(Assessment ass : assessments){
            if(ass == assessment){
                ass.close();
            }
        }
    }
    public void grade(Assessment ass, int marks, Student stud) {
        int x = ass.grade(stud,marks,this);
    }
    @Override
    public void view_lectures(ArrayList<Material> material) {
        for (Material mat : material) {
            mat.view();
            System.out.println("-------------------------------------------");
        }
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int WhoAmI(){
        return 1;
    }
    @Override
    public Instructor Logout() {
        return null;
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
