package tel_ran.employees.dao;

import tel_ran.collections.Array;

public class Company {
int minSalary;
int maxSalary;
Array employees;
String [] names;
String [] positions;
public Company(int minSalary, int maxSalary, String[] names, String[] positions) {
	super();
	employees=new Array();
	this.minSalary = minSalary;
	this.maxSalary = maxSalary;
	this.names = names;
	this.positions = positions;
}
public int getMinSalary() {
	return minSalary;
}
public int getMaxSalary() {
	return maxSalary;
}
public String[] getNames() {
	return names;
}
public String[] getPositions() {
	return positions;
}
public void addEmployee(Employee employee){
	employees.add(employee);
}
public Array getAllEmployees(){
	return employees;
}
public Array getEmployeesPosition(String position){
	return employees.find(new PositionPredicate(position));
}
public Array getEmployeesSalary(int minSalary, int maxSalary){
	return employees.find(new SalaryRangePredicate(minSalary, maxSalary));
}
}
