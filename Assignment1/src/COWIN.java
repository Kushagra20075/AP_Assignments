import java.io.*;
import java.lang.reflect.Array;
import java.util.*;



class Hospital {

    private String name;
    private long pincode, id;
    private ArrayList<Slots> slots;

    Hospital(String name, long pincode, long id) {
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

    long getId() {
        return this.id;
    }

    void printer() {
        System.out.println("Hospital Name: " + this.name + ", PinCode: " + pincode + ", Unique ID: " + id);
    }

    void add_slot(int num, int day, int quantity, Vaccine vac) {
        Slots sl = new Slots(vac, day, quantity);
        slots.add(sl);
    }

    public int getday(int index) {
        Slots slot = slots.get(index);
        return slot.getDay();
    }

    public void printslots(String vac, int minday) {
        for (int i = 0; i < slots.size(); i++) {
            Slots slot = slots.get(i);
            if (vac == "" || vac == slot.getVacc()) {
                if (slot.getDay() >= minday && slot.getQuantity() > 0) {
                    System.out.println(i + "->" + ", Day :" + slot.getDay() + " , Available Quantity :" + slot.getQuantity() + " , Vaccine :" + slot.getVacc());
                }
            }
        }
    }

    public String getvacc(int index) {
        Slots slot = slots.get(index);
        return slot.getVacc();
    }

    public int selectslot(String name, String vac, int minday, int index) {
        Slots slot = slots.get(index);
        if (vac == "" || vac == slot.getVacc()) {
            if (slot.getDay() >= minday && slot.getQuantity() > 0) {
                slot.reducer();
                System.out.println(name + " vaccinated with " + slot.getVacc());
                return slot.getnextday();
            }
        }
        return -1;
    }

    public boolean checkvacc(String vacname) {
        for (int i = 0; i < slots.size(); i++) {
            Slots slot = slots.get(i);
            if(vacname==slot.getVacc()){
                return true;
            }
        }
        return false;
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

        public int getDoses() {
            return this.doses;
        }
    }

    class Citizen {
        private String name, status;
        private int age;
        private long aadhar;
        private int doses, day;
        private String vac;

        Citizen(String name, int age, long aadhar) {
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
    }

    public class COWIN {
        private int id, vid;
        private HashMap<Integer, Hospital> hospital;
        private HashMap<Long, Citizen> citizen;
        private HashMap<Integer, Vaccine> vaccine;

        private String check(int doses, String vacname) {
            for (Map.Entry<Integer, Vaccine> map : vaccine.entrySet()) {
                int vid = map.getKey();
                Vaccine vacc = map.getValue();
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
            citizen = new HashMap<Long, Citizen>();
            vaccine = new HashMap<Integer, Vaccine>();
        }

        void add_Vaccine(String name, int doses, int gap) {
            Vaccine vac = new Vaccine(name, doses, gap);
            vaccine.put(this.vid, vac);
            vac.printer();
            vid++;
        }

        void Register_Hospital(String name, long pin) {
            Hospital hos = new Hospital(name, pin, id);
            hospital.put(id, hos);
            hos.printer();
            id++;
        }

        void Register_Citizen(String name, int age, long aadhar) {
            Citizen cit = new Citizen(name, age, aadhar);
            cit.register();
            if (age > 18) {
                citizen.put(aadhar, cit);
            } else {
                System.out.println("Only above 18 are allowed");
            }
        }

        void add_slot(int id, int num, int day, int quantity, int vacnum) {
            Vaccine vac;
            Hospital hos;
            if (hospital.containsKey(id)) {
                hos = hospital.get(id);
                vac = vaccine.get(vacnum);
                hos.add_slot(num, day, quantity, vac);
            }
        }

        void Book_slot_by_area(long pincode) {
            int flag=0;
            for (Map.Entry<Integer, Hospital> map : hospital.entrySet()) {
                int hid = map.getKey();
                Hospital hos = map.getValue();
                if (hos.getPincode() == pincode) {
                    flag=1;
                    System.out.println(hos.getId() + " " + hos.getName());
                }
            }
            if(flag==0){
                System.out.println("No slots Available");
            }
        }

        void Book_slot_by_vaccine(String vacname) {
            int flag =0;
            for (Map.Entry<Integer, Hospital> map : hospital.entrySet()) {
                int hid = map.getKey();
                Hospital hos = map.getValue();
                if (hos.checkvacc(vacname)) {
                    flag=1;
                    System.out.println(hos.getId() + " " + hos.getName());
                }
            }
            if(flag==0){
                System.out.println("No slots Available");
            }
        }

        void getslotsbyid(long id, long aadhar , String vac) {
            Hospital hos = hospital.get(id);
            Citizen cit = citizen.get(aadhar);
            if(vac == "") {
                vac = cit.getVac();
            }
            int minday = cit.getDay();
            hos.printslots(vac, minday);
        }

        void select_slot(long id, int index, long aadhar) {
            Hospital hos = hospital.get(id);
            Citizen cit = citizen.get(aadhar);
            String vac = cit.getVac();
            int minday = cit.getDay();
            String name = cit.getName();
            int newday = hos.selectslot(name ,vac, minday, index);
            if(newday==-1){
                System.out.println("Invalid slot Selected");
                return;
            }
            else{
                int doses = cit.getDoses() + 1;
                String vaccine = hos.getName();
                String status = this.check(doses,vaccine);
                if(status=="FULLY VACCINATED"){
                    newday = Integer.MAX_VALUE;
                }
                cit.setter(vaccine,newday,status);
            }
        }





        public static void main(String[] args) throws IOException {
            Reader.init(System.in);
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
