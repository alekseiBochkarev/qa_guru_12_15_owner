package io.qaguru.owner.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:${device}.properties",
      //if uncomment testIos will be passed
        //  "classpath:iphone12.properties"
})
public interface MobileConfig extends Config {

  //  @DefaultValue("Android")
    @Key("platform.name")
    String platformName();

  //  @DefaultValue("27.0")
    @Key("platform.version")
    String platformVersion();

  //  @DefaultValue("Google Pixel XL")
    @Key("device.name")
    String deviceName();

}
