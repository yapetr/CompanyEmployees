package tel_ran.employees.dao;

public class Employee {
String name;
String position;
int salary;
public Employee(String name, String position, int salary) {
	super();
	this.name = name;
	this.position = position;
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", position=" + position + ", salary=" + salary + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
}
