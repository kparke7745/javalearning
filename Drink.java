
public class Drink extends Item {
	
	private float ounces;
	private String type;
	
	public Drink(String name, float calories, String itemType, float ounces, String type) {
		super(name, calories, itemType);
		this.ounces = ounces;
		this.type = type;
	}

	public float getOunces() {
		return ounces;
	}

	public void setOunces(float ounces) {
		this.ounces = ounces;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Drink [ounces=" + ounces + ", type=" + type + "]";
	}
	

}
