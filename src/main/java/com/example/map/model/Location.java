package com.example.map.model;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String longValue;
    private String latValue;
    private String address;
    private String addressDeatails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    public Location() {
    }

    public Location(String longValue, String latValue, String address, String addressDeatails, City city) {
        this.longValue = longValue;
        this.latValue = latValue;
        this.address = address;
        this.addressDeatails = addressDeatails;
        this.city = city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return this.city;
    }

    public Long getId() {
        return id;
    }

    public String getLongValue() {
        return longValue;
    }

    public void setLongValue(String longValue) {
        this.longValue = longValue;
    }

    public String getLatValue() {
        return latValue;
    }

    public void setLatValue(String latValue) {
        this.latValue = latValue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDeatails() {
        return addressDeatails;
    }

    public void setAddressDeatails(String addressDeatails) {
        this.addressDeatails = addressDeatails;
    }
}