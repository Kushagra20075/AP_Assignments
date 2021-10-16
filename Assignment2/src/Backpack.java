import java.util.*;

public class Backpack {
    private ArrayList<Instructor> instructor;
    private ArrayList<Student> student;
    private ArrayList<Comment> comment;
    private ArrayList<Material> material;
    private ArrayList<Assessment> assessments;
    private Logger User;
    private Instructor IUser;
    private Student SUser;


    Backpack(){
        this.instructor = new ArrayList<>();
        this.comment = new ArrayList<>();
        this.student = new ArrayList<>();
        this.assessments = new ArrayList<>();
        this.IUser = null;
        this.SUser = null;
        this.User = null;
    }

    void add_lecture(Material lecturemat){
        if(IUser!=null){
            IUser.add(lecturemat,material);
        }
        System.out.println("Student must not access it");
    }

    void add_assessment(Assessment test){
        if(IUser!=null){
            assessments.add(test);
        }
        System.out.println("Student must not access it");
    }

    void view_Assessments(){
        User.view_Assessment(assessments);
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
        User = null;
    }
    void Login(Logger User){
        this.User = User;
        if(whoAmI()==0){
            SUser = (Student)User;
        }
        else{
            IUser = (Instructor) User;
        }
    }
    int whoAmI(){
        //0 for student
        //1 for Instructor
        return User.WhoAmI();
    }
    void addComment(String comment){
        String name = User.getName();
        Date date = new Date();
        Comment comobj = new Comment(comment,User,date);
        this.comment.add(comobj);
    }
    void printComments(){
        for (Comment comobj : comment) {
            comobj.view();
        }
    }

    public static void main(String[] args){
        Student stud = new Student("Kushagra");
        Instructor ins = new Instructor();
        Backpack portal = new Backpack();
        portal.Login(stud);
        portal.addComment("Shivaansh is a bad boy");
        portal.addComment("Nishaant is very confused");
        portal.printComments();
        //1. Add class material ----OBj to be made in main function
        //2. Add assessments -----Obj to be made in main function
        //3. View lecture materials -----------------
        //4. View assessments ---------------------
        //5. Grade assessments
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
}
