
package functions ;
//package ipredict.database;
// as we removed the package statement need to point to these
import ipredict.database.SequenceDatabase;
import ipredict.database.Sequence;
import ipredict.database.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;




////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//return stats in list rather than print

public class SequenceStatsGenerator2 {


		/**
		* This method generates statistics for a sequence database (a file)
		* @param path the path to the file
		* @throws IOException  exception if there is a problem while reading the file.
		*/
		public static List<Object> Stats2(SequenceDatabase database) {


			// we initialize some variables that we will use to generate the statistics
			java.util.Set<Integer> items = new java.util.HashSet<Integer>();  // the set of all items
			List<Integer> sizes = new ArrayList<Integer>(); // the lengths of each sequence

			// Loop on sequences from the database
			for (Sequence sequence : database.getSequences()) {
				// we add the size of this sequence to the list of sizes
				sizes.add(sequence.size());
				
				// this map is used to calculate the number of times that each item
				// appear in this sequence.
				// the key is an item
				// the value is the number of occurences of the item until now for this sequence
				HashMap<Integer, Integer> mapIntegers = new HashMap<Integer, Integer>();
				
				// Loop on itemsets from this sequence
				for (Item item : sequence.getItems()) {
				// we add the size of this itemset to the list of itemset sizes
					// If the item is not in the map already, we set count to 0
					Integer count = mapIntegers.get(item.val);
					if (count == null) {
						count = 0;
					}
					// otherwise we set the count to count +1
					count = count + 1;
					mapIntegers.put(item.val, count);
					// finally, we add the item to the set of items
					items.add(item.val);
					
				}

			}
	
				
			// return
			int nodi = items.size() ;
			double ips = calculateMean(sizes);		
						
			return Arrays.asList(nodi, ips);
			
			}
			

		
		/**
		 * This method calculate the mean of a list of integers
		 * @param list the list of integers
		 * @return the mean 
		 */
		private static double calculateMean(List<Integer> list) {
			double sum = 0;
			for (Integer val : list) {
				sum += val;
			}
			return sum / list.size();
		}
	}












