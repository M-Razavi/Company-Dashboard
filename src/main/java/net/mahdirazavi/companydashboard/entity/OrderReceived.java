package net.mahdirazavi.companydashboard.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "order_received")
public class OrderReceived extends KeyEntity {

    @Column
    private int orderReceived;

    @Column
    private String dateReceived;

    public int getOrderReceived() {
        return orderReceived;
    }

    public void setOrderReceived(int orderReceived) {
        this.orderReceived = orderReceived;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }
}
