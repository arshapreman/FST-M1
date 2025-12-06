package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args)
	{
	
		  HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
	        hash_map.put(1, "One");
	        hash_map.put(2, "Two");
	        hash_map.put(3, "Three");
	        hash_map.put(4, "Four");
	        hash_map.put(5, "Five");
	 
	        System.out.println("My map: " + hash_map);
	        hash_map.remove(3);
	        System.out.println("After removing key 3: " + hash_map);
	         if(hash_map.containsValue("Five")) 
	         {
	            System.out.println("Five exists in the Map");
	        } else {
	            System.out.println("Five does not exist in the Map");
	        }
	       
	        System.out.println("Number of pairs in the Map is: " + hash_map.size());
	    }
	}



