# How to run from Terminal
**For web tests (all tests will be passed)**

./gradlew clean test --tests io.qaguru.owner.home_web_tests.WebTest

**For web tests local (all tests will be passed)**

./gradlew clean test --tests io.qaguru.owner.home_web_tests.WebTest -Denvironment=local

**For web tests remote (just remote test will be passed)**

./gradlew clean test --tests io.qaguru.owner.home_web_tests.WebTest -Denvironment=remote

**For api tests with file property:**

./gradlew clean test --tests io.qaguru.owner.home_api_tests.ApiFileTest

**For api test with system property:**

./gradlew clean test --tests io.qaguru.owner.home_api_tests.ApiPropertyTest
