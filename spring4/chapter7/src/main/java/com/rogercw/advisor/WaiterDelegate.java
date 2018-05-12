package com.rogercw.advisor;

/**
 * Created by 1 on 2018/5/1.
 */
public class WaiterDelegate {

    private Waiter waiter;

    public void server(String name){
        waiter.greet(name);
        waiter.server(name);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
