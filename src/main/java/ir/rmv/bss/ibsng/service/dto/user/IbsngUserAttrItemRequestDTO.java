package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.service.enumeration.IbsngExpireUnit;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IbsngUserAttrItemRequestDTO implements Serializable {

    @JsonProperty("normal_user_spec")
    private IbsngUserAttrItemLoginRequestDTO loginAttr;
    @JsonProperty("custom_fields")
    private List<Object> customField;
    @JsonProperty("first_login")
    private Integer firstLogin;
    private String charge;
    private String name;
    private String email;
    private String phone;
    @JsonProperty("cell_phone")
    private String cellphone;
    @JsonProperty("birthdate")
    private String birthDate;
    @JsonProperty("birthdate_unit")
    private String birthDateUnit = "gregorian";
    private String address;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("abs_exp_date")
    private String expireDate;
    @JsonProperty("abs_exp_date_unit")
    private String expireDateUnit = "gregorian";
    @JsonProperty("rel_exp_date")
    private Integer realExpireDate;
    @JsonProperty("rel_exp_date_unit")
    private String realExpireDateUnit;
    @JsonProperty("renew_next_group")
    private String newGroupName;
    @JsonProperty("renew_remove_user_exp_dates")
    private Boolean removeExpDate;
    @JsonProperty("auto_renew")
    private Boolean autoRenew;
    @JsonProperty("group_name")
    private String groupName;

    public IbsngUserAttrItemLoginRequestDTO getLoginAttr() {
        return loginAttr;
    }

    public void setLoginAttr(IbsngUserAttrItemLoginRequestDTO loginAttr) {
        this.loginAttr = loginAttr;
    }

    public List<Object> getCustomField() {
        return customField;
    }

    public void setCustomField(List<Object> customField) {
        this.customField = customField;
    }

    public Integer getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Integer firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getExpireDateUnit() {
        return expireDateUnit;
    }

    public String getNewGroupName() {
        return newGroupName;
    }

    public void setNewGroupName(String newGroupName) {
        this.newGroupName = newGroupName;
    }

    public Boolean getRemoveExpDate() {
        return removeExpDate;
    }

    public void setRemoveExpDate(Boolean removeExpDate) {
        this.removeExpDate = removeExpDate;
    }

    public Integer getRealExpireDate() {
        return realExpireDate;
    }

    public void setRealExpireDate(Integer realExpireDate) {
        this.realExpireDate = realExpireDate;
    }

    public String getRealExpireDateUnit() {
        return realExpireDateUnit;
    }

    public void setRealExpireDateUnit(IbsngExpireUnit realExpireDateUnit) {
        this.realExpireDateUnit = realExpireDateUnit.getValue();
    }

    public Boolean getAutoRenew() {
        return autoRenew;
    }

    public void setAutoRenew(Boolean autoRenew) {
        this.autoRenew = autoRenew;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "IbsngUserAttrItemRequestDTO{" +
                "loginAttr=" + loginAttr +
                ", customField=" + customField +
                ", firstLogin=" + firstLogin +
                ", charge='" + charge + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", birthDateUnit='" + birthDateUnit + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", expireDateUnit='" + expireDateUnit + '\'' +
                ", realExpireDate=" + realExpireDate +
                ", realExpireDateUnit='" + realExpireDateUnit + '\'' +
                ", newGroupName='" + newGroupName + '\'' +
                ", removeExpDate=" + removeExpDate +
                ", autoRenew=" + autoRenew +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
