import java.util.ArrayList;

public interface Logger {
    void view_lectures(ArrayList<Material> material);
    String getName();
    int WhoAmI();
    Logger Logout();
    void view_comments(ArrayList<Comment> comments);
    void addComment(ArrayList<Comment> comment , String comm);
    void viewassessments(ArrayList<Assessment> assessments);
}
