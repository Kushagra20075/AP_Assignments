import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quiz implements Assessment{

    String question;
    int maxmarks;
    HashMap<Student , Submission> submissions;
    Instructor Publisher;

    Quiz(String question , int maxmarks , ArrayList<Student> students , Instructor Publisher){
        this.maxmarks = maxmarks;
        this.question = question;
        submissions = new HashMap<>();
        this.Publisher = Publisher;
        for(Student stud : students){
            submissions.put(stud,null);
        }
    }

    @Override
    public int grade(Student stud, int marks , Instructor prof) {
        if(submissions.containsKey(stud)){
            Submission sub = submissions.get(stud);
            if(marks>maxmarks){
                System.out.println("Cannot give more marks than maximum marks");
                return -1;
            }
            else{
                sub.grade(marks,prof);
                return 0;
            }
        }
        System.out.println("Student does not exist");
        return -1;
    }

    @Override
    public Instructor get_Publisher() {
        return Publisher;
    }

    @Override
    public void close() {
        for(Map.Entry<Student , Submission> map : submissions.entrySet()){
            if(map.getValue() !=null){
                map.getValue().close();
            }
        }
    }
    @Override
    public void view_Assessment(int index) {
        System.out.println("ID :" + index + "Question: " + question);
    }
    //Complete this
    @Override
    public boolean check_Submission(Submission answer) {
        return true;
    }

    @Override
    public boolean is_graded(Student stud) {
        if(submissions.containsKey(stud)){
            Submission sub = submissions.get(stud);
            return sub != null && sub.getMarks() != -1;
        }
        return false;
    }

    @Override
    public boolean is_submitted(Student stud) {
        if(submissions.containsKey(stud)){
            Submission sub = submissions.get(stud);
            return sub != null;
        }
        return false;
    }

    @Override
    public void printer(Student student) {
        if (submissions.containsKey(student)) {
            Submission sub = submissions.get(student);
            if(sub!=null){
                System.out.println("Question : " + this.question);
                System.out.println("Submission : " + sub.getSolution());
                System.out.println("Marks scored : " + sub.getMarks() );
                System.out.println("Graded by : " + sub.getgrader());
            }
        }
    }
    @Override
    public void submit(Student student, Submission sub) {
        if(!submissions.containsKey(student)){
            submissions.put(student,sub);
        }
    }

}
