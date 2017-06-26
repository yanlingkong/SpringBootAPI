package com.hurongsoft.controller;

import com.hurongsoft.configuration.properties.ShortUrlProperties;
import com.hurongsoft.model.JsonResult;
import com.hurongsoft.utils.WebClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/common")
@Slf4j
public class CommonApi {

    @Autowired
    private ShortUrlProperties shortUrlProperties;

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public JsonResult getUser(@PathVariable Long id) {
        JsonResult ret = new JsonResult();
        ret.setCode("101");
        ret.setMsg("成功");
        ret.setSuccess(true);
        ret.setData("123");
        return ret;
    }

    @ApiOperation(value = "登录", notes = "登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, paramType = "form", dataType = "String")})
    @PostMapping(value = "/login")
    public JsonResult login(@RequestParam String userName, @RequestParam String password, @RequestParam String code) {
        Map<String, String> map = new HashMap<>();
        map.put("userName", userName);
        map.put("password", password);
        map.put("code", code);
        JsonResult ret = new JsonResult();
        ret.setCode("101");
        ret.setMsg("成功");
        ret.setSuccess(true);
        ret.setData(map);
        return ret;
    }

    @ApiOperation(value = "查看", notes = "查看", produces = MediaType.ALL_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "姓名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sex", value = "性别", required = true, paramType = "query", dataType = "String")})
    @GetMapping(value = "/perQueryList")
    public String perQueryList(@RequestParam String userName,
                               @RequestParam String age,
                               @RequestParam String sex) {
//        String url = "http://172.16.10.4:9090/hurong_erp_sm_bzxt/creditFlow/customer/person/perQueryListPerson.do";
//        Map<String, String> map = new HashMap<>();
//        map.put("isAll", "true");
//        map.put("userName",userName);
//        map.put("age",age);
//        map.put("sex",sex);
//        return WebClient.doPost(map, url, "utf-8");
        return "success";
    }

    @ApiOperation(value = "获取短网址", notes = "获取短网址", produces = MediaType.ALL_VALUE)
    @ApiImplicitParam(name = "url", value = "链接", required = true, dataType = "String", paramType = "query")
    @GetMapping("/shortUrl")
    public String shortUrl(String url) {
        if (StringUtils.isNotEmpty(url)) {
//            HttpResponse response = HttpRequest.get("http://api.weibo.com/2/short_url/shorten.json")
//                    .query("source", "5786724301")
//                    .query("url_long", url).send();
//            if (response.statusCode() == HttpStatus.SC_OK) {
//                JSONObject json = (JSONObject) JSONObject.parse(response.bodyText());
//                return json.getJSONArray("urls").getJSONObject(0).getString("url_short");
//            }
            Map<String, String> params = new HashMap<>();
            params.put("source",shortUrlProperties.getSource());
            params.put("url_long", url);
            return WebClient.doPost(params, shortUrlProperties.getUrl(), "UTF-8");
        }
        return null;
    }
}
