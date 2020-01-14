import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class SonnetReaderConsole
{
	private Scanner sonnetScanner;
	
	public SonnetReaderConsole(File sonnetFile) throws FileNotFoundException {
		sonnetScanner = new Scanner(sonnetFile);
	}
	
	private Sonnet readNextSonnet() {

		if(!sonnetScanner.hasNextLine()) {
			return null;
		}
		
		Sonnet sonnet = new Sonnet(sonnetScanner.nextLine());
		
		sonnetScanner.nextLine();
		
		String line=sonnetScanner.nextLine().toLowerCase();

		while(line.length()>0) {
			sonnet.lines.add(line);
			//System.out.println(line);
			line=sonnetScanner.nextLine().toLowerCase();
		}
		return sonnet;
	}
	
	public List<Sonnet> readAllSonnets() {
		List<Sonnet> sonnets=new LinkedList<Sonnet>();
		Sonnet sonnet=readNextSonnet();
		while(sonnet!=null) {
			sonnets.add(sonnet);
			sonnet=readNextSonnet();
		}
		
		sonnetScanner.close();
		
		return sonnets;
	}
}
