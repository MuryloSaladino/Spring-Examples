package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter @Entity @Table()
public class RealStateEntity extends BaseEntity {

    @Column()
    private Boolean sold = false;

    @Column()
    private Float price;

    @Column()
    private Integer squaredMeters;

    @Setter
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CategoryEntity category;

    @OneToMany(mappedBy = "realStateEntity")
    private Set<ScheduleEntity> scheduleEntities;


    public RealStateEntity() {}

    public RealStateEntity(Boolean sold, Float price, Integer squaredMeters) {
        super();
        this.sold = sold;
        this.price = price;
        this.squaredMeters = squaredMeters;
    }


    public void setSold(Boolean sold) {
        this.updateUpdatedAt();
        this.sold = sold;
    }

    public void setPrice(Float price) {
        this.updateUpdatedAt();
        this.price = price;
    }

    public void setSize(Integer squaredMeters) {
        this.updateUpdatedAt();
        this.squaredMeters = squaredMeters;
    }

    public void setAddress(AddressEntity address) {
        this.updateUpdatedAt();
        this.address = address;
    }

    public void setCategory(CategoryEntity realStateCategory) {
        this.updateUpdatedAt();
        this.category = realStateCategory;
    }
}
