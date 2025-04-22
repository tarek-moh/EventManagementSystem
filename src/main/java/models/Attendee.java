package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Attendee extends User
{
    Scanner input = new Scanner(System.in);

    private static int attendeeCount = 0;
    private String address;
    private Gender gender;
    private Wallet wallet;
    private ArrayList<myCategory> interestList;
    private ArrayList<Ticket> ticketList;

    public Attendee() {    super();     } // no-arg-constructor

    // parameterized constructor
    public Attendee(String userName, String password, LocalDate dateOfBirth, String address, Gender gender) 
    {
        super(userName, password, dateOfBirth);
        this.ID = 10000 + attendeeCount;
        this.address = address;
        this.gender = gender;
         this.wallet = new Wallet();
         this.ticketList = new ArrayList<Ticket>();
         this.interestList = new ArrayList<myCategory>();
        attendeeCount++;
    }

    @Override
    public void showDashboard() 
    {
        while (true)  
        {  
            System.out.println("========================================");
            System.out.println("Dashboard");
            System.out.println("========================================");
            System.out.println("1: View Events\n2: View my tickets \n3: Buy ticket\n4: My wallet");
            System.out.println("5: Check Profile\n6: Interests\n7: Logout");

            short choice;
            while (true) 
            {
                if (input.hasNextShort()) 
                {
                    choice = input.nextShort();
                
                    if (choice == 1){    // viewEvents   
                    }

                    else if (choice == 2)  {    // viewMyTickets    
                    }

                    else if (choice == 3){    
                        // buyTicket
                    }

                    else if (choice == 4)
                    {
                        // System.out.println(wallet.getBalnce());  
                        System.out.println("Current balance");
                        System.out.println("1: Add money     2: Withdraw money     3: Exit");
                        while (true) 
                            {
                                if (input.hasNextShort()) 
                                {
                                    short inchoice = input.nextShort();
                                
                                    if (inchoice == 1 ) 
                                    {
                                        System.out.println("Enter amouunt: ");
                                        int amount = input.nextInt();
                                        // updateWallet(amount, inchoice);
                                        break; 
                                    } 

                                    else if (inchoice == 2) 
                                    {
                                        System.out.println("Enter amouunt: ");
                                        int amount = input.nextInt();
                                        // updateWallet(amount, inchoice);
                                        break;
                                    }
                                    
                                    else if (inchoice == 3) {    break;    }
                                    
                                    else 
                                    {
                                        System.out.println("Invalid input! Please choose between 1 and 3:");
                                    }
                                } 
                                
                                else 
                                {
                                    System.out.println("Invalid input! Please choose between 1 and 3:");
                                    input.next(); // Clear the invalid input
                                }
                            }
                    }

                    else if (choice == 5)
                    {
                        short profchoice ;
                        while (true)
                        {
                            System.out.println("========================================");
                            System.out.println("Profile");
                            System.out.println("========================================");
                            System.out.println("Username            1: Change Username\n" + getUserName());
                            System.out.println("Password            2: change Password\n" + getPassword());
                            System.out.println("Date of birth       3: Change date of birth\n" + getDateOfBirth());
                            System.out.println("models.Gender              4: Change models.Gender\n" + getGender());
                            System.out.println("Address             5: Change address\n" + getAddress());
                            System.out.println("ID                  6: Exit Profile\n" + getId());

                            while (true) // check if choice is an integer (1-5)
                            {
                                if (input.hasNextShort()) 
                                {
                                    profchoice = input.nextShort();
                                
                                    if (profchoice == 1 ) 
                                    {
                                        System.out.println("Enter your new username ");
                                        // check if username is taken
                                        String newName = input.next();
                                        setUserName(newName);    
                                        break; 
                                    } 

                                    else if (profchoice == 2) 
                                    {
                                        System.out.println("Enter your new password ");
                                        String newPass = input.next();
                                        setPassword(newPass);
                                        break;
                                    } 

                                    else if (profchoice == 3) 
                                    {
                                        {
                                            System.out.println("Enter year of birth (e.g., 2000): ");
                                            int year = input.nextInt();
                                            while (year < 1 || year > 2024)
                                            {
                                                System.out.println("Invalid Year! Try again");
                                                year = input.nextInt();
                                            }
                                            System.out.println("Enter month of birth (1-12): ");
                                            int month = input.nextInt();
                                            while (month < 1 || month > 12)
                                            {
                                                System.out.println("Invalid Month! Try again(1-12)");
                                                month = input.nextInt();
                                            }
                                            System.out.println("Enter day of birth (1-31): ");
                                            int day = input.nextInt();
                                            while (day < 1 || day > 31)
                                            {
                                                System.out.println("Invalid Day! Try again(1-31)");
                                                day = input.nextInt();
                                            }
                                            setDateOfBirth(year,month,day);
                                        }
                                        break; 
                                    }

                                    else if (profchoice == 4) 
                                    { 
                                        {    
                                            System.out.println("Select your gender(Enter 1 or 2):\n1.Male\n2.Female");
                                            short select;
                                            while (true) // check if gender is an integer (1-2)
                                            {
                                                if (input.hasNextShort()) 
                                                {
                                                    select = input.nextShort();    
                                                    if (select == 1 || select == 2) 
                                                    {
                                                        setGender(select);
                                                        break; // Valid choice, exit the loop
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Invalid input! Please choose 1 or 2");
                                                    }
                                                }
                                            }    
                                        }
                                        break; 
                                    }

                                    else if (profchoice == 5) 
                                    { 
                                        System.out.println("Enter your new address");
                                        String newAdd = input.next();
                                        setAddress(newAdd);
                                        break; 
                                    }

                                    else if (profchoice == 6)  {    break;   }
                                    
                                    else 
                                    {
                                        System.out.println("Invalid input! Please choose between 1 and 6:");
                                    }
                                } 
                                
                                else 
                                {
                                    System.out.println("Invalid input! Please choose between 1 and 6:");
                                    input.next(); // Clear the invalid input
                                }
                            }
                        }
                    }
                    
                    else if (choice == 6) // show interests and option to change interests and exit 
                    {}
                    
                    else if (choice == 7) {    break;    } 
                    
                    else {    System.out.print("Invalid input! Please choose between 1 and 7: ");    }
                } 
                
                else 
                {
                    System.out.print("Invalid input! Please choose between 1 and 7: ");
                    input.next(); // Clear the invalid input
                }
            }
        } 
    }

    public boolean buyTicket(Event e){
        if (e.isAvailable()){
            managers.PaymentService.transferFunds(wallet, e.getOrganizer().getWallet(), e.getTicketPrice());
            Ticket ticket = e.generateTicket();
            ticketList.add(ticket);
            e.addAttendee(this);
            return true;
        }
        else{
            return false;
        }
    }
    public void viewMyTickets()
    {
        System.out.println("Viewing my tickets...");
        for(Ticket ticket : ticketList)
        {
            System.out.println(ticket.showTicketDetsils());
        }
    }

    public void updateWallet(double amount, short choice)
    {
        if (choice == 1) {    wallet.addFunds(amount);    }
        else if (choice == 2) {    wallet.deductFunds(amount);    }
    }

    public String getAddress() {     return this.address;      }

    public void setAddress(String newAddress) 
    {
        this.address = newAddress;
    }

    public ArrayList<Ticket> getMyTickets() {
        return ticketList;
    }

    public Gender getGender() {   return this.gender;   }

    public void setGender(int select) 
    {    
                if (select == 1) 
                {
                    this.gender = Gender.MALE;
                } 
                else if (select == 2) 
                {
                    this.gender = Gender.FEMALE;
                }
    }

    public ArrayList<myCategory> getInterests() {
        return interestList;
    }

    public void setInterests(ArrayList<myCategory> interests) {
        this.interestList = interests;
    }

    public static int getAttendeeCount() {    return attendeeCount;    }

    public void showAttendeeDetails()
    {
        System.out.println("Attendee ID: " + this.ID);
        System.out.println("Attendee Username: " + this.userName);
        System.out.println("Gender: " + this.gender);
        System.out.println("Address: " + this.address);
    }

    @Override
    public String toString()
    {
        return "Attendee ID: " + this.ID + "Attendee Username: " + this.userName + "Gender: " + this.gender
                + "Address: " + this.address;
    }
}

