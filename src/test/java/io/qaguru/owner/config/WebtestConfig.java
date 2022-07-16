package io.qaguru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${environment}.properties",
        "classpath:local.properties"
})
public interface WebtestConfig extends Config{
    @Key("browser.name")
    String browser();

    @Key("browser.version")
    @DefaultValue("101")
    String version();

    @Key("host")
    String host();
}
