import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Assignment implements Assessment{
    private String problem;
    private Instructor Publisher;
    private HashMap<Student , Submission> submissions;
    private int maxmarks;
    private boolean isclosed;

    Assignment(String problem , Instructor Publisher , int maxmarks , ArrayList<Student> students) {
        this.problem = problem;
        this.Publisher = Publisher;
        this.maxmarks = maxmarks;
        submissions = new HashMap<>();
        for(Student stud : students){
            submissions.put(stud,null);
        }
        this.isclosed = false;
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
            if(map.getValue() !=null) {
                this.isclosed = true;
                map.getValue().close();
            }
        }
        this.isclosed = true;
    }
    @Override
    public void view_Assessment(int index) {
        System.out.println("ID :" + index + " Assignment: " + problem + " Max Marks: " + maxmarks);
    }
    //Complete this
    @Override
    public boolean check_Submission(Submission answer) {
        int size = answer.getSolution().length();
        String ans = answer.getSolution();
        if(size >= 5 && ans.endsWith(".zip")){
            return true;
        }
        //Hatana h end m
        System.out.println("Wrong format");
        return false;
    }
    @Override
    public boolean is_graded(Student stud) {
        if(submissions.containsKey(stud)){
            Submission sub = submissions.get(stud);
            if(sub==null){ return false ;}
            return sub.getMarks() != -1;
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
                System.out.println("Submission : " + sub.getSolution());
            }
        }
    }

    @Override
    public void print_submission(Student student) {
            Submission sub = submissions.get(student);
            if(sub!=null){
                System.out.println("Submission : " + sub.getSolution());
                System.out.println("----------------------------------");
                System.out.println("Max Marks : " + this.maxmarks );
            }
    }
    @Override
    public boolean is_closed() {
        return this.isclosed;
    }

    @Override
    public void submit(Student student, Submission sub) {
            submissions.put(student,sub);
    }
    @Override
    public void print_question() {
        System.out.print("Enter the filename for this assignment : ");
    }
}
