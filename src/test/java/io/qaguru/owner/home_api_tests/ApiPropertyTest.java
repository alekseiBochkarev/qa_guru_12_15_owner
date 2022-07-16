package io.qaguru.owner.home_api_tests;

import io.qaguru.owner.config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiPropertyTest {
    @Test
    @DisplayName("check params with property")
    void checkParamsWithProperty () {
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

        assertThat(config.baseurl()).isEqualTo("http://demowebshop.tricentis.com");
        assertThat(config.token()).isEqualTo("SEth3F1qKcfTFPsl57ffLhbWmAUVWzPBwGMPWAVdpBp7Pdkua0vQcTyzXf0W0CtKa6NvHKeUDqD1do0jfVwTcQnwzhRZl1QCymDXPSTXorpnuIIAeH7gNdIZex1f2FVTdflxfm5uVE0N8T25V31HldyAszxiPkklNdRIY4kzgYjvqDwuXVOW89nea2vMzuQ8Ld7T3gm2kdvLut5tmua2kaElaiU2VTOggNR8MpieJQlxZuAQb0Kc97JUFOnEH2fn");
    }
}
