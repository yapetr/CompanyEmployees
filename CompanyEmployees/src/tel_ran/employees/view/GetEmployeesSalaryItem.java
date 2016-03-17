package tel_ran.employees.view;

import tel_ran.employees.dao.Company;
import tel_ran.view.AbstractView;

public class GetEmployeesSalaryItem extends ItemEmployees {

	public GetEmployeesSalaryItem(Company company, AbstractView view) {
		super(company, view);
	}

	@Override
	public String getDisplayedName() {
		return "displaying employee of salary range";
	}

	@Override
	public void action() throws Exception {
		int minSalary = view.getIntValue("input min salary", 
				company.getMinSalary(), company.getMaxSalary());
		int maxSalary = view.getIntValue("input max salary", 
				minSalary, company.getMaxSalary());
		displayArray(company.getEmployeesSalary(minSalary, maxSalary));

	}

}
