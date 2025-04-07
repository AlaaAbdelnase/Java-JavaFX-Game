package game.engine.weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import application.TitanEntity;
import game.engine.titans.Titan;

public class PiercingCannon extends Weapon
{
	public static final int WEAPON_CODE = 1;

	public PiercingCannon(int baseDamage)
	{
		super(baseDamage);
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans,HashMap<Titan,TitanEntity> TitansEntity,ArrayList<Titan> Deadtitans)
	{
		ArrayList<Titan> tmp = new ArrayList<>();
		int attackRes = 0;

		for (int i = 0; i < 5 && !laneTitans.isEmpty(); i++)
		{
			Titan nextTitan = laneTitans.poll();
			attackRes += this.attack(nextTitan);

			if (!nextTitan.isDefeated())
			{
				tmp.add(nextTitan);
			}else {
				Deadtitans.add(nextTitan);
			}
		}

		laneTitans.addAll(tmp);

		return attackRes;
	}

}
