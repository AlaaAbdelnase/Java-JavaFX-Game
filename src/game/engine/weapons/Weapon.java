package game.engine.weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import application.TitanEntity;
import game.engine.interfaces.Attacker;
import game.engine.titans.Titan;

public abstract class Weapon implements Attacker
{
	private final int baseDamage;

	public Weapon(int baseDamage)
	{
		super();
		this.baseDamage = baseDamage;
	}

	@Override
	public int getDamage()
	{
		return this.baseDamage;
	}

	public abstract int turnAttack(PriorityQueue<Titan> laneTitans, HashMap<Titan,TitanEntity> TitansEntity,ArrayList<Titan> Deadtitans);

}
