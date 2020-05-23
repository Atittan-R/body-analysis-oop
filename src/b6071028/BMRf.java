package b6071028;

public class BMRf extends BMR{
	
	@Override
	public void calBMR(){
		bmr = 665+(9.6*weight)+(1.8*height)-(4.7*age);
	}
	
	@Override
	public double getBMR(){
		return bmr;
}
}
