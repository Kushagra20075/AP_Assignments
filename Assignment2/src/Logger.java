import java.util.ArrayList;

public interface Logger {
    void view_lectures(ArrayList<Material> material);
    void view_Assessment(ArrayList<Assessment> assessments);
    String getName();
    int WhoAmI();
}
