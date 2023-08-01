package dorm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Manager> manage= new ArrayList<Manager>();
		try {
			File file = new File("manager.txt");
			if (file.exists()) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					Manager m = new Manager();
					m.setName(line);
					line = buffer.readLine();
					m.setUsername(line);
					line = buffer.readLine();
					m.setPassword(line);
					line = buffer.readLine();
					Dorm d = new Dorm();
					m.dorm.add(d);
					m.dorm.get(0).setDorm_name(line);
					manage.add(m);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean p=true;
		Scanner in=new java.util.Scanner(System.in);
		while(p) {
			System.out.println("1)Sign in         2)Sign up");
			int input = in.nextInt();
			if (input==1) {
				System.out.println("username");
				String user=in.next();
				System.out.println("password");
				String pass=in.next();
				Manager manager=null;
				for(int i=0;i<manage.size();i++) {
					if((manage.get(i).getUsername().equals(user))) {
						if(manage.get(i).getPassword().equals(pass)) {
							manager=manage.get(i);
							break;
						}
						
					}	
				}
				if(manager !=null) {
					menu(manager);
				}
				else
					System.out.println("manager not found");
			}
			if (input==2) {
				Manager manager=new Manager();
				System.out.println("Please inter your name");
				String name = in.next();
				manager.setName(name);
				System.out.println("username");
				String put=in.next();
				manager.setUsername(put);
				System.out.println("password");
				put=in.next();
				manager.setPassword(put);
				manage.add(manager);
				System.out.println("please Inter dormitory name");
				put=in.next();
				Dorm dr =new Dorm();
				dr.setDorm_name(put);
				System.out.println("Please Inter dormitory type");
				put=in.next();
				dr.setDorm_type(put);
				manager.dorm.add(dr);
				manage.add(manager);
				try {
					File file = new File("manager.txt");
					 if (!file.exists()) {
		                   file.createNewFile();
					 }
		                   BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		                   buffer.write(manager.getName());
		                   buffer.newLine();
	                	   buffer.write(manager.getUsername());
	                	   buffer.newLine();
	                	   buffer.write(manager.getPassword());
	                	   buffer.newLine();
	                	   buffer.write(manager.dorm.get(0).getDorm_name());
	                	   buffer.newLine();
	                	   buffer.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("manager added susccessfuly");
			}
		}
		

	}
static void menu(Manager manager) {
	boolean stay=true;
	Scanner in = new Scanner(System.in);
	while(stay) {
		System.out.println("welcom mr "+manager.getName()+"		dormitory name:"+manager.dorm.get(0).getDorm_name());
		System.out.println("1)New studnet      2)Register new block    3)Register new room    4)Edit student");
		System.out.println("5)Delete student   6)Empty room            7)Rooms                8)Exit");
		int choose=in.nextInt();
		switch (choose) {
		case 1:
			manager.add_student();
			break;
		case 2:
			manager.add_block();
			break;
		case 3:
			manager.add_room();
			break;
		case 4:
			manager.edit();
			break;
		case 5:
			manager.delete_student();
			break;
		case 6:
			manager.empty_room();
			break;
		case 7:
			manager.show_room();
			break;
		case 8:
			 stay=false;
			 break;
		default:
			break;
		}
	}
	
		
}

}

