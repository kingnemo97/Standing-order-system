import java.util.ArrayList;

public class StandingOrderSystemTester
{
	static int testCount = 0;
	static String test;
	public static void main(String [] args) throws Exception
	{
	testInit();
	//testUC1();
	//testUC2();
	//testUC3();
	//testUC4();
	//testUC5();
	//testUC6();
	// for a complicated use case, such as use case 4, you should
	// consider having more than one test method
	}

	
	// test creation of new system
	public static void testInit() throws Exception
	{
		test = "TEST UC0: Create new system";
		StandingOrderSystem sos = new StandingOrderSystem();
		System.out.println("\n" + test + "\n" + sos);
		System.out.println("each test case is commented out, they are set up to work independent of each other");
	}
	
	// test add product
	public static void testUC1()throws Exception
	{
		test = "TEST UC1: Add product";
		// create a new system object
		StandingOrderSystem sos = new StandingOrderSystem();
		// then add a product
		sos.addProduct("P1", "Coke");
		sos.addProduct("P2", "Sprite");
		System.out.println("\n" + test + "\n" + sos);
		//invalid test case
		sos.addProduct("P1", "Coke");
		System.out.println("\n" + test + "\n" + sos);				
		// should have one or two more valid cases
		// then some invalid cases, i.e. preconditions
		// are not satisfied
	}
	
	
	// test add customer
	public static void testUC2()throws Exception
	{
		test = "TEST UC2: Add customer";
		// create a system object
		// then add enough data for your testing purpose
		StandingOrderSystem sos = new StandingOrderSystem();
		sos.addProduct("P1", "Coke");
		// first valid case
		sos.addCustomer("C1", "Smith","A1", "1 Street-1", "Suburb-1","John","1111");
		System.out.println("\n" + test + "\n" + sos);
		
		//test if customer id is new
		sos.addCustomer("C1", "Smith","A2", "1 Street-1", "Suburb-1","John","1111");
		System.out.println("\n" + "test if customer id is new" + "\n" + sos);
		
		//valid case with different customer id and address id to existing customer
		sos.addCustomer("C2", "Smith","A2", "1 Street-1", "Suburb-1","John","1111");
		System.out.println("\n" + "test if new customer can be added" + "\n" + sos);
		
		//invalid case with different customer id and invalid address id
		sos.addCustomer("C3", "Smith","A2", "1 Street-1", "Suburb-1","John","1111");
		System.out.println("\n" + "test if address id is new" + "\n" + sos);
	}
	
	public static void testUC3() {
		test = "TEST UC3: Add Address to existing customer";
		// create a system object
		StandingOrderSystem sos = new StandingOrderSystem();
		sos.addProduct("P1", "Coke");
		// add a customer to add addresses too
		sos.addCustomer("C1", "Smith","A1", "1 Street-1", "Suburb-1","John","1111");
		System.out.println("\n" + test + "\n" + sos);
		
		//valid case to add an address
		sos.addAddress("C1", "A2", "2 Street-2", "Suburb-1","John","1111");
		System.out.println("\n" + "valid case to add address to existing customer" + "\n" + sos);
		
		//invalid case using non existing customer id
		sos.addAddress("C2", "A3", "2 Street-2", "Suburb-1","John","1111");
		System.out.println("\n" + "invalid case using non existing customer id" + "\n" + sos);
		
		//invalid case using existing address id
		sos.addAddress("C1", "A1", "2 Street-2", "Suburb-1","John","1111");
		System.out.println("\n" + "invalid case using existing address id" + "\n" + sos);
	}
	
	public static void testUC4() {
		test = "TEST UC4: Add a standing order to an existing customer";
		// create a system object
		StandingOrderSystem sos = new StandingOrderSystem();
		sos.addProduct("P1", "Coke");
		// add a customer for later test cases
		sos.addCustomer("C1", "Smith","A1", "1 Street-1", "Suburb-1","John","1111");
		System.out.println("\n" + test + "\n" + sos);
		
		//ArrayList to hold specified quantities for given days
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//populate quantity list
		for(int x = 0; x < 7; x++) {
			Integer temp = new Integer(x);
			list.add(temp);
		}
		//start and end date Integer
		Integer startDate = new Integer(13);
		Integer endDate = new Integer(24);
		//invalid end date
		Integer endDateInvalid = new Integer(10);
		
		//add a valid order to a customer
		sos.addOrder("O1", "C1", "A1", "P1", 3.50, list, startDate, endDate, Status.active);
		System.out.println("\n" + "add a valid order to a customer" + "\n" + sos);
		
		//add an invalid order using existing orderId
		sos.addOrder("O1", "C1", "A1", "P1", 3.50, list, startDate, endDate, Status.active);
		System.out.println("\n" + "add an order with an existing order id" + "\n" + sos);
		
		//add an order with a non existing customer
		sos.addOrder("O2", "C2", "A1", "P1", 3.50, list, startDate, endDate, Status.active);
		System.out.println("\n" + "add an order with a non existing customer" + "\n" + sos);
		
		//add an order with a non existing address id
		sos.addOrder("O2", "C1", "A2", "P1", 3.50, list, startDate, endDate, Status.active);
		System.out.println("\n" + "add an order with a non existing address id" + "\n" + sos);
		
		//add an order with a non existing product id
		sos.addOrder("O2", "C1", "A1", "P3", 3.50, list, startDate, endDate, Status.active);
		System.out.println("\n" + "add an order with a non existing product id" + "\n" + sos);
		
		//add an order with end date before start date		
		sos.addOrder("O2", "C1", "A1", "P1", 3.50, list, startDate, endDateInvalid, Status.active);
		System.out.println("\n" + "add an order where startDate > endDate" + "\n" + sos);
		
		//test to check if a quantity has been added for every day
		//change length of list to 6
		for(int x = 0; x < 6; x++) {
			Integer temp = new Integer(x);
			list.add(temp);
		}
		sos.addOrder("O2", "C1", "A1", "P1", 3.50, list, startDate, endDate, Status.active);
		System.out.println("\n" + "add an order where startDate > endDate" + "\n" + sos);		
	}

	public static void testUC5() {
		test = "TEST UC5: list standing orders for a date";
		// create a system object
		StandingOrderSystem sos = new StandingOrderSystem();
		sos.addProduct("P1", "Coke");
		// add a customer to add addresses too
		sos.addCustomer("C1", "Smith","A1", "1 Street-1", "Suburb-1","John","1111");
		sos.addCustomer("C2", "Jim","A2", "1 Street-1", "Suburb-1","John","1111");
		sos.addCustomer("C3", "Adam","A3", "1 Street-1", "Suburb-1","John","1111");
		System.out.println("\n" + test + "\n" + sos);
		
		//ArrayList to hold specified quantities for given days
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//populate quantity list
		for(int x = 0; x < 7; x++) {
			Integer temp = new Integer(x);
			list.add(temp);
		}
		//start and end date Integer
		Integer startDate = new Integer(13);
		Integer endDate = new Integer(24);
		//integer to create order before specified date
		Integer endDateSecond = new Integer(14);
		
		//add a valid order to a customer
		sos.addOrder("O1", "C1", "A1", "P1", 3.50, list, startDate, endDate, Status.active);
		sos.addOrder("O2", "C1", "A1", "P1", 3.50, list, startDate, endDate, Status.active);
		sos.addOrder("O3", "C2", "A2", "P1", 3.50, list, startDate, endDate, Status.active);
		sos.addOrder("O4", "C3", "A3", "P1", 3.50, list, startDate, endDate, Status.active);
		
		//date of order
		Integer specifiedDate = new Integer(15);
		//test if list is sorted by name
		System.out.println("test if orders are sorted by id");
		ArrayList<Order> orderList = sos.listOrders(specifiedDate);
		
		for(Order o : orderList) {
			System.out.println(o + "\n");
		}
		
		//add an order outside specified date
		System.out.println("add an order that does not meet the specified date");
		sos.addOrder("O5", "C3", "A3", "P1", 3.50, list, startDate, endDateSecond, Status.active);
		orderList = sos.listOrders(specifiedDate);
		
		for(Order o : orderList) {
			System.out.println(o + "\n");
		}
		
		//add a customer with the same name with an order
		System.out.println("add a customer with the same name to test if its sorting by customer id where names are the same");
		sos.addCustomer("C4", "Smith","A4", "1 Street-1", "Suburb-1","John","1111");
		sos.addOrder("O6", "C4", "A4", "P1", 3.50, list, startDate, endDate, Status.active);

		
		orderList = sos.listOrders(specifiedDate);
		
		for(Order o : orderList) {
			System.out.println(o + "\n");
		}

	}
	
	public static void testUC6() {
		test = "TEST UC5: list standing orders for a date";
		// create a system object
		StandingOrderSystem sos = new StandingOrderSystem();
		sos.addProduct("P1", "Coke");
		// add a customer to add addresses too
		sos.addCustomer("C1", "Smith","A1", "1 Street-1", "Suburb-1","John","1111");
		
		//ArrayList to hold specified quantities for given days
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//populate quantity list
		for(int x = 0; x < 7; x++) {
			Integer temp = new Integer(x);
			list.add(temp);
		}
		//start and end date Integer
		Integer startDate = new Integer(13);
		Integer endDate = new Integer(24);
		
		//add an order to the customer
		sos.addOrder("O1", "C1", "A1", "P1", 3.50, list, startDate, endDate, Status.active);
		
		//date for the delivery
		Integer deliveryDate = new Integer(18);
		//quantity actually delivered
		Integer quantity = new Integer(3);
		
		//add a valid delivery
		sos.addDelivery("D1", "C1", "A1", deliveryDate, "O1", quantity);
		System.out.println("\n" + "add a valid delivery" + "\n" + sos);
		
		//add a delivery with an existing delivery id
		sos.addDelivery("D1", "C1", "A1", deliveryDate, "O1", quantity);
		System.out.println("\n" + "add a delivery with an existing delivery id" + "\n" + sos);
		
		//add a delivery with a non existing customer id
		sos.addDelivery("D2", "C2", "A1", deliveryDate, "O1", quantity);
		System.out.println("\n" + "add a delivery with a non existing customer id" + "\n" + sos);
		
		//add a delivery with a non existing address id
		sos.addDelivery("D2", "C1", "A2", deliveryDate, "O1", quantity);
		System.out.println("\n" + "add a delivery with a non existing address id" + "\n" + sos);
	}
}