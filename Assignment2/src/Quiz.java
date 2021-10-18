import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quiz implements Assessment{

    private String question;
    private int maxmarks;
    private HashMap<Student , Submission> submissions;
    private Instructor Publisher;
    private boolean isclosed;

    Quiz(String question , int maxmarks , ArrayList<Student> students , Instructor Publisher){
        this.maxmarks = maxmarks;
        this.question = question;
        submissions = new HashMap<>();
        this.Publisher = Publisher;
        for(Student stud : students){
            submissions.put(stud,null);
        }
        isclosed = false;
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
        this.isclosed = true;
    }

    @Override
    public boolean is_closed() {
        return this.isclosed;
    }
    @Override
    public void view_Assessment(int index) {
        System.out.println("ID : " + index + " Question: " + question);
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
    public void print_submission(Student student) {
        if (submissions.containsKey(student)) {
            Submission sub = submissions.get(student);
            if(sub!=null){
                System.out.println("Submission : " + sub.getSolution());
                System.out.println("----------------------------------");
                System.out.println("Max Marks : " + this.maxmarks );
            }
        }
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
    public void printer_ungraded(Student student) {
        if (submissions.containsKey(student)) {
            Submission sub = submissions.get(student);
            if(sub!=null){
                System.out.println("Question : " + this.question);
                System.out.println("Submission : " + sub.getSolution());
            }
        }
    }

    @Override
    public void submit(Student student, Submission sub) {
            submissions.put(student,sub);
    }
    @Override
    public void print_question() {
        System.out.print(this.question + " ");
    }
}
