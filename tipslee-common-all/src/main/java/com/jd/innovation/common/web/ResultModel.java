package com.jd.innovation.common.web;

import com.alibaba.fastjson.JSON;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * Created by cdchenhui1 on 2018/1/6.
 */
public class ResultModel extends ModelMap {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_ERROR_CODE = "-1";

    private boolean result = true;

    private String msg;

    private String code;

    public ResultModel() {

    }

    public ResultModel addAttribute(String name, Object value) {
        super.addAttribute(name, value);
        return this;
    }

    public ResultModel fail(String msg) {
        this.result = false;
        this.msg = msg;
        this.code=DEFAULT_ERROR_CODE;
        return this;
    }

    public ResultModel fail(String code,String msg) {
        this.result = false;
        this.msg = msg;
        this.code=code;
        return this;
    }

    public boolean isResult() {
        return result;
    }


    public String getJsonResult() {
        ResultMsg message = new ResultMsg(this.result , this.code , this.msg , this);
        return JSON.toJSONString(message);
    }

    public String getDateFormateJsonResult() {
        ResultMsg message = new ResultMsg(this.result , this.code ,this.msg , this);
        return JSON.toJSONStringWithDateFormat(message, "yyyy-MM-dd HH:mm:ss");
    }

    public static void main(String[] args) {
        ResultModel resultModel = new ResultModel();
//        resultModel.fail("scdjlaksjf");
        resultModel.addAttribute("css", "sdf");
        System.out.println(resultModel.getJsonResult());

        ResultModel rs=new ResultModel();
        rs.fail("ss");
        System.out.println(rs.getJsonResult());
    }
}

class ResultMsg {

    private boolean result = false;
    private String msg;
    private String code;
    private Map<String, Object> resultData;


    ResultMsg(boolean result , String code ,String msg , Map<String , Object> resultData) {
        this.result = result;
        this.code = code;
        this.msg = msg;
        this.resultData = resultData;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode(){ return  code; }

    public Map<String, Object> getResultData() {
        return CollectionUtils.isEmpty(resultData) ? null : resultData;
    }

}

