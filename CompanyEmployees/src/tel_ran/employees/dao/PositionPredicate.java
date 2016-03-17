package tel_ran.employees.dao;

import tel_ran.collections.Predicate;

public class PositionPredicate extends Predicate {
String position;
	public PositionPredicate(String position) {
	super();
	this.position = position;
}
	@Override
	public boolean matches(Object obj) {
		return position.equalsIgnoreCase(((Employee)obj).getPosition());
	}

}
