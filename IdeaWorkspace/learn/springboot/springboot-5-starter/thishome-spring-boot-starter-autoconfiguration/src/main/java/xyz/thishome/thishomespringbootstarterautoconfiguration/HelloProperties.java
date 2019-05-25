package xyz.thishome.thishomespringbootstarterautoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "thishome.hello")
public class HelloProperties {

    private String profix;
    private String suffix;

    public void setProfix(String profix) {
        this.profix = profix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getProfix() {

        return profix;
    }

    public String getSuffix() {
        return suffix;
    }
}
