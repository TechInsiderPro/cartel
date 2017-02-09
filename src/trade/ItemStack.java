package trade;

/**
 * Created by Alex on 2/8/2017.
 */
public class ItemStack
{
	public static final int STACK_MAX = 64;
	private Item stackItem;
	private int count;

	public ItemStack(Item stackItem)
	{
		this.stackItem = stackItem;
		this.count = 1;
	}

	public ItemStack(Item stackItem, int count)
	{
		this.stackItem = stackItem;
		this.count = Math.min(STACK_MAX, count);
	}

	public int add(Item item, int itemCount)
	{
		if (item.equals(stackItem) && itemCount > -1)
		{
			int amountToAdd = Math.min(itemCount, STACK_MAX - count);
			count += amountToAdd;
			return amountToAdd;
		}

		return -1;
	}

	public void addFromStack(ItemStack itemStack, int itemCount)
	{
		itemStack.remove(this.add(itemStack.getStackItem(), Math.min(itemCount, itemStack.getCount())));
	}

	public int remove(int itemCount)
	{
		if (itemCount > -1)
		{
			int amountToRemove = Math.min(itemCount, count);
			count -= amountToRemove;
			return amountToRemove;
		}

		return -1;
	}

	public Item getStackItem()
	{
		return stackItem;
	}

	public int getCount()
	{
		return count;
	}
}