package xyz.thishome.hotel.pojo;

import java.util.Date;

public class Reside {
    private Integer id;

    private Integer userId;

    private Integer hostNumber;

    private Date creationTime;

    private Date checkInTime;

    private Date departureTime;

    private Date appointmentTime;

    private Integer resideStatus;

    private String lastname;

    private String userPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHostNumber() {
        return hostNumber;
    }

    public void setHostNumber(Integer hostNumber) {
        this.hostNumber = hostNumber;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getResideStatus() {
        return resideStatus;
    }

    public void setResideStatus(Integer resideStatus) {
        this.resideStatus = resideStatus;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }
}