package ir.rmv.bss.ibsng.service.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicParams;

public class IbsngGroupInfoRequestDTO extends IbsngBasicParams {
    @JsonProperty("group_name")
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "IbsngGroupListRequestDTO{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
