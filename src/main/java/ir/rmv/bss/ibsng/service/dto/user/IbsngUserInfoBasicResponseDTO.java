package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.service.enumeration.IbsngChoice;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IbsngUserInfoBasicResponseDTO implements Serializable {

    @JsonProperty(value = "user_id")
    private Long id;

    @NotNull
    private int count;

    @NotNull
    private float credit;

    @NotNull
    @JsonProperty(value = "isp_name")
    private String ispName;

    @JsonProperty(value = "group_id")
    private int groupId;

    @NotNull
    @JsonProperty(value = "group_name")
    private String groupName;

    @NotNull
    @JsonProperty(value = "credit_comment")
    private String creditComment;

    @JsonProperty(value = "custom_fields")
    private HashMap<String, String> customFields;

    @JsonProperty(value = "creation_date")
    private String createdDate;

    private float deposit;

    @JsonProperty(value = "isp_id")
    private int ispId;

    @JsonProperty(value = "nearest_exp_date")
    private String nearestExpiringDate;

    @JsonProperty(value = "recharge_deposit")
    private float rechargeDeposit;

    private IbsngChoice status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public String getIspName() {
        return ispName;
    }

    public void setIspName(String ispName) {
        this.ispName = ispName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public HashMap<String, String> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(HashMap<String, String> customFields) {
        this.customFields = customFields;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public int getIspId() {
        return ispId;
    }

    public void setIspId(int ispId) {
        this.ispId = ispId;
    }

    public String getNearestExpiringDate() {
        return nearestExpiringDate;
    }

    public void setNearestExpiringDate(String nearestExpiringDate) {
        this.nearestExpiringDate = nearestExpiringDate;
    }

    public float getRechargeDeposit() {
        return rechargeDeposit;
    }

    public void setRechargeDeposit(float rechargeDeposit) {
        this.rechargeDeposit = rechargeDeposit;
    }

    public IbsngChoice getStatus() {
        return status;
    }

    public void setStatus(IbsngChoice status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IbsngUserInfoBasicResponseDTO{" +
                "id=" + id +
                ", count=" + count +
                ", credit=" + credit +
                ", ispName='" + ispName + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", creditComment='" + creditComment + '\'' +
                ", customFields=" + customFields +
                ", createdDate='" + createdDate + '\'' +
                ", deposit=" + deposit +
                ", ispId=" + ispId +
                ", nearestExpiringDate='" + nearestExpiringDate + '\'' +
                ", rechargeDeposit=" + rechargeDeposit +
                ", status=" + status +
                '}';
    }
}
