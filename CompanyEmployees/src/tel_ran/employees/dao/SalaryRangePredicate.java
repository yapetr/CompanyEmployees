package tel_ran.employees.dao;

import tel_ran.collections.Predicate;

public class SalaryRangePredicate extends Predicate {
int minSalary;
int maxSalary;

	public SalaryRangePredicate(int minSalary, int maxSalary) {
	super();
	this.minSalary = minSalary;
	this.maxSalary = maxSalary;
}

	@Override
	public boolean matches(Object obj) {
		int salary=((Employee)obj).getSalary();
		return salary>=minSalary && salary <=maxSalary;
	}

}
