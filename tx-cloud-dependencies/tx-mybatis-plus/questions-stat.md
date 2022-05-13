
#1. 依赖注入问题
``
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'orderMapper' 
defined in file [/TX-cloud/tx-cloud-demo/tx-mybatis-plus/target/classes/com/example/mybatis/mapper/OrderMapper.class]: 
Unsatisfied dependency expressed through bean property 'sqlSessionFactory'; 
nested exception is org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'sqlSessionFactory' defined in class path resource [com/baomidou/mybatisplus/autoconfigure/MybatisPlusAutoConfiguration.class]: 
Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.apache.ibatis.session.SqlSessionFactory]: 
Factory method 'sqlSessionFactory' threw exception; nested exception is java.lang.NoClassDefFoundError: org/mybatis/logging/LoggerFactory
``
**Factory method 'sqlSessionFactory' threw exception; nested exception is java.lang.NoClassDefFoundError: org/mybatis/logging/LoggerFactory**

解决办法： 
1.定位问题的所在，mybatis plus 的bean注入问题；
2. 定位到，本项目中关于引入了父包的依赖后，就会引发该问题，经过排查后，发现去除mybatis plus无关的其它依赖引入，项目即可正常启动运行

