import java.util.ArrayList;
import java.util.Date;

public class Slide implements Material{
    String title;
    ArrayList<String> content;
    Date publish;
    String publisher;

    @Override
    public void view() {
        System.out.printf("Title of Video : " + title);
        for(int i=0;i<content.size();i++){
            String x = content.get(i);
            System.out.println("Slide " + i + ": " + x);
        }
        System.out.println("Date of Upload : " + publish);
        System.out.println("Uploaded by : " + publisher);
    }
}
