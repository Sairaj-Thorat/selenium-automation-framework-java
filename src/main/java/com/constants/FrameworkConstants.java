package com.constants;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources" ;

    private static final String CONFIG_FILE_PATH = RESOURCES_PATH + "/config/config.properties";
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output";
    private static final String EXCEL_PATH = RESOURCES_PATH + "/excel/testdata.xlsx";
    private static String extentReportFilePath = "";

    private static final String RUN_MANAGER = "RUNMANAGER";
    private static final String ITERATION_DATASET = "DATA";

    private static final int EXPLICITLY_WAIT = 10;


    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        if (PropertyUtils.getValue(ConfigProperties.OVERRIDE_REPORTS).equalsIgnoreCase("no")){
            return EXTENT_REPORT_FOLDER_PATH + "/" + System.currentTimeMillis() + "index.html" ;
        }
        else{
            return EXTENT_REPORT_FOLDER_PATH + "/" + "index.html" ;
        }  }


    public static int getExplicitWait() {
        return EXPLICITLY_WAIT;
    }

    public static String getConfigFilePath(){
        return CONFIG_FILE_PATH;
    }

    public static String getExcelPath(){ return EXCEL_PATH; }

    public static String getRunmanagerDatasheet(){ return RUN_MANAGER; }

    public static String getIterationDatasheet(){ return ITERATION_DATASET; }


    /*
    public static String getEdgeDriverPath(){ return EDGE_DRIVER_PATH ;  }

    public static String getChromeDriverPath() { return CHROME_DRIVER_PATH; }

    public static String getFirefoxDriverPath() { return FIREFOX_DRIVER_PATH; }
    */

}
