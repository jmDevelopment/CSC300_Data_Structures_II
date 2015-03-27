package CSC301_HW2;

public class Cat extends Pet{
	
	private String hairlength;
	
	public static void main(String[] args) {
		Cat cat1 = new Cat("Tom", "Bob", "Black", "Short");
		cat1.setSex(3);
		System.out.println(cat1.toString());
	}
	
	public Cat(String petName, String ownerName, String color, String hairLength){
		super(petName, ownerName, color);
		this.hairlength = hairLength;
	}
	
	public String getHairLength(){
		return this.hairlength;
	}
	
	public String toString(){
		
		return "CAT: \n" + 
				super.toString() + 
				"Hair: " + getHairLength() + "\n";
	}
	
}
