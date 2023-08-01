package dorm;
import java.util.ArrayList;
import java.util.Scanner;
public class Manager {
	private String name,username,password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Manager(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	ArrayList<Dorm> dorm = new ArrayList<Dorm>();
	Scanner input = new Scanner(System.in);
	public void delete_student() {
		System.out.println("delete with :");
		System.out.println("          		1) name     2)studnet number  ");
		int choose = input.nextInt();
		if(choose == 1) {
			System.out.println("please inter name");
			String name = input.next();
			delete(name);
		}
		if(choose==2) {
			System.out.println("please inter student number");
			choose = input.nextInt();
			delete(choose);
		}
	}
	public void add_student() {
		System.out.println("Please choose dormitery");
		for (int i=0;i<dorm.size();i++) {
			System.out.print((i+1)+") "+dorm.get(i).getDorm_name()+"\t");
		}
		int choose =input.nextInt();
		System.out.println("please choose block");
		dorm.get(choose-1).show_blocks();
		int choose2=input.nextInt();
		System.out.println("please choose room");
		show_room(choose-1, choose2-1);
		int choose3=input.nextInt();
		boolean space=space_check(choose-1, choose2-1, choose3-1);
		if(space) {
			add_student(choose-1,choose2-1,choose3-1);
			System.out.println("student added succussfuly");
		}
		else
			System.out.println("room is full");	
	}
	public void show_room(int num,int num2) {
		dorm.get(num).blocks.get(num2).show_room();		
	}
	public void  add_student(int num,int num2,int num3) {
		System.out.println("Inter studnet name");
		String st = input.next();
		System.out.println("Inter student number");
		int n = input.nextInt();
		System.out.println("Inter study field");
		String st2 = input.next();
		System.out.println("Inter student debt");
		int n2 = input.nextInt();
		System.out.println("Inter student Entrance year");
		int n3 = input.nextInt();
		student person = new student(st,st2,n2,n3,n);
		dorm.get(num).blocks.get(num2).rooms.get(num3).students.add(person);
		person.add_to_room(dorm.get(num).blocks.get(num2).rooms.get(num3));
		int size = dorm.get(num).blocks.get(num2).rooms.get(num3).getRoom_size();
		dorm.get(num).blocks.get(num2).rooms.get(num3).setRoom_size(size - 1);
	}
	public boolean space_check(int num,int num2,int num3) {
		boolean space=false;
		if (dorm.get(num).blocks.get(num2).rooms.get(num3).getRoom_size()>0)
			space=true;
		return space;
	}
	public void delete(String name) {
		inner: for (int i=0;i<dorm.size();i++) {
					for (int j=0;j<dorm.get(i).block_size();j++) {
						for (int k=0,l=0;k<dorm.get(i).blocks.get(j).rooms.get(k).students.size();k++,l++) {
							if(dorm.get(i).blocks.get(j).rooms.get(k).students.get(l).getName().equals(name)) {
								dorm.get(i).blocks.get(j).rooms.get(k).students.remove(l);
								System.out.println("deleted succesfuly");
							break inner;
							}
						}
					}
				}
		
	}
	public void delete(int number) {
		System.out.println("please inter student number");
		outer: for (int i=0;i<dorm.size();i++) {
			for (int j=0;j<dorm.get(i).block_size();j++) {
				for (int k=0;k<dorm.get(i).blocks.get(j).rooms.size();k++) {
					for (int l=0;l<dorm.get(i).blocks.get(j).rooms.get(k).students.size();l++){
						if(dorm.get(i).blocks.get(j).rooms.get(k).students.get(l).getStudent_number()==number) {
							dorm.get(i).blocks.get(j).rooms.get(k).students.remove(l);
							System.out.println("deleted succesfuly");
							break outer;
						}
					}
				}
			}
}
	}
	public void show_detail(int num) {
		System.out.println("inter student number");
		int num1 = input.nextInt();
		student st = new student();
		st=find(num1);
		if(st!=null) {
			st.toString();
		}
		else
			System.out.println("student not found");
	}
	public student find(int number) {
		student st = new student();
		outer: for (int i=0;i<dorm.size();i++) {
					for (int j=0;j<dorm.get(i).block_size();j++) {
						for (int k=0;k<dorm.get(i).blocks.get(j).rooms.size();k++) {
							for (int l=0;l<dorm.get(i).blocks.get(j).rooms.get(k).students.size();l++){
								if(dorm.get(i).blocks.get(j).rooms.get(k).students.get(l).getStudent_number()==number) {
									st=dorm.get(i).blocks.get(j).rooms.get(k).students.get(l);
									break outer;
								}
							}
						}
					}
		}
		return st;
	}
	public void edit() {
		System.out.println("please inter student number");
		int number = input.nextInt();
		student st = new student();
		st = find(number);
		if(st != null) {
			System.out.println("select the item you want to change");
			boolean p=true;
			while (p) {
				System.out.println("1)name ="+st.getName()+"  2)student number = "+st.getStudent_number()+"  3)study field= "
				+st.getStudy_field()+"  4)debt = "+st.getPay()+"   5)Entrance year = "+st.getInter_year());
				System.out.println("6)EXIT      7)room");
				int in=input.nextInt();
				String n;
				switch (in) {
				case 1:
					System.out.println("name");
					n = input.next();
					st.setName(n);
					break;
				case 2 :
					System.out.println("student number");
					in=input.nextInt();
					st.setStudent_number(in);
					break;
				case 3:
					System.out.println("study field");
					n=input.next();
					break;
				case 4:
					System.out.println("debt");
					in=input.nextInt();
					st.setPay(in);
					break;
				case 5:
					System.out.println("Entrance year");
					in=input.nextInt();
					st.setInter_year(in);
					break;
				case 6:
					p=false;
				case 7:
				st.show_room();	
					break;
				default:
					break;
				}
			}
		}
		else
			System.out.println("student not found");
	}
	public void show_room() {
		System.out.println("please choose dormitery");
		for (int i=0;i<dorm.size();i++) {
			System.out.print((i+1)+") "+dorm.get(i).getDorm_name()+"\t");
		}
		int choose =input.nextInt();
		System.out.println("please choose block");
		dorm.get(choose-1).show_blocks();
		int choose2=input.nextInt();
		System.out.println("please choose room");
		show_room(choose-1, choose2-1);
		int choose3=input.nextInt();
		show_student(choose-1, choose-1, choose3-1);
		System.out.println("1)delete all     2)exit");
		int s = input.nextInt();
		if (s==1) {
			delete_all(choose-1, choose2-1, choose3-1);
			System.out.println("deleting compeleted");
		}
	}
	public void show_student(int num,int num2,int num3) {
		dorm.get(num).blocks.get(num2).rooms.get(num3).show_student();
	}
	public void delete_all(int num,int num2,int num3) {
	for (int i=0 ; i<	dorm.get(num).blocks.get(num2).rooms.get(num3).students.size();i++) {
		dorm.get(num).blocks.get(num2).rooms.get(num3).students.remove(i);
		 int s=dorm.get(num).blocks.get(num2).rooms.get(num3).getRoom_number();
		 s=s+1;
		 dorm.get(num).blocks.get(num2).rooms.get(num3).setRoom_size(s);;
	}
	}
	public void empty_room() {
		 for (int i=0;i<dorm.size();i++) {
			for (int j=0;j<dorm.get(i).block_size();j++) {
				for (int k=0;k<dorm.get(i).blocks.get(j).rooms.size();k++) {
					if(dorm.get(i).blocks.get(j).rooms.get(k).getRoom_size()>0)
						System.out.println("block : "+dorm.get(i).blocks.get(j).getBlock_number()+"   room : "+dorm.get(i).blocks.get(j).rooms.get(k).getRoom_number()+
								"   room size:"+dorm.get(i).blocks.get(j).rooms.get(k).getRoom_size());
				}
			}
		 }			
	}
	public void add_block() {
		System.out.println("please inter block number");
		int choose = input.nextInt();
		System.out.println("please inter floor number");
		int choose2 = input.nextInt();
		Block bl = new Block(choose,choose2);
		dorm.get(0).blocks.add(bl);
		System.out.println("block added succesfuly");
	}
	public void add_room() {
		System.out.println("please choose block that you want to add room");
		dorm.get(0).show_blocks();
		int choose = input.nextInt();
		System.out.println("please inter room number");
		int num = input.nextInt();
		System.out.println("please inter room size");
		int size = input.nextInt();
		System.out.println("please inter Room rental cost");
		int cost = input.nextInt();
		System.out.println("please inter the  number of floor");
		int fl = input.nextInt();
		Room r = new Room(num,size,fl,cost);
		dorm.get(0).blocks.get(choose-1).rooms.add(r);
	}
	public Manager(){
		
	}
}
