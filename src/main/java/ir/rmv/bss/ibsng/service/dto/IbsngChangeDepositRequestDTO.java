package ir.rmv.bss.ibsng.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IbsngChangeDepositRequestDTO extends IbsngBasicParams {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("deposit")
    private Float deposit;

    @JsonProperty("is_absolute_change")
    private Boolean isAbslChange;

    @JsonProperty("deposit_type")
    private String depositType;

    @JsonProperty("deposit_comment")
    private String comment = "";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    public Boolean getAbslChange() {
        return isAbslChange;
    }

    public void setAbslChange(Boolean abslChange) {
        isAbslChange = abslChange;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "IbsngChangeDepositRequestDTO{" +
                "userId='" + userId + '\'' +
                ", deposit=" + deposit +
                ", isAbslChange=" + isAbslChange +
                ", depositType='" + depositType + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
