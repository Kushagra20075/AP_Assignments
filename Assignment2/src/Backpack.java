import java.util.*;

public class Backpack {
    private ArrayList<Instructor> instructor;
    private ArrayList<Student> student;
    private ArrayList<Comment> comment;
    private ArrayList<Material> material;
    private Logger User;
    private Instructor IUser;
    private Student SUser;


    Backpack(){
        this.instructor = new ArrayList<>();
        this.comment = new ArrayList<>();
        this.student = new ArrayList<>();
        this.IUser = null;
        this.SUser = null;
        this.User = null;
    }

    void add(Material lecturemat){
        if(IUser!=null){
            IUser.add(lecturemat,material);
        }
        System.out.println("Student must not access it");
    }

    void view_Material(){

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
    }
}
