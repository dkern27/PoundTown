package FarmGame;

public enum LocationType {
	POND, // These all need files 
	FOREST, 
	FIELD, 
	VOLCANO;
	
	private final String fileName;
	LocationType (String fileName){
		this.fileName = fileName;
	}
	
	public String getfileName(){
		return fileName;
	}
}