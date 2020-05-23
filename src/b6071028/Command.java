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
				 qty =  JOptionPane.showInputDialog(myWindow,"��Ңͧ��ѧ�ҹ�����Ԩ�������������ѹ �����͡�ҡ�Ԩ������� list ��ҹ��ҧ ��ҷ���͡�Ҩ����Ңͧ����Ҽ�ҭ��ѧ�ҹ����繤����������Ф�Ҩҡ��÷ӡԨ���������ѹ �ô������Ţ\n1.�͡���ѧ��¹��� �ӧҹ�຺�������Ѻ���\n2.�͡���ѧ��� ������蹡��� �຺��� 1-3 �ѹ����ѻ����\n3.�͡���ѧ��� ������蹡��� ����˹ѡ�ҹ��ҧ 3-5 �ѹ����ѻ����\n4.�͡���ѧ��� ������蹡��� ˹ѡ 6-7 �ѹ����ѻ����\n5.�͡���ѧ��� ������蹡��� ˹ѡ �຺��ë���������觢ѹ ���Шӷء�ѹ");

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
				
				if(gender.equalsIgnoreCase("MALE")|| gender.equals("���")){
					BMR bmr = new BMRm();
					bmr.setHeight(height);
					bmr.setAge(age);
					bmr.setWeight(weight);
					bmr.calBMR();
					bmr_res = bmr.getBMR();
					tdee.calTDEE(qty,bmr_res);
					cal.setBMR(bmr);
				}else if(gender.equalsIgnoreCase("FEMALE")|| gender.equals("˭ԧ")){
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
								+"\n���� :\t%s   \n"
								+"���˹ѡ:\t%.2f   ���š���\n"
								+"��ǹ�٧ :\t%.2f   ૹ������\n"
								+"�� :\t%s   \n"
								+"���� :\t%d   ��\n\n",cal.getPerson().getName(),cal.getPerson().getWeight(),cal.getPerson().getHeight(),cal.getPerson().getGender(),cal.getPerson().getAge());
				
				result = String
						.format("-----------------------------------------------------------------------"
								+ "\n\t\t\tBody Analysis\t\t\t\n"+
								"-----------------------------------------------------------------------"
								+"\n\nBMI :\t%.2f   \n"
								+"BMR:\t%.2f   ����������\n"
								+"TDEE :\t%.2f   ����������\n"
								+"�š����������:\t%s   \n"
								+"���й� :\t%s \n\n",cal.rcBMI().getBMI(),cal.rcBMR().getBMR(),cal.rcTDEE().getTDEE(),cal.rcShape().getShape(),cal.rcShape().getRecommend());
				
				ref = String
						.format("-----------------------------------------------------------------------"
								+ "\n\t\t\tReferences\t\t\t\n"+
								"-----------------------------------------------------------------------"
								+"\n\nBMI(Body Mass Index)��� ��ҴѪ����š��\n"
								+"BMR(Basal Metabolic Rate)��� ��ѧ�ҹ�����繾�鹰ҹ㹡���ժ��Ե\n"
								+"TDEE(Total Daily Energy Expenditure)��� ��Ңͧ��ѧ�ҹ����������������ѹ ������ա�÷ӡԨ������ҧ�\n"
								+"�ͺ�س�����Ũҡ:\n\t-https://www.honestdocs.co/bmi-body-mass-index-calculator"
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