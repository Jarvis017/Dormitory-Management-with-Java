package dorm;
import java.util.ArrayList;
public class Dorm {
	private String dorm_name,dorm_type;
	 ArrayList<Block> blocks=new ArrayList<Block>();
	public ArrayList<Block> getBlocks() {
		return blocks;
	}
	public Dorm(String dorm_name, String dorm_type) {
		super();
		this.dorm_name = dorm_name;
		this.dorm_type = dorm_type;
	}
	public String getDorm_name() {
		return dorm_name;
	} 
	public void setDorm_name(String dorm_name) {
		this.dorm_name = dorm_name;
	}
	public String getDorm_type() {
		return dorm_type;
	}
	public void setDorm_type(String dorm_type) {
		this.dorm_type = dorm_type;
	}
	public int block_size() {
		return blocks.size();
	}
	public void show_blocks() {
		for(int i=0;i<blocks.size();i++) {
			System.out.print((i+1)+") "+blocks.get(i).getBlock_number()+"\t");
		}
	}
	public Dorm() {
		
	}
	public int block_number() {
		return blocks.size();
	}
}
	
