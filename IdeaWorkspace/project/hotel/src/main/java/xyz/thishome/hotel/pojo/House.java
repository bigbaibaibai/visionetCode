package xyz.thishome.hotel.pojo;

public class House {
    private Integer id;

    private Integer houseLevel;

    private Integer housePrice;

    private Integer houseStatus;

    private String houseFloor;

    private String houseImage;

    private Integer houseNumber;

    private String houseInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseLevel() {
        return houseLevel;
    }

    public void setHouseLevel(Integer houseLevel) {
        this.houseLevel = houseLevel;
    }

    public Integer getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(Integer housePrice) {
        this.housePrice = housePrice;
    }

    public Integer getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Integer houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(String houseFloor) {
        this.houseFloor = houseFloor == null ? null : houseFloor.trim();
    }

    public String getHouseImage() {
        return houseImage;
    }

    public void setHouseImage(String houseImage) {
        this.houseImage = houseImage == null ? null : houseImage.trim();
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", houseLevel=" + houseLevel +
                ", housePrice=" + housePrice +
                ", houseStatus=" + houseStatus +
                ", houseFloor='" + houseFloor + '\'' +
                ", houseImage='" + houseImage + '\'' +
                ", houseNumber=" + houseNumber +
                ", houseInfo='" + houseInfo + '\'' +
                '}';
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo == null ? null : houseInfo.trim();
    }
}