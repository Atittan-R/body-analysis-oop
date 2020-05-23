package b6071028;

public class Calculator{
	BodyInfo bodyInfo;
	BMR BMR;
	BMI bmi;
	Shape shape;
	TDEE tdee;
	
	public void setBMI(BMI bmi) {
		this.bmi = bmi;
	}

	public BMI rcBMI() {
		return this.bmi;
	}
	
	public void setPerson(BodyInfo ps){
		bodyInfo = ps;
	}
	
	public BodyInfo getPerson(){
		return bodyInfo;
	}
	
	public void setBMR(BMR BMR){
		this.BMR = BMR;
	}
	
	public BMR rcBMR(){
		return this.BMR;
	}
	
	public void setShape(Shape shape){
		this.shape = shape;
	}
	
	public Shape rcShape(){
		return this.shape;
	}
	
	public void setTDEE(TDEE tdee){
		this.tdee = tdee;
	}
	
	public TDEE rcTDEE(){
		return this.tdee;
	}
}
