import java.util.ArrayList;

public class Tile_Carpet {
    private ArrayList<Tile> tiles;
    Tile_Carpet(){
        tiles = new ArrayList<Tile>();
        Tile t1 = new Tile("Toy1",false);
        tiles.add(t1);
        Tile t2 = new Tile("Toy2",true);
        tiles.add(t2);
        Tile t3 = new Tile("Toy3",false);
        tiles.add(t3);
        Tile t4 = new Tile("Toy4",true);
        tiles.add(t4);
        Tile t5 = new Tile("Toy5",false);
        tiles.add(t5);
        Tile t6 = new Tile("Toy6",true);
        tiles.add(t6);
        Tile t7 = new Tile("Toy7",false);
        tiles.add(t7);
        Tile t8 = new Tile("Toy8",true);
        tiles.add(t8);
        Tile t9 = new Tile("Toy9",false);
        tiles.add(t9);
        Tile t10 = new Tile("Toy10",true);
        tiles.add(t10);
        Tile t11 = new Tile("Toy11",false);
        tiles.add(t11);
        Tile t12 = new Tile("Toy12",true);
        tiles.add(t12);
        Tile t13 = new Tile("Toy13",false);
        tiles.add(t13);
        Tile t14 = new Tile("Toy14",true);
        tiles.add(t14);
        Tile t15 = new Tile("Toy15",false);
        tiles.add(t15);
        Tile t16 = new Tile("Toy16",true);
        tiles.add(t16);
        Tile t17 = new Tile("Toy17",false);
        tiles.add(t17);
        Tile t18 = new Tile("Toy18",true);
        tiles.add(t18);
        Tile t19 = new Tile("Toy19",false);
        tiles.add(t19);
        Tile t20 = new Tile("Toy20",true);
        tiles.add(t20);
    }
    Boolean iseven(int index) throws WrongIndexException{
        if(index<0 || index>=tiles.size()){
            throw new WrongIndexException("Wrong Index of the Soft Toy");
        }
        Tile t = tiles.get(index);
        return t.iseven();
    }
    Soft_Toy cloner(int index) throws WrongIndexException{
        if(index<0 || index>=tiles.size()){
            throw new WrongIndexException("Wrong Index of the Soft Toy");
        }
        Tile t = tiles.get(index);
        return t.cloner();
    }
}
