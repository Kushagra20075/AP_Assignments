import java.util.ArrayList;
import java.util.Date;

public class Slide implements Material{
    private String title;
    private ArrayList<String> content;
    private Date publish;
    private Instructor publisher;

    Slide(String title , ArrayList<String>content, Date publish , Instructor publisher){
        this.title = title;
        this.content = content;
        this.publish = publish;
        this.publisher =  publisher;
    }

    @Override
    public String getname() {
        return this.title;
    }
    @Override
    public boolean is_correct(String filename) {
        return true;
    }
    @Override
    public void view() {
        System.out.println("Title of Video : " + title);
        for(int i=0;i<content.size();i++){
            String x = content.get(i);
            System.out.println("Slide " + i + ": " + x);
        }
        System.out.println("Date of Upload : " + publish);
        System.out.println("Uploaded by : " + publisher.getName());
    }
}
