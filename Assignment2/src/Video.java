import java.util.Date;

public class Video implements Material {
    String topic;
    String filename;
    Date publish;
    String Publisher;

    @Override
    public void view() {
        System.out.printf("Title of Video : " + topic);
        System.out.println("Video File : " + filename);
        System.out.println("Date of Upload : " + publish);
        System.out.println("Uploaded by : " + Publisher);
    }
}
