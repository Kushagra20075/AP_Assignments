public interface Assessment {
    void view_Assessment(int i);
    boolean check_Submission(Submission answer);
    void close();
    Instructor get_Publisher();
    int grade(Student stud, int marks , Instructor ins);
    boolean is_graded(Student stud);
    boolean is_submitted(Student stud);
    boolean is_closed();
    void printer(Student student);
    void submit(Student student, Submission sub);
    void print_question();
    void print_submission(Student student);

}
