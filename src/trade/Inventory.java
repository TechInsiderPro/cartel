package trade;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 2/8/2017.
 */
public class Inventory
{
	private int maxWeight;
	private Map<Item, ItemStack> itemStacks;

	public Inventory(int maxWeight)
	{
		this.maxWeight = maxWeight;
		this.itemStacks = new HashMap<>();
	}

	public void add(Item item, int itemCount)
	{
		getStackOf(item).add(Math.min(itemCount, (getMaxWeight() - getCurrentWeight()) / item.getWeight()));
	}

	public void add(ItemStack itemStack)
	{
		add(itemStack.getStackItem(), itemStack.getCount());
	}

	public ItemStack getStackOf(Item item)
	{
		if (!itemStacks.containsKey(item))
			itemStacks.put(item, new ItemStack(item));

		return itemStacks.get(item);
	}

	public ItemStack remove(Item item, int itemCount)
	{
		ItemStack temp = new ItemStack(item);
		temp.addFromStack(getStackOf(item), itemCount);
		return temp;
	}

	public int getSize()
	{
		return itemStacks.size();
	}

	public int getMaxWeight()
	{
		return maxWeight;
	}

	public int getCurrentWeight()
	{
		int totalWeight = 0;

		for (ItemStack temp : itemStacks.values())
			if (temp != null)
				totalWeight += temp.getWeight();

		return totalWeight;
	}
}
