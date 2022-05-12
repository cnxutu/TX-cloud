
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

