package CSC301_HW2;

// AnimalHospital.java -- partially filled application code for HW#2.
//
// NOTE:
//  - An input data file (pet_records.csv) is assumed to be found
//     in the same directory as this file.
//  - The three static methods can be written anywhere in the class.


import java.io.*;
import java.util.*;

public class AnimalHospital
{
  public static void main(String[] args)
  {
    String infile = "pet_records.csv";
    ArrayList<Pet> petList = readRecords(infile);

    System.out.println("--- Record of Reno ---");
    printPetInfoByName(petList, "Reno"); System.out.println();

    System.out.println("--- Record of Spot ---");
    printPetInfoByName(petList, "Spot"); System.out.println();

    System.out.println("--- Gary's pets ---");
    printPetInfoByOwner(petList, "Gary"); System.out.println();

    System.out.println("=== Boarding as of 3/19/2001 ===");
    printPetsBoarding(petList, 3, 19, 2001);

  }

  public static ArrayList<Pet> readRecords(String file)
  {
    ArrayList<Pet> lst = new ArrayList<Pet>();
    String line;

    try {
      BufferedReader f = new BufferedReader(new FileReader(file));

      while ((line = f.readLine()) != null) {

        StringTokenizer tok = new StringTokenizer(line, ",");

        // Get all info from the line.
        String petType = tok.nextToken().trim();
        String name = tok.nextToken().trim();
        String owner = tok.nextToken().trim();
        String color = tok.nextToken().trim();
        int sexid = Integer.parseInt(tok.nextToken().trim());
        String sizeORhair = tok.nextToken().trim();
        String startDate = tok.nextToken().trim();
        String endDate = tok.nextToken().trim();

        Pet p = null;

        if (petType.equals("DOG"))
          p = new Dog(name, owner, color, sizeORhair);
        else if (petType.equals("CAT"))
          p = new Cat(name, owner, color, sizeORhair);

        p.setSex(sexid);
        setBoardingDates(p, startDate, endDate);

        lst.add(p);
      }

      f.close();

    } catch (IOException e) { e.printStackTrace(); }

    return lst;
  }

  public static void setBoardingDates(Pet p, String start, String end)
  {
    StringTokenizer tok = new StringTokenizer(start, "/");
    int startMonth = Integer.parseInt(tok.nextToken().trim());
    int startDay = Integer.parseInt(tok.nextToken().trim());
    int startYear = Integer.parseInt(tok.nextToken().trim());

    tok = new StringTokenizer(end, "/");
    int endMonth = Integer.parseInt(tok.nextToken().trim());
    int endDay = Integer.parseInt(tok.nextToken().trim());
    int endYear = Integer.parseInt(tok.nextToken().trim());

    p.setBoardStart(startMonth, startDay, startYear);
    p.setBoardEnd(endMonth, endDay, endYear);
  }

  // Methods to write
  static void printPetInfoByName(ArrayList<Pet> lst, String name){
	  for(Pet p : lst){
		  if(p.petName.equals(name))
			  System.out.println(p.toString());
		}
  }
  
  static void printPetInfoByOwner(ArrayList<Pet> lst, String name){
	  for(Pet p : lst){
		  if(p.ownerName.equals(name))
			  System.out.println(p.toString());
		}
  }
  
  static void printPetsBoarding(ArrayList<Pet> lst, int month, int day, int year){
	  for(Pet p : lst){
		  if(p.isBoarding(month, day, year))
			  System.out.println(p.toString());
	  }
  }


}

/* Output of the program

--- Record of Reno ---
DOG:
Reno owned by Mark
Color: black
Sex: neutered
Size: large


--- Record of Spot ---
DOG:
Spot owned by Mary
Color: black&white
Sex: male
Size: medium


--- Gary's pets ---
CAT:
Tom owned by Gary
Color: brown
Sex: neutered
Hair: short

CAT:
Otis owned by Gary
Color: brown
Sex: male
Hair: short


=== Boarding as of 3/19/2001 ===
DOG:
Zoey owned by Tracy
Color: yellow
Sex: spayed
Size: large

DOG:
Spot owned by Mary
Color: black&white
Sex: male
Size: medium

DOG:
Buddy owned by Mick
Color: black&tan
Sex: neutered
Size: medium

CAT:
Kate owned by Michelle
Color: white
Sex: female
Hair: long

DOG:
Shorty owned by Doug
Color: brown
Sex: male
Size: small

*/
