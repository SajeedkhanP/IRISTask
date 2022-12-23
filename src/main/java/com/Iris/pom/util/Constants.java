package com.Iris.pom.util;

import java.util.Hashtable;

public class Constants {

    //LOCAL_SINGLE_BROWSER_RUN =true means local single browsers parallel on local
    //GRID_RUN = false means local grid

    //GRID_RUN = true means remote grid


    public static final boolean LOCAL_SINGLE_BROWSER_RUN = true;
    public static final boolean GRID_RUN = false;

    //Environment
    public static final String ENV = "STAGE"; //PROD, UAT,SAT

    // URLs-Stage
   

    public static final String STAGE_HOMEPAGE_URL = "https://www.xe.com/";
    public static final String CLIENT_HOMEPAGE_URL = "https://www.xe.com/";
    public static final String HIREORG_HOMEPAGE_URL ="https://www.xe.com/";
    public static final String STAGE_USERNAME = "superman";
    public static final String STAGE_PASSWORD = "Th3@adm1n@acc0unt";

    public static final String STAGE_MAIL = "mpelemene";
    public static final String STAGE_BASE_URI = "https://www.xe.com/";

    public static final String STAGE_PASSWORD2 = "dev@ranker";
    // URLs-uat
    public static final String UAT_HOMEPAGE_URL = "https://www.xe.com/";
    
    public static final String UAT_USERNAME = "admin";
    public static final String UAT_PASSWORD = "admin";
   // public static final String DBURL ="jdbc:mysql://rankerdb.stg.internal.ranker.com:3306";
    public static final String DBUSER = "app_db";
    public static final String DBPASSWORD = "ranker_rules";
    public static String accessToken;

    public static String existingUserId = "";
    public static String existingtoken="";

    public static Hashtable<String, String> table;
	public static Object driver;

    public static Hashtable<String, String> getEnvDetails() {
        if (table == null) {
            table = new Hashtable<String, String>();
            if (ENV.equals("STAGE")) {
                
            	table.put("url", STAGE_HOMEPAGE_URL);
            	table.put("username", STAGE_USERNAME);
                table.put("password", STAGE_PASSWORD);
              //table.put("url", PROD_HOMEPAGE_URL);
                //table.put("url", UAT_HOMEPAGE_URL);
                //table.put("username", PROD_USERNAME);
               // table.put("password", PROD_PASSWORD);
             
            } else if (ENV.equals("UAT")) {
                table.put("url", UAT_HOMEPAGE_URL);
                table.put("username", UAT_USERNAME);
                table.put("password", UAT_PASSWORD);
            }
        }
        return table;
    }

    //Paths

    public static final String REPORTS_PATH = System.getProperty("user.dir") + "/Report/";



}
