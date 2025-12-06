package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		names.add("Ramya");
		names.add("Aiswariya");
		names.add("Bachan");
		names.add("Sachin");
		names.add("Rahul");
		System.out.println(names);
		
		System.out.println(names.get(2));
		System.out.println(names.contains("Ramya"));
		System.out.println(names.size());
		names.remove(1);
		System.out.println(names.size());
		
	}



}
