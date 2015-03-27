package CSC301_HW2;

public class Pet implements Boardable{

	protected String petName;
	protected String ownerName;
	protected String color;
	protected int sex;
	
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	public static final int NEUTERED = 2;
	public static final int SPAYED = 3;
	
	private int boardStartMonth, boardStartDay, boardStartYear;
	private int boardEndMonth, boardEndDay, boardEndYear;
	
	// MAIN
	public static void main(String[] args) {
		Pet pet1 = new Pet("Spot", "Mary", "Black and White");
		
		//Uncomment to test isBoarding();
		/*pet1.setBoardStart(3, 26, 2015);
		pet1.setBoardEnd(3, 30, 2015);*/
		System.out.println(pet1.toString());
		
		//Uncomment to test isBoarding();
		/*System.out.println();
		System.out.println("Is Boarding: " + pet1.isBoarding(3, 29, 2015) + " **Should be TRUE");	// Should be true.
		System.out.println("Is Boarding: " + pet1.isBoarding(7, 4, 2015) + " **Should be FALSE");	// Should be false.
*/	}// END MAIN
	
	public Pet(String petName, String ownerName, String color){
		this.petName = petName;
		this.ownerName = ownerName;
		this.color = color;
	}
	
	public String getPetName(){
		return this.petName;
	}
	
	public String getOwnerName(){
		return this.ownerName;
	}
	
	public String getColor(){
		return this.color;
	}
	
	void setSex(int sexID){
		sex = sexID;
	}
	
	public String getSex(){
		String temp = "";
		
		if(sex == 0)
			temp = "Male";
		else if(sex == 1)
			temp = "Female";
		else if(sex == 2)
			temp = "Spayed";
		else if(sex == 3)
			temp = "Neutered";
		
		return temp;
	}
	
	public String toString(){
		String temp = 	getPetName() + " owned by " + getOwnerName() +	 
						"\nColor: " + getColor() + 
						"\nSex: " + getSex() + "\n";
						//Uncomment to test isBoarding();
						// "\nStart: " + boardStartMonth + "-"  + boardStartDay + "-" + boardStartYear + 
						// "\nEnd: " + boardEndMonth + "-"  + boardEndDay + "-" + boardEndYear;
		return temp;
	}
	
	public void setBoardStart(int month,int day, int year){
		boardStartMonth = month;
		boardStartDay = day;
		boardStartYear = year;
	}
	
	public void setBoardEnd(int month,int day, int year){
		boardEndMonth = month;
		boardEndDay = day;
		boardEndYear = year;
	}
	
	public boolean isBoarding(int month, int day, int year){
		boolean temp = false;
		
		if	((boardStartMonth <= month && month <= boardEndMonth) &&
			(boardStartDay <= day && day <= boardEndDay) && 
			(boardStartYear <= year && year <= boardEndYear)){
			temp = true;
		}
		
		return temp;
	}
}
