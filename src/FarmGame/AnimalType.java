package FarmGame;

public enum AnimalType {
	CHICKEN("/Animalmages/Chicken.png"),
	PIG("/Animalmages/Pig.png"),
	COW("/Animalmages/Cow.png"),
	SHEEP("/Animalmages/Sheep.png");
	
	private final String fileName;
	
	AnimalType(String fileName){
		this.fileName = fileName;
	}
	
	public String getFileName(){
		return fileName;
	}
}
