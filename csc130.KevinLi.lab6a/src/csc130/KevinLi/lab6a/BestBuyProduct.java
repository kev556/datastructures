package csc130.KevinLi.lab6a;

/**
* <b>Title:</b> Lab 6a:<br>

* <b>Filename:</b> BestBuyProduct.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 18, 2023<br>
* <p>
* <b>Description:</b><br>
* Class defining a BestBuyProduct, an object containing a price, a name,
* a upc, its manufacturer, the model of an object, all to simulate the 
* characteristic of an item that is sold at the retailer Best Buy.
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li
*/

class BestBuyProduct implements Comparable<BestBuyProduct> {
	long sku;
	double price;
	String name, upc, manufacturer, model;

	public BestBuyProduct(long sku, double price, String name, String upc, String manufacturer, String model) {
		this.sku = sku;
		this.price = price;
		this.name = name;
		this.upc = upc;
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public long getSku() {
		return sku;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getUPC() {
		return upc;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	/**
	 * toString method -- creates and returns a String which represents the state of
	 * the object
	 * 
	 * @return a String containing the current values of the product
	 */
	public String toString() {
		return sku + "," + price  + ",\""+ name + "\"," + upc + ",\"" + manufacturer + "\"," + model + "\n";
	}

	/**
	 * equals method -- determines if two Products have the same sku
	 * 
	 * @param otherItem is a reference to a Product object
	 * @return true if the two objects contain the same sku false otherwise
	 */
	public boolean equals(Object otherItem) {
		if(otherItem instanceof BestBuyProduct) {
			BestBuyProduct temp = (BestBuyProduct) otherItem;
			return (this.sku == temp.sku);
		}
		return false;
	}

	@Override
	public int compareTo(BestBuyProduct otherProduct) {
		return (int) (sku - otherProduct.sku);
	}

}