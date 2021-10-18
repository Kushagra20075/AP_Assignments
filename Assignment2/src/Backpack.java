import java.util.*;

public class Backpack {
    private final ArrayList<Instructor> instructor;
    private final ArrayList<Student> student;
    private final ArrayList<Comment> comment;
    private final ArrayList<Material> material;
    private final ArrayList<Assessment> assessments;
    private Logger User;
    private Instructor IUser;
    private Student SUser;


    Backpack(){
        this.instructor = new ArrayList<>();
        this.comment = new ArrayList<>();
        this.student = new ArrayList<>();
        this.assessments = new ArrayList<>();
        this.material = new ArrayList<>();
        this.IUser = null;
        this.SUser = null;
        this.User = null;
    }
    public void addInstructor(Instructor ins) {
        instructor.add(ins);
    }
    private void addStudent(Student stud) {
        student.add(stud);
    }

    //Check function left TT_TT to be done when crating object;
    void add_lecture(Material lecturemat){
        if(IUser!=null){
            if(lecturemat.is_correct(lecturemat.getname())){
                IUser.add(lecturemat,material);
                return;
            }
            else{
                System.out.println("Wrong format");
                return;
            }
        }
        System.out.println("Student must not access it");
    }

    void add_assessment(Assessment test){
        if(IUser!=null){
            assessments.add(test);
            return;
        }
        System.out.println("Student must not access it");
    }

    void view_Assessments(){
        User.viewassessments(assessments);
    }
    public boolean ispending(){
        boolean flag=false;
        if(SUser!=null){
            for (Assessment ass : assessments) {
                if (!ass.is_closed()&&!ass.is_submitted(SUser)) {
                    flag = true;
                }
            }
        }
        return flag;
    }
    public void printpending(){
        if(SUser!=null){
            for(int i=0;i<assessments.size();i++){
                Assessment ass = assessments.get(i);
                if(!ass.is_submitted(SUser)){
                    ass.view_Assessment(i);
                }
            }
        }
    }
    
    void close_Assessment(Assessment assessment){
        if(IUser!=null){
            IUser.close(assessment,assessments);
        }
    }
    
    void view_lectures(){
        User.view_lectures(material);
    }

    void Logout(){
        //Student
        SUser = null;
        IUser = null;
        User = User.Logout();
    }
    void Login(Logger User){
        this.User = User;
        if(whoAmI()==0){
            SUser = (Student) User;
        }
        else{
            IUser = (Instructor) User;
        }
    }

    void Hello(){
        System.out.println("Welcome " + User.getName());
    }
    int whoAmI(){
        //0 for student
        //1 for Instructor
        return User.WhoAmI();
    }



    void Grade(int marks , Assessment ass , Student stud){
        if(IUser!=null){
            IUser.grade(ass,marks,stud);
        }
    }

    void submit_Assessment(Assessment ass,Submission sub, Student User){
        if(SUser!=null){
            SUser.submit(ass,sub,SUser);
        }
    }

    void addComment(String comment){
        User.addComment(this.comment , comment);
    }

    void viewGrades(){
        if(SUser!=null){
            SUser.viewgrade(assessments);
        }
    }



    void printComments(){
        User.view_comments(comment);
    }

    public static void main(String[] args){
        Backpack portal = new Backpack();
        Reader cin = new Reader();
        //Hardcoding the add part

        Instructor ins1 = new Instructor("I0");
        portal.addInstructor(ins1);
        ins1 = new Instructor("I1");
        portal.addInstructor(ins1);
        Student stud1 = new Student("S0");
        portal.addStudent(stud1);
        stud1 = new Student("S1");
        portal.addStudent(stud1);
        stud1 = new Student("S2");
        portal.addStudent(stud1);
        int cont=1;
        while(cont==1){
            System.out.println("Welcome to backpack");
            int ch,ch2;
            System.out.println("1. Enter as Instructor");
            System.out.println("2. Enter as Student");
            System.out.println("3. Exit");
            ch = cin.nextInt();
            if(ch==1) {

                //Instructor Menu
                portal.printinstructors();
                int index = cin.nextInt();
                Instructor ilog = portal.getInstructor(index);
                portal.Login(ilog);

                //1. Add class material ----OBj to be made in main function
                //2. Add assessments -----Obj to be made in main function
                //3. View lecture materials -----------------
                //4. View assessments ---------------------
                //5. Grade assessments --------------------
                //6. Close assessment ---------------------
                //7. View comments --------------------
                //8. Add comments -------------------
                //9. Logout --------------------------
                int cont2 = 1;
                while (cont2 == 1) {
                    int ch3;
                    portal.Hello();
                    System.out.println("""
                            INSTRUCTOR MENU
                            1. Add class material
                            2. Add assessments
                            3. View lecture materials
                            4. View assessments
                            5. Grade assessments
                            6. Close assessment
                            7. View comments
                            8. Add comments
                            9. Logout""");
                    System.out.println("Menu drive");
                    ch3 = cin.nextInt();
                    if (ch3 == 1) {
                        int ch4;
                        System.out.println("1.Add Lecture Slide \n" +
                                "2.Add Lecture Video");
                        //Video
                        ch4 = cin.nextInt();
                        if (ch4 == 1) {
                            String topic;
                            String filename;
                            System.out.print("Enter topic of Lecture Slides :");
                            topic = cin.nextLine();
                            System.out.print("Enter the no. of slides : ");
                            int slides;
                            slides = cin.nextInt();
                            ArrayList<String> content = new ArrayList<>();
                            System.out.println("Enter the content of slides");
                            String contents;
                            for(int i=0;i<slides; i++){
                                System.out.print("Enter content of slide " + i+1 + " : ");
                                contents = cin.nextLine();
                                content.add(contents);
                            }
                            Slide material = new Slide(topic,content,new Date(), ilog);
                            portal.add_lecture(material);
                        }
                        else if (ch4 == 2) {
                            String topic;
                            String filename;
                            System.out.print("Enter topic of video :");
                            topic = cin.nextLine();
                            System.out.print("Enter filename of the video :");
                            filename = cin.next();
                            Video material = new Video(topic,filename,new Date() ,ilog);
                            portal.add_lecture(material);
                        }
                    }
                    else if(ch3==2){
                        int ch4;
                        System.out.println("1. Add Assignment \n2. Add Quiz");
                        //Assignment
                        //Quiz
                        ch4 = cin.nextInt();
                        if (ch4 == 1) {
                            String problem;
                            int maxmarks;
                            System.out.print("Enter Problem Statement : ");
                            problem = cin.nextLine();
                            System.out.print("Enter max marks : ");
                            maxmarks = cin.nextInt();
                            Assignment ass = new Assignment(problem,ilog,maxmarks,portal.getStudents());
                            portal.add_assessment(ass);

                        }
                        else if (ch4 == 2) {
                            String problem;
                            int maxmarks;
                            System.out.print("Enter Quiz Problem : ");
                            problem = cin.nextLine();
                            Quiz quiz = new Quiz(problem,1,portal.getStudents(),ilog);
                            portal.add_assessment(quiz);
                        }
                        else {
                            System.out.println("Wrong choice");
                        }
                    }

                    else if(ch3==3){ portal.view_lectures();}
                    else if(ch3==4){ portal.view_Assessments();}
                    else if(ch3==5){
                        portal.view_Assessments();
                        System.out.print("Enter the ID of assessment to view submissions : ");
                        int in = cin.nextInt();
                        Assessment ass = portal.getassessment(in);
                        System.out.println("Choose ID from these ungraded submissions");
                        portal.printungradedstudents(ass);
                        in = cin.nextInt();
                        Student student = portal.getStudent(in);
                        System.out.println("Submission");
                        ass.print_submission(student);
                        System.out.print("Marks Scored : ");
                        int marks = cin.nextInt();
                        portal.Grade(marks,ass,student);
                    }
                    else if(ch3==6){
                        portal.printopenassessments();
                        System.out.print("Enter ID of Assignment to close :");
                        int id = cin.nextInt();
                        Assessment ass = portal.getassessment(id);
                        portal.close_Assessment(ass);
                    }
                    else if(ch3==7){
                        portal.printComments();
                    }
                    else if(ch3==8){
                        String Comment;
                        System.out.print("Enter comment :");
                        Comment = cin.nextLine();
                        portal.addComment(Comment);
                    }
                    else if(ch3==9){
                        portal.Logout();
                        cont2=0;
                    }
                    else{
                        System.out.println("Wrong choice \nEnter Again");
                    }
                }
            }
            else if(ch==2){

                //Student Menu
                //1. Add class material ----OBj to be made in main function
                //2. Add assessments -----Obj to be made in main function
                //3. View lecture materials -----------------
                //4. View assessments ---------------------
                //5. Grade assessments --------------------
                //6. Close assessment ---------------------
                //7. View comments --------------------
                //8. Add comments -------------------
                //9. Logout --------------------------
                portal.printstudents();
                int index = cin.nextInt();
                Student ilog = portal.getStudent(index);
                portal.Login(ilog);
                //Chalo Login to krlia
                int cont2 = 1;
                while(cont2==1){
                    int ch3;
                    portal.Hello();
                    System.out.println("""
                            STUDENT MENU
                            1. View lecture materials
                            2. View assessments
                            3. Submit assessment
                            4. View grades
                            5. View comments
                            6. Add comments
                            7. Logout""");
                    System.out.println("Menu drive");
                    ch3 = cin.nextInt();
                    if(ch3==1){ portal.view_lectures(); }
                    else if(ch3==2){ portal.view_Assessments(); }
                    else if(ch3==3){
                        if(portal.ispending()){
                            System.out.println("Pending Assessments");
                            portal.printpending();
                            System.out.print("Enter ID of assessment :");
                            int id = cin.nextInt();
                            Assessment ass = portal.getassessment(id);
                            ass.print_question();
                            String ans = cin.nextLine();
                            Submission sub = new Submission(ans);
                            portal.submit_Assessment(ass,sub,ilog);
                        }
                        else{
                            System.out.println("No Pending Assessments");
                        }
                    }
                    else if(ch3==4){ portal.viewGrades(); }
                    else if(ch3==5){
                        portal.printComments();
                    }
                    else if(ch3==6){
                        String Comment;
                        System.out.print("Enter comment :");
                        Comment = cin.nextLine();
                        portal.addComment(Comment);
                    }
                    else if(ch3==7){
                        portal.Logout();
                        cont2=0;
                    }
                    else{ System.out.println("Wrong choice \nEnter Again"); }

                }

            }
            else{
                cont =0;
            }
        }
        //1. Add class material ----OBj to be made in main function
        //2. Add assessments -----Obj to be made in main function
        //3. View lecture materials -----------------
        //4. View assessments ---------------------
        //5. Grade assessments --------------------
        //6. Close assessment ---------------------
        //7. View comments --------------------
        //8. Add comments -------------------
        //9. Logout --------------------------

        //1. View lecture materials -------------------------
        //2. View assessments --------------------------
        //3. Submit assessment
        //4. View grades
        //5. View comments ------------------
        //6. Add comments --------------------
        //7. Logout -------------------
    }
    private void printopenassessments() {
        int id =0;
        for(Assessment ass : assessments){
            if(!ass.is_closed()){
                ass.view_Assessment(id);
                System.out.println("--------------------");
            }
            id++;
        }
    }

    private void printungradedstudents(Assessment ass) {
        for(int i=0;i< student.size();i++){
            if(!ass.is_graded(student.get(i))&& ass.is_submitted(student.get(i)))
                System.out.println( i + " - " + student.get(i).getName());
        }
    }



    public Assessment getassessment(int index) {
        return assessments.get(index);
    }

    private void printinstructors() {
        for(int i=0;i<instructor.size();i++){
            System.out.println( i + " - " + instructor.get(i).getName());
        }
    }
    private void printstudents() {
        for(int i=0;i< student.size();i++){
            System.out.println( i + " - " + student.get(i).getName());
        }
    }

    public Instructor getInstructor(int index){
        if(index<instructor.size()){
            return instructor.get(index);
        }
        return null;
    }

    public Student getStudent(int index){
        if(index<student.size()){
            return student.get(index);
        }
        return null;
    }

    public ArrayList<Student> getStudents(){
        return this.student;
    }

}
