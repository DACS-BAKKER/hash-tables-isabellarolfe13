import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTables {
    private static Scanner wordScanner;
    private static ArrayList<String> elementsToAdd;
    private String[] table;
    private String[] preHash;
    private int size; //MAKE SURE SIZE BIGGER ALWAYS then what being added
    private static int collisions=0;


    public HashTables(){
        size=(int)(1000*8);
        table=new String[size];
        for(int x=0;x<table.length;x++){
            table[x]="";
        }
    }

    private static void read(File wordFile) throws FileNotFoundException {
        wordScanner = new Scanner(wordFile);
        //while(wordScanner.hasNextLine()){
        for(int x=0;x<1000;x++){
            String line=wordScanner.nextLine();
            elementsToAdd.add(line);
        }
    }

    public int Hash(String word){
        int pos=0;
        int sum=0;
        for(int x=0;x<word.length();x++){
            //prime number less likely for collisions
            pos+=word.charAt(x)*31*x;
            sum+=word.charAt(x);
        }
        pos+=sum;
        pos=pos%size;
        return pos;
    }
    public void put(int pos, String word){
        if(isEmpty(pos)){
            table[pos]=word;
        }
        else{
            collisions++;
            pos=movetoNextSpot((pos+1)%size);
            table[pos]=word;
        }
    }
    //checks if spot filled
    public boolean isEmpty(int pos){
        return(table[pos].equals(""));
    }

    //move to next spot and place
    public int movetoNextSpot(int pos){
        //can assume pos is less than size
        while(!isEmpty(pos)){
            pos=(pos+1)%size;
        }
        return pos;
    }

    public String get(int index){
        return(table[index]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("wordFile.txt");
        HashTables table = new HashTables();
        elementsToAdd = new ArrayList<String>();
        read(f);
        for (int x = 0; x < elementsToAdd.size(); x++) {
            int hashed = table.Hash(elementsToAdd.get(x));
            table.put(hashed, elementsToAdd.get(x));
        }
        for (int y = 0; y < table.size; y++) {
            System.out.println(y + "-" + table.table[y]);
        }
        System.out.println("Total Number of collisions: " + collisions);
    }
}
