package dorm;

import java.util.ArrayList;

public class Block {
	private int block_number,floor_number;
	public ArrayList<Room> rooms=new ArrayList<Room>();
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	ArrayList<Dorm> dorm=new ArrayList<Dorm>();
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public Block(int block_number, int floor_number) {
		super();
		this.block_number = block_number;
		this.floor_number = floor_number;
	}
	public int getBlock_number() {
		return block_number;
	}
	public void setBlock_number(int block_number) {
		this.block_number = block_number;
	}
	public int getFloor_number() {
		return floor_number;
	}
	public void setFloor_number(int floor_number) {
		this.floor_number = floor_number;
	}
	public void show_room() {
		for (int i=0;i<rooms.size();i++) {
			System.out.println((i+1)+") "+rooms.get(i).getRoom_number()+"  room size =  "+rooms.get(i).getRoom_size());
		}
		System.out.println("\n");
	}
}
