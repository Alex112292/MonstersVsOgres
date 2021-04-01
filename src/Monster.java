//Alex Santeramo
//Creates a monster from the parameters such as: name, health, and strength
import java.util.Random;

public class Monster 
{
		private double health = 0.0;
		private double strength = 0.0;
		private boolean isAlive = true;
		private String _name;
		
		public Monster()
		{
			health = 0.0;
			strength = 0.0;
		}
		
		public Monster(double health, double strength, String name)
		{
			this.health = health;
			this.strength = strength;
			this._name = name;
			
		}
		//Returns the health of the monster.
		public double getHealth()
		{
			return health;
		}
		//Returns the strength of the monster.
		public double getStrength()
		{
			return strength;
		}
		//Returns the name of the monster.
		public String getName()
		{
			return _name;
		}
		//Assigns the health of the monster.
		public void setHealth(double newHealth)
		{
			health = newHealth;
		}
		//Assigns the strength of the monster.
		public void setStrength(double newStrength)
		{
			strength = newStrength;
		}
		//Assigns the name of the monster.
		public void setName(String name)
		{
			_name = name;
		}
		//Takes a random number between 0 and the monster's strength and assigns damage based on that.
		public double attack()
		{
			Random random = new Random();
			double randomNumber = random.nextDouble();
			return ((strength * randomNumber));
		}
		//Changes the health value of the monster based on how much damage it took.
		public void takeDamage(double attack)
		{
			health = health - attack;
		}
		//Checks to see if the monster is alive.
		public boolean isAlive()
		{
			if(health > 0)
			{
				isAlive = true;
				return isAlive;
			}
			else
			{
				isAlive = false;
				return isAlive;
			}
		}
		//Turns the monsters health, strength, and name into a string to be displayed.
		public String toString()
		{
			String Stats = String.format(_name + "(Health: %.2f, Strength: %.2f)", health, strength);
			return Stats;	
		}
}
