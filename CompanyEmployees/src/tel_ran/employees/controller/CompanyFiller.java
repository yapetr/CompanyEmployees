package tel_ran.employees.controller;

import tel_ran.employees.dao.Company;
import tel_ran.employees.dao.Employee;
import tel_ran.view.AbstractView;

public class CompanyFiller {
	int amount;
	Company company;
	AbstractView view;

	public CompanyFiller(int amount, Company company, AbstractView view) {
		super();
		this.amount = amount;
		this.company = company;
		this.view = view;
	}

	public void hireEmployees() throws Exception {
		for (int i = 0; i < amount; i++) {
			Employee empl = createEmployee();
			company.addEmployee(empl);
		}
	}

	private Employee createEmployee() throws Exception {
		int salary = view.getIntValue("enter a salary value", company.getMinSalary(), company.getMaxSalary());
		String name = view.getStringValue("enter an employee name", company.getNames());
		String position = view.getStringValue("enter position", company.getPositions());
		return new Employee(name, position, salary);
	}
}
