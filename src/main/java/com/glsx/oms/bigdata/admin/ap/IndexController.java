//package com.glsx.oms.bigdata.admin.ap;
//
//import java.util.Map;
//
//import org.oreframework.web.ui.ResultEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.glsx.oms.bigdata.admin.ap.framework.StaticProperty;
//
//
//@Controller
//class IndexController
//{
//    @Autowired
//    private StaticProperty staticProperty;
//    
//    @RequestMapping("/")
//    public String index(Map<String, Object> model)
//    {
//        model.put("cdnPath", staticProperty.getResource());
//        return "index";
//    }
//    
////    @RequestMapping("/")
////	@ResponseBody
////	public ResultEntity<String> index(){
////    	ResultEntity<String> result = new ResultEntity<String>();
////    	result.setReturnCode("-200");
////    	result.setMessage("数据接口登录成功，请重新获取数据");
////    	return result;
////	}
//}