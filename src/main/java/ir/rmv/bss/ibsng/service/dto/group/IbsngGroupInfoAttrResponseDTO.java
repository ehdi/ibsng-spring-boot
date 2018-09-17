package ir.rmv.bss.ibsng.service.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class IbsngGroupInfoAttrResponseDTO implements Serializable {

    @JsonProperty("rel_exp_date")
    private String expireDate;

    @JsonProperty("rel_exp_date_unit")
    private String expireDateUnit;

    @JsonProperty("group_credit")
    private String credit;

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getExpireDateUnit() {
        return expireDateUnit;
    }

    public void setExpireDateUnit(String expireDateUnit) {
        this.expireDateUnit = expireDateUnit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "IbsngGroupInfoAttrResponseDTO{" +
                "expireDate='" + expireDate + '\'' +
                ", expireDateUnit='" + expireDateUnit + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
