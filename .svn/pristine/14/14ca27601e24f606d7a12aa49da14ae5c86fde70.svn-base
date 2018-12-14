package com.glsx.oms.bigdata.admin.ap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glsx.oms.bigdata.admin.ap.util.DateUtil;
import com.glsx.oms.bigdata.admin.ap.util.OkHttpUtil;
import com.glsx.oms.bigdata.admin.ap.vo.RespMessage;

@RestController
@RequestMapping("/ddBox")
public class DDBOXController {

    @GetMapping("/version")
    public RespMessage version() {
        RespMessage rm = new RespMessage();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("cmd", "version");
        String result = OkHttpUtil.get("http://14.17.97.245:8809", paramMap);
        rm.setData(parseHtmlOfVersion(result));
        return rm;
    }

    public Map<String, Object> parseHtmlOfVersion(String html) {
        Document doc = Jsoup.parse(html);
        Elements div = doc.select("div");
        String text = div.text();
        int index1 = text.indexOf("服务器版本号");
        int index2 = text.indexOf("编译时间");
        String text1 = text.substring(index1 + 7, index2).trim();
        String text2 = text.substring(index2 + 5).trim();

        Map<String, Object> map = new HashMap<>();
        map.put("version", "服务器版本号:" + text1);
        try {
            String strDate = DateUtil.parseDateToStr(DateUtil.parseData(text2),
                    DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
            map.put("date", "编译时间:" + strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @GetMapping("/svrloading")
    public RespMessage svrloading() {
        RespMessage rm = new RespMessage();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("cmd", "svrloading");
        String result = OkHttpUtil.get("http://14.17.97.245:8809", paramMap);
        rm.setData(parseTableOfHtml(result));
        return rm;
    }

    @GetMapping("/channelstate")
    public RespMessage channelstate() {
        RespMessage rm = new RespMessage();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("cmd", "showchannelstate");
        String result = OkHttpUtil.get("http://14.17.97.245:8809", paramMap);
        rm.setData(parseTableOfHtml(result));
        return rm;
    }

    @GetMapping("/statiOnlineUsers")
    public RespMessage statiOnlineUsers() throws Exception {
        RespMessage rm = new RespMessage();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("opt", "100");
        String result = OkHttpUtil.get("http://14.17.97.245:60001/json/stati_online_users", paramMap);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(result, HashMap.class);

        Map<String, Object> resultMap = new HashMap<>();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        for (Object obj : (List) map.get("type_stati")) {
            Map m = (HashMap) obj;
            if (null != m.get("user_type")) {
                list1.add(obj);
            } else {
                list2.add(obj);
            }
        }
        resultMap.put("list1", list1);
        resultMap.put("list2", list2);
        resultMap.put("totalUsers", map.get("total_users"));
        rm.setData(resultMap);
        return rm;
    }

    public Map<String, Object> parseTableOfHtml(String html) {
        Map<String, Object> map = new HashMap<>();
        Document doc = Jsoup.parse(html);
        Elements trs = doc.select("table").select("tr");

        List<Map<String, String>> thList = new ArrayList<>();
        List<Map<String, Object>> tdList = new ArrayList<>();

        for (int i = 0; i < trs.size(); i++) {
            Elements ths = trs.get(i).select("th");
            if (ths.size() > 0) {
                for (int y = 0; y < ths.size(); y++) {
                    String text = ths.get(y).text();
                    Map<String, String> thMap = new HashMap<>();
                    thMap.put("columnEn", "column" + y);
                    thMap.put("columnCn", text);
                    thList.add(y, thMap);
                }
            }

            Elements tds = trs.get(i).select("td");
            if (tds.size() > 0) {
                Map<String, Object> tdMap = new HashMap<>();
                for (int j = 0; j < tds.size(); j++) {
                    String text = tds.get(j).text();
                    tdMap.put("column" + j, text);
                }
                tdList.add(tdMap);
            }
        }
        map.put("column", thList);
        map.put("list", tdList);
        return map;
    }
}
