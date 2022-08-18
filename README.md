# Reproducible steps

- Start up the application and call the dummy endpoint `curl localhost:8080/dummy`
- comment/uncomment the sleuth dependencies to see the difference in logging 


File logs:
```
// with sleuth
2022-08-18 15:39:03.822 severity= INFO [,,] PID=72750 [thread=main] [traceId=] [spanId=] logger="c.e.s.SleuthOverrideExampleApplication" Started SleuthOverrideExampleApplication in 1.857 seconds (JVM running for 7.377)
2022-08-18 15:39:14.447 severity= INFO [,3efb7f5d894cd734,3efb7f5d894cd734] PID=72750 [thread=http-nio-8080-exec-1] [traceId=3efb7f5d894cd734] [spanId=3efb7f5d894cd734] logger="o.a.c.c.C.[Tomcat].[localhost].[/]" Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-08-18 15:39:14.448 severity= INFO [,3efb7f5d894cd734,3efb7f5d894cd734] PID=72750 [thread=http-nio-8080-exec-1] [traceId=3efb7f5d894cd734] [spanId=3efb7f5d894cd734] logger="o.s.web.servlet.DispatcherServlet" Initializing Servlet 'dispatcherServlet'
2022-08-18 15:39:14.448 severity= INFO [,3efb7f5d894cd734,3efb7f5d894cd734] PID=72750 [thread=http-nio-8080-exec-1] [traceId=3efb7f5d894cd734] [spanId=3efb7f5d894cd734] logger="o.s.web.servlet.DispatcherServlet" Completed initialization in 0 ms
2022-08-18 15:39:14.462 severity= INFO [,3efb7f5d894cd734,3efb7f5d894cd734] PID=72750 [thread=http-nio-8080-exec-1] [traceId=3efb7f5d894cd734] [spanId=3efb7f5d894cd734] logger="c.e.s.DummyController" Here's a log line!

// without sleuth
2022-08-18 15:40:00.761 severity=INFO PID=72806 [thread=main] [traceId=] [spanId=] logger="c.e.s.SleuthOverrideExampleApplication" Started SleuthOverrideExampleApplication in 1.048 seconds (JVM running for 6.557)
2022-08-18 15:40:07.849 severity=INFO PID=72806 [thread=http-nio-8080-exec-1] [traceId=] [spanId=] logger="o.a.c.c.C.[Tomcat].[localhost].[/]" Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-08-18 15:40:07.849 severity=INFO PID=72806 [thread=http-nio-8080-exec-1] [traceId=] [spanId=] logger="o.s.web.servlet.DispatcherServlet" Initializing Servlet 'dispatcherServlet'
2022-08-18 15:40:07.850 severity=INFO PID=72806 [thread=http-nio-8080-exec-1] [traceId=] [spanId=] logger="o.s.web.servlet.DispatcherServlet" Completed initialization in 1 ms
2022-08-18 15:40:07.863 severity=INFO PID=72806 [thread=http-nio-8080-exec-1] [traceId=] [spanId=] logger="c.e.s.DummyController" Here's a log line!
```
- Sleuth overrides spring logging.pattern.level https://github.com/spring-cloud/spring-cloud-sleuth/blob/3.1.x/spring-cloud-sleuth-autoconfigure/src/main/java/org/springframework/cloud/sleuth/autoconfig/TraceEnvironmentPostProcessor.java#L47
