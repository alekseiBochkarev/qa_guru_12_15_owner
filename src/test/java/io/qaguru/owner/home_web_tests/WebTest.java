package io.qaguru.owner.home_web_tests;

import io.qaguru.owner.config.ApiConfig;
import io.qaguru.owner.config.WebtestConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTest {
    @Test
    @DisplayName("Local test")
    void CheckLocalProperties () {
        WebtestConfig config = ConfigFactory.create(WebtestConfig.class, System.getProperties());
        assertThat(config.browser()).isEqualTo("Chrome");
        assertThat(config.version()).isEqualTo("100");
        assertThat(config.host()).isEqualTo("https://localhost:4444/wd/hub");
    }

    @Test
    @DisplayName("Remote test")
    public void TestingRemoteWeb() {
        System.setProperty("environment", "remote");
        WebtestConfig config = ConfigFactory
                .create(WebtestConfig.class, System.getProperties());

        assertThat(config.browser()).isEqualTo("Firefox");
        assertThat(config.version()).isEqualTo("102.0.1");
        assertThat(config.host()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }


}
