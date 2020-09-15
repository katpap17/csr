//class that stores the source and target nodes 

public class SourceAndTarget{
	
	private int source; //row index
	private int target; //column index
	
	//constructor
	public SourceAndTarget(int source, int target){
		this.source=source;
		this.target=target;
	}
	
	public int getSource(){
		return source;
	}
	
	public int getTarget(){
		return target;
	}
	
	public void setSource(int a){
		source=a;
	}
	
	public void setTarget(int b){
		target=b;
	}
}


