package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicParams;

import java.io.Serializable;

public class IbsngUserCreditRequestDTO extends IbsngBasicParams implements Serializable {

    @JsonProperty("user_id")
    private String userId;
    private String credit;
    @JsonProperty("is_absolute_change")
    private Boolean absoluteChange;
    @JsonProperty("credit_comment")
    private String creditComment;

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

    public Boolean getAbsoluteChange() {
        return absoluteChange;
    }

    public void setAbsoluteChange(Boolean absoluteChange) {
        this.absoluteChange = absoluteChange;
    }

    public String getCreditComment() {
        return creditComment;
    }

    public void setCreditComment(String creditComment) {
        this.creditComment = creditComment;
    }

    @Override
    public String toString() {
        return "IbsngUserCreditRequestDTO{" +
                "userId='" + userId + '\'' +
                ", credit='" + credit + '\'' +
                ", absoluteChange=" + absoluteChange +
                ", creditComment='" + creditComment + '\'' +
                '}';
    }
}
