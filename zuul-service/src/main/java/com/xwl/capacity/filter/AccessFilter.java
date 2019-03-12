package com.xwl.capacity.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器的类型 pre表示请求在路由之前被过滤
     * @return 类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * @return 顺序 数字越大表示优先级越低，越后执行
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 过滤器是否会被执行
     * @return true
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        return request.getRequestURI().indexOf("security-service") != 1;
    }

    /**
     * 过滤逻辑
     * @return 过滤结果
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String accessToken = request.getHeader("Authorization");
        String url = request.getRequestURI();

        if (accessToken==null){
            logger.error("Authorization token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("Authorization token is empty");
            return null;
        } else {
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);

            /**
             * 连接redis获取token,进行验证
             */
            logger.info("Authorization token is ok");

            /**
             * 灰度发布
             * jar包:ribbon-discovery-filter-spring-cloud-starter:2.1.0
             * 配置文件metadata-map：eureka.instance.metadata-map.gated-launch=false
             * 即：所有节点发布后，默认灰度模式为false。然后把特定的灰度机器上的配置，该参数改成true（表明这台机器是用于灰度验证的）
             */
//            RibbonFilterContextHolder.clearCurrentContext();
//            if (token.equals("1234567890")) {
//                RibbonFilterContextHolder.getCurrentContext().add("gated-launch", "true");
//            } else {
//                RibbonFilterContextHolder.getCurrentContext().add("gated-launch", "false");
//            }
        }
        return null;
    }
}
