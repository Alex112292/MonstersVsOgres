//Alex Santeramo
//This class has a giant and an ogre fight one another if the user chooses to have the default battle, if the user chooses to have a custom battle they can have two files be read in that can create new monsters to fight. 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MonsterBattle 
{

	public static void main(String[] args) 
	{
		System.out.println("Would you like to run a default battle, or a custom one? Type: 1 for Default or 2 for Custom.");
		Scanner input = new Scanner(System.in);
		String answer = input.next();
		if(answer.equals("1"))
		{
			//Creates the two monsters to fight.
			Monster giant = new Monster(200.00, 25.00, "Giant");
			Monster ogre = new Monster(100.00, 50.00, "Ogre");
			//Plays out the battle.
			do
			{
				//Displays the first hit.
				double hitA = giant.attack();
				ogre.takeDamage(hitA);
				System.out.printf("Giant attacked Ogre for %.2f damage.\n", hitA);
				//Displays the second hit.
				double hitB = ogre.attack();
				giant.takeDamage(hitB);
				System.out.printf("Ogre attacked Giant for %.2f damage.\n", hitB);
				//Displays the summary of the round.
				System.out.println(giant + " " + ogre);
			} while (giant.isAlive() == true && ogre.isAlive() == true);
			//Determines the outcome of the fight depending on what monster died.
			if(giant.isAlive() == false && ogre.isAlive() == false)
			{
				System.out.println("It's a draw!");
			}
			else if(ogre.isAlive() == false)
			{
				System.out.println("Giant wins!");
			}
			else if(giant.isAlive() == false )
			{
				System.out.println("Ogre wins!");
			}
		}
		else if (answer.equals("2"))
		{
			//Has the user enter two file names that contain the attributes of monsters to fight with.
			Monster customMonsterA;
			Monster customMonsterB;
			do
			{
				System.out.println("Please enter a file name to create one monster with.");
				String fileName = input.next();
				customMonsterA = readMonster(fileName);
			} while (customMonsterA == null);
			do
			{
				System.out.println("Please enter a file name to create the other monster with.");
				String fileName = input.next();
				customMonsterB = readMonster(fileName);
			} while (customMonsterB == null);
			do
			{
				//Displays the first hit.
				double hitA = customMonsterA.attack();
				customMonsterB.takeDamage(hitA);
				System.out.printf(customMonsterA.getName() + " attacked " + customMonsterB.getName() + " for %.2f damage. \n", hitA);
				//Displays the second hit.
				double hitB = customMonsterB.attack();
				customMonsterA.takeDamage(hitB);				
				System.out.printf(customMonsterB.getName() + " attacked " + customMonsterA.getName() + " for %.2f damage. \n", hitB);
				//Displays the results of that round.
				System.out.println(customMonsterA + " " + customMonsterB);
			} while (customMonsterA.isAlive() == true && customMonsterB.isAlive() == true);
			//Checks how the fight ended.
			if(customMonsterA.isAlive() == false && customMonsterB.isAlive() == false)
			{
				System.out.println("It's a draw!");
			}
			else if(customMonsterB.isAlive() == false)
			{
				System.out.println(customMonsterA.getName() + " wins!");
			}
			else if(customMonsterA.isAlive() == false)
			{
				System.out.println(customMonsterB.getName() + " wins!");
			}
		}

	}
	//Takes a file name and converts its contents into a monster that is returned to the program.
	public static Monster readMonster(String monsterFileName)
	{	
		File monsterFile = new File(monsterFileName);
		Scanner fileInput = null;
		try
		{
			fileInput = new Scanner(monsterFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("That file doesn't exist. Please enter two filenames to create the monsters with.");
			return null;
		}
		//Takes the values from inside of the file and assigns them to variables.
		String name = fileInput.nextLine();
		double health = fileInput.nextDouble();
		double strength = fileInput.nextDouble();
		fileInput.close();
		//Creates the custom monster.
		Monster customMonster = new Monster(health, strength, name);
		return customMonster;
	}

}
