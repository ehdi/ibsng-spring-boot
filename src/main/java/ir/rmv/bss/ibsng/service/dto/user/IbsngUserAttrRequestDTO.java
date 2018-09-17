package ir.rmv.bss.ibsng.service.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicParams;

import java.util.List;

public class IbsngUserAttrRequestDTO extends IbsngBasicParams {

    @JsonProperty("user_id")
    private String userId;

    private IbsngUserAttrItemRequestDTO attrs;

    @JsonProperty("to_del_attrs")
    private List<String> deletedAttr;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public IbsngUserAttrItemRequestDTO getAttrs() {
        return attrs;
    }

    public void setAttrs(IbsngUserAttrItemRequestDTO attrs) {
        this.attrs = attrs;
    }

    public List<String> getDeletedAttr() {
        return deletedAttr;
    }

    public void setDeletedAttr(List<String> deletedAttr) {
        this.deletedAttr = deletedAttr;
    }
}
