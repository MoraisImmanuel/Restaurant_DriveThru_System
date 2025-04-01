import java.util.*;

public class Drivethru {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        List<String> itemNames = new ArrayList<>();
        List<Double> costPrices = new ArrayList<>();
        boolean choice = true;
        double totalCost = 0.0;

        welcomePage();

        while (choice) {
            System.out.print("Enter item code (1-20): ");
            int itemCode = keybd.nextInt();

            if (itemCode < 1 || itemCode > 20) {
                System.out.println("Invalid item code. Please enter a code between 1 and 20.");
                continue;
            }

            System.out.print("Enter the number of items to be purchased: ");
            int numberOfItems = keybd.nextInt();
            if (numberOfItems <= 0) {
                System.out.println("Invalid quantity. Please enter a positive number.");
                continue;
            }

            double costPrice = selectedItem(itemCode, numberOfItems, itemNames, costPrices);
            totalCost += costPrice;

            printReceipt(itemNames, costPrices, totalCost);

            System.out.print("Do you want to add another item? (true/false): ");
            choice = keybd.nextBoolean();
        }

        double change = paymentPoint(totalCost, keybd);
        printFinalReceipt(itemNames, costPrices, totalCost, change);

        keybd.close();
    }

    public static void welcomePage() {
        System.out.println("<<<<<<<<WELCOME TO TWIN TURBO REBOOST>>>>>>>>>");
        System.out.println("***********************************************");
        System.out.println("                   Food");
        System.out.println("-----------------------------------------------");
        System.out.println("01 Chip roll - 15.50");
        System.out.println("02 Warm chips - 15.00");
        System.out.println("03 Pap n Vleis - 20.00");
        System.out.println("04 Fat cakes (with sauce) - 05.50");
        System.out.println("05 Chicken gizzards - 25.00");
        System.out.println("06 Steak chops - 30.50");
        System.out.println("07 Spaghetti - 14.00");
        System.out.println("08 Seasoned rice - 75.00");
        System.out.println("09 Fried banana - 50.00");
        System.out.println("10 Chimichurri sauce - 95.50");
        System.out.println(" ");
        System.out.println("                Refreshments");
        System.out.println("-----------------------------------------------");
        System.out.println("11 Java coffee - 09.60");
        System.out.println("12 Fruitree juice 150ml - 27.90");
        System.out.println("13 Summer punch - 19.95");
        System.out.println("14 Soft drinks 500ml - 16.98");
        System.out.println("15 Monster energy drink - 26.89");
        System.out.println("16 Water - 09.99");
        System.out.println("17 Cocktail - 35.90");
        System.out.println("18 Ice cream - 12.45");
        System.out.println("19 Wine (Red, White, Dry) - 45.00");
        System.out.println("20 Champagne - 64.50");
        System.out.println("**************************************************");
    }

    public static double selectedItem(int itemCode, int numberOfItems, List<String> itemNames, List<Double> costPrices) {
        String itemName = "";
        double pricePerItem = 0.0;

        switch (itemCode) {
            case 1 -> { itemName = "Chip roll"; pricePerItem = 15.50; }
            case 2 -> { itemName = "Warm chips"; pricePerItem = 15.00; }
            case 3 -> { itemName = "Pap n Vleis"; pricePerItem = 20.00; }
            case 4 -> { itemName = "Fat cakes (with sauce)"; pricePerItem = 5.50; }
            case 5 -> { itemName = "Chicken gizzards"; pricePerItem = 25.00; }
            case 6 -> { itemName = "Steak chops"; pricePerItem = 30.50; }
            case 7 -> { itemName = "Spaghetti"; pricePerItem = 14.00; }
            case 8 -> { itemName = "Seasoned rice"; pricePerItem = 75.00; }
            case 9 -> { itemName = "Fried banana"; pricePerItem = 50.00; }
            case 10 -> { itemName = "Chimichurri sauce"; pricePerItem = 95.50; }
            case 11 -> { itemName = "Java coffee"; pricePerItem = 9.60; }
            case 12 -> { itemName = "Fruitree juice 150ml"; pricePerItem = 27.90; }
            case 13 -> { itemName = "Summer punch"; pricePerItem = 19.95; }
            case 14 -> { itemName = "Soft drinks 500ml"; pricePerItem = 16.98; }
            case 15 -> { itemName = "Monster energy drink"; pricePerItem = 26.89; }
            case 16 -> { itemName = "Water"; pricePerItem = 9.99; }
            case 17 -> { itemName = "Cocktail"; pricePerItem = 35.90; }
            case 18 -> { itemName = "Ice cream"; pricePerItem = 12.45; }
            case 19 -> { itemName = "Wine"; pricePerItem = 45.00; }
            case 20 -> { itemName = "Champagne"; pricePerItem = 64.50; }
        }

        double costPrice = pricePerItem * numberOfItems;
        itemNames.add(itemName);
        costPrices.add(costPrice);

        return costPrice;
    }

    public static void printReceipt(List<String> itemNames, List<Double> costPrices, double totalCost) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("<<<<<<<<<<<<<<<<<<< Your current receipt is >>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < itemNames.size(); i++) {
            System.out.printf("Item Name: %s    Cost price: %.2f%n", itemNames.get(i), costPrices.get(i));
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        System.out.println("--------------------------------------------------------------");
    }

    public static double paymentPoint(double totalCost, Scanner keybd) {
        double cashDue;
        while (true) {
            System.out.print("Supply cash due: ");
            cashDue = keybd.nextDouble();
            if (cashDue >= totalCost) {
                break;
            }
            System.out.println("Insufficient cash. Please provide enough to cover the total cost.");
        }
        return cashDue - totalCost;
    }

    public static void printFinalReceipt(List<String> itemNames, List<Double> costPrices, double totalCost, double change) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("<<<<<<<<<<<<<<<<<<< Your final receipt is >>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < itemNames.size(); i++) {
            System.out.printf("Item Name: %s    Cost price: %.2f%n", itemNames.get(i), costPrices.get(i));
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        System.out.printf("Your change is: %.2f%n", change);
        System.out.println(new Date());
        System.out.println("--------------------------------------------------------------");
    }
}