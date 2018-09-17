package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicParams;

import java.io.Serializable;

public class IbsngCreateUserRequestDTO extends IbsngBasicParams implements Serializable {

    private String count;
    private String credit;

    @JsonProperty("isp_name")
    private String ipsName;

    @JsonProperty("group_name")
    private String groupName;

    @JsonProperty("credit_comment")
    private String creditComment;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getIpsName() {
        return ipsName;
    }

    public void setIpsName(String ipsName) {
        this.ipsName = ipsName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreditComment() {
        return creditComment;
    }

    public void setCreditComment(String creditComment) {
        this.creditComment = creditComment;
    }

    @Override
    public String toString() {
        return "IbsngCreateUserRequestDTO{" +
                "count='" + count + '\'' +
                ", credit='" + credit + '\'' +
                ", ipsName='" + ipsName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", creditComment='" + creditComment + '\'' +
                '}';
    }
}
