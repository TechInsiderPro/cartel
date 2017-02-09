package trade;

import static trade.ItemType.*;

/**
 * Created by Alex on 2/8/2017.
 */
public enum Item
{
	Coke(30, Drugs, "White");

	private double baseValue;
	private ItemType itemType;
	private String description;

	Item(double baseValue, ItemType itemType, String description)
	{
		this.baseValue = baseValue;
		this.itemType = itemType;
		this.description = description;
	}

	public double getBaseValue()
	{
		return baseValue;
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
