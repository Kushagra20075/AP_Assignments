import java.util.Date;

public class Video implements Material {
    private String topic;
    private String filename;
    private Date publish;
    private Instructor Publisher;


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
        return size >= 5 && filename.endsWith(".mp4");
    }

    @Override
    public void view() {
        System.out.println("Title of Video : " + topic);
        System.out.println("Video File : " + filename);
        System.out.println("Date of Upload : " + publish);
        System.out.println("Uploaded by : " + Publisher.getName());
    }
}
