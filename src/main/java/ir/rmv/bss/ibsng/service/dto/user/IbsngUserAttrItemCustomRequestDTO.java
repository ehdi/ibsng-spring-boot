package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class IbsngUserAttrItemCustomRequestDTO implements Serializable {
    @JsonProperty("custom_field_shahkar_id")
    private String shahkarId;

    public String getShahkarId() {
        return shahkarId;
    }

    public void setShahkarId(String shahkarId) {
        this.shahkarId = shahkarId;
    }
}
