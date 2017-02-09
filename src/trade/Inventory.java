package trade;

/**
 * Created by Alex on 2/8/2017.
 */
public class Inventory
{
	private ItemStack[] itemStacks;

	public Inventory(int maxSlots)
	{
		this.itemStacks = new ItemStack[maxSlots];
	}

	public void add(ItemStack itemStack)
	{
		for (ItemStack temp : itemStacks)
			if (temp != null && itemStack.getCount() > 0)
				temp.addFromStack(itemStack, itemStack.getCount());

		for (int i = 0; i < itemStacks.length && itemStack.getCount() > 0; i++)
			if (itemStacks[i] == null)
			{
				itemStacks[i] = itemStack;
				return;
			}
	}

	public ItemStack get(int index)
	{
		if (index >= 0 || index < itemStacks.length)
			return itemStacks[index];

		return null;
	}

	public ItemStack set(int index, ItemStack itemStack)
	{
		if (index >= 0 || index < itemStacks.length)
		{
			ItemStack temp = itemStacks[index];
			itemStacks[index] = itemStack;
			return temp;
		}

		return null;
	}

	public ItemStack remove(int index)
	{
		if (index >= 0 || index < itemStacks.length)
		{
			ItemStack temp = itemStacks[index];
			itemStacks[index] = null;
			return temp;
		}

		return null;
	}

	public int getSize()
	{
		return itemStacks.length;
	}
}
