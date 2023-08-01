package dorm;
import java.util.ArrayList;
public class Room {
private int room_number,room_size=3,pay,floor;
public int getFloor() {
	return floor;
}
public void setFloor(int floor) {
	this.floor = floor;
}
public ArrayList<student> students=new ArrayList<student>();

public Room(int room_number, int room_size, int floor, int pay) {
	super();
	this.room_number = room_number;
	this.room_size = room_size;
	this.floor = floor;
	this.pay = pay;
}
public int getRoom_number() {
	return room_number;
}
public void setRoom_number(int room_number) {
	this.room_number = room_number;
}
public int getRoom_size() {
	return room_size;
}
public void setRoom_size(int room_size) {
	this.room_size = room_size;
}
public int getPay() {
	return pay;
}
public void setPay(int pay) {
	this.pay = pay;
}
public ArrayList<student> getStudents() {
	return students;
}
public void show_student() {
	for(int i=0;i<students.size();i++) {
		System.out.println((i+1)+")"+students.get(i).getName());
	}
}
public void delete() {
	for(int i=0;i<students.size();i++) {
		students.remove(i);
		room_size++;
	}
}
public Room() {
	
}
}



