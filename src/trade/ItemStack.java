package trade;

/**
 * Created by Alex on 2/8/2017.
 */
public class ItemStack
{
	private Item stackItem;
	private int count;

	public ItemStack(Item stackItem)
	{
		this.stackItem = stackItem;
		this.count = 0;
	}

	public ItemStack(Item stackItem, int count)
	{
		this.stackItem = stackItem;
		this.count = count;
	}

	public void add(int itemCount)
	{
		if (itemCount > 0)
			count += itemCount;
	}

	public void addFromStack(ItemStack itemStack, int itemCount)
	{
		if (itemStack.getStackItem().equals(stackItem))
		{
			this.add(itemCount);
			itemStack.remove(itemCount);
		}
	}

	public int remove(int itemCount)
	{
		if (itemCount > -1)
			count = Math.max(0, count - itemCount);

		return Math.min(count, itemCount);
	}

	public Item getStackItem()
	{
		return stackItem;
	}

	public int getCount()
	{
		return count;
	}

	public int getWeight()
	{
		return getCount() * stackItem.getWeight();
	}
}