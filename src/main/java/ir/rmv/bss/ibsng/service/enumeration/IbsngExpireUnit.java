package ir.rmv.bss.ibsng.service.enumeration;

public enum IbsngExpireUnit {
    MINUTES("Minutes"),
    HOURS("Hours"),
    DAYS("Days"),
    MONTH("Months"),
    YEARS("Years");

    private String value;

    IbsngExpireUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
