package net.androidbootcamp.mrfixit20.model;

public class Parts {

    private int id;
    private String appPartSerial;
    private String partName;
    private String partNumber;
    private String partCost;
    private String partInv;

    //constructor for empty parameters
    public Parts(){

    }

    //constructor for five parameters
    public Parts(String appPartSerial, String partName, String partNumber, String partCost, String partInv) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.partCost = partCost;
        this.partInv = partInv;
    }

    //get/set methods

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAppPartSerial() { return appPartSerial; }
    public void setAppPartSerial(String appPartSerial) { this.appPartSerial = appPartSerial; }
    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public String getPartCost() { return partCost; }
    public void setPartCost(String partCost) { this.partCost = partCost; }
    public String getPartInv() { return partInv; }
    public void setPartInv(String partInv) { this.partInv = partInv; }
}
