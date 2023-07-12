package sorting;

public class People {
	int id;
	String name;
	int age;
	
	public People(int id,String name,int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
