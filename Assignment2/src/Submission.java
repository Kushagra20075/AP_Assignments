public class Submission {
    String solution;
    int marks;
    boolean isopen;
    Instructor grader;
    Submission(String solution){
        this.solution = solution;
        this.marks = -1;
        this.isopen = true;
        this.grader = null;
    }
    public String getSolution() {
        return solution;
    }
    public int getMarks() {
        return marks;
    }
    void close(){
        this.isopen = false;
        if(this.marks==-1){
            this.marks = 0;
        }
    }
    void grade(int marks , Instructor grader){
        this.marks = marks;
        this.grader = grader;
    }
    String getgrader(){
        return this.grader.getName();
    }


}
