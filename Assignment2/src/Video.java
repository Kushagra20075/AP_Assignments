import java.util.Date;

public class Video implements Material {
    String topic;
    String filename;
    Date publish;
    String Publisher;
    Video(String topic , String filename , Date publish ,String Publisher){
        this.topic = topic;
        this.filename = filename;
        this.publish = publish;
        this.Publisher = Publisher;
    }

    @Override
    public void view() {
        System.out.println("Title of Video : " + topic);
        System.out.println("Video File : " + filename);
        System.out.println("Date of Upload : " + publish);
        System.out.println("Uploaded by : " + Publisher);
    }
}
