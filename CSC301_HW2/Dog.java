package CSC301_HW2;

public class Dog extends Pet{
	
	private String size;
	
	public static void main(String[] args) {
		Dog dog1 = new Dog("Spot", "Susan", "White", "Medium");
		dog1.setSex(3);
		System.out.println(dog1.toString());
	}
	
	public Dog(String petName, String ownerName, String color, String size){
		super(petName, ownerName, color);
		this.size = size;
	}
	
	public String getSize(){
		return this.size;
	}
	
	public String toString(){
		
		return "DOG: \n" + 
				super.toString() + 
				"Size: " + getSize() + "\n";
	}

}
