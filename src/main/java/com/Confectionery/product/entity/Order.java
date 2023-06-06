package com.Confectionery.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;

    //@Column(name = "car_model")
    //private String carModel;
    @Column(name = "adress")
    private String adress;

    //@Column(name = "engine_capacity")
    //private String engineCapacity;
    @Column(name = "product_name")
    private String productName;

    @Column(name = "more_detailed",columnDefinition = "text")
    private String moreDetailed;


    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*public String getCarModel() {
        return carModel;
    }*/
    public String getAdress() {
        return adress;
    }

    /*public void setCarModel(String carModel) {
        this.carModel = carModel;
    }*/
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /*public String getEngineCapacity() {
        return engineCapacity;
    }*/
    public String getProductName() {
        return productName;
    }

    /*public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }*/
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMoreDetailed() {
        return moreDetailed;
    }

    public void setMoreDetailed(String moreDetailed) {
        this.moreDetailed = moreDetailed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
