import java.io.File;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.*;
public class SonnetConcordance
{
	public HashTablesWord table;
	public int TotalSonnets;
	public List<Sonnet> sonnets;
	public SonnetConcordance() throws FileNotFoundException {
		table=Read();
	}
	
	public HashTablesWord Read() throws FileNotFoundException {
		HashTablesWord table2=new HashTablesWord();
		
		SonnetReader sr = new SonnetReader(new File("shake.txt"));
		TotalSonnets=sr.totalSonnets;
		
		sonnets = sr.readAllSonnets();
		
		for(int y=0;y<sonnets.size();y++){
			Sonnet s=sonnets.get(y);
			for(int x=0;x<s.lines.size();x++) {
				String[] parts = s.lines.get(x).split(" ");
				for (String part : parts) {
					//create new reference before word
					References ref=new References();
					ref.line=x+1;
					ref.sonnetNumber=y+1;
					//create new word
					Word word=new Word();
					word.word=part;
					word.reference=new ArrayList<References>();
					word.reference.add(ref);
					table2.put(table2.Hash(word), word);
				}
			}
		}
		return table2;
	}
	
	public String Perform(String word){
		String full="";
		int occurrences=0;
		for(int x=0;x<table.size;x++){
			if(table.table[x]!=null){
				if(table.table[x].word.equals(word)){
					for(int y=0; y<table.table[x].reference.size();y++){
						References ref=table.table[x].reference.get(y);
						full+="Sonnet: " + ref.sonnetNumber;
						full+=" Line number: " + ref.line;
						full+="\n";
						occurrences=y;
					}
				}
			}
		}
		if(occurrences!=0) {
			occurrences += 1;
		}
		full+="Total Occurences= " + occurrences;
		System.out.println(full);
		return full;
	}
}
