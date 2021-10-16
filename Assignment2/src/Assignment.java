import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Assignment implements Assessment{
    String problem;
    Instructor Publisher;
    HashMap<Student , Submission> submissions;
    int maxmarks;

    Assignment(String problem , Instructor Publisher , int maxmarks , ArrayList<Student> students) {
        this.problem = problem;
        this.Publisher = Publisher;
        this.maxmarks = maxmarks;
        submissions = new HashMap<>();
        for(Student stud : students){
            submissions.put(stud,null);
        }
    }

    @Override
    public void close() {
        for(Map.Entry<Student , Submission> map : submissions.entrySet()){
            map.getValue().close();
        }
    }

    @Override
    public void view_Assessment(int index) {
        System.out.println("ID :" + index + "Assignment: " + problem + " Max Marks: " + maxmarks);
    }
    //Complete this
    @Override
    public boolean check_Submission(Submission answer) {
        return false;
    }
}
