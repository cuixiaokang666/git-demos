package com.sing.car;

public class Proxy implements Buy_car{

    private People people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public void buy_mycar() {
        if(people.getVip() == "vip"){
            people.buy_mycar();
            return;
        }
        if(people.getCash()>=50000){
            System.out.println(people.getUsername()+"买了新车,交易结束!");
        }else{
            System.out.println(people.getUsername()+"钱不够,不能买车,继续比赛");
        }
    }
}
