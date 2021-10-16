import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quiz implements Assessment{

    String question;
    int maxmarks;
    HashMap<Student , Submission> submissions;

    Quiz(String question , int maxmarks , ArrayList<Student> students){
        this.maxmarks = maxmarks;
        this.question = question;
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
        System.out.println("ID :" + index + "Question: " + question + " Max Marks: " + maxmarks);
    }
    //Complete this
    @Override
    public boolean check_Submission(Submission answer) {
        return false;
    }
}
