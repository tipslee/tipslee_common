package com.jd.innovation.common.web;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by cdyuanlifei on 2016/7/25.
 */
public class BaseController {
    private static Log log = LogFactory.getLog(BaseController.class);

    public BaseController() {
    }

    /**
     * 以json形式输出页面
     * @param response
     * @param jsonString
     */
    protected void sendJson(HttpServletResponse response, String jsonString) {
        try {
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            response.getWriter().print(jsonString);
        } catch (Exception e) {
            log.error("Fail to write json into response.", e);
        }
    }

    /**
     * 以json形式输出页面
     * @param response
     * @param object
     */
    protected void sendJson(HttpServletResponse response, Object object) {
        try {
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            String e = JSONObject.toJSONString(object);
            response.getWriter().print(e);
        } catch (Exception e) {
            log.error("Fail to write json into response.", e);
        }
    }

    /**
     * 以html文本类型输出页面
     * @param response
     * @param htmlString
     */
    protected void sendHtml(HttpServletResponse response, String htmlString) {
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.getWriter().print(htmlString);
        } catch (Exception e) {
            log.error("Fail to write html into response.", e);
        }
    }

    /**
     * 获取ModelAndView
     * @param uri
     * @param model
     * @return
     */
    public ModelAndView view(String uri, Model model) {
        return new ModelAndView(this.view(uri), model.asMap());
    }

    public String view(String vmName) {
        return this.getControllerMapping() + vmName;
    }

    public String getControllerMapping() {
        Object obj = AnnotationUtils.getValue(this.getClass().getAnnotation(RequestMapping.class), "value");
        if (obj != null && obj.getClass().isArray()) {
            String[] mapping = (String[]) ((String[]) obj);
            if (mapping.length > 0) {
                return mapping[0];
            }
        }

        return "";
    }


}
