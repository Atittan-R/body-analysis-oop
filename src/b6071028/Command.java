package b6071028;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class Command {
	public static void main(String[] args) {
		String name, gender;
		int age;
		double height, weight;
		double bmi_res,bmr_res;
		String bodyinfo = "", result="", ref="";
		String cmd1,cmd2,cmd3,cmd4,cmd5,tde;
		
		try{
			FileReader infile = new FileReader("./src/BodyInfo3.txt");
			FileWriter outfile = new FileWriter("./src/output.txt");
			Scanner input = new Scanner(infile);
			System.out.printf("You are input file name: %s\n",infile);
			while(input.hasNext()){
				System.out.printf("Analyzing...");
				cmd1 = input.next();
					name = input.next();
				cmd2 = input.next();
					weight = input.nextDouble();
				cmd3 = input.next();
					height = input.nextDouble();
				cmd4 = input.next();
					gender = input.next();
				cmd5 = input.next();
					age = input.nextInt();
				
				//Set Body Info
				BodyInfo guy = new BodyInfo();
				if(name.equals(null)){
					guy.setName();
				}else{
					guy.setName(name);
				}
				guy.setWeight(weight);
				guy.setHeight(height);
				guy.setGender(gender);
				guy.setAge(age);
				
				//Set BMI
				BMI bmi = new BMI();
				bmi.setHeight(height);
				bmi.setAge(age);
				bmi.setWeight(weight);
				bmi.calBMI();
				bmi_res = bmi.getBMI();
				
				JFrame myWindow = new JFrame();
				String	qty;
				 myWindow.setSize(100,200);
				 myWindow.setTitle("Total Daily Energy Expenditure");
				 myWindow.setVisible(false);
				 qty =  JOptionPane.showInputDialog(myWindow,"ค่าของพลังงานที่ใช้กิจกรรมอื่นในแต่ละวัน โดยเลือกจากกิจกรรมตาม list ด้านล่าง ค่าที่ออกมาจะได้ค่าของการเผาผลาญพลังงานที่เป็นค่าเพียวๆเเละค่าจากการทำกิจกรรมร่วมกัน โปรดใส่ตัวเลข\n1.ออกกำลังกายน้อย ทำงานเเบบนั่งอยู่กับที่\n2.ออกกำลังกาย หรือเล่นกีฬา เเบบเบาๆ 1-3 วันต่อสัปดาห์\n3.ออกกำลังกาย หรือเล่นกีฬา ความหนักปานกลาง 3-5 วันต่อสัปดาห์\n4.ออกกำลังกาย หรือเล่นกีฬา หนัก 6-7 วันต่อสัปดาห์\n5.ออกกำลังกาย หรือเล่นกีฬา หนัก เเบบการซ้อมเพื่อเเข่งขัน เป็นระจำทุกวัน");

				//Set Body Shape
				Shape shape = new Shape();
				shape.calShape(bmi_res);

				//Set Calculator //Major Class "Calculator"
				Calculator cal = new Calculator();
				TDEE tdee = new TDEE();
				cal.setPerson(guy);
				cal.setBMI(bmi);
				cal.setShape(shape);
				cal.setTDEE(tdee);
				
				if(gender.equalsIgnoreCase("MALE")|| gender.equals("ชาย")){
					BMR bmr = new BMRm();
					bmr.setHeight(height);
					bmr.setAge(age);
					bmr.setWeight(weight);
					bmr.calBMR();
					bmr_res = bmr.getBMR();
					tdee.calTDEE(qty,bmr_res);
					cal.setBMR(bmr);
				}else if(gender.equalsIgnoreCase("FEMALE")|| gender.equals("หญิง")){
					BMR bmr = new BMRf();
					bmr.setHeight(height);
					bmr.setAge(age);
					bmr.setWeight(weight);
					bmr.calBMR();
					bmr_res = bmr.getBMR();
					tdee.calTDEE(qty,bmr_res);
					cal.setBMR(bmr);
					}		
				bodyinfo= String
						.format("-----------------------------------------------------------------------"
								+ "\n\t\t\tUser Information\t\t\t\n"+
								"-----------------------------------------------------------------------"
								+"\nชื่อ :\t%s   \n"
								+"น้ำหนัก:\t%.2f   กิโลกรัม\n"
								+"ส่วนสูง :\t%.2f   เซนติเมตร\n"
								+"เพศ :\t%s   \n"
								+"อายุ :\t%d   ปี\n\n",cal.getPerson().getName(),cal.getPerson().getWeight(),cal.getPerson().getHeight(),cal.getPerson().getGender(),cal.getPerson().getAge());
				
				result = String
						.format("-----------------------------------------------------------------------"
								+ "\n\t\t\tBody Analysis\t\t\t\n"+
								"-----------------------------------------------------------------------"
								+"\n\nBMI :\t%.2f   \n"
								+"BMR:\t%.2f   กิโลแคลอรี่\n"
								+"TDEE :\t%.2f   กิโลแคลอรี่\n"
								+"ผลการวิเคราะห์:\t%s   \n"
								+"คำแนะนำ :\t%s \n\n",cal.rcBMI().getBMI(),cal.rcBMR().getBMR(),cal.rcTDEE().getTDEE(),cal.rcShape().getShape(),cal.rcShape().getRecommend());
				
				ref = String
						.format("-----------------------------------------------------------------------"
								+ "\n\t\t\tReferences\t\t\t\n"+
								"-----------------------------------------------------------------------"
								+"\n\nBMI(Body Mass Index)คือ ค่าดัชนีมวลกาย\n"
								+"BMR(Basal Metabolic Rate)คือ พลังงานที่จำเป็นพื้นฐานในการมีชีวิต\n"
								+"TDEE(Total Daily Energy Expenditure)คือ ค่าของพลังงานที่ใช้ทั้งหมดในแต่ละวัน เมื่อมีการทำกิจกรรมต่างๆ\n"
								+"ขอบคุณข้อมูลจาก:\n\t-https://www.honestdocs.co/bmi-body-mass-index-calculator"
								+"\n\t-https://www.honestdocs.co/bmr-basal-metabolic-rate-calculator"
								+"\n\t-https://www.lokehoon.com/app.php?q_id=calculate_bmr_tdee\n\n"
								+"-----------------------------------------------------------------------");						
				outfile.write(bodyinfo+result+ref+"\r\n");
				System.out.printf("\nFile was write! \nThank you =)");

			}//end while
			input.close();
			infile.close();
			outfile.close();
		}catch (IOException error) {
			error.printStackTrace();
		}		
	}
}