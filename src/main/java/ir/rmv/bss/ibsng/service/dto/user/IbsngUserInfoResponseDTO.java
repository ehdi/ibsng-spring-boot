package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * A User DTO for sending to 'IBSNG'
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class IbsngUserInfoResponseDTO implements Serializable {

    @JsonProperty("basic_info")
    private IbsngUserInfoBasicResponseDTO basicInfo;

    @JsonProperty("attrs")
    private IbsngUserInfoAttributeResponseDTO attr;

    @JsonProperty("user_repr")
    private String userRepr;

    @JsonProperty("online_status")
    private Boolean onlineStatus;

    @JsonProperty("voip_onlines")
    private List<List<Object>> voips;

    @JsonProperty("internet_onlines")
    private List<List<Object>> internets;

    public IbsngUserInfoBasicResponseDTO getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(IbsngUserInfoBasicResponseDTO basicInfo) {
        this.basicInfo = basicInfo;
    }

    public IbsngUserInfoAttributeResponseDTO getAttr() {
        return attr;
    }

    public void setAttr(IbsngUserInfoAttributeResponseDTO attr) {
        this.attr = attr;
    }

    public String getUserRepr() {
        return userRepr;
    }

    public void setUserRepr(String userRepr) {
        this.userRepr = userRepr;
    }

    public Boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public List<List<Object>> getVoips() {
        return voips;
    }

    public void setVoips(List<List<Object>> voips) {
        this.voips = voips;
    }

    public List<List<Object>> getInternets() {
        return internets;
    }

    public void setInternets(List<List<Object>> internets) {
        this.internets = internets;
    }

    @Override
    public String toString() {
        return "IbsngUserInfoResponseDTO{" +
                "basicInfo=" + basicInfo +
                ", attr=" + attr +
                ", userRepr='" + userRepr + '\'' +
                ", onlineStatus=" + onlineStatus +
                ", voips=" + voips +
                ", internets=" + internets +
                '}';
    }
}
