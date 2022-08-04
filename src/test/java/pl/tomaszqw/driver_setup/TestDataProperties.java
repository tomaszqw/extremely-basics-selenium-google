package pl.tomaszqw.driver_setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataProperties {

    private static final String FILE_WITH_PROPERTIES = "./src/test/resources/testdata.properties";

    Properties properties = new Properties();
    FileInputStream fileInputStream;


    public TestDataProperties() throws IOException {
        this.fileInputStream = new FileInputStream(FILE_WITH_PROPERTIES);
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    public BrowserName getBrowserType() {
        return BrowserName.valueOf(properties.getProperty("browser"));
    }

    public String getLocalChromeDriverPath() {
        return properties.getProperty("chromeDriverDir");
    }

    public String getLocalFirefoxDriverPath() {
        return properties.getProperty("firefoxDriverDir");
    }

    public String getLocalEdgePath() {
        return properties.getProperty("edgeDriverDir");
    }

}
