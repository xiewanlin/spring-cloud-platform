1.������������ע�����ģ�eureka-service   http://localhost:8761

2.�����������ģ�config-service  http://localhost:8888

3.�������أ�gateway  http://localhost:8080

4.������Ȩ���ģ�security-service  http://localhost:9999   ֱ�ӻ�ȡtoke��pathΪ/oauth/token����http://localhost:9999/oauth/token

5.����΢����ע��һ���򵥵ķ���eureka-client  http://localhost:8762   ֱ�ӵ��÷���pathΪ/query/xwl/hello����http://localhost:8762/query/xwl/hello


��Ȩ���ص�ַ��http://localhost:8080/security-service
ͨ��������ת����Ȩ����:http://localhost:8080/security-service/oauth/token

΢�����ص�ַ�� http://localhost:8080/service
ͨ������ת����΢�� http://localhost:8080/service/query/xwl/hello


