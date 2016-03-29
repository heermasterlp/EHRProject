package com.um.ehr.action;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;

import sun.net.www.content.text.plain;

import com.opensymphony.xwork2.ActionSupport;

public class PredictAciton extends ActionSupport implements ServletRequestAware{
	
	private static Logger logger = Logger.getLogger("com.um.ehr.action.PredictAciton"); 
	
	 private static final long serialVersionUID = 1L;
     
	 private HttpServletRequest request;
	 
	 private String result;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	/**
     * Predict medicines
     * @return SUCCESS
     */
    public String excuteAjax(){
        try {
            //获取数据
            String batch = request.getParameter("batch");
            double threshold = Double.valueOf(request.getParameter("threshold"));
            String timestatus = request.getParameter("timestatus");
            String xu = request.getParameter("xu");
            String tanyu = request.getParameter("tanyu");
            String tanshi = request.getParameter("tanshi");
            String zhengxing = request.getParameter("zhengxing");
            String sputumamount = request.getParameter("sputumamount");
            String sputumcolor = request.getParameter("sputumcolor");
            String cough = request.getParameter("cough");
            String pulse = request.getParameter("pulse");
            String na = request.getParameter("na");
            String defecate = request.getParameter("defecate");
            String constipation = request.getParameter("constipation");
            String urinate = request.getParameter("urinate");
            String xonglei = request.getParameter("xonglei");
            String futong = request.getParameter("futong");
            String tengtong = request.getParameter("tengtong");
            String bodydiscomfort = request.getParameter("bodydiscomfort");
            String tonguecolor = request.getParameter("tonguecolor");
            String coatedtongue = request.getParameter("coatedtongue");
            String energy = request.getParameter("energy");
            String sleep = request.getParameter("sleep");
            String hanre = request.getParameter("hanre");
            String sweat = request.getParameter("sweat");
            String thirst = request.getParameter("thirst");
            String taste = request.getParameter("taste");
            
            logger.info("batch: " + batch);
            //将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
            
            
            /**
             * 1. Parse request parameters
             */
            String diagnose = "";
            String description = "";
            
            diagnose = zhengxing + (tanyu.equals("yes") ? "痰瘀," : "") + (tanshi.equals("yes") ? "痰湿,":"") + xu;
            
            description = sputumamount + "," + sputumcolor + "," + cough + "," + pulse + na + "," 
            				+ defecate + "," + constipation + "," + urinate + "," + xonglei + ","
            				+ futong + "," + tengtong + bodydiscomfort + tonguecolor + "," 
            				+ coatedtongue + "," + energy + "," + sleep + "," + hanre + ","
            				+ sweat + "," + thirst + "," + taste;
            
            /**
             * 2. Predict medicines based on statistics method
             */
            
            /**
             * 3. Predict medicines based on machine learning method
             */
            
            /**
             * 4. Predict medicines based on rules
             */
            
            /**
             * 5. Return result
             */
            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("batch", batch);
//            map.put("threshold", threshold);
//            map.put("timestatus", timestatus);
//            map.put("xu", xu);
//            map.put("tanyu", tanyu);
//            map.put("tanshi", tanshi);
//            map.put("zhengxing", zhengxing);
//            map.put("sputumamount", sputumamount);
//            map.put("sputumcolor", sputumcolor);
//            map.put("cough", cough);
//            map.put("pulse", pulse);
//            map.put("na", na);
//            map.put("defecate", defecate);
//            map.put("constipation", constipation);
//            map.put("urinate", urinate);
//            map.put("xonglei", xonglei);
//            map.put("futong", futong);
//            map.put("tengtong", tengtong);
//            map.put("bodydiscomfort", bodydiscomfort);
//            map.put("tonguecolor", tonguecolor);
//            map.put("coatedtongue", coatedtongue);
//            map.put("energy", energy);
//            map.put("sleep", sleep);
//            map.put("hanre", hanre);
//            map.put("sweat", sweat);
//            map.put("thirst", thirst);
//            map.put("taste", taste);
            
            map.put("diagnose", diagnose);
            map.put("description", description);
            
            JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
            result = json.toString();//给result赋值，传递给页面
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
	
	
}
