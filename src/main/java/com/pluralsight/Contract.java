package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class Contract {
    private String dateOfContract;
    private String CustomerName;
    private int VehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String dateOfContract, String customerName, int vehicleSold) {
        this.dateOfContract = dateOfContract;
        CustomerName = customerName;
        VehicleSold = vehicleSold;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getVehicleSold() {
        return VehicleSold;
    }

    public void setVehicleSold(int vehicleSold) {
        VehicleSold = vehicleSold;
    }
    public void appendToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            writer.write(this.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                "dateOfContract='" + dateOfContract + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", VehicleSold=" + VehicleSold +
                ", totalPrice=" + totalPrice +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}