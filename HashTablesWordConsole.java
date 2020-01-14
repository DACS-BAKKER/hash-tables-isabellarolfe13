public class HashTablesWordConsole {
    public Word[] table;
    private Word[] preHash;
    public int size; //MAKE SURE SIZE BIGGER ALWAYS then what being added


    public HashTablesWordConsole(){
        size=(int)(17678*1.3);
        table=new Word[size];
        for(int x=0;x<table.length;x++){
            table[x]=null;
        }
    }

    public int Hash(Word word){
        int pos=0;
        for(int x=0;x<word.word.length();x++){
            //prime number less likely for collisions
            pos+=word.word.charAt(x)*31;
        }
        pos=pos%size;
        return pos;
    }
    public void put(int pos, Word word){
        if(isEmpty(pos)){
            table[pos]=word;
        }
        else{
            //same word, need to add to references
            if(word.word.equals(table[pos].word)){
                table[pos].reference.add(word.reference.get(0));
            }
            //different word hashed to same place in hash table
            else{
                pos=movetoNextSpot((pos+1)%size, word);
                if(table[pos]==null){
                    table[pos]=word;
                }
                else{
                    table[pos].reference.add(word.reference.get(0));
                }
            }
        }
    }
    //checks if spot filled
    public boolean isEmpty(int pos){
        return(table[pos]==null);
    }

    //move to next spot and place
    public int movetoNextSpot(int pos, Word word){
        //size always bigger than amount adding, never an issue
        //can assume pos is less than size
        while(!isEmpty(pos)){
            if(word.word.equals(table[pos].word)){
                break;
            }
            pos=(pos+1)%size;
        }
        return pos;
    }
    public Word get(int index){
        return(table[index]);
    }
}
