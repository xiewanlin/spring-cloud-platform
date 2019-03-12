1.首先启动服务注册中心：eureka-service   http://localhost:8761

2.启动配置中心：config-service  http://localhost:8888

3.启动网关：gateway  http://localhost:8080

4.启动鉴权中心：security-service  http://localhost:9999   直接获取toke，path为/oauth/token，即http://localhost:9999/oauth/token

5.启动微服，注册一个简单的服务：eureka-client  http://localhost:8762   直接调用服务，path为/query/xwl/hello，即http://localhost:8762/query/xwl/hello


鉴权网关地址：http://localhost:8080/security-service
通过网关跳转到鉴权中心:http://localhost:8080/security-service/oauth/token

微服网关地址： http://localhost:8080/service
通过网关转发到微服 http://localhost:8080/service/query/xwl/hello


