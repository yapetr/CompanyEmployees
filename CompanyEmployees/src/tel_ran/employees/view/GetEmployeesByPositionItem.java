package tel_ran.employees.view;

import tel_ran.employees.dao.Company;
import tel_ran.view.AbstractView;

public class GetEmployeesByPositionItem extends ItemEmployees{

	public GetEmployeesByPositionItem(Company company, AbstractView view) {
		super(company, view);
	}

	@Override
	public String getDisplayedName() {
		return "displaying employees of position";
	}

	@Override
	public void action() throws Exception {
		String position = view.getStringValue("input name os position", 
				company.getPositions());
		displayArray(company.getEmployeesPosition(position));
		
	}

}
