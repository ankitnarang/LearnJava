package comparatorandcomparable;

import java.util.*;

public class ComparatorExample {
	public static void main(String[] args) {
		Employee e1 = new Employee(30,"Tony Stark",30000);
		Employee e2 = new Employee(34,"Peter Parker",60000);
		Employee e3 = new Employee(32,"Dr. Strange",90000);
		Employee e4 = new Employee(35,"Steve Rogers",20000);
		List<Employee> list = new ArrayList<>();
		list.add(e1);list.add(e2);list.add(e3);list.add(e4);
		System.out.println("*********** Age Comparision ***********");
		Collections.sort(list,new AgeComparator());
		System.out.println(list);
		System.out.println("*********** Name Comparision ***********");
		Collections.sort(list,new NameComparator());
		System.out.println(list);
		System.out.println("*********** Salary Comparision ***********");
		Collections.sort(list,new SalaryComparator());
		System.out.println(list);
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
	
}
class AgeComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int age1 = o1.getAge();
		int age2 = o2.getAge();
		if(age1 > age2) return 1;
		else if(age1 < age2) return -1;
		return 0;
	}
}
class NameComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		String name1 = o1.getName();
		String name2 = o2.getName();
		return name1.compareTo(name2);
	}
}
class SalaryComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int salary1 = o1.getSalary();
		int salary2 = o2.getSalary();
		if(salary1 > salary2) return 1;
		else if(salary1 < salary2) return -1;
		return 0;
	}
}

