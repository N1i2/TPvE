package org.example.exem;

public class People {
    public People(String name, String address) {
        Name = name;
        Address = address;
    }

    public People() {
    }

    public String Name;
    public String Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
