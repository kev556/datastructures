package csc130.KevinLi.lab6a;

/**
* <b>Title:</b> Lab 6a:<br>

* <b>Filename:</b> Lab6aApp.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 18, 2023<br>
* <p>
* <b>Description:</b><br>
* Driver Class for Lab6a, whose purpose is to improve familiarity with 
* Lists as well as SQLLite. Contains methods and code that accesses a SQLLite db file,
* as well as code that tests the functionality of methods contained in the ArrayList class
* and methods that introduce new functionality.
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li
*/

/**
 * <p>Title: Driver Class - Lab6aApp</p>
 *
 * <p>Copyright: Copyright (c) 2014, 2021</p>
 *
 * @author F. Graham
 * @version 1.2
 */
import java.sql.*;

public class Lab6aApp {
	public static void main(String[] args) {
		
		/**
		List<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(1); list.add(2); list.add(3);
		list.add(3); list.add(4); list.add(5); list.add(6);
		list.add(1);
		
		//System.out.println(list.get(1));
		System.out.println(list);
		list.add(8,10);
		System.out.println(list);
		
		System.out.println(list);
		list.remove(1);
		list.remove(4);
		System.out.println(list);
		
		System.out.println(list.getSize());
		list.add(2);
		System.out.println(list.getSize());
		*/
		
		List<BestBuyProduct> list1 = new ArrayList<BestBuyProduct>();
		List<BestBuyProduct> list2 = new ArrayList<BestBuyProduct>(1000);
		System.out.println(list1 + "\n" + list2);
		
		BestBuyProduct prod1 = new BestBuyProduct(100, 19.99, "Dark Souls", "000000000001", "FromSoftware", "bluray");
		BestBuyProduct prod2 = new BestBuyProduct(101, 19.99, "Dark Souls 2", "000000000002", "FromSoftware", "bluray");
		BestBuyProduct prod3 = new BestBuyProduct(102, 59.99, "Dark Souls 3", "000000000003", "FromSoftware", "bluray");
		BestBuyProduct prod4 = new BestBuyProduct(103, 59.99, "Elden Ring", "000000000004", "FromSoftware", "bluray");
		
		BestBuyProduct[] products = getData();
		
		for (int i = 0; i < products.length; i++) {
			BestBuyProduct temp = products[i];
			list2.add(temp);
			System.out.printf("Product %d %s added to List 2\n", temp.getSku(), temp.getName());
		}
		
		testSearch(1088665, list2);
		testSearch(344097, list2);
		
		
		/**tests the indexOf() method while simultaneously testing testSearch()
		 * tests that the index of the element at index 0 is what it should be 
		 */
		BestBuyProduct indexoftester = list2.get(0);
		indexoftester = list2.get(list2.indexOf(indexoftester));
		testSearch(indexoftester.getSku(), list2);
		/**
		System.out.println(list2.get(0));
		System.out.println(list2.get(1000));
		System.out.println("" + list2.get(0).equals(list2.get(1000)));
		System.out.println(list2.getSize());
		*/
		
		/**tests the lastIndexOf() method while simultaneously testing testSearch()
		 * tests that the index of the element at index 999 is what it should be 
		 */
		BestBuyProduct lastindexoftester = list2.get(list2.lastIndexOf(list2.get(list2.getSize() - 1)));
		testSearch(lastindexoftester.getSku(), list2);
		
		testSearch(indexoftester.getSku(), list1);
		
		//searches for product 1196144, removes it, then searches again to confirm removal
		testSearch(1196144, list2);
		testRemove(1196144, list2);
		testSearch(1196144, list2);
		
		//removes the first and last element, then searches for the removed items to confirm removal
		testRemove(indexoftester.getSku(), list2);
		testRemove(list2.get(list2.getSize() - 1).getSku(), list2);
		testSearch(indexoftester.getSku(), list2);
		testSearch(lastindexoftester.getSku(), list2);
		
		//Tests remove on a list with one element
		list1.add(prod1);;
		testRemove(prod1.getSku(), list1);
		testSearch(prod1.getSku(), list1);
		
		//Tests remove on an empty list
		testRemove(prod1.getSku(), list1);
		
		/**
		 * 	Question 17: 
		 * 	
		 * 	To be honest I don't really know why I don't get an error message when the .equals() method is commented out.
		 * 	I suspect that it is because .equals() is already an innate method for all objects in Java, and commenting out 
		 * 	the override doesnt change any output or change the functionality. After some research,
		 * 	I found that the .equals() method compares the strings that results from the toString() methods of the object,
		 * 	so I suppose the output of the code not changing is a result of a well designed class with a well defined toString() method.
		 * 
		 */
		
		//prints all products containing the string "Apple"
		find("Apple", list2);
		
		//Tests the set(int,BestBuyProduct) method
		System.out.println("\n\n" + list2.get(0));
		list2.set(0, prod2);
		System.out.println(list2.get(0) + "\n");
		
		//Tests the set(BestBuyProduct, BestBuyProduct) method
		list2.set(prod2, prod3);
		list2.get(0);
		System.out.println(list2.get(0) + "\n\n");
		
	}
	/**
	 * getData method -- gets the products from an SQLite database
	 * @return the an array of products
	 */
		public static BestBuyProduct[] getData(){		
			Statement stmt = null;
			int records = 0;
			BestBuyProduct[] products = null; 
			try {
				Class.forName("org.sqlite.JDBC");
				Connection c = DriverManager.getConnection("jdbc:sqlite:BestBuyProducts.db");
				c.setAutoCommit(false);
				System.out.println("Opened database successfully");			
				
				stmt = c.createStatement();
				
				ResultSet rs = stmt.executeQuery("SELECT * FROM products;");
				ResultSetMetaData rsmd = rs.getMetaData();			
				
				for(int i = 1; i <= rsmd.getColumnCount(); i++)
				{
					System.out.print(String.format("%-12s", rsmd.getColumnLabel(i)) + "\t");
					System.out.print(rsmd.getColumnTypeName(i) + "\t");
					System.out.println(rsmd.getPrecision(i));
				}
				
				rs = stmt.executeQuery("select count (*) AS totalRecords from products");
				int totalRecords = rs.getInt("totalRecords");
				System.out.println("Records: " + totalRecords);
				
				rs = stmt.executeQuery("SELECT * FROM products;");
				if(rs != null){
					products = new BestBuyProduct[totalRecords];
					while (rs.next()) {
						int sku = rs.getInt("sku");
						double price = rs.getFloat("price");
						String name = rs.getString("name");
						String upc = rs.getString("upc");
						String manufacturer = rs.getString("manufacturer");
						String model = rs.getString("model");

						//System.out.println(String.format("%3s %-6s %3d %6.2f",
						//		records, prodId, quantity, price));	
						products[records++] = new BestBuyProduct(sku, price, name, upc, manufacturer, model);;
						if(records < 6)
						System.out.println(records + " " + products[records-1]);
					}
					System.out.println();
				}
				
				stmt.close();
				c.commit();
				c.close();
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException se){
				System.err.println(se.getClass().getName() + ": " + se.getMessage());
			}
			return products;
		}
		public static void testSearch(long key, List<BestBuyProduct> ulist) {
			System.out.printf("\nSearching for product %d\n", key);
			for (int i = 0; i < ulist.getSize(); i++) {
				if (ulist.get(i).getSku() == key) {
					System.out.printf("Product number %d located at index %d\n", key, i);
					return;
				}
			}
			System.out.printf("Product %d not found in the list\n\n", key);
			
		}
		public static void testRemove(long key, List<BestBuyProduct> ulist) {
			
			System.out.printf("\nRemoving product %d\n", key);
			for (int i = 0; i < ulist.getSize(); i++) {
				if (ulist.get(i).getSku() == key) {
					ulist.remove(ulist.get(i));
					System.out.printf("Product number %d removed from list at index %d\n", key, i);
					return;
				}
			}
			System.out.printf("Product %d not found in the list\n\n", key);
			
		}
		public static void find(String s, List<BestBuyProduct> ulist) {
			System.out.printf("Finding all products containing %s\n\n", s);
			for (int i = 0; i < ulist.getSize(); i++) {
				BestBuyProduct temp = ulist.get(i);
				if (temp.getName().indexOf(s) >= 0 || temp.getUPC().indexOf(s) >= 0 || temp.getModel().indexOf(s) >= 0 || temp.getManufacturer().indexOf(s) >= 0) 
					System.out.println(temp);
			}
			
		}
}