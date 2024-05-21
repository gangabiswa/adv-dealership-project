package com.pluralsight;

public class SalesContract extends Contract {
    private double salePrice;
    private double downPayment;
    private boolean financed;
    private double salesTaxRate = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private double interestRate;
    private int loanTerm;

    public SalesContract(String dateOfContract, String customerName, int vehicleSold, double salePrice, double downPayment, boolean financed, double salesTaxRate, double recordingFee, double processingFee, double interestRate, int loanTerm) {
        super(dateOfContract, customerName, vehicleSold);
        this.salePrice = salePrice;
        this.downPayment = downPayment;
        this.financed = financed;
        this.salesTaxRate = salesTaxRate;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getSalesTaxRate() {
        return salesTaxRate;
    }

    public void setSalesTaxRate(double salesTaxRate) {
        this.salesTaxRate = salesTaxRate;
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    public void setFinancingDetails(){
        if (financed){
            if (salePrice >= 10000){
                this.interestRate = 0.0425;
                this.loanTerm = 48;
            }else{
                this.interestRate=0.0525;
                this.loanTerm =24;
            }
        }else{
            this.interestRate = 0;
            this.loanTerm = 0;

        }
    }


    @Override
    public double getTotalPrice() {
        return getVehicleSold() + salesTaxRate + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financed) {
            if (getVehicleSold() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }
}
