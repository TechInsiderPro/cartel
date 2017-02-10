package trade;

import static trade.ItemType.*;

/**
 * Created by Alex on 2/8/2017.
 */
public enum Item
{
	Coke(30, 1, Drugs, "White");

	private int baseValue, weight;
	private ItemType itemType;
	private String description;

	Item(int baseValue, int weight, ItemType itemType, String description)
	{
		this.baseValue = baseValue;
		this.weight = weight;
		this.itemType = itemType;
		this.description = description;
	}

	public double getBaseValue()
	{
		return baseValue;
	}

	public int getWeight()
	{
		return weight;
	}

	public ItemType getItemType()
	{
		return itemType;
	}

	public String getDescription()
	{
		return description;
	}
}
