package com.project;

public class Ticket implements Runnable{
    private int ticket=100;
    @Override
    public  void run() {
        for (int i = 0; i <100; i++) {
            this.selTicket();
        }
    }
    private synchronized void selTicket() {

            if (ticket > 0) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"窗口正在卖第"+ticket--+"张票");
            }

    }
}
