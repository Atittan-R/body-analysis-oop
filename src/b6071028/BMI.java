package b6071028;

public class BMI extends BodyInfo{
	private double bmi;
	public void calBMI() {
		bmi = weight / ((height / 100) * (height / 100));
	}

	public double getBMI() {
		return bmi;
	}
}
