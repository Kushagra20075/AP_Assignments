import java.util.Date;

public class Comment {
     private String comment;
     private Date posted;
     Logger User;
     Comment(String comment , Logger User , Date posted){
         this.comment = comment;
         this.posted = posted;
         this.User = User;
     }
     void view(){
         System.out.println(comment + " - " + User.getName());
         System.out.println(posted);
         System.out.println();
     }
}
