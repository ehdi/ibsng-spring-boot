package ir.rmv.bss.ibsng.service.vm;

import ir.rmv.bss.ibsng.service.enumeration.IbsngCreditType;

import java.io.Serializable;

public class IbsngUpdateCreditRequestVM implements Serializable {

    private String userId;
    private String credit;
    private IbsngCreditType type;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public IbsngCreditType getType() {
        return type;
    }

    public void setType(IbsngCreditType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "IbsngUpdateCreditRequestVM{" +
                "userId='" + userId + '\'' +
                ", credit='" + credit + '\'' +
                ", type=" + type +
                '}';
    }
}
