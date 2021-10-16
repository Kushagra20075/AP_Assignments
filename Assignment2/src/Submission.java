public class Submission {
    String solution;
    int marks;
    boolean isopen;

    Submission(String solution){
        this.solution = solution;
        this.marks = -1;
        this.isopen = true;
    }

    public String getSolution() {
        return solution;
    }

    public int getMarks() {
        return marks;
    }

    public boolean isIsopen() {
        return isopen;
    }

    void close(){
        this.isopen = false;
        if(this.marks==-1){
            this.marks = 0;
        }
    }
    void grade(int marks){
        this.marks = marks;
    }

}
