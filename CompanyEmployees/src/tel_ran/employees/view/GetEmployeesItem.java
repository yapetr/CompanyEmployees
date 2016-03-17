package tel_ran.employees.view;

import tel_ran.employees.dao.Company;
import tel_ran.view.AbstractView;

public class GetEmployeesItem extends ItemEmployees {

	public GetEmployeesItem(Company company, AbstractView view) {
		super(company, view);
	}

	@Override
	public String getDisplayedName() {
		return "displaying whole company";
	}

	@Override
	public void action() throws Exception {
		displayArray(company.getAllEmployees());
	}

}
