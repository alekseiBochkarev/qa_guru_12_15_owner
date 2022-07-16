package io.qaguru.owner.home_api_tests;

import io.qaguru.owner.config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiFileTest {
    public static String authCookieName = "NOPCOMMERCE.AUTH";
    public static String authCookieValue;
    static Path propsPath;

    @BeforeAll
    static void precondition () throws IOException {
        //используем конфиг из пропертей
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseurl();
        authCookieValue = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", "qaguru@qa.guru")
                .formParam("Password", "qaguru@qa.guru1")
                .log().all()
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(302)
                .extract().cookie(authCookieName);
        String content = "baseurl=http://demowebshop.tricentis.com\ntoken="+authCookieValue;
        propsPath = Paths.get("/tmp/secretAPI.properties");
        Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("check properties with file")
    void checkPropertyWithFile() {
        //а тут уже будет использован конфиг из файла (магия)
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(config.baseurl()).isEqualTo("http://demowebshop.tricentis.com");
        assertThat(config.token()).isEqualTo(authCookieValue);
        assertThat(config.token()).isNotEqualTo("SEth3F1qKcfTFPsl57ffLhbWmAUVWzPBwGMPWAVdpBp7Pdkua0vQcTyzXf0W0CtKa6NvHKeUDqD1do0jfVwTcQnwzhRZl1QCymDXPSTXorpnuIIAeH7gNdIZex1f2FVTdflxfm5uVE0N8T25V31HldyAszxiPkklNdRIY4kzgYjvqDwuXVOW89nea2vMzuQ8Ld7T3gm2kdvLut5tmua2kaElaiU2VTOggNR8MpieJQlxZuAQb0Kc97JUFOnEH2fn");
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("addtocart_53.EnteredQuantity", 4)
                .cookie(authCookieName, authCookieValue)
                .log().all()
                .when()
                .post("/addproducttocart/details/53/1")
                .then()
                .log().all()
                .statusCode(200);
    }

    @AfterAll
    static void deleteProps () throws IOException {
        Files.delete(propsPath);
    }
}
