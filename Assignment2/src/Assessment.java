public interface Assessment {
    void view_Assessment(int i);
    boolean check_Submission(Submission answer);
    void close();
    Instructor get_Publisher();
    int grade(Student stud, int marks , Instructor ins);
    boolean is_graded(Student stud);

    boolean is_submitted(Student stud);

    void printer(Student student);

    void submit(Student student, Submission sub);
}
