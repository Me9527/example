配置管理工具， 调用跟踪系统

http://localhost:2101/consumer2

// ----------------------------------------------------------------------------------
http://localhost:8000/myexample/log4j.do

http://localhost:8000/myexample/modules/module02/jsp/fileupload.jsp
http://localhost:8000/myexample/users/UserAction/getUserInfoDemoData.do
http://localhost:8000/myexample/users/UserAction/getUserInfo.do

//以下2个url演示在同一个类中，同时使用MVC URL注解 和 定制框架默认按模块吗+类名+方法名生成MVC URL功能
http://localhost:8000/myexample/modules/module02/actionTwo.do?username=zhouyunlong
http://localhost:8000/myexample/modules/module02/ActionTwo/getUserInfo.do

//以下3个url演示在同一个类中，同时使用MVC URL注解 和 定制框架默认按模块吗+类名+方法名生成MVC URL功能
http://localhost:8000/myexample/module02/actionTwo.do
http://localhost:8000/myexample/module02/ActionThree/getUserInfo.do?username=zhouyunlong
http://localhost:8000/myexample/module02/invokeService.do

http://localhost:8000/myexample/module01/ActionOne/index.do
http://localhost:8000/myexample/module01/ActionOne/greeting.do
http://localhost:8000/myexample/module01/ActionOne/addUser.do
http://localhost:8000/myexample/module01/ActionOne/testMybatis.do
http://localhost:8000/myexample/module01/ActionOne/testRibbonClient.do?param=test
http://localhost:8000/myexample/module01/ActionOne/testRibbonClient.do?param=accessAnotherService
http://localhost:8000/myexample/module01/ActionOne/testEurekaClient.do
http://localhost:8000/myexample/module01/ActionOne/testHystrix.do?uid=2&param=abc
http://localhost:8000/myexample/module01/ActionOne/testHystrix.do?uid=200&param=abc



//孙悟空可以访问module01和module02；猪八戒只能访问module01
http://localhost:8000/myexample/modules/module01/jsp/registration.jsp
http://localhost:8000/myexample/modules/module02/jsp/registration.jsp
http://localhost:8000/myexample/modules/module03/html/main.html

http://localhost:8000/myexample/modules/module01/jsp/page01.jsp
http://localhost:8000/myexample/modules/module01/html/main.html
// ----------------------------------------------------------------------------------



// springcloud-service-provide 演示url
localhost:2001/product/getProdut/2
localhost:2001/product/getAllProduct
localhost:2001/product/deleteProductById/2
localhost:2001/product/addProduct?name=abc&descrpit=one_product&price=8.8
localhost:2001/product/addProduct2?name=bbb&descript=3_product&price=2.8







Eureka 只能在一个region内做负载均衡，不能跨region。
 It's primary purpose of holding information is for load balancing within a region.
 in AWS, load balancing requires much more sophistication in registering and de-registering servers with load balancer on the fly. S
 There is one eureka cluster per region which knows only about instances in its region. There is at the least one eureka server per zone to handle zone failures.
 
 Services register with Eureka and then send heartbeats to renew their leases every 30 seconds. If the client cannot renew the lease for a few times,
 it is taken out of the server registry in about 90 seconds. The registration information and the renewals are replicated to all the eureka nodes in the cluster. 
 The clients from any zone can look up the registry information (happens every 30 seconds) to locate their services (which could be in any zone) and make remote calls.
 With Eureka you can add or remove cluster nodes on the fly. You can tune the internal configurations from timeouts to thread pools.
 
 Eureka client also searches for eureka-client-{test,prod}.properties.
 
 The Eureka Server will use its Eureka Client configuration to identify peer eureka server that have the same name (ie) eureka.name
 
 Eureka clients tries to talk to Eureka Server in the same zone. 
 If there are problems talking with the server or if the server does not exist in the same zone, the clients fail over to the servers in the other zones.
 
 appID is the name of the application and instanceID is the unique id associated with the instance. In AWS cloud, 
 instanceID is the instance id of the instance and in other data centers, it is the hostname of the instance.
 
 It is important to note that Eureka client cleans up the HTTP connections that have been idle for over 30 seconds that it created for the purpose of server communication. 
 This is because of the AWS firewall restrictions that do not allow traffic on to pass through a connection after a few minutes of idle time.
   
 client based load balancer  VS server based load balancer

如何配置多个zone

服务消费者和服务提供者分别属于哪个zone，均是通过eureka.instance.metadata-map.zone来判定的。
服务消费者会先通过ribbon去注册中心拉取一份服务提供者的列表，然后通过eureka.instance.metadata-map.zone指定的zone进行过滤，过滤之后如果同一个zone内的服务提供者有多个实例，则会轮流调用。
只有在同一个zone内的所有服务提供者都不可用时，才会调用其它zone内的服务提供者。








https://www.tutorialspoint.com/bootstrap/bootstrap_ajax_demo.htm

This information is kept in the file DispatcherServlet.properties in the package org.springframework.web.servlet

BeanFactoryUtils.beanNamesForTypeIncludingAncestors(getApplicationContext(), Object.class) 
RequestMappingHandlerMapping.initHandlerMethods()

MvcNamespaceHandler
AnnotationDrivenBeanDefinitionParser

mail, message, dubble, global session, log mgr, cache, security, web service, time task
Remote Fetch URL	https://github.com/Me9527/spring5


org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource
org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource

SET SQL_SAFE_UPDATES = 0;

$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.
	
$ redis-cli keys '*' | xargs redis-cli del
$ redis-cli del spring:session:sessions:7e8383a4-082c-4ffe-a4bc-c40fd3363c5e	
	
	
git clone https://github.com/webismymind/editablegrid.git	
	DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE
org.springframework.web.servlet.DispatcherServlet.CONTEXT
org.springframework.web.servlet.FrameworkServlet.CONTEXT.Spring_Web_MVC_Controller


https://mdbootstrap.com/previews/docs/latest/fonts/fontawesome-webfont.eot
https://mdbootstrap.com/previews/docs/latest/html/navigation/side-nav-fixed-navbar-fixed.html#

http://localhost:8000/aa/production/index.html

https://mdbootstrap.com/previews/docs/latest/fonts/fontawesome-webfont.eot
https://mdbootstrap.com/previews/docs/latest/html/navigation/side-nav-fixed-navbar-fixed.html#

http://localhost:8000/aa/production/index.html

cd K:\dir08\apache-tomcat-8.5.16

一个用户可以配置多个角色；一个角色下可以有多个菜单项，菜单项可以是树型结构；末级菜单项必须与某个具体的URL类型资源关联。
一个角色包含若干与之相关的受保护的资源（URL，Service）。


普通注册用户->查看用户详细信息，修改用户详细信息，修改登录密码，修改送货地址。
用户权限管理->用户锁定，查看角色，角色信息维护，查看资源，资源信息维护，配置菜单项，菜单配置，角色资源配置。
订单管理->...
org.springframework.cloud.netflix.ribbon.eureka.EurekaRibbonClientConfiguration

http://localhost:2101/consumer
http://localhost:1001/
http://localhost:2001/dc
{org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration$EurekaClientConfigurationRefresher=Generic bean: class [org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration$EurekaClientConfigurationRefresher$$EnhancerBySpringCGLIB$$e35b17ba]; scope=singleton; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null, defaultServletHandlerMapping=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$EnableWebMvcConfiguration; factoryMethodName=defaultServletHandlerMapping; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class], discoveryClientHealthIndicator=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.cloud.client.CommonsClientAutoConfiguration$DiscoveryLoadBalancerConfiguration; factoryMethodName=discoveryClientHealthIndicator; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/cloud/client/CommonsClientAutoConfiguration$DiscoveryLoadBalancerConfiguration.class], org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration$RefreshableEurekaClientConfiguration=Generic bean: class [org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration$RefreshableEurekaClientConfiguration$$EnhancerBySpringCGLIB$$41551f24]; scope=singleton; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null, inetUtils=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.cloud.commons.util.UtilAutoConfiguration; factoryMethodName=inetUtils; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/cloud/commons/util/UtilAutoConfiguration.class], restTemplate=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=springcloudServiceConsumerApplication; factoryMethodName=restTemplate; initMethodName=null; destroyMethodName=(inferred); defined in com.example.consumer.SpringcloudServiceConsumerApplication, observableMVCConfiguration=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.cloud.netflix.rx.RxJavaAutoConfiguration$RxJavaReturnValueHandlerConfig; factoryMethodName=observableMVCConfiguration; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/cloud/netflix/rx/RxJavaAutoConfiguration$RxJavaReturnValueHandlerConfig.class], refreshEventListener=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.cloud.autoconfigure.RefreshAutoConfiguration; factoryMethodName=refreshEventListener; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/cloud/autoconfigure/RefreshAutoConfiguration.class], characterEncodingFilter=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration; factoryMethodName=characterEncodingFilter; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/HttpEncodingAutoConfiguration.class], org.springframework.cloud.commons.httpclient.HttpClientConfiguration=Generic bean: class [org.springframework.cloud.commons.httpclient.HttpClientConfiguration$$EnhancerBySpringCGLIB$$3c3d0d5b]; scope=singleton; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null, preserveErrorControllerTargetClassPostProcessor=Root bean: class [org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=preserveErrorControllerTargetClassPostProcessor; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/ErrorMvcAutoConfiguration.class], org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration=Generic bean: class [org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration$$EnhancerBySpringCGLIB$$2bb264b2]; scope=singleton; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null, org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration=Generic bean: class [org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration$$EnhancerBySpringCGLIB$$44b2b001]; scope=singleton; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null, healthMvcEndpoint=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.actuate.autoconfigure.EndpointWebMvcManagementContextConfiguration; factoryMethodName=healthMvcEndpoint; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/actuate/autoconfigure/EndpointWebMvcManagementContextConfiguration.class], org.springframework.context.annotation.internalConfigurationAnnotationProcessor=Root bean: class [org.springframework.context.annotation.ConfigurationClassPostProcessor]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null, spring.metrics.export-org.springframework.boot.actuate.metrics.export.MetricExportProperties=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.actuate.autoconfigure.MetricExportAutoConfiguration$MetricExportPropertiesConfiguration; factoryMethodName=metricExportProperties; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/actuate/autoconfigure/MetricExportAutoConfiguration$MetricExportPropertiesConfiguration.class], propertiesFactory=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration; factoryMethodName=propertiesFactory; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/cloud/netflix/ribbon/RibbonAutoConfiguration.class], org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration=Generic bean: class [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$39ec2605]; scope=singleton; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null, propertySourcesPlaceholderConfigurer=Root bean: class [org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=propertySourcesPlaceholderConfigurer; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/context/PropertyPlaceholderAutoConfiguration.class], loggersMvcEndpoint=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.actuate.autoconfigure.EndpointWebMvcManagementContextConfiguration; factoryMethodName=loggersMvcEndpoint; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/actuate/autoconfigure/EndpointWebMvcManagementContextConfiguration.class], org.springframework.boot.actuate.autoconfigure.MetricExportAutoConfiguration$StatsdConfiguration=Generic bean: class [org.springframework.boot.actuate.autoconfigure.MetricExportAutoConfiguration$StatsdConfiguration$$EnhancerBySpringCGLIB$$637bf6f2]; scope=singleton; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null, faviconRequestHandler=Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factory...
[characterEncodingFilter, preserveErrorControllerTargetClassPostProcessor, org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration, propertySourcesPlaceholderConfigurer, metricsFilter, methodValidationPostProcessor, springClientFactory, default.org.springframework.cloud.netflix.ribbon.eureka.RibbonEurekaAutoConfiguration.RibbonClientSpecification, org.springframework.context.event.internalEventListenerFactory, configurationPropertiesBeans, spectatorRestTemplateInterceptorPostProcessor, org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration, org.springframework.cloud.autoconfigure.RefreshAutoConfiguration$RefreshScopeConfiguration, org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration, spring.mvc-org.springframework.boot.autoconfigure.web.WebMvcProperties, duplicateServerPropertiesDetector, conventionErrorViewResolver, org.springframework.context.event.internalEventListenerProcessor, localeCharsetMappingsCustomizer, multipartConfigElement, requestContextFilter, org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration, ribbon.eager-load-org.springframework.cloud.netflix.ribbon.RibbonEagerLoadProperties, org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat, spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties, webRequestLoggingFilter, traceRepository, refreshScope, org.springframework.boot.autoconfigure.condition.BeanTypeRegistry, embeddedServletContainerCustomizerBeanPostProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties, org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration, org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration$DispatcherServletConfiguration, org.springframework.boot.actuate.autoconfigure.TraceRepositoryAutoConfiguration, org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory, org.springframework.boot.actuate.autoconfigure.TraceWebFilterAutoConfiguration, errorAttributes, websocketContainerCustomizer, org.springframework.context.annotation.internalCommonAnnotationProcessor, org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration, serverProperties, org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration, httpPutFormContentFilter, org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration, hiddenHttpMethodFilter, spring.http.multipart-org.springframework.boot.autoconfigure.web.MultipartProperties, org.springframework.cloud.netflix.metrics.MetricsInterceptorConfiguration$MetricsRestTemplateConfiguration, org.springframework.scheduling.annotation.SchedulingConfiguration, endpoints.metrics.filter-org.springframework.boot.actuate.autoconfigure.MetricFilterProperties, org.springframework.context.annotation.internalScheduledAnnotationProcessor, dispatcherServlet, loadBalancerClient, default.org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration.RibbonClientSpecification, org.springframework.boot.actuate.autoconfigure.EndpointWebMvcAutoConfiguration$ApplicationContextFilterConfiguration, org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor, servoMetricsConfig, org.springframework.cloud.netflix.metrics.servo.ServoMetricsAutoConfiguration, errorPageRegistrarBeanPostProcessor, org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration, errorPageCustomizer, springcloudServiceConsumerApplication, org.springframework.context.annotation.internalRequiredAnnotationProcessor, applicationContextIdFilter, dispatcherServletRegistration, org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.store, tomcatEmbeddedServletContainerFactory, org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration$TomcatWebSocketConfiguration, management.trace-org.springframework.boot.actuate.trace.TraceProperties, servoMetricServices, monitorRegistry, dcController, org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration]

[characterEncodingFilter, preserveErrorControllerTargetClassPostProcessor, org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration, propertySourcesPlaceholderConfigurer, metricsFilter, methodValidationPostProcessor, springClientFactory, default.org.springframework.cloud.netflix.ribbon.eureka.RibbonEurekaAutoConfiguration.RibbonClientSpecification, org.springframework.context.event.internalEventListenerFactory, configurationPropertiesBeans, spectatorRestTemplateInterceptorPostProcessor, org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration, org.springframework.cloud.autoconfigure.RefreshAutoConfiguration$RefreshScopeConfiguration, org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration, spring.mvc-org.springframework.boot.autoconfigure.web.WebMvcProperties, duplicateServerPropertiesDetector, conventionErrorViewResolver, org.springframework.context.event.internalEventListenerProcessor, localeCharsetMappingsCustomizer, multipartConfigElement, requestContextFilter, org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration, ribbon.eager-load-org.springframework.cloud.netflix.ribbon.RibbonEagerLoadProperties, org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat, spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties, webRequestLoggingFilter, traceRepository, refreshScope, org.springframework.boot.autoconfigure.condition.BeanTypeRegistry, embeddedServletContainerCustomizerBeanPostProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties, org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration, org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration$DispatcherServletConfiguration, org.springframework.boot.actuate.autoconfigure.TraceRepositoryAutoConfiguration, org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory, org.springframework.boot.actuate.autoconfigure.TraceWebFilterAutoConfiguration, errorAttributes, websocketContainerCustomizer, org.springframework.context.annotation.internalCommonAnnotationProcessor, org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration, serverProperties, org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration, httpPutFormContentFilter, org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration, hiddenHttpMethodFilter, spring.http.multipart-org.springframework.boot.autoconfigure.web.MultipartProperties, org.springframework.cloud.netflix.metrics.MetricsInterceptorConfiguration$MetricsRestTemplateConfiguration, org.springframework.scheduling.annotation.SchedulingConfiguration, endpoints.metrics.filter-org.springframework.boot.actuate.autoconfigure.MetricFilterProperties, org.springframework.context.annotation.internalScheduledAnnotationProcessor, dispatcherServlet, loadBalancerClient, default.org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration.RibbonClientSpecification, org.springframework.boot.actuate.autoconfigure.EndpointWebMvcAutoConfiguration$ApplicationContextFilterConfiguration, org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor, servoMetricsConfig, org.springframework.cloud.netflix.metrics.servo.ServoMetricsAutoConfiguration, errorPageRegistrarBeanPostProcessor, org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration, errorPageCustomizer, springcloudServiceConsumerApplication, org.springframework.context.annotation.internalRequiredAnnotationProcessor, applicationContextIdFilter, dispatcherServletRegistration, org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.store, tomcatEmbeddedServletContainerFactory, org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration$TomcatWebSocketConfiguration, management.trace-org.springframework.boot.actuate.trace.TraceProperties, servoMetricServices, monitorRegistry, dcController, org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration]

2018-05-07 22:22:32.163  INFO 6436 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-05-07 22:22:32.164  INFO 6436 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-05-07 22:22:32.181  INFO 6436 --- [           main] .m.m.a.ExceptionHandlerExceptionResolver : Detected @ExceptionHandler methods in exceptionHandle
2018-05-07 22:22:32.205  INFO 6436 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-05-07 22:22:32.583  WARN 6436 --- [           main] arterDeprecationWarningAutoConfiguration : spring-cloud-starter-eureka is deprecated as of Spring Cloud Netflix 1.4.0, please migrate to spring-cloud-starter-netflix-eureka

@Configuration
@ConditionalOnClass({ IClient.class, RestTemplate.class, AsyncRestTemplate.class, Ribbon.class})
@RibbonClients
@AutoConfigureAfter(name = "org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration")
@AutoConfigureBefore({LoadBalancerAutoConfiguration.class, AsyncLoadBalancerAutoConfiguration.class})
@EnableConfigurationProperties({RibbonEagerLoadProperties.class, ServerIntrospectorProperties.class})
public class RibbonAutoConfiguration {



org.springframework.cloud.netflix.ribbon.eureka.EurekaRibbonClientConfiguration
'com.netflix.discovery.EurekaClient

	<context:component-scan base-package="org.springframework.cloud.netflix.eureka" />
	<context:component-scan base-package="org.springframework.cloud.netflix.ribbon.eureka" />
	<context:component-scan base-package="org.springframework.cloud.netflix.ribbon" />
	
	
	
com.netflix.loadbalancer.ZoneAvoidanceRule@4d732b07
com.netflix.niws.loadbalancer.NIWSDiscoveryPing@391f11d0
org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@7a3c67b9
ZonePreferenceServerListFilter{zone='defaultZone'}
com.netflix.loadbalancer.PollingServerListUpdater@592cdc8d





com.netflix.loadbalancer.ZoneAvoidanceRule@49a13ef7
com.netflix.loadbalancer.DummyPing@189c7aaa
com.netflix.loadbalancer.ConfigurationBasedServerList@33df0f35
ZonePreferenceServerListFilter{zone='null'}
com.netflix.loadbalancer.PollingServerListUpdater@464a3ebf
	
	
http://localhost:2001/user/getUser/2
http://localhost:2101/consumer
http://localhost:1001/
http://localhost:1001/health
	
log4j.rootCategory=INFO,stdout
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d %-5p %C:%L [%t] [%M] %m%n
	
There is one eureka cluster per region which knows only about instances in its region. There is at the least one eureka server per zone to handle zone failures.

sample-eureka-service.properties : 
###Eureka Client configuration for Sample Service that register with Eureka

# see the README in eureka-examples to see an overview of the example set up

## configurations related to self identification for registration.
## There are other properties that can be defined, see eureka-client/../CloudInstanceConfig for full details.
# where am I deployed?
eureka.region=default

# what is my application name? (clients can query on this appName)
eureka.name=sampleRegisteringService

# what is my application virtual ip address? (clients can query on this vipAddress)
eureka.vipAddress=sampleservice.mydomain.net

# what is the port that I serve on? (Change this if port 8001 is already in use in your environment)
eureka.port=8001

## configuration related to reaching the eureka servers
eureka.preferSameZone=true
eureka.shouldUseDns=false
eureka.serviceUrl.default=http://localhost:8080/eureka/v2/



//@EnableHystrixDashboard
@EnableCircuitBreaker

  <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE"/>
        <property name="locations">
            <list>
                <value>classpath*:modules/**/properties/*.properties</value>
            </list>
        </property>
    </bean>
    


注意，import命令具有提升效果，会提升到整个模块的头部，首先执行。
最后，import语句会执行所加载的模块，因此可以有下面的写法。
如果多次重复执行同一句import语句，那么只会执行一次，而不会执行多次。
import语句是 Singleton 模式
目前阶段，通过 Babel 转码，CommonJS 模块的require命令和 ES6 模块的import命令，可以写在同一个模块里面
export default就是输出一个叫做default的变量或方法，然后系统允许你为它取任意名字

// 函数声明
async function foo() {}

// 函数表达式
const foo = async function () {};

// 对象的方法
let obj = { async foo() {} };
obj.foo().then(...)

// Class 的方法
class Storage {
  constructor() {
    this.cachePromise = caches.open('avatars');
  }

  async getAvatar(name) {
    const cache = await this.cachePromise;
    return cache.match(`/avatars/${name}.jpg`);
  }
}

const storage = new Storage();
storage.getAvatar('jake').then(…);

// 箭头函数
const foo = async () => {};

throw new Error('出错了');

async function f() {
  await Promise.reject('出错了');
}

f()
.then(v => console.log(v))
.catch(e => console.log(e))
// 出错了

// 写法一
let [foo, bar] = await Promise.all([getFoo(), getBar()]);

// 写法二
let fooPromise = getFoo();
let barPromise = getBar();
let foo = await fooPromise;
let bar = await barPromise;

上面两种写法，getFoo和getBar都是同时触发，这样就会缩短程序的执行时间


  let docs = [{}, {}, {}];
  let promises = docs.map((doc) => db.post(doc));
  
一句话，defer是“渲染完再执行”，async是“下载完就执行”。另外，如果有多个defer脚本，会按照它们在页面出现的顺序加载，而多个async脚本是不能保证加载顺序的。
一般来说，调用resolve或reject以后，Promise 的使命就完成了，后继操作应该放到then方法里面，而不应该直接写在resolve或reject的后面。所以，最好在它们前面加上return语句，这样就不会有意外。
Promise 内部的错误不会影响到 Promise 外部的代码，通俗的说法就是“Promise 会吃掉错误
需要注意的是，立即resolve()的 Promise 对象，是在本轮“事件循环”（event loop）的结束时执行，而不是在下一轮“事件循环”的开始时。  


对象中的扩展运算符(...)用于取出参数对象中的所有可遍历属性，拷贝到当前对象之中

我们知道，this关键字总是指向函数所在的当前对象，ES6 又新增了另一个类似的关键字super，指向当前对象的原型对象。

对象解构赋值：
let obj = { a: { b: 1 } };
let { ...x } = obj;
obj.a.b = 2;
x.a.b // 2

静态字符串一律使用单引号或反引号，不使用双引号。动态字符串使用反引号。

注意区分 Object 和 Map，只有模拟现实世界的实体对象时，才使用 Object。如果只是需要key: value的数据结构，使用 Map 结构。因为 Map 有内建的遍历机制。




 node_modules/.bin/vue-cli-service serve


		