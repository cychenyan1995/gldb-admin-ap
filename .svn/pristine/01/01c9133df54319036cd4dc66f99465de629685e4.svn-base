package com.glsx.oms.bigdata.admin.ap.framework;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("static")
public class StaticProperty
{
    private static Logger logger = Logger.getLogger(StaticProperty.class);
    private String resource;
    
    public String getResource()
    {
        logger.debug(resource);
        return resource;
    }
    
    public void setResource(String resource)
    {
        this.resource = resource;
    }
    
}
