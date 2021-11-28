public class Player {
    Bucket bucket;
    Player(){
        bucket = new Bucket();
    }

    int hop(){
        int  a = (int) (Math.random() *(23));
        return a+1;
    }

    void addtoy(Soft_Toy toy){
        bucket.add_toy(toy);
    }

    void gameOver(){
        bucket.print();
    }


}
