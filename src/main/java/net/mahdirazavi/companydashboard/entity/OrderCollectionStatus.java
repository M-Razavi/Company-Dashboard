package net.mahdirazavi.companydashboard.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_collection_status" )
public class OrderCollectionStatus extends KeyEntity {

    @Column
    private int newOrders;

    @Column
    private double revenue;

    @Column
    private int shipped;

    @Column
    private int returned;

    public int getNewOrders() {
        return newOrders;
    }

    public void setNewOrders(int newOrders) {
        this.newOrders = newOrders;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getShipped() {
        return shipped;
    }

    public void setShipped(int shipped) {
        this.shipped = shipped;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }
}
