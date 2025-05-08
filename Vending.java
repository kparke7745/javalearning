import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Vending {
	private ArrayList<String> directory = new ArrayList<String>();
	private ArrayList<LinkedList<Item>> slots = new ArrayList<LinkedList<Item>>();
	
	public Vending(ArrayList<String> directory) {
		this.directory = directory;
		for (int i=0; i<10; i++) {
			this.slots.add(new LinkedList<Item>());
		}
		loadItem(this.directory);
	}
	
	public String[] parseData(String item) {
		return item.split(", ");
	}
	
	public void loadItem(ArrayList<String> directory) {
		int inputs = 0;
		for (String s : directory) {
			String[] tokens = parseData(s);
			String itemType = tokens[0];
			if (itemType.equals("Drink")) {
				String name = tokens[1];
				float calories = Float.parseFloat(tokens[2]);
				float ounces = Float.parseFloat(tokens[3]);
				String type = tokens[4];
				int amount = Integer.parseInt(tokens[5]);
				Drink drink = new Drink(name, calories, itemType, ounces, type);
				
				for (int n=0; n<amount; n++) {
					this.slots.get(inputs).add(drink);
				}
				inputs++;
			}
			if (itemType.equals("Snack")) {
				String name = tokens[1];
				float calories = Float.parseFloat(tokens[2]);
				float weight = Float.parseFloat(tokens[3]);
				boolean containsNuts = Boolean.parseBoolean(tokens[4]);
				int amount = Integer.parseInt(tokens[5]);
				Snack snack = new Snack(name, calories, itemType, weight, containsNuts);
				
				for (int n=0; n<amount; n++) {
					this.slots.get(inputs).add(snack);
				}
				inputs++;
			}
		}
	}
	
	public void unloadItem(int index) {
		if(this.slots.get(index).isEmpty() || this.slots.get(index) == null) {
			return;
		}
		else if (this.slots.get(index).size() == 1) {
			String item = this.slots.get(index).element().getName().toLowerCase();
			//System.out.println("Only one item of " + item);
			ArrayList<Integer> found = findProduct(item);
			for (Integer n : found) {
				if (this.slots.get(n).size() > 1) {
					this.slots.get(n).remove();
					return;
				}
			}
			this.slots.get(found.get(0)).remove();
		}
		else {
			this.slots.get(index).remove();
		}
	}
	
	public void unloadItem(ArrayList<Integer> indices) {
		for(Integer i : indices) {
			//System.out.println("Input: " + i.toString());
			unloadItem(i);
		}
	}
	
	public ArrayList<Integer> findProduct(String item) {
		
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			//System.out.println("Is " + this.slots.get(i).element().getName().toLowerCase() + " equal to " + item);
			//System.out.println("findProduct loop " + i);
			if ((!this.slots.get(i).isEmpty()) && this.slots.get(i).element().getName().toLowerCase().equals(item.toLowerCase())) {
				indices.add(i);
			}
			else { continue; }
		}
		
		return indices;
	}
	
	public String toString() {
		return this.slots.toString();
	}
	
	public void displayItems() {
		for(int i=0; i<10; i++) {
			if(this.slots.get(i).isEmpty()) {
				System.out.println("EMPTY SLOT");
			}
			else {
				System.out.println(this.slots.get(i).element().getName() + ": " + 
						this.slots.get(i).element().getItemType() + ": " + this.slots.get(i).size());
			}
		}
	}
}
