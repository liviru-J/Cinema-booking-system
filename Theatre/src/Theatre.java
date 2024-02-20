import java.util.Scanner; // Import necessary classes.
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
public class Theatre {
    private static boolean greeting=true; // Create welcome message to display once.
    static int[] row1 = new int[12]; // Adding 3 arrays for row1, row2 and row3.
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];
    static ArrayList <Ticket>ticket_list=new ArrayList<>(); // Adding arraylist for store tickets.
    static Scanner input=new Scanner(System.in); // Create new object for scanner class.
    static String name,surname,email; // Create variables for store user inputs.
    static int row,seat;
     static double price;
    static int row_no,seat_no;
    public static void main(String[] args) {
        if(greeting){
            System.out.println(" ");
            System.out.println("Welcome to the New Theatre"); // Displaying welcome message.
            System.out.println(" ");
            greeting=false;
        }
        while(true) {
            try {
                System.out.println("""
                ----------------------------------------------------------------------------------

                Please select an option:
                   1) Buy a ticket
                   2) Print seating area
                   3) Cancel ticket
                   4) List available seats
                   5) Save to file
                   6) Load from file
                   7) Print ticket information and total price
                   8) Sort tickets by price
                           0) Quit
                -----------------------------------------------------------------------------------""");
                System.out.print("\nEnter option: ");
                int option = input.nextInt();
                System.out.println("-----------------------------------------------------------------------------------\n" +
                        " ");
                if(option>=0 && option<9) {
                    switch (option) {
                        case 0 -> {
                            System.out.println("Thank You For Join With Us..!");
                            System.exit(0);
                        }
                        case 1 -> buy_tickets();
                        case 2 -> print_seating_area();
                        case 3 -> cancel_ticket();
                        case 4 -> show_available();
                        case 5 -> save();
                        case 6 -> load();
                        case 7 -> show_tickets_info();
                        case 8 -> sort_tickets();
                    }
                }
                else {error_1();}
            }
            catch (Exception e) {
                error_1();
                input.next();
            }
        }
    }
    public static void buy_tickets() {
        Scanner input=new Scanner(System.in);
        while(true) {
            System.out.print("Enter Your Name    : ");
            name = input.nextLine();
            if (!name.matches("[a-zA-Z]+")) //Create validations for getting correct input from user for name.
            {error_2();}
            else {break;}
        }
        while(true) {
            System.out.print("Enter Your Surname : ");
            surname=input.nextLine();
            if(!surname.matches("[a-zA-Z]+")) //Create validations for getting correct input from user for surname.
            {error_2();}
            else {break;}
        }
        while(true) {
            System.out.print("Enter Your email   : ");
            email=input.nextLine();
            if(!email.matches("[a-z0-9.]+@[a-z.]+\\.[a-z]{2,}")) //Create validations for getting correct input from user for email.
            { System.out.println("""
                        ----------------------------------------------------------------------------------
                        Invalid Input!
                        (Input letters from "a-z", numbers from "0-9" and periods".")
                        ----------------------------------------------------------------------------------""");
            }
            else {break;}
        }
        while(true) {
            try {
                System.out.print("Enter your price   : ");
                price= input.nextDouble();
                break;
            }
            catch (Exception e){
                System.out.println("""
                        ----------------------------------------------------------------------------------
                        Invalid Input!
                        (Input integers for PRICE of ticket!)
                        ----------------------------------------------------------------------------------""");
                input.next();
            }
        }
        while(true) {
            try {
                System.out.print("Enter row number   : ");
                 row = input.nextInt();
                if(row>0 && row<4) {break;}
                else{
                    System.out.println("""
                            -----------------------------------------------------------------------------------
                            Invalid Input!
                            (please input integer number from 1-3!)
                            -----------------------------------------------------------------------------------""");
                }
            }
            catch (Exception e) {
                input.nextLine();
                error_3();}
        }
        while(true) {
            try {
                System.out.print("Enter seat number  : ");
                seat = input.nextInt();
                if(row==1){
                    if(seat>0 && seat<13){
                        if(row1[seat-1]==1) {error_4();}
                        else {
                            row1[seat - 1] = 1; // When ticket booked in row1, and it adds to the array.
                            seat_booking();
                        }
                    }
                    else{
                        System.out.println("""
                                -----------------------------------------------------------------------------------
                                Invalid Input!
                                (Please enter seat number from 1-12!)
                                -----------------------------------------------------------------------------------""");
                        continue;
                    }
                }
                else if(row==2){
                    if(seat>0 && seat<17){
                        if(row2[seat-1]==1) {error_4();}
                        else{
                            row2[seat-1]=1; // When ticket booked in row2, and it adds to the array.
                            seat_booking();
                        }
                    }
                    else{
                        System.out.println("""
                                -----------------------------------------------------------------------------------
                                Invalid Input!
                                (Please enter seat number from 1-16!)
                                -----------------------------------------------------------------------------------""");
                        continue;
                    }
                }
                else if(seat>0 && seat<21){
                    if(row3[seat-1]==1) {error_4();}
                    else{
                        row3[seat-1]=1; // When ticket booked in row3, and it adds to the array.
                        seat_booking();
                    }
                }
                else{
                    System.out.println("""
                                -----------------------------------------------------------------------------------
                                Invalid Input!
                                (Please enter seat number from 1-20!)
                                -----------------------------------------------------------------------------------""");
                    continue;
                }
            }
            catch (Exception e) {
                error_3();
                input.nextLine();
                continue;
            }
            break;
        }
    }
    static void print_seating_area(){
        System.out.println("""
                     ***********
                     *  STAGE  *
                     ***********
                """);
        for (int i=0;i<row1.length;i++) {
            if (i==0) {System.out.print("    "); }
            if (i==6) {System.out.print(" "); }
            if (row1[i]==0) {System.out.print("O"); }
            else {System.out.print("X"); }
        }
        System.out.println(" ");
        for (int j=0;j< row2.length;j++) {
            if (j==0) {System.out.print("  "); }
            if (j==8) {System.out.print(" "); }
            if (row2[j]==0) {System.out.print("O"); }
            else {System.out.print("X"); }
        }
        System.out.println(" ");
        for (int k=0;k< row3.length;k++) {
            if (k==10) {System.out.print(" "); }
            if (row3[k]==0) {System.out.print("O"); }
            else {System.out.print("X"); }
        }
        System.out.println(" ");
    }
    static void cancel_ticket(){
        while(true) {
            try {
                System.out.print("Enter row number: ");
                row_no = input.nextInt();
                if(row_no>0 && row_no<4) {break; }
                else{
                    System.out.println("""
                            -----------------------------------------------------------------------------------
                            Invalid Input!
                            (please input integer number from 1-3!)
                            -----------------------------------------------------------------------------------""");
                }
            }
            catch (Exception e) {error_5();}
        }
        while(true) {
            try {
                System.out.print("Enter seat number: ");
                seat_no = input.nextInt();
                if(row_no==1){
                    if(seat_no>0 && seat_no<13){
                        if(row1[seat_no-1]==1){
                            row1[seat_no-1]=0; // Removing cancelled ticket in row1 from array.
                            seat_cancelling();
                        }
                        else {error_6();}
                    }
                    else{
                        System.out.println("""
                                -----------------------------------------------------------------------------------
                                Invalid Input!
                                (Please enter seat number from 1-12!)
                                -----------------------------------------------------------------------------------""");
                        continue;
                    }
                }
                else if(row_no==2){
                    if(seat_no>0 && seat_no<17){
                        if(row2[seat_no-1]==1){
                            row2[seat_no-1]=0; // Removing cancelled ticket in row2 from array.
                            seat_cancelling();
                        }
                        else {error_6();}
                    }
                    else{
                        System.out.println("""
                                -----------------------------------------------------------------------------------
                                Invalid Input!
                                (Please enter seat number from 1-16!)
                                -----------------------------------------------------------------------------------""");
                        continue;
                    }
                }
                else if(seat_no>0 && seat_no<21){
                    if(row3[seat_no-1]==1){
                        row3[seat_no-1]=0; // Removing cancelled ticket in row3 from array.
                        seat_cancelling();
                    }
                    else {error_6();}
                }
                else{
                    System.out.println("""
                                -----------------------------------------------------------------------------------
                                Invalid Input!
                                (Please enter seat number from 1-20!)
                                -----------------------------------------------------------------------------------""");
                    continue;
                }
            }
            catch (Exception e) {
                error_5();
                continue;
            }
            break;
        }
    }
    static void show_available(){
        System.out.print("Seats available in row 1: ");
        for (int i=0;i< row1.length;i++) {
            if (row1[i]==0){
                System.out.print(i+1);          // Show available seats in row 1.
                if (i==row1.length-1) {
                    System.out.print(". ");
                }
                else {System.out.print(", "); }
            }
        }
        System.out.println(" ");
        System.out.print("Seats available in row 2: ");
        int count=0;
        for (int j=0;j< row2.length;j++) {
            if (row2[j]==0) {
                System.out.print(j+1);          // Show available seats in row 2.
                if (j==row2.length-1) {
                    System.out.print(". ");
                }
                else {System.out.print(", "); }
                if (count==12) {
                    System.out.print("\n");
                }
                count+=1;
            }
        }
        System.out.println(" ");
        System.out.print("Seats available in row 3: ");
        int count1=0;
        for (int k=0;k< row3.length;k++) {
            if (row3[k]==0) {
                System.out.print(k+1);           // Show available seats in row 3.
                if (k==row3.length-1) {
                    System.out.print(". ");
                }
                else {System.out.print(", "); }
                if (count1==12) {
                    System.out.print("\n");
                }
                count1+=1;
            }
        }
        System.out.println(" ");
    }
    static void save(){
        try {
            FileWriter arrays=new FileWriter("Arrays.txt");
            arrays.write("row1 : ");
            for (int i=0;i<row1.length;i++) {
                arrays.write(Integer.toString(row1[i])); // Save row1 information to file.
                if (i==row1.length-1) {
                    arrays.write(". ");
                }
                else {arrays.write(", "); }
            }
            arrays.write("\n");
            arrays.write("row2 : ");
            for (int j=0;j< row2.length;j++) {
                arrays.write(Integer.toString(row2[j])); // Save row2 information to file.
                if (j==row2.length-1) {
                    arrays.write(". ");
                }
                else {arrays.write(", "); }
            }
            arrays.write("\n");
            arrays.write("row3 : ");
            for (int k=0;k<row3.length;k++) {
                arrays.write(Integer.toString(row3[k])); // Save row3 information to file.
                if (k==row3.length-1) {
                    arrays.write(". ");
                }
                else {arrays.write(", "); }
            }
            System.out.println("Successfully SAVED to file!");
            arrays.close();
        }
        catch (IOException e) { System.out.println("ERROR occurred while writing to the file!"); }
    }
    static void load() {
        try {
            String[] string_row1 = new String[12];
            String[] string_row2 = new String[16];
            String[] string_row3 = new String[20];
            File array_file = new File("Arrays.txt");
            Scanner arrays = new Scanner(array_file);
            while (arrays.hasNextLine()) {
                String Data = arrays.nextLine();
                System.out.println(Data);                           // Load information in file.
                Data = Data.replaceAll("row1 : ", "").replaceAll("row2 : ", "").replaceAll("row3 : ", "").replace(".", "");
                String[] string_array = Data.split(", ");
                if (string_array.length == 12) {
                    string_row1 = string_array;
                } else if (string_array.length == 16) {
                    string_row2 = string_array;
                } else {
                    string_row3 = string_array;
                }
            }
            for (int p = 0; p < 12; p++) {
                row1[p] = Integer.parseInt(string_row1[p].trim()); // Re-store row1 (adding current information that saved to file to row1 and re-store the row information.)
            }
            for (int q = 0; q < 16; q++) {
                row2[q] = Integer.parseInt(string_row2[q].trim()); // Re-store row2 (adding current information that saved to file to row2 and re-store the row information.)
            }
            for (int r = 0; r < 20; r++) {
                row3[r] = Integer.parseInt(string_row3[r].trim()); // Re-store row3 (adding current information that saved to file to row3 and re-store the row information.)
            }
            arrays.close();
        }
        catch (IOException e) {
            System.out.println("ERROR occurred while reading the file!");
        }
    }
    static void show_tickets_info(){
        int k=1; int j; double a=0; double b;
        for (Ticket i: ticket_list) {
            System.out.println("-------------------------------------------");
            System.out.println("Ticket no."+k);
            System.out.println(" ");
            i.print();             // Show booked tickets.
            System.out.println("-------------------------------------------");
            k++;
        }
        for (j=0;j<ticket_list.size();j++) {
            b = ticket_list.get(j).price;
            a = a+b;
        }
        System.out.println(" ");
        System.out.println("Total Price : £"+a); // Show total price for booked tickets.
    }
    static void sort_tickets(){
        ArrayList<Ticket> sort_list = new ArrayList<>(ticket_list);
        for (int i=0;i<sort_list.size();i++){
            for (int j=i+1;j<sort_list.size();j++){
                if (sort_list.get(i).getPrice()>sort_list.get(j).getPrice()){
                    Ticket tempo=sort_list.get(i);
                    sort_list.set(i, sort_list.get(j));
                    sort_list.set(j, tempo);
                }
            }
        }
        int o=1; int j; double a=0; double b;
        for (Ticket T : sort_list) {
            System.out.println("-------------------------------------------");
            System.out.println("Ticket no."+o);
            System.out.println(" ");
            T.print();             // Show sorted booked tickets.
            System.out.println("-------------------------------------------");
            o++;
        }
        for (j=0;j<sort_list.size();j++) {
            b = sort_list.get(j).price;
            a = a+b;
        }
        System.out.println(" ");
        System.out.println("Total Price : £"+a); // Show total price for booked tickets.
    }
    // User defined methods.
    static void error_1(){System.out.println("""
                            -----------------------------------------------------------------------------------
                            Invalid Input!
                            (please input integer number from 1-8!)
                            """);}
    static void error_2(){System.out.println("""
                        ----------------------------------------------------------------------------------
                        Invalid Input!
                        (Input letters from "a-z" or "A-Z")
                        ----------------------------------------------------------------------------------""");}
    static void error_3(){System.out.println("""
                            -----------------------------------------------------------------------------------
                            Invalid Input!
                            (Please enter VALID number!)
                            -----------------------------------------------------------------------------------""");
        }
    static void error_4(){System.out.println("---------------------------------------------------------------------------------\n" +
            "This seat seems BOOKED.please take look to the MENU for OPTIONS!");}
    static void error_5(){System.out.println("""
                            -----------------------------------------------------------------------------------
                            Invalid Input!
                            (Please enter VALID number!)
                            -----------------------------------------------------------------------------------""");
        input.next();}
    static void error_6(){System.out.println("----------------------------------------------------------------------------------\n" +
            "This seat is NOT booked!.It's AVAILABLE yet!");}
    static void seat_booking(){
        Person person=new Person(name,surname,email);
        Ticket ticket=new Ticket(row,seat,price,person);
        ticket_list.add(ticket);
        System.out.println("----------------------------------------------------------------------------------\n" +
                "Seat BOOKED Successfully!");}
    static void seat_cancelling(){System.out.println("----------------------------------------------------------------------------------\n" +
            "successfully CANCELLED the BOOKED ticket!");
        for(int i=0;i<ticket_list.size();i++){
            if(seat_no==ticket_list.get(i).seat){
                ticket_list.remove(i);
            }
        }}
}
