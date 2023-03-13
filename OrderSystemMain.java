package SBA6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class OrderSystemMain {

	public static void main(String[] args) {
		

		

		
				// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				
//			while(true) {
				try  {
					
					String customerName="krishna";
					String emailAddress="krishna@gmail.com";		
					CustomerOrder customerOrder=new CustomerOrder(customerName, emailAddress);
					ItemCategory itemCategory=new ItemCategory();		
					int choice = 0, option = 0;		
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("      Welcome to Electronics World    ");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					
					while (true) {
						boolean validInput = false;
						while (!validInput) {
						    try {
						System.out.println("1. Mobiles");
						System.out.println("2. Tabs");
						System.out.println("3. Electronics");
						System.out.println("4. View Orders");
						System.out.println("5. HelpLine");
						System.out.println("6. Exit");
						System.out.print("\nEnter your choice item category: ");
						choice = sc.nextInt();
						 validInput = true;
				    } catch (InputMismatchException e) {
				        System.out.println("Invalid input type. Please enter a valid choice.");
				        sc.nextLine(); // Clear scanner buffer
				    }
						}
						int itemNumber=0;
						int itemQuantity=0;;
						boolean isValidItem=false;
						switch (choice) {
						case 1:
							validInput = false;
							while (!validInput) {
							    try {
							itemCategory.showMobilesMenu();
							//****** 		
							System.out.print("Enter item number: ");
							itemNumber = sc.nextInt();
							System.out.print("Enter quantity of item: ");
							itemQuantity = sc.nextInt();
							 validInput = true;
							    } catch (InputMismatchException e) {
							        System.out.println("Invalid input type. Please enter a valid choice.");
							        sc.nextLine(); // Clear scanner buffer
							    }
									}
							
							
							for (Item item :itemCategory.mobiles) {
								if (item.getNumber()==itemNumber) {
									item.quantity=itemQuantity;
									isValidItem=true;	
									validInput = false;
									while (!validInput) {
									    try {
									System.out.println("\n1.Add To Cart");
									System.out.println("2.PlaceOrder");
									System.out.print("Enter option: ");
									option = sc.nextInt();
									 validInput = true;
									    } catch (InputMismatchException e) {
									        System.out.println("Invalid input type. Please enter a valid choice.");
									        sc.nextLine(); // Clear scanner buffer
									    }
											}
									if (option == 1) {
										System.out.println("");
										itemCategory.addToCart(item);
										itemCategory.showCartItems();
									} else if(option==2){
										System.out.println("");
										
										Calendar c = Calendar.getInstance();
										c.setTime(new Date());
										Date startDate= c.getTime();
										c.add(Calendar.DATE, 5); // Adding 5 days
										Date deliverDate = c.getTime();	
										
										DeliveryTimeline timeLine=new DeliveryTimeline(startDate,deliverDate);	
										OrderDetails order=new OrderDetails(timeLine);	
										order.addDeliveryDetails();
										itemCategory.placeOrder(item);
										order.addItems(itemCategory.cartItems);
										int orderId = order.placeOrder();
										order.showOrderItems();
										//Review order
										order.customerFeedback();									
										customerOrder.addOrderDetails(order);
										itemCategory.cartItems.clear();	
									}
									else {
										System.out.println("Invalid option");
									}
								}						
							}
							if(!isValidItem) {
								System.out.println("\nItem is not available. ");
							}					
							break;
						case 2:
							validInput = false;
							while (!validInput) {
							    try {
							itemCategory.showTabsMenu();
							System.out.print("Enter item number: ");
							itemNumber = sc.nextInt();
							System.out.print("Enter quantity of item: ");
							itemQuantity = sc.nextInt();
							validInput = true;
							    } catch (InputMismatchException e) {
							        System.out.println("Invalid input type. Please enter a valid choice.");
							        sc.nextLine(); // Clear scanner buffer
							    }
									}
							
							for (Item item :itemCategory.tabs) {
								if (item.getNumber()==itemNumber) {
									item.quantity=itemQuantity;
									isValidItem=true;	
									
									validInput = false;
									while (!validInput) {
									    try {
									System.out.println("\n1.Add To Cart");
									System.out.println("2.PlaceOrder");
									System.out.print("Enter option: ");
									option = sc.nextInt();
									validInput = true;
									    } catch (InputMismatchException e) {
									        System.out.println("Invalid input type. Please enter a valid choice.");
									        sc.nextLine(); // Clear scanner buffer
									    }
											}
									
									if (option == 1) {
										System.out.println("");
										itemCategory.addToCart(item);
										itemCategory.showCartItems();
									} else if(option==2){
										System.out.println("");
										
										Calendar c = Calendar.getInstance();
										c.setTime(new Date());
										Date startDate= c.getTime();
										c.add(Calendar.DATE, 5); // Adding 5 days
										Date deliverDate = c.getTime();
										
										DeliveryTimeline timeLine=new DeliveryTimeline(startDate,deliverDate);	
										OrderDetails order=new OrderDetails(timeLine);								
										//order.addItems(itemCategory.cartItems);								
										order.addDeliveryDetails();
										itemCategory.placeOrder(item);
										order.addItems(itemCategory.cartItems);
										int orderId = order.placeOrder();
										order.showOrderItems();									
										//Review order
										order.customerFeedback();
										customerOrder.addOrderDetails(order);
										itemCategory.cartItems.clear();
									}
									else {
										System.out.println("Invalid option");
									}
								}						
							}
							if(!isValidItem) {
								System.out.println("\nItem is not available. ");
							}					
							break;
						case 3:
							validInput = false;
							while (!validInput) {
							    try { 
							itemCategory.showElectronicsMenu();
							System.out.print("Enter item number: ");
							itemNumber = sc.nextInt();
							System.out.print("Enter quantity of item: ");
							itemQuantity = sc.nextInt();
							validInput = true;
							    } catch (InputMismatchException e) {
							        System.out.println("Invalid input type. Please enter a valid choice.");
							        sc.nextLine(); // Clear scanner buffer
							    }
									}
							
							
							for (Item item :itemCategory.electronics) {
								if (item.getNumber()==itemNumber) {
									item.quantity=itemQuantity;
									isValidItem=true;	
									
									validInput = false;
									while (!validInput) {
									    try {
									System.out.println("\n1.Add To Cart");
									System.out.println("2.PlaceOrder");
									System.out.print("Enter option: ");
									option = sc.nextInt();
									validInput = true;
									    } catch (InputMismatchException e) {
									        System.out.println("Invalid input type. Please enter a valid choice.");
									        sc.nextLine(); // Clear scanner buffer
									    }
											}
									
									if (option == 1) {
										System.out.println("");
										itemCategory.addToCart(item);
										itemCategory.showCartItems();
									} else if(option==2){
										System.out.println("");
										
										Calendar c = Calendar.getInstance();
										c.setTime(new Date());
										Date startDate= c.getTime();
										c.add(Calendar.DATE, 5); // Adding 5 days
										Date deliverDate = c.getTime();
										
										DeliveryTimeline timeLine=new DeliveryTimeline(startDate,deliverDate);	
										OrderDetails order=new OrderDetails(timeLine);								
										//order.addItems(itemCategory.cartItems);								
										order.addDeliveryDetails();
										itemCategory.placeOrder(item);
										order.addItems(itemCategory.cartItems);
										int orderId = order.placeOrder();
										order.showOrderItems();									
										//Review order
										order.customerFeedback();
										customerOrder.addOrderDetails(order);
										itemCategory.cartItems.clear();
									}
									else {
										System.out.println("Invalid option");
									}
								}						
							}
							if(!isValidItem) {
								System.out.println("\nItem is not available. ");
							}					
							break;
						case 4:
							customerOrder.showCustomerDetails();
							break;
						case 5:					
							System.out.println("Please enter your complaint");
							sc.next();
							String complaint=sc.nextLine();
							CustomerHelpline.resolveComplaint(complaint);
							System.out.println("Thank you for your complaint. We will look into it and get back to you shortly.\"");
							break;
						case 6:
							System.out.println("ThankYou!..Visit Again..Have a GoodDay..");
			                break;
						default:
							
							System.out.println("Invalid Choice");					
						}
					}
					
				}
				catch (InputMismatchException ae) {
					System.out.println(ae);
				}
			

			}

		

		// TODO Auto-generated method stub

	}


