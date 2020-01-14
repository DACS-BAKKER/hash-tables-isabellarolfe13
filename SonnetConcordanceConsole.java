import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.*;
public class SonnetConcordanceConsole
{

	public static void main(String[] args) throws FileNotFoundException
	{
		HashTablesWordConsole table=new HashTablesWordConsole();

		SonnetReaderConsole sr = new SonnetReaderConsole(new File("shake.txt"));
		
		List<Sonnet> sonnets = sr.readAllSonnets();

		
		for(int y=0;y<sonnets.size();y++){
			Sonnet s=sonnets.get(y);
			for(int x=0;x<s.lines.size();x++) {
				String[] parts = s.lines.get(x).split(" ");
				for (String part : parts) {
					//System.out.println(part);
					//create new reference before word
					References ref=new References();
					ref.line=x+1;
					ref.sonnetNumber=y+1;
					//create new word
					Word word=new Word();
					word.word=part;
					word.reference=new ArrayList<References>();
					word.reference.add(ref);
					table.put(table.Hash(word), word);
				}
			}
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("What word would you like to search for?");
		String word=scan.nextLine();
		int occurrences=0;
		for(int x=0;x<table.size;x++){
			if(table.table[x]!=null){
				if(table.table[x].word.equals(word)){
					for(int y=0; y<table.table[x].reference.size();y++){
						References ref=table.table[x].reference.get(y);
						System.out.print("Sonnet Number: " + ref.sonnetNumber);
						System.out.println(" Line number: " + ref.line);
						occurrences=y;
					}
				}

			}
		}
		if(occurrences!=0) {
			occurrences += 1;
		}
		System.out.println("There are " + occurrences + " occurrences of " + word + " in all of Shakespeare's texts");
	}

}
