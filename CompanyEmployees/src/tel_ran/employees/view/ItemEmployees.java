package tel_ran.employees.view;

import tel_ran.collections.Array;
import tel_ran.employees.dao.Company;
import tel_ran.view.AbstractView;

public abstract class ItemEmployees {
	
	Company company;
	AbstractView view;
	

	
	public ItemEmployees(Company company, AbstractView view) {
		super();
		this.company = company;
		this.view = view;
	}
	public abstract String getDisplayedName();
	public abstract void action() throws Exception;
	
	protected void displayArray(Array numbers) {
		int nNumbers=numbers.size();
		for(int i=0;i<nNumbers; i++){
			view.display(numbers.get(i).toString());
		}
		
	}	

}
