import java.util.ArrayList;

public class Tile_Carpet {
    private ArrayList<Tile> tiles;
    Tile_Carpet(){
        tiles = new ArrayList<Tile>();
        Tile t1 = new Tile("Iron Man",false);
        tiles.add(t1);
        Tile t2 = new Tile("Black Widow",true);
        tiles.add(t2);
        Tile t3 = new Tile("Hulk",false);
        tiles.add(t3);
        Tile t4 = new Tile("Thor",true);
        tiles.add(t4);
        Tile t5 = new Tile("Odin",false);
        tiles.add(t5);
        Tile t6 = new Tile("Hawkeye",true);
        tiles.add(t6);
        Tile t7 = new Tile("Shang Chi",false);
        tiles.add(t7);
        Tile t8 = new Tile("Sersi",true);
        tiles.add(t8);
        Tile t9 = new Tile("Ikaris",false);
        tiles.add(t9);
        Tile t10 = new Tile("Loki",true);
        tiles.add(t10);
        Tile t11 = new Tile("Rad Skull",false);
        tiles.add(t11);
        Tile t12 = new Tile("Captain America",true);
        tiles.add(t12);
        Tile t13 = new Tile("Black Panther",false);
        tiles.add(t13);
        Tile t14 = new Tile("Dr. Strange",true);
        tiles.add(t14);
        Tile t15 = new Tile("Spiderman",false);
        tiles.add(t15);
        Tile t16 = new Tile("Scarlet Witch",true);
        tiles.add(t16);
        Tile t17 = new Tile("Captain Marvel",false);
        tiles.add(t17);
        Tile t18 = new Tile("Falcon",true);
        tiles.add(t18);
        Tile t19 = new Tile("War Machine",false);
        tiles.add(t19);
        Tile t20 = new Tile("Ant Man",true);
        tiles.add(t20);
    }
    Boolean iseven(int index) throws WrongIndexException{
        if(index<0 || index>=tiles.size()){
            throw new WrongIndexException("Wrong Index of the Soft Toy");
        }
        Tile t = tiles.get(index);
        return t.iseven();
    }
    void cloner(int index , Player player) throws WrongIndexException{
        if(index<0 || index>=tiles.size()){
            throw new WrongIndexException("Wrong Index of the Soft Toy");
        }
        Tile t = tiles.get(index);
        t.cloner(player);
        return;
    }
}
