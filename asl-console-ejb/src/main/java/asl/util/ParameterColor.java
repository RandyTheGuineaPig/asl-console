package asl.util;

/**
 * Created by sengir on 13.05.16.
 */
public enum ParameterColor {
    RED("RED"),
    YELLOW("YELLOW"),
    GREEN("GREEN");
    private String value;

    ParameterColor(final String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
