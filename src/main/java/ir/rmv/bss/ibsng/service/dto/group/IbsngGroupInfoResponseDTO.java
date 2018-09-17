package ir.rmv.bss.ibsng.service.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IbsngGroupInfoResponseDTO {

    private String status;
    private IbsngGroupInfoAttrResponseDTO attrs;
    @JsonProperty("group_id")
    private Integer id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IbsngGroupInfoAttrResponseDTO getAttrs() {
        return attrs;
    }

    public void setAttrs(IbsngGroupInfoAttrResponseDTO attrs) {
        this.attrs = attrs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IbsngGroupInfoResponseDTO{" +
                "status='" + status + '\'' +
                ", attrs=" + attrs +
                ", id=" + id +
                '}';
    }
}
