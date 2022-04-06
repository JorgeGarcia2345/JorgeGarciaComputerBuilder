import java.security.cert.CertificateParsingException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        // TODO: Make a Computer object, using the default constructor
        // TODO: Make an array list of Computer objects to represent the shopping cart

        int option;
        double capacity, speed, price;
        String manufacturer, core, maxRes, type;

        Computer myComputer =  new Computer(); // mCPU = null, etc

        // Shopping Cart
        // List (interface) ---> ArrayList, LinkedList, allows for it to be versatile
        List<Computer> cart = new ArrayList<>();

        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print(printMenu());
            option = Integer.parseInt(keyboard.nextLine());
            switch (option) {
                case 1: // CPU
                    System.out.println("~~~CPU~~~");
                    System.out.print("Enter manufacturer: ");
                    manufacturer = keyboard.nextLine();
                    System.out.print("Enter core: ");
                    core = keyboard.nextLine();
                    System.out.print("Enter speed (GHz): ");
                    speed = Double.parseDouble(keyboard.nextLine());
                    System.out.print("Enter price $ ");
                    price = Double.parseDouble(keyboard.nextLine());
                    myComputer.new CPU(manufacturer, core, speed, price);
                    break;
                case 2: // RAM
                    System.out.println("~~~RAM~~~");
                    System.out.print("Enter manufacturer: ");
                    manufacturer = keyboard.nextLine();
                    System.out.print("Enter capacity (GB): ");
                    capacity = Double.parseDouble(keyboard.nextLine());
                    System.out.print("Enter speed (MHz): ");
                    speed = Double.parseDouble(keyboard.nextLine());
                    System.out.print("Enter price $ ");
                    price = Double.parseDouble(keyboard.nextLine());
                    myComputer.new RAM(manufacturer, capacity, speed, price);
                    break;
                case 3: // Storage
                    System.out.println("~~~Storage~~~");
                    System.out.print("Enter manufacturer: ");
                    manufacturer = keyboard.nextLine();
                    System.out.print("Enter capacity (TB): ");
                    capacity = Double.parseDouble(keyboard.nextLine());
                    System.out.print("Enter type: ");
                    type = keyboard.nextLine();
                    System.out.print("Enter price $ ");
                    price = Double.parseDouble(keyboard.nextLine());
                    myComputer.new Storage(manufacturer, type, capacity, price);
                    break;
                case 4: // Video Card
                    System.out.println("~~~Video Card~~~");
                    System.out.print("Enter manufacturer: ");
                    manufacturer = keyboard.nextLine();
                    System.out.print("Enter capacity: ");
                    capacity = Double.parseDouble(keyboard.nextLine());
                    keyboard.nextLine();
                    System.out.print("Enter maximum resolution: ");
                    maxRes = keyboard.nextLine();
                    System.out.print("Enter price $ ");
                    price = Double.parseDouble(keyboard.nextLine());
                    myComputer.new VideoCard(manufacturer, capacity, maxRes, price);
                    break;
                case 5: // Display Computer Configuration
                    System.out.println(myComputer);
                    break;
                case 6: // Add Computer to Shopping Cart
                    // Done: If any of the components (CPU, RAM, Storage or VideoCard) is null,
                    // Done: display error message.
                    // Done: Otherwise, add the Computer to the shopping cart (array list)

                    String errorMessage = "";

                    if (myComputer.getCPU() == null)
                        errorMessage += "Configure CPU before adding to cart\n";
                    if (myComputer.getRAM() == null)
                        errorMessage += "Configure RAM before adding to cart\n";
                    if (myComputer.getStorage() == null)
                        errorMessage += "Configure Storage before adding to cart\n";
                    if (myComputer.getVideoCard() == null)
                        errorMessage += "Configure VideoCard before adding to cart\n";

                    if(errorMessage.equalsIgnoreCase("")) {
                        cart.add(myComputer);
                        // reset myComputer by instantiating a new obj
                        myComputer = new Computer();
                        System.out.println("Computer added to cart successfully.");
                    }
                    else
                        System.err.println(errorMessage);
                    break;
                case 7: // Display Entire Shopping Cart
                    // TODO: If shopping cart is empty, please display the error message below,
                    // Otherwise, loop through the cart and print out each Computer object.
                    if(cart.isEmpty())
                    System.err.println("No computers added to cart...yet");
                    else
                        for (Computer c : cart)    // for Each Loop
                            System.out.println(c); // For each individual object (computer) in the cart
                    break;
                case 8: // Checkout
                    // TODO: If shopping cart is empty, please display the error message below,
                    if(cart.isEmpty())
                        System.err.println("No computers added to cart...yet");
                    else
                    // TODO: Otherwise, implement a method that calculates the entire cost of the order by summing the total cost of
                    // TODO: each Computer object in the shopping cart.
                    System.out.println("Please pay " + totalCost(cart) + " to checkout.");
                    System.out.println("Thanks for your business!  Happy Computing!");
                    break;
                default:
                    System.err.println("Enter valid option between 1-7.");
                    Thread.sleep(5);

            }
        } while (option != 8);

        keyboard.close();
    }

    // TODO: Implement a method named totalCost, which takes an ArrayList as its parameter, loops through each Computer object
    // TODO: and sums all prices of the computers in the shopping cart.

    public static double totalCost(List<Computer> array) {
        double cost = 0.00;
        for (Computer c : array)
            cost += c.calculateCost();
        return cost;
    }




    public static String printMenu()
    {
        return "\n********************************************************************\n"
                + "**                                                                **\n"
                + "**                  BUILD YOUR OWN COMPUTER!                      **\n"
                + "**                                                                **\n"
                + "********************************************************************\n"
                + "** Please select from the following options:                      **\n"
                + "** 1) Configure CPU                                               **\n"
                + "** 2) Configure RAM                                               **\n"
                + "** 3) Configure Storage                                           **\n"
                + "** 4) Configure Video Card                                        **\n"
                + "** 5) Display Computer Configuration                              **\n"
                + "** 6) Add Computer to Shopping Cart                               **\n"
                + "** 7) Display Entire Shopping Cart                                **\n"
                + "** 8) Checkout                                                    **\n"
                + "********************************************************************\n"
                + ">> ";
    }
}
