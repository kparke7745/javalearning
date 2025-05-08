
public class Item {
	
	private String name;
	private float calories;
	private String itemType;
	
	public Item(String name, float calories, String itemType) {
		this.name = name;
		this.calories = calories;
		this.itemType = itemType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
}
