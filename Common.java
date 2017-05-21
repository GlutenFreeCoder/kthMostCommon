import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Common {
	public static int kthMostCommon(int[] a, int k) {
			
		//Declarations
		int kthCommon; 
		int[] input = a;
		
		HashMap<Integer, Integer> occurences = new HashMap<>();
		HashMap<Integer,Integer> frequencyMap = new HashMap<>();
		
		//Populates the HashMaps
		for (int i : input) {
			int count = 1;
			if (occurences.containsKey(i)) {
				count = occurences.get(i) + 1;
			}
			occurences.put(i, count);
		}
		
		//Reverses the keys and values for sorting by occurrence count
		for(HashMap.Entry<Integer,Integer> entry : occurences.entrySet()) {
		    	frequencyMap.put(entry.getValue(), entry.getKey());
		}
		
		//Creates and populates a Collection sortable by occurrence count (from least to greatest)
		Map<Integer,Integer> sortedValues = new TreeMap<Integer,Integer>(frequencyMap);
		
		
		//Determine kthMostComon integer
		Integer[] sortedArray = sortedValues.values().toArray(new Integer[sortedValues.size()]);
		
		kthCommon = sortedArray[(sortedValues.size()- k)];
		
		return kthCommon;
	}

	public static void main(String[] args) {
		int x = kthMostCommon(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
		System.out.println(x);
	}
}
