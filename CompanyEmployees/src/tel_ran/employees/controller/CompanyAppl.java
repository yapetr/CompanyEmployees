package tel_ran.employees.controller;

import tel_ran.collections.Array;
import tel_ran.employees.dao.Company;
import tel_ran.employees.view.GetEmployeesByPositionItem;
import tel_ran.employees.view.GetEmployeesItem;
import tel_ran.employees.view.GetEmployeesSalaryItem;
import tel_ran.employees.view.HireEmployeesItem;
import tel_ran.employees.view.ItemEmployees;
import tel_ran.employees.view.MenuEmployees;
import tel_ran.view.AbstractView;
import tel_ran.view.ViewRandomNumbersConsole;
import tel_ran.view.ViewRealConsole;

public class CompanyAppl {

	public static final String[] NAMES = {"Vasya","Moshe","Serg","Olya",
			"Manya","Yuri","Igor", "Arcady"};
	public static final String[] POSITIONS = {"Engineer","SalesPerson",
			"Programmer","Cleaner", "SalesManager"}; 
	public static final int MIN_SALARY = 4_500;
	public static final int MAX_SLARY  = 30_506;
	public static final int MIN_HIRE_EMPLOYEES = 2;
	public static final int MAX_HIRE_EMPLOYEES = 10;
	
	public static void main(String[] args) throws Exception {
		
		Company company=new Company(MIN_SALARY, MAX_SLARY, NAMES, POSITIONS);
		//AbstractView view=new ViewRandomNumbersConsole();
		AbstractView view=new ViewRealConsole();
		
		ItemEmployees itemHire=new HireEmployeesItem(company, view, 
				MIN_HIRE_EMPLOYEES, MAX_HIRE_EMPLOYEES);
		ItemEmployees itemGetAllEmployees= new GetEmployeesItem(company, view);
		ItemEmployees itemGetEmplyeesByPosition = 
				new GetEmployeesByPositionItem(company, view);
		ItemEmployees itemGetEmployeesSalary = 
				new GetEmployeesSalaryItem(company, view);
		
		Array items=new Array();
		items.add(itemHire);
		items.add(itemGetAllEmployees);
		items.add(itemGetEmplyeesByPosition);
		items.add(itemGetEmployeesSalary);
				
		MenuEmployees menu=new MenuEmployees(items, view);
		menu.runMenu();	

	}


}
