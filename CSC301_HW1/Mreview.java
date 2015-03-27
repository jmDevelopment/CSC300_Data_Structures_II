package CSC301_HW1;

import java.util.*;

public class Mreview implements Comparable<Mreview>{
	
	public static void main(String[] args) {
		
		Mreview test = new Mreview("Kill Bill", 3);
		test.addRating(4);
		test.addRating(2);
		test.addRating(3);
		System.out.println(test.toString());
		System.out.println();
		
		/*// Uncomment to check compareTo() method.
		Mreview test2 = new Mreview("Kill Bill");
		Mreview test3 = new Mreview("Pulp Fiction");
		Mreview test4 = new Mreview("Death Proof");
		System.out.println(test.compareTo(test3)); // -
		System.out.println(test.compareTo(test2)); // 0
		System.out.println(test.compareTo(test4)); // +
		*/		
	}
	
	/*
	 * Private Instance Variables.
	 */
	private String title;
	private ArrayList<Integer> ratings;
	
	/*
	 * Constructors
	 */
	
	/**
	 * Sets title to "" and creates an empty ArrayList to ratings.
	 */
	public Mreview(){
		title = "";
		ratings = new ArrayList<Integer>();
	}
	
	/**
	 * Sets title to the parameter string and creates an empty ArrayList to ratings.
	 * @param ttl - A string to be used to initialize title.
	 */
	public Mreview(String ttl){
		title = ttl;
		ratings = new ArrayList<Integer>();
	}
	
	/**
	 * Sets title to the parameter string and creates a ratings list whose size() is one, having the parameter int as the (only/first) element.
	 * @param ttl - A string to be used to initialize title.
	 * @param firstRating - The first rating number/int.
	 */
	public Mreview(String ttl, int firstRating){
		title = ttl;
		ratings = new ArrayList<Integer>();
		ratings.add(firstRating);
	}
	
	
	/*
	 * Methods
	 */
	
	/**
	 * Returns title string.
	 * @return - title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Inserts the parameter rating in the ratings list.
	 * @param r - A rating (int) to be inserted in ratings.
	 */
	public void addRating(int r){
		ratings.add(r);
	}
	
	/**
	 * Returns the size (not capacity) of the rating list.
	 * @return - size() of ratings.
	 */
	public int numRatings(){
		return ratings.size();
	}
	
	/**
	 * Returns the average of the ratings stored in the rating list.
	 * @return - average of ratings.
	 */
	public double avgRating(){
		double rt = 0;
		
		for(int i : ratings)
			rt += i;
		rt = rt / ratings.size();
		return rt;
	}
	
	/**
	 * Overrides the method derived from Object. To determine the (content) equality of two Mreview's, only the titles are considered -- 
	 * If this title is "equals" to the title of the parameter object. Casting is required to make the parameter a Mreview object.
	 * @param obj - Another Object to be compared for the order. Casting is required to make the parameter a Mreview object.
	 * @return - true if two title String's are equal, or false otherwise.
	 */
	public boolean equals(Mreview obj){	
		boolean tf = true;	
		
		if(!obj.title.equals(title))
			tf = false;

		return tf;			
	}
	
	/**
	 * Overrides the abstract method defined in Comparable interface. To determine the order of two Mreview's, 
	 * only the titles are considered and their order translates the order of Mreview's directly.
	 * @param Mreview obj -  Another Mreview object to be compared for the order.
	 * @return - a negative number if this title is before the title of the parameter object, or a positive number if this title 
	 * is after the title of the parameter object, or 0 otherwise.
	 */
	public int compareTo(Mreview obj)
	 {
	    int val = this.title.compareTo(obj.title);
	    
	    /*if(val < 0)
	    	System.out.println(obj.title + " comes after " + this.title);
	    else if (val > 0)
	    	System.out.println(obj.title + " comes before " + this.title);
	    else
	    	System.out.println("Two titles are equal.");*/
	    
	    return val;
	 }
	
	/**
	 * String representation of a Mreview.
	 * @return - a string of the form "XXX, average YYY out of ZZZ ratings" where XXX is the title, 
	 * YYY is the average ratings and ZZZ is the number of ratings.
	 */
	public String toString(){
		String temp = getTitle() + ", average of " + avgRating() + " out of " + numRatings() + " ratings.";
		return temp;
	}
	
	 
	
	 
	 
	
	
	

}
