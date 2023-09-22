package com.sing.car;

public class People implements Buy_car{
    private String username;
    private String vip;
    private int cash;
    public void buy_mycar() {
        System.out.println(username+"是vip客户,可以直接购买新车");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
