package com.debt_brew.backend.models;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.*;



@Entity
@Table(name = "accounts")
public class Account {
    
    // primary identifier
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(nullable = false)
    public String biller;

    public long amountOwed;

    public long amountPayed;

    public long remainingBalance;

    @Column(nullable = false)
    public String billerUrl;

    @Column(nullable = false)
    public Date dueDate;

    @Column(nullable = false)
    public long paymentAmount;


    public Account() {
    }

    public Account(Integer id, String biller, long amountOwed, long amountPayed, long remainingBalance, String billerUrl, Date dueDate, long paymentAmount) {
        this.id = id;
        this.biller = biller;
        this.amountOwed = amountOwed;
        this.amountPayed = amountPayed;
        this.remainingBalance = remainingBalance;
        this.billerUrl = billerUrl;
        this.dueDate = dueDate;
        this.paymentAmount = paymentAmount;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiller() {
        return this.biller;
    }

    public void setBiller(String biller) {
        this.biller = biller;
    }

    public long getAmountOwed() {
        return this.amountOwed;
    }

    public void setAmountOwed(long amountOwed) {
        this.amountOwed = amountOwed;
    }

    public long getAmountPayed() {
        return this.amountPayed;
    }

    public void setAmountPayed(long amountPayed) {
        this.amountPayed = amountPayed;
    }

    public long getRemainingBalance() {
        return this.remainingBalance;
    }

    public void setRemainingBalance(long remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public String getBillerUrl() {
        return this.billerUrl;
    }

    public void setBillerUrl(String billerUrl) {
        this.billerUrl = billerUrl;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public long getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Account id(Integer id) {
        this.id = id;
        return this;
    }

    public Account biller(String biller) {
        this.biller = biller;
        return this;
    }

    public Account amountOwed(long amountOwed) {
        this.amountOwed = amountOwed;
        return this;
    }

    public Account amountPayed(long amountPayed) {
        this.amountPayed = amountPayed;
        return this;
    }

    public Account remainingBalance(long remainingBalance) {
        this.remainingBalance = remainingBalance;
        return this;
    }

    public Account billerUrl(String billerUrl) {
        this.billerUrl = billerUrl;
        return this;
    }

    public Account dueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Account paymentAmount(long paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(biller, account.biller) && amountOwed == account.amountOwed && amountPayed == account.amountPayed && remainingBalance == account.remainingBalance && Objects.equals(billerUrl, account.billerUrl) && Objects.equals(dueDate, account.dueDate) && paymentAmount == account.paymentAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, biller, amountOwed, amountPayed, remainingBalance, billerUrl, dueDate, paymentAmount);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", biller='" + getBiller() + "'" +
            ", amountOwed='" + getAmountOwed() + "'" +
            ", amountPayed='" + getAmountPayed() + "'" +
            ", remainingBalance='" + getRemainingBalance() + "'" +
            ", billerUrl='" + getBillerUrl() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            ", paymentAmount='" + getPaymentAmount() + "'" +
            "}";
    }



}