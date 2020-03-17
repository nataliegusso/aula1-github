package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

/*		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String DepartmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(DepartmentName));

		System.out.println();
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=0 ; i<n ; i++) {
			int aux = i+1;
			System.out.printf("Enter contract #%d data:%n", aux);
			System.out.print("Date (DD/MM/YY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year,  month)));
*/
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());  //
		
		Order order = new Order(new Date(), status, client); //
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
				
		for (int i=0 ; i<n ; i++) {
			int x = i+1;
			System.out.printf("Enter #%d item data: %n", x);
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);   //
		}

		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
/*		System.out.println("Order moment: ");
		System.out.println(order.moment());
		System.out.println();
		System.out.println("Order status: " + status);
		System.out.println("Client" + client);
		System.out.println("Order items: ");
		System.out.println(order);    //
		System.out.println(order.total());
*/	
		sc.close();
	}
}

