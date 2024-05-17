package com.pluralsight;

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

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}