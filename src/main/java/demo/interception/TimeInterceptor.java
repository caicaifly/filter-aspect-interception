package demo.interception;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: filter-aspect-interception
 * @Package: demo.interception
 * @Description: note
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-27 9:28
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-27 9:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/
@Component
public class TimeInterceptor implements HandlerInterceptor {
    /**
     *进入被拦截的方法体之前执行
     * @return 返回结果为false：不执行postHandle和afterCompletion
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle start");
        // 将开始时间添加到requestWebConfig
        request.setAttribute("start",new Date().getTime());

        HandlerMethod object = (HandlerMethod)handler;
        // 被过滤的方法
        Method method = object.getMethod();
        // 被过滤的对象
        Object bean = object.getBean();
        System.out.println(method.getName());
        System.out.println(bean.getClass());
        return true;
    }

    /**
     *进入被拦截的方法体之后执行（一旦方法体中有异常，不执行）
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        // 获取开始时间
        long start = (long)request.getAttribute("start");
        System.out.println("postHandle start");
        // 将开始时间从request移去
        request.removeAttribute("start");
        System.out.println("TimeInterceptor耗时：" + (new Date().getTime() - start));

    }

    /**
     *进入被拦截的方法体之后执行（始终进入）
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("postHandle afterCompletion");

    }
}
