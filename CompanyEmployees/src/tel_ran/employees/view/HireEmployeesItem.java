package tel_ran.employees.view;

import tel_ran.employees.controller.CompanyFiller;
import tel_ran.employees.dao.Company;
import tel_ran.view.AbstractView;

public class HireEmployeesItem extends ItemEmployees {
	
	private int minValue;
	private int maxValue;

	public HireEmployeesItem(Company company, AbstractView view, int minValue, 
			int maxValue) {
		super(company, view);
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public String getDisplayedName() {
		return "hire employees";
	}

	@Override
	public void action() throws Exception {
		int amount = view.getIntValue("how many employees you whant hire?", 
				minValue, maxValue);
		CompanyFiller companyFiller = new CompanyFiller(amount, company, view);
		companyFiller.hireEmployees();
	}

}
