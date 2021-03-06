package com.zaihua.service; /**
 * @author : zaihua.chen
 * @version : 1.0.0
 * @since : 2016/11/28 11:12
 */
import com.google.common.collect.Maps;

import com.zaihua.utils.HttpClientUtils;
import com.zaihua.utils.Md5Utils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

import java.util.Map;

public class XQUrlLib {
    public static String getCompanyInfo(String symbol, String cookie) {
        long timeStemp = System.currentTimeMillis();
        String url = "https://xueqiu.com/stock/f10/compinfo.json?";
        url += "symbol="+symbol;
        url += "&page=1&size=5&_=" + String.valueOf(timeStemp);

        Map<String, String> headers = Maps.newHashMap();
        headers.put("Host", "xueqiu.com");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
        headers.put("Cookie", cookie);

        return HttpClientUtils.getWithHeader(url, headers);
    }

    public static String searchComps(String code, String cookie) {
        long timeStemp = System.currentTimeMillis();
        String url = "https://xueqiu.com/stock/search.json?";
        url += "code="+code;
        url += "&size=5&_=" + String.valueOf(timeStemp);

        Map<String, String> headers = Maps.newHashMap();
        headers.put("Host", "xueqiu.com");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
        headers.put("Cookie", cookie);

        return HttpClientUtils.getWithHeader(url, headers);
    }

    public static String getFinmainIndex(String symbol, String cookie, int page) {
        long timeStemp = System.currentTimeMillis();
        String url = "https://xueqiu.com/stock/f10/finmainindex.json?";
        url += "symbol="+symbol;
        url += "&page=" + page;
        url += "&size=8&_=" + String.valueOf(timeStemp);

        Map<String, String> headers = Maps.newHashMap();
        headers.put("Host", "xueqiu.com");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
        headers.put("Cookie", cookie);

        return HttpClientUtils.getWithHeader(url, headers);
    }

    public static String login(String phone, String psw) {
        String cookie = "";
        String url = "https://xueqiu.com/user/login";

        Map<String, String> headers = Maps.newHashMap();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Host", "xueqiu.com");
        headers.put("Origin", "https://xueqiu.com");
        headers.put("Referer", "https://xueqiu.com/");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");

        Map<String, String> maps = Maps.newHashMap();
        maps.put("areacode", "86");
        maps.put("password", Md5Utils.md5Encode(psw));
        maps.put("remember_me", "on");
        maps.put("telephone", phone);

        HttpResponse response = HttpClientUtils.postMapAndHeaderForResponse(url, headers, maps);
        Header[] hs = response.getHeaders("set-cookie");

        for (Header h : hs) {
            cookie = cookie + h.getValue().split(";")[0] + ";";
        }

        return cookie;
    }
}
