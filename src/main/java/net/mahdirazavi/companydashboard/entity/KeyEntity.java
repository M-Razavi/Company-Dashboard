package net.mahdirazavi.companydashboard.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class KeyEntity {

    @Id
    @Column(name = "pk", unique = true)
    private String pk;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }
}
