package FarmGame;

public enum LocationType {
	POND("/BackgroundImages/Lake.jpg"), // These all need files 
	FOREST("/BackgroundImages/Forest.jpg"), 
	FIELD("/BackgroundImages/Pasture.jpg"), 
	VOLCANO("/BackgroundImages/Volcano.jpg");
	
	private final String fileName;
	
	LocationType (String fileName){
		this.fileName = fileName;
	}
	
	public String getfileName(){
		return fileName;
	}
}