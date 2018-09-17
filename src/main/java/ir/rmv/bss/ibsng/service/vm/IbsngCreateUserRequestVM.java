package ir.rmv.bss.ibsng.service.vm;

import java.io.Serializable;

public class IbsngCreateUserRequestVM implements Serializable {

    private String groupName;
    private String creditComment;

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
        return "IbsngCreateUserRequestVM{" +
                "groupName='" + groupName + '\'' +
                ", creditComment='" + creditComment + '\'' +
                '}';
    }
}
