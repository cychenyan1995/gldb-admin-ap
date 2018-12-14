package com.glsx.oms.bigdata.admin.ap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.oreframework.web.ui.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * @Title: ExceptionController.java
 * @Description: 异常控制器
 * @author Alvin
 * @date 2018年9月4日 下午3:16:05
 * @version V1.0
 * @Company: didihu.com.cn
 * @Copyright Copyright (c) 2018
 */
//@Controller
//@EnableConfigurationProperties({ServerProperties.class})
public class ExceptionController implements ErrorController {
	
    private static final String ERROR_PATH = "/error";
	
	private ErrorAttributes errorAttributes;
	@Autowired
	private ServerProperties serverProperties;

	@Autowired
	public ExceptionController(ErrorAttributes errorAttributes) {
		Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping(value = ERROR_PATH)
	@ResponseBody
	public ResultEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
		HttpStatus status = getStatus(request);
		ResultEntity<Map<String, Object>> result = new ResultEntity<>();
		result.setReturnCode(status.toString());
		result.setMessage(status.name());
		result.setData(body);
		return result;
	}

	protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
		ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
		if (include == ErrorProperties.IncludeStacktrace.ALWAYS) { return true; }
		if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) { return getTraceParameter(request); }
		return false;
	}

	/**
	 * 获取错误的信息
	 * 
	 * @param request
	 * @param includeStackTrace
	 * @return
	 */
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
	}

	/**
	 * 是否包含trace
	 * 
	 * @param request
	 * @return
	 */
	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) { return false; }
		return !"false".equals(parameter.toLowerCase());
	}

	/**
	 * 获取错误编码
	 * 
	 * @param request
	 * @return
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) { return HttpStatus.INTERNAL_SERVER_ERROR; }
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
