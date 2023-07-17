package com.dinger.onlinehousingshow.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner_username",nullable = false)
    private String ownerUserName;
    @Column(name = "owner_name",nullable = false)
    private String ownerName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;
    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,mappedBy = "ownerId")
    private Set<Housing> housings = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role", joinColumns =
    @JoinColumn(name = "user_id",referencedColumnName = "id"), inverseJoinColumns =
    @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }
}
