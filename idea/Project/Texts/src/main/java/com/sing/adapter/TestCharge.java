package com.sing.adapter;

public class TestCharge {
    public static void main(String[] args) {
        Socked socked = new ChargerClassAdapter();
       socked.connect();
        socked.charge();
    }
}
