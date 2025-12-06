package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs =new HashSet<String>();
		hs.add("A");
		hs.add("B");
		hs.add("C");
		hs.add("D");
		hs.add("E");
		hs.add("F");
		System.out.println("Hashset: " +hs);
		
		System.out.println("Size of the Hashset: " +hs.size());
		if(hs.remove("F")) {
        	System.out.println("F removed from the Set");
        } else {
        	System.out.println("F is not present in the Set");
        }
		System.out.println(hs.contains("obj6"));
		System.out.println(hs);
		
		

	}

}
