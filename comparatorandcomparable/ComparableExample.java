package comparatorandcomparable;
import java.util.*;


public class ComparableExample {
	
	public static void main(String[] args) {
		Employee1 e1 = new Employee1(30,"Tony Stark",30000);
		Employee1 e2 = new Employee1(34,"Peter Parker",60000);
		Employee1 e3 = new Employee1(32,"Tony Stark",90000);
		Employee1 e4 = new Employee1(35,"Steve Rogers",20000);
		List<Employee1> list = new ArrayList<>();
		list.add(e1);list.add(e2);list.add(e3);list.add(e4);
		Collections.sort(list);
		System.out.println(list);
	}

}
class Employee1 implements Comparable<Employee1>{
	private int age;
	private String name;
	private int salary;
	
	public Employee1(int age, String name, int salary) {
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
	public int compareTo(Employee1 o) {
		// TODO Auto-generated method stub
		String name1 = this.getName();
		String name2 = o.getName();
		//if name is same then compare on the basis of age
		if(name1.compareTo(name2)==0) {
			int age1 = this.getAge();
			int age2 = o.getAge();
			if(age1 > age2) return 1;
			else if(age1 < age2) return -1;
			return 0;
		}
		return name1.compareTo(name2);
	}
}
