package efeeney.xml.protobean;

public class Whore {
	private String name;
	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Whore{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
