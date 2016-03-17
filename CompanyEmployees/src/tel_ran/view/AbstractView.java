package tel_ran.view;

public abstract class AbstractView {
public abstract int getIntValue(String message,int min, int max) throws Exception;
public abstract String getStringValue(String message,String[]strings)throws Exception;
public abstract void display(String message);
}
