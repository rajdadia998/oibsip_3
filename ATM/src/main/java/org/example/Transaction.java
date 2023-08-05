package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Transaction {
    private static final Random RANDOM = new Random();
    private String transId;
    private String transType;
    private double amount;

    public static String getRandomId()
    {
        return Integer.toString(RANDOM.nextInt(124563,9875624));
    }

    public Transaction(String transId, String transType, double amount) {
        this.transId = transId;
        this.transType = transType;
        this.amount = amount;
    }

    public String getTransId() {
        return transId;
    }

    public String getTransType() {
        return transType;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transId='" + transId + '\'' +
                ", transType='" + transType + '\'' +
                ", amount=" + amount +
                '}';
    }
}

class TransactionHistory {
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addTransaction(String id, String type, double amount) {
        transactions.add(new Transaction(id, type, amount));
    }

    public static void displayTransactionHistory() {
        for(Transaction transaction : transactions) {

            System.out.println(transaction);

        }
    }

    public static void displayTransactionHistoryByChoise(String choise) {
        boolean flag=true;
        for(Transaction transaction : transactions) {
            if(transaction.getTransType().equals(choise))
            {
                flag=false;
                System.out.println(transaction);
            }
        }

        if(flag)
        {
            System.out.println("NO TRANSACTION RELATED TO "+choise+" FOUND!");
        }
    }
}

