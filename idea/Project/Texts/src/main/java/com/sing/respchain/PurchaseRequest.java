package com.sing.respchain;

public class PurchaseRequest {
    //请求类型
    private int type = 0;
    //请求金额
    private float price = 0.0f;
    //请求编号
    private int id = 0;

    //全参构造
    public PurchaseRequest(int type,float price,int id){
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
