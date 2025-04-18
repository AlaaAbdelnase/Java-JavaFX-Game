package game.engine.titans;

public class TitanRegistry // For storing the titan's information from the csv file read in the data loader
{
	private final int code;
	private int baseHealth;
	private int baseDamage;
	private int heightInMeters;
	private int speed; // distance moved per turn
	private int resourcesValue; // resources gained by defeating it
	private int dangerLevel;

	public TitanRegistry(int code, int baseHealth, int baseDamage, int heightInMeters, int speed, int resourcesValue,
			int dangerLevel)
	{
		super();
		this.code = code;
		this.baseHealth = baseHealth;
		this.baseDamage = baseDamage;
		this.heightInMeters = heightInMeters;
		this.speed = speed;
		this.resourcesValue = resourcesValue;
		this.dangerLevel = dangerLevel;
	}

	public int getCode()
	{
		return code;
	}

	public int getBaseHealth()
	{
		return baseHealth;
	}

	public int getBaseDamage()
	{
		return baseDamage;
	}

	public int getHeightInMeters()
	{
		return heightInMeters;
	}

	public int getSpeed()
	{
		return speed;
	}

	public int getResourcesValue()
	{
		return resourcesValue;
	}

	public int getDangerLevel()
	{
		return dangerLevel;
	}

	public Titan spawnTitan(int distanceFromBase){
		switch(getCode()){
			case 1:
			return new PureTitan(getBaseHealth(),getBaseDamage(),getHeightInMeters(),distanceFromBase,getSpeed(),getResourcesValue(),getDangerLevel());
			case 2:
			return new AbnormalTitan(getBaseHealth(),getBaseDamage(),getHeightInMeters(),distanceFromBase,getSpeed(),getResourcesValue(),getDangerLevel());
			case 3:
			return new ArmoredTitan(getBaseHealth(),getBaseDamage(),getHeightInMeters(),distanceFromBase,getSpeed(),getResourcesValue(),getDangerLevel());
			case 4:
			return new ColossalTitan(getBaseHealth(),getBaseDamage(),getHeightInMeters(),distanceFromBase,getSpeed(),getResourcesValue(),getDangerLevel());
			default:
			return null;
		}
	}

}
