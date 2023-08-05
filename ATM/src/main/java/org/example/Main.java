package org.example;
import java.util.*;

import static java.lang.System.exit;

class Bank_acc1
{

    Scanner sc=new Scanner(System.in);

    String Depositor_name;
    String acc_no;
    String acc_type;
    double balance,new_deposit,withdraw,transfer;

    void createAcc()
    {
        System.out.println("Enter Depositor Name:");
        Depositor_name=sc.next();

        System.out.println("Enter Account Type:");
        acc_type=sc.next();

        System.out.println("Enter Balance:");
        balance=sc.nextDouble();

        acc_no=Transaction.getRandomId()+"ICICI";
    }

    void Deposit()
    {
        System.out.println("Enter New Deposit:");
        new_deposit=sc.nextDouble();
        if(balance>1000)
        {
            balance=balance+new_deposit;
            TransactionHistory.addTransaction(Transaction.getRandomId(),"Credit",new_deposit);
        }
        else
        {
            System.out.println("Balance is Below 1000.\nIt must be above 1000");
        }
    }

    void withdraw()
    {
        System.out.println("Enter Withdraw Amount:");
        withdraw=sc.nextDouble();
        if(balance>1000)
        {
            balance=balance-withdraw;
            TransactionHistory.addTransaction(Transaction.getRandomId(),"Debit",withdraw);
        }
        else if(balance<1000)
        {
            System.out.println("Balance is Below 1000.\nYou can't withdraw");
        }

    }
    void transfer()
    {
        System.out.println("Enter Transfer Amount:");
        transfer=sc.nextDouble();
        if(balance>1000)
        {
            balance=balance-transfer;
            TransactionHistory.addTransaction(Transaction.getRandomId(),"Transfer",transfer);
        }
        else if(balance<1000)
        {
            System.out.println("Balance is Below 1000.\nYou can't Make Transaction Right Now.");
        }

    }


    void BalanceInquiry()
    {
        System.out.println("Current Balance is: "+balance);
    }

    void display()
    {
        System.out.println("\nAccount No. is: "+acc_no);
        System.out.println("Name is: "+Depositor_name);
        System.out.println("Account Type is: "+acc_type);
        System.out.println("Current Balance is: "+balance);
    }
}

class bank
{
    public static void main(String a[])
    {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("                                                   ATM                                                  ");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        Scanner sc1=new Scanner(System.in);
        int ch,num;
        String name1;
        Bank_acc1 b=new Bank_acc1();
        Scanner name=new Scanner(System.in);
        Scanner no=new Scanner(System.in);
        System.out.println();
        System.out.println("Enter Username:");
        name1=name.next();
        System.out.println("Enter Password:");
        num=no.nextInt();
        String nr="Raj";
        int num1=77;
        if(name1.equals(nr) && num==num1) {
            System.out.println("Login Successful");
            System.out.println();
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("                                             MAIN MENU                                                  ");
            System.out.println("--------------------------------------------------------------------------------------------------------");

            do
            {
                System.out.println("\n1. To Create\n2. Deposit\n3. Withdraw\n4. Balance Inquiry\n5. Transfer\n6. Transaction History\n7. Display");
                System.out.println("Enter your choice:");
                ch=sc1.nextInt();

                switch(ch)
                {
                    case 1:
                        b.createAcc();
                        break;

                    case 2:
                        b.Deposit();
                        break;

                    case 3:
                        b.withdraw();
                        break;

                    case 4:
                        b.BalanceInquiry();
                        break;
                    case 5:
                        b.transfer();
                        break;
                    case 6:
                        System.out.println("Select Any One From The Following As Per Your Need : \n1. Show All Transaction\n2. Show Specific Transaction\n3. Go Back");
                        switch(no.nextInt())
                        {
                            case 1:
                                TransactionHistory.displayTransactionHistory();
                                break;
                            case 2:
                                System.out.println("1.DEBIT TRANSACTIONS\n2.CREDIT TRANSACTIONS\n3.TRANSFERS");
                                int n=no.nextInt();
                                if(n==1)
                                {
                                    TransactionHistory.displayTransactionHistoryByChoise("Debit");
                                }else if(n==2)
                                {
                                    TransactionHistory.displayTransactionHistoryByChoise("Credit");
                                }else if(n==3)
                                {
                                    TransactionHistory.displayTransactionHistoryByChoise("Transfer");
                                }else{
                                    System.out.println("Select Valid Choice");
                                }
                            case 3:break;
                        }

                        break;
                    case 7:
                        b.display();
                        break;
                    case 8:
                        exit(0);
                        break;
                }
            }
            while(ch!=8);

        }
    }
}
