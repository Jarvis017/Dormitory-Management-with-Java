package dorm;

import java.util.ArrayList;

public class student {
ArrayList<Room> room = new ArrayList<Room>();
private String name,study_field;
private int pay,inter_year,student_number;
public student(String name, String study_field, int pay, int inter_year, int student_number) {
	super();
	this.name = name;
	this.study_field = study_field;
	this.pay = pay;
	this.inter_year = inter_year;
	this.student_number = student_number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getStudent_number() {
	return student_number;
}
@Override
public String toString() {
	return "student [name=" + name + ", study field=" + study_field + ", pay =" + pay + " , inter year=" + inter_year
			+ " , student number= " + student_number + " ] ";
}
public void setStudent_number(int student_number) {
	this.student_number = student_number;
}
public String getStudy_field() {
	return study_field;
}
public void setStudy_field(String study_field) {
	this.study_field = study_field;
}
public int getPay() {
	return pay;
}
public void setPay(int pay) {
	this.pay = pay;
}

public int getInter_year() {
	return inter_year;
}
public void setInter_year(int inter_year) {
	this.inter_year = inter_year;
}
public student() {
}
public void add_to_room(Room r) {
	room.add(r);
}
public void show_room() {
	for(int i=0;i<room.size();i++) {
		room.get(i).show_student();
	}
}
}

