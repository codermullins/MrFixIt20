package net.androidbootcamp.mrfixit20.model;

public class Appliance {

    private int id;
    private String make;
    private String model;
    private String serial;
    private String type;

    public Appliance(){

    }

    public Appliance(String make, String model, String serial, String type){
        this.id = id;
        this.make = make;
        this.model = model;
        this.serial = serial;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
