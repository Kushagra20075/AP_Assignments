import java.io.*;
import java.lang.reflect.Array;
import java.util.*;



class Hospital{

    String name;
    long pincode,id;
    LinkedList<Slots> slots;
    Hospital(String name , long pincode , long id) {
        this.name = name;
        this.id = id;
        this.pincode = pincode;
        slots = new LinkedList<>();
    }

    void printer(){
        System.out.println("Hospital Name: " + this.name + ", PinCode: "+ pincode + ", Unique ID: " + id);
    }
    void add_slot(int num , int day , int quantity, Vaccine vac ){
        Slots sl = new Slots(vac,day,quantity,num);
        slots.add(sl);
    }
}
class Slots{
    int num;
    int day,quantity;
    Vaccine vacc;
    Slots(Vaccine v , int day , int quantity, int num){
        this.num = num
        this.day = day;
        this.vacc = v;
        this.quantity = quantity;
    }
}
class Vaccine{
    String name;
    int doses;
    int gap;
    Vaccine(String name, int doses , int gap){
        this.name = name;
        this.doses = doses;
        this.gap = gap;
    }
    void printer(){
        System.out.println("Vaccine Name: " + this.name + ", Number of doses: "+ doses + ", Gap Between Doses: " + gap);
    }
}
class Citizen{
    String name,status;
    int age;
    long aadhar;
    int doses = 0;
    Citizen(String name,int age ,long aadhar){
        this.name = name;
        this.age = age;
        this.aadhar = aadhar;
        this.status = "REGISTERED";
        this.doses = 0;
    }
    void register(){
        System.out.println("Citizen Name: " + this.name + ", Age: "+ age + ", Unique ID: " + aadhar);
    }
}

public class COWIN {
    int id,vid;
    HashMap<Integer , Hospital> hospital;
    HashMap<Long , Citizen> citizen;
    HashMap<Integer , Vaccine> vaccine;

    COWIN(){
        this.id = 100000;
        this.vid = 0;
        hospital = new HashMap<Integer, Hospital>();
        citizen = new HashMap<Long, Citizen>();
        vaccine = new HashMap<Integer, Vaccine>();
    }

    void add_Vaccine(String name ,int doses ,int gap){
        Vaccine vac = new Vaccine(name,doses,gap);
        vaccine.put(this.vid,vac);
        vac.printer();
        vid++;
    }

    void Register_Hospital(String name , long pin){
        Hospital hos = new Hospital(name,pin,id);
        hospital.put(id,hos);
        hos.printer();
        id++;
    }

    void Register_Citizen(String name, int age , long aadhar){
        Citizen cit = new Citizen(name,age,aadhar);
        cit.register();
        if(age>18){
            citizen.put(aadhar,cit);
        }
        else{
            System.out.println("Only above 18 are allowed");
        }
    }

    void add_slot(int id,int num , int day , int quantity ,int vacnum){
        Vaccine vac;
        Hospital hos;
        if(hospital.containsKey(id)){
            hos = hospital.get(id);
            vac = vaccine.get(vacnum);
            hos.add_slot(num,day,quantity,vac);
        }
    }

    void Book_slot_by_area()

    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
    }

    public static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        static int nextint() throws IOException {
            return Integer.parseInt( next() );
        }

        static long nextlong() throws IOException {
            return Long.parseLong( next() );
        }

        static double nextdouble() throws IOException {
            return Double.parseDouble( next() );
        }

    }
}
