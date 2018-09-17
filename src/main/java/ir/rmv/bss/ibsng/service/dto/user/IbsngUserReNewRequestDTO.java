package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicParams;

public class IbsngUserReNewRequestDTO extends IbsngBasicParams{

    @JsonProperty("user_id")
    private String userId;
    private String comment;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "IbsngUserReNewRequestDTO{" +
                "userId='" + userId + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
