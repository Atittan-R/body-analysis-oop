package b6071028;

public class BMRm extends BMR{
	
	@Override
	public void calBMR(){
		bmr = 66+(13.7*weight)+(5*height)-(6.8*age);
	}
	
	@Override
	public double getBMR(){
		return bmr;
	}
}