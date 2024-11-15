package com.dadytech.dslist.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private  Integer position;


    public Belonging() {
    }

    public Belonging(BelongingPK id, Integer position) {
        this.id = id;
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }
}
