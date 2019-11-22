package hashcodeandequals;

import java.util.*;

public class HashCodeAndEqualsContract {
	
	public static void main(String[] args) {
		Employee e1 = new Employee(30,"Ankit",30000);
		Employee e2 = new Employee(30,"Ankit",30000);
		System.out.println(e1.equals(e2));// This will be false if equals is not overridden in Employee class
		Set<Employee> set = new HashSet<>();
		set.add(e1);
		set.add(e2);
		System.out.println(set);// This will add same employee twice if hascode is not overridden
	}

}
class Employee{
	private int age;
	private String name;
	private int salary;
	
	public Employee(int age, String name, int salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	
	
	
}
