package com.sing.respchain;

public class DepartmentApprover extends Approver{
    //创建审批人要指定姓名
    public DepartmentApprover(String name) {
        super(name);
    }

    //教学主任审批逻辑
    @Override
    public void approve(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() <= 5000){
            System.out.println("请求编号:"+purchaseRequest.getId()+"被"+this.name+"处理");
        }else{
            approver.approve(purchaseRequest);
        }
    }
}
