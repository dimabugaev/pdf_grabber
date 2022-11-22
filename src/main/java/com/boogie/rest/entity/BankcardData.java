package com.boogie.rest.entity;


public class BankcardData {
    private String holder;
    private String card;
    private String period;
    private String cvv;
    private String reserv;

    public BankcardData() {
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getReserv() {
        return reserv;
    }

    public void setReserv(String reserv) {
        this.reserv = reserv;
    }
}
