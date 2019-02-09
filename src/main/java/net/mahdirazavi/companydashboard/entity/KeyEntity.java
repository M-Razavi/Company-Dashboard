package net.mahdirazavi.companydashboard.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class KeyEntity {

    @Id
    @Column(name = "pk", unique = true)
    private Long pk;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }
}
