package functions ;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import ipredict.database.SequenceDatabase;
import java.util.*;


public class MainTestCPTPlus2 {

	public static List<Object> getStats(String[] args) throws IOException{

		// Load the set of training sequences
		String inputPath = fileToPath("contextCPT.txt");  
		SequenceDatabase trainingSet = new SequenceDatabase();
		trainingSet.loadFileSPMFFormat(inputPath, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
		
		List<Object> id = SequenceStatsGenerator2.Stats2(trainingSet);
		return id ;

	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestCPTPlus2.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}	

	public static void main(String[] args) {
    }
	
	// note: if we use this main method to call, it outputs as expected in eclipse
	// so I think the java code is okay
//	public static void main(String[] args) throws IOException {
//		List<Object> id =  MainTestCPTPlus2.getStats(args);
//	     System.out.println(id);
//    }
}





