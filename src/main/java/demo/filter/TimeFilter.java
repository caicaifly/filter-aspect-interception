package demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: filter-aspect-interception
 * @Package: demo.filter
 * @Description: note
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-27 9:12
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-27 9:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/

/**
 * 另一中添加过滤器的方式，可以配置多个过滤器
 *      在过滤器上增加：@WebFilter(filterName = "myFilter", urlPatterns = "/*")
 *      在启动类上增加： @ServletComponentScan("demo.filter") //filter扫描路径
 */
@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TimeFilter start");
        // 开始时间
        long start = new Date().getTime();
        // 过滤的实际业务
        filterChain.doFilter(servletRequest,servletResponse);
        // 结束时间
        long end = new Date().getTime();
        System.out.println("过滤用时：" + (end - start)+" 毫秒");
        System.out.println("TimeFilter end");
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter destroy");
    }
}
