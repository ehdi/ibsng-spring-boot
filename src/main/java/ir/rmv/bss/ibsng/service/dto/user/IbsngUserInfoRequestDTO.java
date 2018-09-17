package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicParams;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IbsngUserInfoRequestDTO extends IbsngBasicParams implements Serializable {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("normal_username")
    private String userName;

    @JsonProperty("phone")
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "IbsngUserInfoRequestDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
