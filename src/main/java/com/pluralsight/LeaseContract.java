package com.pluralsight;

public class LeaseContract extends Contract{
    private double originalPrice;
    private double endingValue;
    private double leaseFee;
    private double interRate;
    private int leaseTermMonths;

    public LeaseContract(String dateOfContract, String customerName, int vehicleSold, double originalPrice, double endingValue, double leaseFee, double interRate, int leaseTermMonths) {
        super(dateOfContract, customerName, vehicleSold);
        this.originalPrice = originalPrice;
        this.endingValue = originalPrice* 0.50;
        this.leaseFee = originalPrice * 0.07;
        this.interRate = 0.04;
        this.leaseTermMonths = 36;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getInterRate() {
        return interRate;
    }

    public void setInterRate(double interRate) {
        this.interRate = interRate;
    }

    public int getLeaseTermMonths() {
        return leaseTermMonths;
    }

    public void setLeaseTermMonths(int leaseTermMonths) {
        this.leaseTermMonths = leaseTermMonths;
    }
    @Override
    public double getTotalPrice() {
        return (getVehicleSold() - endingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }

}
