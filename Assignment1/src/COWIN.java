import java.io.*;
import java.lang.reflect.Array;
import java.util.*;



class Hospital {

    private String name;
    private long pincode;
    int id;
    private ArrayList<Slots> slots;

    Hospital(String name, long pincode, int id) {
        this.name = name;
        this.id = id;
        this.pincode = pincode;
        slots = new ArrayList<>();
    }

    long getPincode() {
        return this.pincode;
    }

    String getName() {
        return this.name;
    }

    int getId() {
        return this.id;
    }

    void printer() {
        System.out.println("Hospital Name: " + this.name + ", PinCode: " + pincode + ", Unique ID: " + id);
    }

    void add_slot( int day, int quantity, Vaccine vac) {
        Slots sl = new Slots(vac, day, quantity);
        slots.add(sl);
    }

    public int getday(int index) {
        Slots slot = slots.get(index);
        return slot.getDay();
    }

    public int printslots(String vac, int minday) {
        int flag =-1;
        for (int i = 0; i < slots.size(); i++) {
            Slots slot = slots.get(i);
            if (vac.length()==0 || vac.equals(slot.getVacc())) {
                if (slot.getDay() >= minday && slot.getQuantity() > 0) {
                    flag = 1;
                    System.out.println(i + "->" + ", Day :" + slot.getDay() + " , Available Quantity :" + slot.getQuantity() + " , Vaccine :" + slot.getVacc());
                }
            }
        }
        return flag;
    }

    public String getvacc(int index) {
        if(index>=slots.size()){
            return "";
        }
        Slots slot = slots.get(index);
        return slot.getVacc();
    }

    public int selectslot(String name, String vac, int minday, int index) {
        if(index>=slots.size()){
            System.out.println("Slot does not exist");
            return -1;
        }
        Slots slot = slots.get(index);
        if (vac.length()==0 || vac.equals(slot.getVacc())) {
            if (slot.getDay() >= minday && slot.getQuantity() > 0) {
                slot.reducer();
                if(slot.getQuantity()<=0){
                    slots.remove(slot);
                }
                System.out.println(name + " vaccinated with " + slot.getVacc());
                return slot.getnextday();
            }
            else {
                System.out.println("Cannot take another dose before :" + minday);
            }
        }
        else{
            System.out.println("Different Vaccine Dose Already Taken");
        }
        return -1;
    }

    public boolean checkvacc(String vacname) {
        for (int i = 0; i < slots.size(); i++) {
            Slots slot = slots.get(i);
            if(vacname.equals(slot.getVacc())){
                return true;
            }
        }
        return false;
    }

    public void allslots() {
        for(int i=0;i<slots.size();i++){
            Slots slot = slots.get(i);
            System.out.println("Day :" + slot.getDay() + " , Available Quantity :" + slot.getQuantity() + " , Vaccine :" + slot.getVacc());
        }
    }
}

class Slots {
    private int day, quantity;
    private Vaccine vacc;

    Slots(Vaccine v, int day, int quantity) {
        this.day = day;
        this.vacc = v;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getVacc() {
        return this.vacc.getName();
    }

    int getDay() {
        return this.day;
    }

    void reducer() {
        this.quantity--;
    }

    public int getnextday() {
        return this.day + this.vacc.getGap();
    }
}

class Vaccine {

    private String name;
    private int doses;
    private int gap;

    Vaccine(String name, int doses, int gap) {
        this.name = name;
        this.doses = doses;
        this.gap = gap;
    }
    int getGap(){
        return this.gap;
    }

    String getName() {
        return this.name;
    }

    void printer() {
        System.out.println("Vaccine Name: " + this.name + ", Number of doses: " + doses + ", Gap Between Doses: " + gap);
    }

    public int getDoses() {return this.doses;}
}

class Citizen {
    private String name, status;
    private int age;
    private String aadhar;
    private int doses, day;
    private String vac;

    Citizen(String name, int age, String aadhar) {
        this.name = name;
        this.age = age;
        this.aadhar = aadhar;
        this.status = "REGISTERED";
        this.doses = 0;
        this.vac = "";
        this.day = 0;
    }

    void setter(String vac , int day ,String status){
        this.doses++;
        this.vac = vac;
        this.day = day;
        this.status = status;
    }

    void register() {
        System.out.println("Citizen Name: " + this.name + ", Age: " + age + ", Unique ID: " + aadhar);
    }

    public int getDay() {
        return this.day;
    }

    public String getVac() {
        return this.vac;
    }

    public String getName() {
        return this.name;
    }

    public int getDoses() {
        return this.doses;
    }

    public void getstatus() {
        if(this.status=="REGISTERED"){
            System.out.println("Citizen " + this.status);
        }
        else if(this.status=="FULLY VACCINATED") {
            System.out.println(this.status);
            System.out.println("Vaccine given:" + this.vac);
            System.out.println("Number of doses given :" + this.doses);
        }
        else{
            System.out.println(this.status);
            System.out.println("Vaccine given:" + this.vac);
            System.out.println("Number of doses given :" + this.doses);
            System.out.println("Next Dose Due Date :" + this.day);
        }
    }

}

public class COWIN {
    private int id, vid;
    private HashMap<Integer, Hospital> hospital;
    private HashMap<String, Citizen> citizen;
    private ArrayList<Vaccine> vaccine;
    private String check(int doses, String vacname) {
        for (int i=0;i<vaccine.size();i++) {
            int vid = i;
            Vaccine vacc = vaccine.get(i);
            if (vacname == vacc.getName()) {
                if (doses == vacc.getDoses()){
                    return "FULLY VACCINATED";
                }
            }
        }
        return "PARTIALLY VACCINATED";
    }

    COWIN() {
        this.id = 100000;
        this.vid = 0;
        hospital = new HashMap<Integer, Hospital>();
        citizen = new HashMap<String, Citizen>();
        vaccine = new ArrayList<>();
    }

    public void vaccineprinter() {
        for(int i=0; i<vaccine.size();i++){
            Vaccine vac = vaccine.get(i);
            System.out.println(i + ". " + vac.getName());
        }
        return;
    }


    void add_Vaccine(String name, int doses, int gap) {
        Vaccine vac = new Vaccine(name, doses, gap);
        vaccine.add(vac);
        vac.printer();
        vid++;
    }

    void Register_Hospital(String name, long pin) {
        Hospital hos = new Hospital(name, pin, id);
        hospital.put(id, hos);
        hos.printer();
        id++;
    }

    void Register_Citizen(String name, int age, String aadhar) {
        Citizen cit = new Citizen(name, age, aadhar);
        if(citizen.containsKey(aadhar)){
            System.out.println("The Id Already Exists");
            return;
        }
        cit.register();
        if (age >=18) {
            citizen.put(aadhar, cit);
        } else {
            System.out.println("Only above 18 are allowed");
        }
    }

    void add_slot(int id,  int day, int quantity, int vacnum) {
        Vaccine vac;
        Hospital hos;
        if (hospital.containsKey(id)) {
            hos = hospital.get(id);
            if(vacnum<vaccine.size()){
                vac = vaccine.get(vacnum);
                hos.add_slot( day, quantity, vac);
                System.out.println("Slot added by Hospital " + id + " for Day " + day + ", Available Quantity: " + quantity + " of Vaccine" + vac.getName());
            }
            else{
                System.out.println("Vaccine does not exist");
            }
        }
        else{
            System.out.println("Hospital does not exist");
        }
    }

    int Book_slot_by_area(long pincode,String aadhar) {
        int flag=-1;
        if(citizen.containsKey(aadhar)){
            Citizen cit = citizen.get(aadhar);
            if(cit.getDay()==Integer.MAX_VALUE){
                System.out.println("Patient Already Vaccinated");
                return flag;
            }
        }
        else{
            return flag;
        }
        for (Map.Entry<Integer, Hospital> map : hospital.entrySet()) {
            int hid = map.getKey();
            Hospital hos = map.getValue();
            if (hos.getPincode() == pincode) {
                flag=1;
                System.out.println(hos.getId() + " " + hos.getName());
            }
        }
        if(flag==-1){
            System.out.println("No Hospitals Available");
        }
        return flag;
    }

    int Book_slot_by_vaccine(String vacname , String aadhar) {
        int flag =-1;
        if(citizen.containsKey(aadhar)){
            Citizen cit = citizen.get(aadhar);
            if(cit.getDay()==Integer.MAX_VALUE){
                System.out.println("Patient Already Vaccinated");
                return flag;
            }
        }
        else{
            return flag;
        }

        for (Map.Entry<Integer, Hospital> map : hospital.entrySet()) {
            int hid = map.getKey();
            Hospital hos = map.getValue();
            if (hos.checkvacc(vacname)) {
                flag=1;
                System.out.println(hos.getId() + " " + hos.getName());
            }
        }
        if(flag==-1){
            System.out.println("No slots Available");
        }
        return flag;
    }

    int getslotsbyid(int id , String aadhar , String vac) {
        if (hospital.containsKey(id)){
            Hospital hos = hospital.get(id);
            if(citizen.containsKey(aadhar)){
                Citizen cit = citizen.get(aadhar);
                if(vac.length()==0) {
                    vac = cit.getVac();
                }
                String citvac = cit.getVac();
                if(citvac.length()!=0&&vac.length()!=0){
                    if(!citvac.equals(vac)){
                        System.out.println("Different Vaccine already taken");
                    }
                }
                int minday = cit.getDay();
                return hos.printslots(vac, minday);
            }
        }
        return -1;
    }

    void select_slot(int id, int index, String aadhar ,String vacname) {
        if (hospital.containsKey(id)){
            Hospital hos = hospital.get(id);
            if(citizen.containsKey(aadhar)){
                Citizen cit = citizen.get(aadhar);
                String vac = cit.getVac();
                int minday = cit.getDay();
                String name = cit.getName();
                String vaccine = hos.getvacc(index);
                if(vaccine.equals(vacname) || vacname.length()==0){
                    int newday = hos.selectslot(name ,vac, minday, index);
                    if(newday==-1){
                        System.out.println("Invalid slot Selected");
                        return;
                    }
                    else{
                        int doses = cit.getDoses() + 1;
                        String status = this.check(doses,vaccine);
                        if(status.equals("FULLY VACCINATED")){
                            newday = Integer.MAX_VALUE;
                        }
                        cit.setter(vaccine,newday,status);
                    }
                }
                else {
                    System.out.println("Cannot book slot for other vaccine");
                }
            }
            else{
                System.out.println("Citizen doesn't exist");
            }
        }
        else {
            System.out.println("Hospital With This ID Doesn't exist");
        }
    }

    void allslots(int id){
        if (hospital.containsKey(id)) {
            Hospital hos = hospital.get(id);
            hos.allslots();
        }
        else{
            System.out.println("Hospital does not exist");
        }
    }

    void checkstatus(String aadhar){
        if(citizen.containsKey(aadhar)){
            Citizen cit = citizen.get(aadhar);
            cit.getstatus();
        }
        else{
            System.out.println("Citizen does not exist");
        }
    }

        public static void main(String[] args) throws IOException {

            Reader.init(System.in);
            COWIN portal = new COWIN();
            int start = 0;
            int cont = 1;
            int ch;
            System.out.println("Portal Intialized");
            System.out.println("...................................................................");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add slot for Vaccination");
            System.out.println("5. Book slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination status");
            System.out.println("8. Exit");
            System.out.println("...................................................................");

            while(cont==1){
                if(start!=0){
                    System.out.println("{Menu Options}");
                }
                ch = Reader.nextint();
                if(ch==1){
                    String vac;
                    int doses,gap;
                    System.out.print("Vaccine Name : ");
                    vac = Reader.next();
                    System.out.print("Number of doses : ");
                    doses = Reader.nextint();
                    gap = 0;
                    if(doses>1){
                        System.out.print("Gap between Doses : ");
                        gap = Reader.nextint();
                    }
                    if(doses<1){
                        System.out.println("No. of doses must be greater than 1");
                    }
                    else if(doses>=1){
                        portal.add_Vaccine(vac ,doses,gap);
                    }
                }
                else if(ch==2){
                    String name;
                    long pincode;
                    System.out.print("Hospital Name : ");
                    name = Reader.next();
                    System.out.print("PinCode : ");
                    pincode = Reader.nextlong();
                    portal.Register_Hospital(name,pincode);
                }
                else if(ch==3){
                    String name;
                    int age;
                    String aadhar;
                    System.out.print("Citizen Name : ");
                    name = Reader.next();
                    System.out.print("age : ");
                    age = Reader.nextint();
                    System.out.print("Unique ID : ");
                    aadhar = Reader.next();
                    if(aadhar.length()==12){
                        portal.Register_Citizen(name,age,aadhar);
                    }
                    else {
                        System.out.println("Unique ID of citizen must be of 12 digits");
                    }
                }
                else if(ch==4){
                    int id, num ,day ,quantity ,vacnum;
                    System.out.print("Enter Hospital id : ");
                    id = Reader.nextint();
                    System.out.print("Enter the no. of slots to be added : ");
                    num = Reader.nextint();
                    for(int i=0;i<num;i++){
                        System.out.print("Enter Day Number : ");
                        day = Reader.nextint();
                        System.out.print("Enter Quantity : ");
                        quantity = Reader.nextint();
                        System.out.println("Select Vaccine ");
                        portal.vaccineprinter();
                        vacnum = Reader.nextint();
                        portal.add_slot(id,day,quantity,vacnum);
                    }
                }


                else if(ch==5){
                    String aadhar;
                    System.out.print("EnterPatient ID : ");
                    aadhar = Reader.next();
                    System.out.println("1. Search by Area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    int choice;
                    choice = Reader.nextint();
                    if(choice==1){
                        System.out.print("Enter PinCode :");
                        long pincode = Reader.nextlong();
                        int flag = portal.Book_slot_by_area(pincode,aadhar);
                        if(flag!=-1){
                            int id;
                            System.out.print("Enter Hospital id : ");
                            id = Reader.nextint();
                            int k = portal.getslotsbyid(id,aadhar,"");
                            if(k!=-1){
                                System.out.print("Choose slot :");
                                int index = Reader.nextint();
                                portal.select_slot(id,index,aadhar,"");
                            }
                            else{
                                System.out.println("No slots Available");
                            }
                        }
                    }
                    if(choice==2){
                        String vaccine;
                        System.out.print("Enter Vaccine Name : ");
                        vaccine = Reader.next();
                        int flag = portal.Book_slot_by_vaccine(vaccine,aadhar);
                        if(flag!=-1){
                            int id;
                            System.out.print("Enter Hospital id : ");
                            id = Reader.nextint();
                            int k = portal.getslotsbyid(id,aadhar,vaccine);
                            if(k!=-1){
                                System.out.print("Choose slot :");
                                int index = Reader.nextint();
                                portal.select_slot(id,index,aadhar,vaccine);
                            }
                            else{
                                System.out.println("No slots Available");
                            }
                        }
                    }
                }
                else if(ch==6){
                    int id;
                    System.out.print("Enter Hospital id : ");
                    id = Reader.nextint();
                    portal.allslots(id);
                }
                else if(ch==7){
                    String aadhar;
                    System.out.print("EnterPatient ID : ");
                    aadhar = Reader.next();
                    portal.checkstatus(aadhar);
                }
                else if(ch==8){
                    cont = 0;
                }
                else{
                    System.out.println("Please Enter choices from the menu");
                }
                System.out.println("...................................................................");
                start = 1;
            }

            /*
            portal.add_Vaccine("Covax" , 2 , 2);
            portal.add_Vaccine("Covi",1,0);
            portal.Register_Hospital("Medistar" , 110091);
            portal.Register_Hospital("HealthCenter",110001);
            portal.add_slot(100000,1,5,0);
            portal.add_slot(100000,2,5,1);
            portal.allslots(100000);
            portal.add_slot(100001,3,10,0);
            portal.Register_Citizen("Justin",14,"1234566543");
            portal.Register_Citizen("Marrion",23,"1234567890");
            portal.Book_slot_by_area(110091);
            portal.getslotsbyid(100000,"1234567890","");
            portal.select_slot(100000,0,"1234567890");
            portal.checkstatus("1234567890");
            portal.Book_slot_by_vaccine("Covax");
            portal.getslotsbyid(100000,"1234567890","Covax");
            portal.getslotsbyid(100001,"1234567890","Covax");
            portal.select_slot(100001,0,"1234567890");
            portal.checkstatus("1234567890");
            portal.allslots(100000);
            portal.Register_Citizen("Mutt",45,"454545656");
            portal.checkstatus("454545656");
            portal.Register_Citizen("Oxley",67,"999999000");
            portal.Book_slot_by_vaccine("Covi");
            portal.getslotsbyid(100000,"999999000","Covi");
            portal.select_slot(100000,1,"999999000");
            portal.checkstatus("999999000");
            */

        }



    public static class Reader {

            static BufferedReader reader;
            static StringTokenizer tokenizer;

            static void init(InputStream input) {
                reader = new BufferedReader(new InputStreamReader(input));
                tokenizer = new StringTokenizer("");
            }

            static String next() throws IOException {
                while (!tokenizer.hasMoreTokens()) {
                    //TODO add check for eof if necessary
                    tokenizer = new StringTokenizer(
                            reader.readLine());
                }
                return tokenizer.nextToken();
            }

            static int nextint() throws IOException {
                return Integer.parseInt(next());
            }

            static long nextlong() throws IOException {
                return Long.parseLong(next());
            }

            static double nextdouble() throws IOException {
                return Double.parseDouble(next());
            }

        }
    }
