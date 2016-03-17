package tel_ran.view;

import java.util.Scanner;

public class ViewRealConsole extends AbstractView {

	@Override
	public int getIntValue(String message, int min, int max) throws Exception {
	    System.out.println(message);
	    System.out.println("Value must be between " 
	            + min + " and " + max);	    
	    return readInt(min, max);
	}
	
	private int readInt(int min, int max){
		Scanner in = new Scanner(System.in);		
	    while(true){
	        int value = in.nextInt();
	        if(value >= min && value <= max){
	        	in.close();
	        	return value;
	        } else {
	        	System.out.println("incorrect input. Value must be between " 
	            + min + " and " + max);
	        }
	    }		
	}

	@Override
	public String getStringValue(String message, String[] strings) 
			throws Exception {
		System.out.println(message);
		System.out.println("choose value:");
		for(int i=0; i < strings.length; i++){
			System.out.println(i + "." + strings[i]);
		}
		String result = strings[readInt(0,strings.length - 1)];
		System.out.println(result);
		return result;
	}

	@Override
	public void display(String message) {
		System.out.println(message);
		
	}

}
