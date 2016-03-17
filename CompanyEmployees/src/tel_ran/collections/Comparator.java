package tel_ran.collections;

public abstract class Comparator {
/**
 * 
 * @param obj1
 * @param obj2
 * @return <0 if obj1 less than obj2; >0 if obj1 greater than obj2;0 if obj1 equals obj2
 */
	public abstract int compare(Object obj1, Object obj2);
}
