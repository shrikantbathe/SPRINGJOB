package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Test {
	
	public static void main(String[] args) {

		String test = "I am shrikant shrikant is going to school";
		
		List<String> list = Arrays.asList(test.split(" "));
		
		Set<String> set = new HashSet<>(list);
		
		set.forEach(action->{
			System.out.println(action +" : "+Collections.frequency(list, action));
		});
		 
		/***********/
	
	
	int num = 12345 ; 
	int reversedNo = 0;
	
	while(num != 0){
		int dig  = num%10;
		reversedNo = reversedNo * 10 + dig;
		num = num/10;
	} 
 	System.out.println("reversed No: "+ reversedNo);
 	
 	/***********************/
 	
 	Map<String ,String > map = new HashMap<>();
 	
	 	map.put("1", "one");
	 	map.put("4", "four");
	 	map.put("3", "three");
	 	map.put("0", "zero");
	 	map.put("8", "zero");
	 	
	 	Set <Entry<String, String>> entrySet = map.entrySet();
	 	
	 	List<Entry<String, String>> list2 = new ArrayList<>(entrySet);
	 	
	 	Collections.sort(list2, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
	 	
	 	Map<String, String> mapSorted = new LinkedHashMap<>();
	 	
	 	for (Map.Entry<String, String> entry: list2){
	 		mapSorted.put(entry.getKey(), entry.getValue());
	 	}
	 	
	 	mapSorted.forEach((key,val)->{
	 		System.out.println(key +" :  "+val);
	 	} );
	 	
}
	
	
	
	
	

}
	
	
 		
	
	
	 
		
		
	
	
	
	 

 
/*
1. find occ of each word in String

2 reverse an int no

3 sort hash map by val
*/

 