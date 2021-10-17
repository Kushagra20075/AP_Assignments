import java.util.Date;

public class Video implements Material {
    String topic;
    String filename;
    Date publish;
    Instructor Publisher;
    Video(String topic , String filename , Date publish ,Instructor Publisher){
        this.topic = topic;
        this.filename = filename;
        this.publish = publish;
        this.Publisher = Publisher;
    }

    @Override
    public String getname() {
        return this.filename;
    }
    @Override
    public boolean is_correct(String filename) {
        int size = filename.length();
        return size >= 5 && filename.endsWith(".zip");
    }

    @Override
    public void view() {
        System.out.println("Title of Video : " + topic);
        System.out.println("Video File : " + filename);
        System.out.println("Date of Upload : " + publish);
        System.out.println("Uploaded by : " + Publisher.getName());
    }
}
