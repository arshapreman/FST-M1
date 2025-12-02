package activities;

public class Activity2 {

	public static void main(String[] args) {
		int[] array = {10, 77, 10, 54, -11, 10};
		int sum=0;
		
		for(int number:array)
		{
			if( number==10)
			{
				sum+=number;
				
			}
			
		}
		if (sum==30)
			
			System.out.println("Sum: " +sum);
		boolean result = (sum == 30);
		
		System.out.println("Result:" +result);
	
		
				
	}

}
