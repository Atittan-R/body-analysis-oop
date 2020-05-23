package b6071028;

public class BodyInfo {
	protected String name, gender;
	protected double height, weight;
	protected int age;
	
	//Overload
	public void setName() {
		name = "Unknown";
	}

	public void setName(String bodyName) {
		name = bodyName;
	}

	public String getName() {
		return name;
	}
	
	public void setHeight(double h) {
		height = h;
	}
	
	public double getHeight() {
		return height;
	}

	public void setWeight(double w) {
		weight = w;
	}

	public double getWeight() {
		return weight;
	}
	
	public void setAge(int ag) {
		age = ag;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setGender(String gend) {
		gender = gend;
	}
	
	public String getGender() {
		return gender;
	}
	
}
