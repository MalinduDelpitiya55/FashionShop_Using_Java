import java.util.*;

/**
 * Fashion Shop Management System
 *  * @author Malindu Delpitiya
 */
class Customer {

    private String Orders;
    private String phoneNumbers;
    private String sizes;
    private int qtys;
    private double amounts;
    private String statuss;

    public Customer(String id, String phoneNumber, String size, int qty, double amount, String status) {
        this.Orders = id;
        this.phoneNumbers = phoneNumber;
        this.sizes = size;
        this.qtys = qty;
        this.amounts = amount;
        this.statuss = status;
    }

    public String getID() {
        return Orders;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getSizes() {
        return sizes;
    }

    public int getQtys() {
        return qtys;
    }

    public double getAmounts() {
        return amounts;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String status) {
        this.statuss = status;
    }

    public void showOrderDetails(int i) {
        System.out.print("\n\tPhone Number : " + Orders);
        System.out.print("\n\tSize         : " + sizes);
        System.out.print("\n\tQTY          : " + qtys);
        System.out.print("\n\tAmount       : " + amounts);
        System.out.print("\n\tStatus       : " + statuss);
    }

}

public class Fashion_Shop {

    static Scanner input = new Scanner(System.in);
    static int id = 0;
    static Customer[] customers = new Customer[0];
    static String sizeChart[] = {"XS", "S", "M", "L", "XL", "XXL"};
    static final int XS = 600;
    static final int S = 800;
    static final int M = 900;
    static final int L = 1000;
    static final int XL = 1100;
    static final int XXL = 1200;
    static final String[] finalStatus = {"Processing", "Delivering", "Delivered"};

    public static void main(String[] args) {
        homepage();
    }

    public static void homepage() {
        clearConsole();
        System.out.println("\t    /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$");
        System.out.println("\t   | $$_____/                | $$      |__/                           /$$__  $$| $$");
        System.out.println("\t   | $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$");
        System.out.println("\t   | $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
        System.out.println("\t   | $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
        System.out.println("\t   | $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
        System.out.println("\t   | $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
        System.out.println("\t   |__/  \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ |_______/");
        System.out.println("                                                                                                           | $$");
        System.out.println("                                                                                                           | $$");
        System.out.println("                                                                                                           |__/");

        System.out.printf("\n\t\t%-30s%-30s\n\n\t\t%-30s%-30s\n\n\t\t%-30s%-30s\n", "[1]Place Order", "[2]Search Customer", "[3]Search Order", "[4]View Reports", "[5]Set Order Status", "[6]Delete Order");
        char option;
        do {
            System.out.print("\n\n\t\tInput Option: ");
            option = input.next().charAt(0);
            if (option == '1' || option == '2' || option == '3' || option == '4' || option == '5' || option == '6') {
                break;
            } else {
                System.out.print("\n\t\tInvalid Input...!\n\t\tPlease Enter valid option: ");
            }
        } while (true);

        switch (option) {
            case '1':
                placeOrder();
                break;
            case '2':
                searchCustomer();
                break;
            case '3':
                searchOrder();
                break;
            case '4':
                viewReports();
                break;
            case '5':
                setOrderStatus();
                break;
            case '6':
                deleteOrder();
                break;
        }
    }

    public static void placeOrder() {
        clearConsole();
        System.out.println("\t\t _____  _                        ____          _");
        System.out.println("\t\t|  __ \\| |                      / __ \\        | |");
        System.out.println("\t\t| |__) | | __ _  ____ ____     | |  | |_ __ __| | ____ _ __");
        System.out.println("\t\t|  ___/| |/ _` |/ __/  _  \\    | |  | | '__/ _` |/  _ \\ '__|");
        System.out.println("\t\t| |    | | (_| | (_|    __/    | |__| | | | (_| |   __/ |");
        System.out.println("\t\t|_|    |_|\\__,_|\\___\\_____|     \\____/|_|  \\__,_|\\____|_|");
        System.out.println("\t\t___________________________________________________________\n");

        String phoneNumber, size = "", sizeInput;
        id++;
        String formatLength = String.format("%05d", id);
        String oderID = "ODR#" + formatLength;
        System.out.print("\n\tEnter Order Id: " + oderID);
        boolean isValid = true;
        System.out.print("\n\n\tEnter Customer Phone Number: ");

        phoneNumber = input.next();
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0') {
            isValid = false;
        } else {
            System.out.println("\n\t\tInvalid Phone Number.. Try Again");
            System.out.print("\n\tDo you want to enter phone number again? (Y/N): ");
            char op = input.next().charAt(0);
            if (op == 'N' || op == 'n') {
                id--;
                homepage();
            } else if (op == 'Y' || op == 'y') {
                id--;
                placeOrder();
            }
        }
        isValid = true;
        while (isValid) {
            System.out.print("\n\tEnter T-Shirt Size (XS/S/M/L/XL/XXL): ");
            sizeInput = input.next();
            size = sizeInput.toUpperCase();
            if (size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL") || size.equals("XXL")) {
                isValid = false;
                break;
            }
            clearLinesAbove(2);
        }
        int QTY = 0;
        isValid = true;
        while (isValid) {
            System.out.print("\n\tEnter QTY: ");
            QTY = input.nextInt();
            if (QTY > 0) {
                isValid = false;
                break;
            }
            clearLinesAbove(2);
        }

        double total;
        switch (size.toUpperCase()) {
            case "XS":
                total = QTY * XS;
                break;
            case "S":
                total = QTY * S;
                break;
            case "M":
                total = QTY * M;
                break;
            case "L":
                total = QTY * L;
                break;
            case "XL":
                total = QTY * XL;
                break;
            case "XXL":
                total = QTY * XXL;
                break;
            default:
                throw new AssertionError();
        }
        System.out.printf("\n\t%s%.2f", "Amount: ", total);

        System.out.print("\n\n\tDo you want to place this order? (Y/N): ");
        char option = input.next().charAt(0);

        if (option == 'Y' || option == 'y') {
            customers = extendCustomerArray(customers);
            customers[customers.length - 1] = new Customer(oderID, phoneNumber, size, QTY, total, finalStatus[0]);
            System.out.println("\n\t\tOrder Placed..!");

        } else {
            id--;
        }

        System.out.print("\n\tDo you want to place another order? (Y/N): ");
        option = input.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            placeOrder();
        } else if (option == 'N' || option == 'n') {
            homepage();
        }
    }

    public static void searchCustomer() {
        clearConsole();
        System.out.println("\t\t   _____                     _           ____           _   ");
        System.out.println("\t\t  / ____|                   | |         / ___|         | |   ");
        System.out.println("\t\t | (___   ___  __ _ _ __ ___| |_       | |    _   _ ___| |_ ___  _ __ __    ___ _ __");
        System.out.println("\t\t  \\___ \\ / _ \\/ _' | '__/ __| '_ \\     | |   | | | /  _| __/ _ \\| '_ ' _ \\ / _ \\ '__|");
        System.out.println("\t\t  ____) |  __/ (_| | | | (__| | | |    | |___| |_| \\__ \\ || (_) | | | | | |  __/ |        ");
        System.out.println("\t\t |_____/ \\___|\\__,_|_|  \\___|_| |_|     \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_| ");
        System.out.println("\t\t_____________________________________________________________________________________________");

        int qty[] = new int[6];
        double total[] = new double[6];
        String tempsize[] = new String[sizeChart.length];
        double totalAmount = 0;
        
        for (int i = 0; i < sizeChart.length; i++) {
            tempsize[i] = sizeChart[i];
        }
        System.out.print("\n\n\tEnter Customer Phone Number: ");
        String phoneNumber = input.next();
        boolean isValidNumber = false;
        for (int i = 0; i < customers.length; i++) {
            if (phoneNumber.equalsIgnoreCase(customers[i].getPhoneNumbers())) {
                isValidNumber = true;
                switch (customers[i].getSizes()) {
                    case "XS":
                        qty[0] += customers[i].getQtys();
                        total[0] += customers[i].getAmounts();
                        totalAmount += customers[i].getAmounts();
                        break;
                    case "S":
                        qty[1] += customers[i].getQtys();
                        total[1] += customers[i].getAmounts();
                        totalAmount += customers[i].getAmounts();
                        break;
                    case "M":
                        qty[2] += customers[i].getQtys();
                        total[2] += customers[i].getAmounts();
                        totalAmount += customers[i].getAmounts();
                        break;
                    case "L":
                        qty[3] += customers[i].getQtys();
                        total[3] += customers[i].getAmounts();
                        totalAmount += customers[i].getAmounts();
                        break;
                    case "XL":
                        qty[4] += customers[i].getQtys();
                        total[4] += customers[i].getAmounts();
                        totalAmount += customers[i].getAmounts();
                        break;
                    case "XXL":
                        qty[5] += customers[i].getQtys();
                        total[5] += customers[i].getAmounts();
                        ;
                        totalAmount += customers[i].getAmounts();
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
        if (isValidNumber) {
            for (int i = 0; i < total.length - 1; i++) {
                for (int j = i; j < total.length; j++) {
                    if (total[i] < total[j]) {
                        double temp = total[i];
                        total[i] = total[j];
                        total[j] = temp;

                        int temp1 = qty[i];
                        qty[i] = qty[j];
                        qty[j] = temp1;

                        String temp2 = tempsize[i];
                        tempsize[i] = tempsize[j];
                        tempsize[j] = temp2;
                    }
                }
            }
            System.out.printf("\t\t+%-7s+%-6s+%-15s+\n", "-------", "------", "---------------");
            System.out.printf("\t\t|%-7s|%-6s|%-15s|\n", " size", "  QTY", "      Total");
            System.out.printf("\t\t+%-7s+%-6s+%-15s+\n", "-------", "------", "---------------");

            for (int i = 0; i < total.length; i++) {
                System.out.printf("\t\t|  %-5s|  %-4d|%13.2f  |\n", tempsize[i], qty[i], total[i]);
            }

            System.out.printf("\t\t+%-7s+%-6s+%-15s+\n", "-------", "------", "---------------");
            System.out.printf("\t\t| %-10s |%13.2f  |\n", "Total Amount", totalAmount);
            System.out.printf("\t\t+%-7s+%-6s+%-15s+\n", "-------", "------", "---------------");
        } else {
            System.out.println("\n\t\tInvalid input..");
        }
        System.out.print("\n\n\tDo you want search another customer report? (Y/N): ");
        char option = input.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            searchCustomer();
        } else if (option == 'N' || option == 'n') {
            homepage();
        }
    }

    public static void searchOrder() {
        clearConsole();
        System.out.println("\t\t   _____                     _          ____          _                          ");
        System.out.println("\t\t  / ____|                   | |        / __ \\        | |                         ");
        System.out.println("\t\t | (___   ___  __ _ _ __ ___| |_      | |  | |_ __ __| | ____ _ __               ");
        System.out.println("\t\t  \\___ \\ / _ \\/ _' | '__/ __| '_ \\    | |  | | '__/ _' |/  _ \\ '__|              ");
        System.out.println("\t\t  ____) |  __/ (_| | | | (__| | | |   | |__| | | | (_| |   __/ |                 ");
        System.out.println("\t\t |_____/ \\___|\\__,_|_|  \\___|_| |_|    \\____/|_|  \\__,_|\\____|_|                 ");
        System.out.println("\t\t__________________________________________________________________    ");

        System.out.print("\n\n\tEnter order ID : ");
        String orderID = input.next();
        boolean isValidNumber = false;
        for (int i = 0; i < customers.length; i++) {
            if (orderID.equals(customers[i].getID())) {
                customers[i].showOrderDetails(i);
                isValidNumber = true;
                break;
            }
        }
        if (!isValidNumber) {
            System.out.print("\n\t\tInvalid ID..");
        }
        System.out.print("\n\n\tDo you want to search another order? (Y/N) : ");
        char option = input.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            searchOrder();
        } else if (option == 'N' || option == 'n') {
            homepage();
        }
    }

    private static void viewReports() {
        clearConsole();
        System.out.println("\t\t     _____                        _       ");
        System.out.println("\t\t    |  __ \\                      | |   ");
        System.out.println("\t\t    | |__) |___  _ __   ___  _ __| |_ ___ ");
        System.out.println("\t\t    |  _  // _  \\ '_ \\ / _ \\| '__|  _/ __| ");
        System.out.println("\t\t    | | \\ \\   __/ |_) | (_) | |  | |_\\__ \\ ");
        System.out.println("\t\t    |_|  \\_\\____| .__/ \\___/|_|   \\__|___/");
        System.out.println("\t\t                | |    ");
        System.out.println("\t\t                |_|");
        System.out.println("\t\t  __________________________________________");

        System.out.printf("\n\n\t\t[1] Best in Customers \n\n\t\t[2] All Orders \n\n\tEnter option : ");
        int op = input.nextInt();
        switch (op) {
            case 1:
                bestInCostomers();
                break;
            case 2:
                AllOrders();
                break;
            default:
                System.out.println("Try Again");
        }
    }

    public static void bestInCostomers() {
        clearConsole();
        System.out.println("\t ____            _      _____             ____           _                                          ");
        System.out.println("\t|  _ \\          | |    |_   _|           / ___|         | |                                        ");
        System.out.println("\t| (_| | ___  ___| |_     | |  _ __      | |    _   _ ___| |_ ___  _ __ __    ___ _ __ ___          ");
        System.out.println("\t|  _ < / _ \\/ __|  _|    | | | '_  \\    | |   | | | /  _| __/ _ \\| '_ ' _ \\ / _ \\ '__/ __|      ");
        System.out.println("\t| (_| |  __/\\__ \\ |_    _| |_| | | |    | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\     ");
        System.out.println("\t|____/ \\___||___/\\__|  |_____|_| |_|     \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/     ");
        System.out.println("\t________________________________________________________________________________________________\n");
        String phone[] = new String[0];
        int qty[] = new int[0];
        double total[] = new double[0];

        System.out.printf("\n\t\t\t+%-15s+%-7s+%-15s+\n", "---------------", "-------", "---------------");
        System.out.printf("\t\t\t|%-15s|%-7s|%-15s|\n", "Customer ID", "All QTY", "Total Amount");
        System.out.printf("\t\t\t+%-15s+%-7s+%-15s+\n", "---------------", "-------", "---------------");
        l1:
        for (int i = 0; i < customers.length; i++) {
            for (int j = 0; j < phone.length; j++) {
                if (customers[i].getPhoneNumbers().equalsIgnoreCase(phone[j])) {
                    qty[j] += customers[i].getQtys();
                    total[j] += customers[i].getAmounts();
                    continue l1;
                }
            }
            phone = extendStringArrays(phone);
            qty = extendIntArrays(qty);
            total = extendDoubleArrays(total);
            phone[phone.length - 1] = customers[i].getPhoneNumbers();
            qty[qty.length - 1] = customers[i].getQtys();
            total[total.length - 1] = customers[i].getAmounts();
        }
        for (int i = 0; i < qty.length - 1; i++) {
            for (int j = i + 1; j < qty.length; j++) {
                if (qty[i] < qty[j]) {
                    double temp = total[i];
                    total[i] = total[j];
                    total[j] = temp;

                    int temp1 = qty[i];
                    qty[i] = qty[j];
                    qty[j] = temp1;

                    String temp2 = phone[i];
                    phone[i] = phone[j];
                    phone[j] = temp2;
                }
            }
        }
        for (int i = 0; i < phone.length; i++) {
            System.out.printf("\t\t\t|%-15s|%-7d|%-15s|\n", phone[i], qty[i], total[i]);
        }
        System.out.printf("\t\t\t+%-15s+%-7s+%-15s+\n", "---------------", "-------", "---------------");
        while (true) {
            System.out.print("\n\n\tTo access the Main, please enter 0 : ");
            char op = input.next().charAt(0);
            if (op == '0') {
                homepage();
                break;
            }
            clearLinesAbove(3);
        }

    }

    public static void AllOrders() {
        clearConsole();
        System.out.println("\t\t  _        __                       ____          _                          ");
        System.out.println("\t\t  \\ \\    / (_)                     / __ \\        | |                         ");
        System.out.println("\t\t   \\ \\  / / _  _____        __    | |  | |_ __ __| | ____ _ __               ");
        System.out.println("\t\t    \\ \\/ / | |/ _ \\ \\  /\\  / /    | |  | | '__/ _' |/  _ \\ '__|              ");
        System.out.println("\t\t     \\  /  | |  __/\\ \\/  \\/ /     | |__| | | | (_| |   __/ |                 ");
        System.out.println("\t\t      \\/   |_|\\___| \\__/\\__/       \\____/|_|  \\__,_|\\____|_|                 ");
        System.out.println("\t\t________________________________________________________________________");
        System.out.printf("\n\n\t\t+%-12s+%-13s+%-7s+%-7s+%-13s+%-15s+\n", "------------", "---------------", "-------", "-------", "--------------", "---------------");
        System.out.printf("\t\t|  %-10s| %-14s| %-6s|  %-5s|   %-11s| %-14s|\n", "Order ID", "Phone Number", "Size", "QTY", " Amount", "    Status");
        System.out.printf("\t\t+%-12s+%-13s+%-7s+%-7s+%-13s+%-15s+\n", "------------", "---------------", "-------", "-------", "--------------", "---------------");

        
        for (int i = customers.length-1; i >=0; i--) {
            System.out.printf("\t\t|  %-10s| %-14s|  %-5s|  %-5s|   %-11.2f| %-14s|\n", customers[i].getID(), customers[i].getPhoneNumbers(), customers[i].getSizes(), customers[i].getQtys(), customers[i].getAmounts(), customers[i].getStatuss());
        }
        System.out.printf("\t\t+%-12s+%-13s+%-7s+%-7s+%-13s+%-15s+\n", "------------", "---------------", "-------", "-------", "--------------", "---------------");
        while (true) {
            System.out.print("\n\n\tTo access the Main, please enter 0 : ");
            char op = input.next().charAt(0);
            if (op == '0') {
                homepage();
                break;
            }
            clearLinesAbove(3);
        }
    }

    public static void setOrderStatus() {
        clearConsole();
        System.out.println("\t\t      ___           _                   ______ _        _                         ");
        System.out.println("\t\t    / __ \\        | |                 / _____| |      | |                        ");
        System.out.println("\t\t   | |  | |_ __ __| | ____ _ __      | (____ | |_ __ _| |_ _   _ ____                         ");
        System.out.println("\t\t   | |  | | '__/ _' |/  _ \\ '__|      \\___  \\| __/ _` |  _| | | / ___|                  ");
        System.out.println("\t\t   | |__| | | | (_| |   __/ |         ____)  | || (_| | |_| |_| \\___ \\                  ");
        System.out.println("\t\t    \\____/|_|  \\__,_|\\____|_|        |______/ \\__\\__,_|\\__|\\__,_|____/                        ");
        System.out.println("\t\t________________________________________________________________________\n\n");
        System.out.print("\t\tEnter order ID : ");
        String searchId = input.next();
        boolean isvalid = false;
        for (int i = 0; i < customers.length; i++) {
            if (searchId.equalsIgnoreCase(customers[i].getID())) {
                customers[i].showOrderDetails(i);
                isvalid = true;
                System.out.print("\n\n\tDo you want to change this status? (y/n) : ");
                char op = input.next().charAt(0);
                if (op == 'y' || op == 'Y') {
                    if (customers[i].getStatuss().equalsIgnoreCase("Processing")) {
                        System.out.printf("\n\t\t[1]  Order Delivering  \n\t\t[2] Order Delivered ");
                        int option = 1;
                        System.out.println("");
                        do {
                            System.out.print("\n\tEnter option : ");
                            option = input.nextInt();
                            if (option == 1 || option == 2) {
                                break;
                            }
                            System.out.println("\n\t\tInvalid Input..");
                        } while (true);
                        switch (option) {
                            case 1:
                                customers[i].setStatuss(finalStatus[1]);
                                System.out.println("\n\t\tStatus Updated..!");
                                break;
                            case 2:
                                customers[i].setStatuss(finalStatus[2]);
                                System.out.println("\n\t\tStatus Updated..!");
                                break;
                        }

                    } else if (customers[i].getStatuss().equalsIgnoreCase("Delivering")) {
                        System.out.printf(" \n\t\t[1] Order Delivered ");
                        int option = 1;
                        do {
                            System.out.print("\n\n\tEnter option : ");
                            option = input.nextInt();
                            if (option == 1) {
                                break;
                            }
                            System.out.println("\n\t\tInvalid Input..");
                        } while (true);
                        if (option == 1) {
                            customers[i].setStatuss(finalStatus[2]);
                            System.out.println("\n\t\tStatus Updated..!");
                            break;
                        }

                    } else {
                        System.out.println("\n\t\tCan't change this order status, Order already delivered...!!");
                        break;
                    }
                }
                break;
            }
        }
        if (!isvalid) {
            System.out.println("\n\t\tInvalid ID..");
        }
        System.out.print("\n\tDo you want to change another Order status? (y/n)  : ");
        char op = input.next().charAt(0);
        if (op == 'y' || op == 'Y') {
            setOrderStatus();
        } else {
            homepage();
        }
    }

    public static void deleteOrder() {
        clearConsole();
        System.out.println("\t\t ______       _      _            ____          _                          ");
        System.out.println("\t\t|  __  \\     | |    | |          / __ \\        | |                         ");
        System.out.println("\t\t| |  |  | ___| | ___| |_ ___    | |  | |_ __ __| | ____ _ __               ");
        System.out.println("\t\t| |  |  |/ _ \\ |/ _ \\ __/ _ \\   | |  | | '__/ _' |/  _ \\ '__|              ");
        System.out.println("\t\t| |__|  |  __/ |  __/ ||  __/   | |__| | | | (_| |   __/ |                 ");
        System.out.println("\t\t|______/ \\___|_|\\___|\\__\\___|    \\____/|_|  \\__,_|\\____|_|                 ");
        System.out.println("\t\t_______________________________________________________________");
        System.out.print("\n\n\t\tEnter order ID : ");
        String searchId = input.next();
        Customer[] temp = new Customer[customers.length - 1];
        boolean isValid = false;
        for (int i = 0; i < customers.length; i++) {

            if (searchId.equalsIgnoreCase(customers[i].getID())) {
                customers[i].showOrderDetails(i);
                System.out.print("\n\n\tDo you want to delete this order? (y/n) : ");
                char op = input.next().charAt(0);
                if (op == 'y' || op == 'Y') {
                    for (int j = i; j < customers.length - 1; j++) {
                        temp[j] = customers[j + 1];
                    }
                    customers = temp;
                }

                isValid = true;
                break;
            } else if (i < customers.length - 1) {
                temp[i] = customers[i];
            }
        }
        
        
        
        
        
        
        if (!isValid) {
            System.out.println("\n\t\tInvalid ID..");
        }
        System.out.print("\n\n\tDo you want to delete another order? (Y/N) : ");
        char option = input.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            deleteOrder();
        } else if (option == 'N' || option == 'n') {
            homepage();
        }

    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    private static void clearLinesAbove(int numLines) {
        for (int i = 0; i < numLines; i++) {
            System.out.print("\033[1F\033[2K"); // Move cursor up one line and clear line
        }
    }

    public static Customer[] extendCustomerArray(Customer[] arr) {
        Customer temp[] = new Customer[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public static String[] extendStringArrays(String[] arr) {
        String temp[] = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public static int[] extendIntArrays(int[] arr) {
        int temp[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public static double[] extendDoubleArrays(double[] arr) {
        double temp[] = new double[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

}
