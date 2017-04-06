package rest;

import remote.SOService;

/**
 * Created by PriyaPC on 05-04-2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://schooper.in:3004/api/v1/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
