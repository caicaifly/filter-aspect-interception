package demo.interception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: filter-aspect-interception
 * @Package: demo.interception
 * @Description: note
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-27 9:43
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-27 9:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/
@Deprecated
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Resource
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(timeInterceptor);
    }
}
