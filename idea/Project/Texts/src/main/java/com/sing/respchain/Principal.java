package com.sing.respchain;

public class Principal extends Approver{
    //创建审批人要指定的姓名
    public Principal(String name) {
        super(name);
    }

    //校长审批逻辑
    @Override
    public void approve(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() > 30000){
            System.out.println("请求编号:"+purchaseRequest.getId()+"被"+this.name+"处理");
        }else{
            approver.approve(purchaseRequest);
        }
    }
}
