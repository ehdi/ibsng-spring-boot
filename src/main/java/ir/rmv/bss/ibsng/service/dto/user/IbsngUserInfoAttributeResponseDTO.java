package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class IbsngUserInfoAttributeResponseDTO implements Serializable {

    @JsonProperty(value = "user_id")
    private int userId;

    @JsonProperty(value = "normal_username")
    private String normalUsername;

    @JsonProperty(value = "normal_password")
    private String normalPassword;

    @JsonProperty(value = "first_login")
    private String firstLogin;

    @JsonProperty(value = "real_first_login")
    private String realFirstLogin;

    @JsonProperty(value = "nearest_exp_date")
    private String nearestExpiringDate;

    @JsonProperty(value = "time_to_nearest_exp_date")
    private String timeToNearestExpiringDate;

    @JsonProperty(value = "charge_rule_usage")
    private List<List<Object>> chargeRuleUsage;

    private String charge;

    @JsonProperty(value = "last_renew")
    private String lastRenew;

    @JsonProperty(value = "abs_exp_date")
    private String absoluteExpirationDate;

    private String comment;

    private String name;

    private String email;

    private String phone;

    private String cell_phone;

    private String birthdate;

    private String address;

    private String postal_code;

    private String credit_limit;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNormalUsername() {
        return normalUsername;
    }

    public void setNormalUsername(String normalUsername) {
        this.normalUsername = normalUsername;
    }

    public String getNormalPassword() {
        return normalPassword;
    }

    public void setNormalPassword(String normalPassword) {
        this.normalPassword = normalPassword;
    }

    public String getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getRealFirstLogin() {
        return realFirstLogin;
    }

    public void setRealFirstLogin(String realFirstLogin) {
        this.realFirstLogin = realFirstLogin;
    }

    public String getNearestExpiringDate() {
        return nearestExpiringDate;
    }

    public void setNearestExpiringDate(String nearestExpiringDate) {
        this.nearestExpiringDate = nearestExpiringDate;
    }

    public String getTimeToNearestExpiringDate() {
        return timeToNearestExpiringDate;
    }

    public void setTimeToNearestExpiringDate(String timeToNearestExpiringDate) {
        this.timeToNearestExpiringDate = timeToNearestExpiringDate;
    }

    public List getChargeRuleUsage() {
        return chargeRuleUsage;
    }

    public void setChargeRuleUsage(List chargeRuleUsage) {
        this.chargeRuleUsage = chargeRuleUsage;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getLastRenew() {
        return lastRenew;
    }

    public void setLastRenew(String lastRenew) {
        this.lastRenew = lastRenew;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(String credit_limit) {
        this.credit_limit = credit_limit;
    }

    public String getAbsoluteExpirationDate() {
        return absoluteExpirationDate;
    }

    public void setAbsoluteExpirationDate(String absoluteExpirationDate) {
        this.absoluteExpirationDate = absoluteExpirationDate;
    }

    @Override
    public String toString() {
        return "IbsngUserInfoAttributeResponseDTO{" +
                "userId=" + userId +
                ", normalUsername='" + normalUsername + '\'' +
                ", normalPassword='" + normalPassword + '\'' +
                ", firstLogin='" + firstLogin + '\'' +
                ", realFirstLogin='" + realFirstLogin + '\'' +
                ", nearestExpiringDate='" + nearestExpiringDate + '\'' +
                ", timeToNearestExpiringDate='" + timeToNearestExpiringDate + '\'' +
                ", chargeRuleUsage=" + chargeRuleUsage +
                ", charge='" + charge + '\'' +
                ", lastRenew='" + lastRenew + '\'' +
                ", absoluteExpirationDate='" + absoluteExpirationDate + '\'' +
                ", comment='" + comment + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", cell_phone='" + cell_phone + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", address='" + address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", credit_limit='" + credit_limit + '\'' +
                '}';
    }
}
