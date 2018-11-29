package com.bin.t28;

public class Future {

    private Product product;

    private boolean down;

    public synchronized void setProduct(Product product) {
        if (down) {
            return;
        }
        this.product = product;
        down = true;
        notifyAll();
    }

    public synchronized Product getProduct() {
        while (!down) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return product;
    }



}
