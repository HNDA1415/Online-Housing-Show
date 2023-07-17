package com.dinger.onlinehousingshow.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Housing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "housing_name",nullable = false)
    private String housingName;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "number_of_floors",nullable = false)
    private int numberOfFloors;
    @Column(name = "number_of_master_room",nullable = false)
    private int numberOfMasterRoom;
    @Column(name = "number_of_single_room",nullable = false)
    private int numberOfSingleRoom;
    @Column(name = "amount",nullable = false)
    private double amount;
    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "updated_date")
    private Timestamp updatedDate;
    @ManyToOne
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    private User ownerId;

    public Housing() {
    }
}
