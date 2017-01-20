package com.zaihua.models.base;

import com.zaihua.service.XQUrlLib;
import com.zaihua.utils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

public final class DefaultContant {
    private static String fileName = "default.properties";

    private static String xq_user = PropertyUtils.getValue("xq_user", fileName);
    private static String xq_psw = PropertyUtils.getValue("xq_psw", fileName);
    private static String xq_cookie;

    public static String getXq_cookie() {


        if (StringUtils.isBlank(xq_cookie)) {
            xq_cookie = XQUrlLib.login(xq_user, xq_psw);

           /* xq_cookie = PropertyUtils.getValue("xq_cookie", fileName);

            if (StringUtils.isBlank(xq_cookie)) {

            }*/
        }

        return xq_cookie;
    }

    public static String getPsw() {
        return xq_psw;
    }

    public static String getUser() {
        return xq_user;
    }
}
