import java.util.ArrayList;

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
    public void view_Assessment(ArrayList<Assessment> assessments) {

    }


}
