package com.sing.respchain;

public class Dean extends Approver{
    //创建审批人要指定姓名
    public Dean(String name) {
        super(name);
    }

    //院长审批逻辑
    @Override
    public void approve(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() > 5000 && purchaseRequest.getPrice() <= 10000){
            System.out.println("请求编号:"+purchaseRequest.getId() +"被"+this.name+"处理");
        }else{
            approver.approve(purchaseRequest);
        }
    }
}
