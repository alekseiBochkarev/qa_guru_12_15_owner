package io.qaguru.owner.config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "file:/tmp/secretAPI.properties",
        "classpath:api.properties"
})
public interface ApiConfig extends Config {
    @Key("baseurl")
    @DefaultValue("http://demowebshop.tricentis.com")
    String baseurl();

    @Key("token")
    @DefaultValue("SEth3F1qKcfTFPsl57ffLhbWmAUVWzPBwGMPWAVdpBp7Pdkua0vQcTyzXf0W0CtKa6NvHKeUDqD1do0jfVwTcQnwzhRZl1QCymDXPSTXorpnuIIAeH7gNdIZex1f2FVTdflxfm5uVE0N8T25V31HldyAszxiPkklNdRIY4kzgYjvqDwuXVOW89nea2vMzuQ8Ld7T3gm2kdvLut5tmua2kaElaiU2VTOggNR8MpieJQlxZuAQb0Kc97JUFOnEH2fn")
    String token();
}
