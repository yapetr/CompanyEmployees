package tel_ran.view;

public class ViewRandomNumbersConsole extends AbstractView {

	@Override
	public int getIntValue(String message, int min, int max) throws Exception {
		System.out.println(message);
		Thread.sleep(2000);//delay for 2 seconds
		int intValue=getRandomNumber(min,max);
		System.out.println(intValue);
		return intValue;
	}

	private int getRandomNumber(int min, int max) {
		int result=(int) (min+Math.random()*(max-min+1));
		
		return result;
	}

	@Override
	public String getStringValue(String message, String[] strings) 
			throws Exception {
		System.out.println(message);
		Thread.sleep(2000);
		if(strings != null){
			String res=strings[getRandomNumber(0,strings.length-1)];
			System.out.println(res);
			return res;
		}
		return message;
	}

	@Override
	public void display(String message) {
		System.out.println(message);

	}

}
