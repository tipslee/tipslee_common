package com.jd.innovation.common.test.controller;

import com.jd.innovation.common.test.transaction.MyBusiness;
import com.jd.innovation.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cdyuanlifei on 2016/7/26.
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    @Resource
    MyBusiness myBusiness;

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(HttpServletResponse response) {
        return "index";
    }

    @RequestMapping(value = "/addSurvey", method = {RequestMethod.POST, RequestMethod.GET})
    public void addSurvey(HttpServletResponse response) {
        myBusiness.addSurvey(null);
    }

//    @RequestMapping(value = "/json", method = {RequestMethod.POST, RequestMethod.GET})
//    public void json(HttpServletResponse response) {
//        JSONResult result;
//        HashMap<String, String> hashMap = new HashMap<String, String>();
//        result = JSONResult.success("User message.", hashMap);
//        sendJson(response, result);
//    }
//
//    @RequestMapping(value = "/html", method = {RequestMethod.POST, RequestMethod.GET})
//    public void html(HttpServletResponse response) {
//        JSONResult result;
//        HashMap<String, String> hashMap = new HashMap<String, String>();
//        result = JSONResult.success("User message.", hashMap);
//
//        sendHtml(response, getControllerMapping());
//    }
//
//    @RequestMapping(value = "/testCsrfInterceptorIndex", method = {RequestMethod.POST, RequestMethod.GET})
//    public String testCsrfInterceptorIndex(HttpServletResponse response) {
//        return "testCsrfInterceptorPage";
//    }
//
//
//    /**
//     * CSRF安全检测拦截器测试
//     *
//     * @param response
//     */
////    @WithoutCsrfSecurityCheck
//    @RequestMapping(value = "/testCsrfInterceptor", method = {RequestMethod.POST, RequestMethod.GET})
//    public void testCSRFInterceptor(HttpServletResponse response) {
//        JSONResult result = JSONResult.success();
//
//        sendJson(response, result);
//    }
//
//    @RequestMapping(value = "/testXssInterceptorIndex", method = {RequestMethod.POST, RequestMethod.GET})
//    public String testXssInterceptorIndex(HttpServletResponse response) {
//        return "testXssInterceptorPage";
//    }
//
//
//    /**
//     * XSS安全检测拦截器测试
//     *
//     * @param response
//     */
//    @XssSecurityCheck({"src=","src2=(.*)","<img(.*)>"})
////    @WithoutXssSecurityCheck
//    @RequestMapping(value = "/testXssInterceptor", method = {RequestMethod.POST, RequestMethod.GET})
//    public void testXssInterceptor(HttpServletResponse response) {
//        JSONResult result = JSONResult.success();
//
//        sendJson(response, result);
//    }
//
//    /**
//     * ErpLoginInterceptor测试
//     *
//     * @param response
//     */
//    @RequestMapping(value = "/testErpLogin", method = {RequestMethod.POST, RequestMethod.GET})
//    public void testErpLogin(HttpServletResponse response) {
//        JSONResult result = JSONResult.success();
//
//        sendJson(response, result);
//    }
//
//    /**
//     * SsoErpLoginInterceptor测试
//     *
//     * @param response
//     */
//    @RequestMapping(value = "/testSsoErpLogin", method = {RequestMethod.POST, RequestMethod.GET})
//    public void testSsoErpLogin(HttpServletResponse response) {
//        JSONResult result = JSONResult.success();
//
//        sendJson(response, result);
//    }
//
//    /**
//     * PassportLoginInterceptor测试
//     *
//     * @param response
//     */
//    @RequestMapping(value = "/testPassportLogin", method = {RequestMethod.POST, RequestMethod.GET})
//    public void testPassportLogin(HttpServletResponse response) {
//        JSONResult result = JSONResult.success();
//
//        sendJson(response, result);
//    }


}
