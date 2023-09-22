package com.sing.respchain;

public abstract class Approver {
    //审批人姓名
    protected String name;
    //下一个审批人
    protected Approver approver;

    //指定审批人要指定姓名
    public Approver(String name){
        this.name= name;
    }
    //指定下一个审批人
    public void setApprover(Approver approver){
        this.approver = approver;
    }
    //抽象的审批对象
    public abstract void approve(PurchaseRequest purchaseRequest);

}
