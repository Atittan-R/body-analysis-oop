package b6071028;

public class TDEE{
	private double tdee;
	
	public void calTDEE(String qty,double bmr){
		if(qty.equals("1")){
			this.tdee = 1.2*bmr; 
		}else if(qty.equals("2")){
			this.tdee = 1.375*bmr; 
		}else if(qty.equals("3")){
			this.tdee = 1.55*bmr; 
		}else if(qty.equals("4")){
			this.tdee = 1.7*bmr; 
		}else  if(qty.equals("5")){
			this.tdee = 1.9*bmr; 
		}else if(qty.equals(null)){
			this.tdee = 0;
		}else{
			this.tdee = 0;
		}
	}
	public double getTDEE(){
		return this.tdee;
	}
}
