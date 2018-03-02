package com.imooc.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by rj on 18/2/27.
 */
@Configuration
public class SessionFactoryConfiguration {
    //mybatis-config.xml文件路径
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;

    //mybatis  mapper 文件所在路径
    @Value("${mapper_path}")
    private String mapperPath;

    @Autowired
    @Qualifier("dataSource")  //按照名字加载dataSource
    private DataSource dataSource;

    //实体类所在的package
    @Value("${bean_package}")
    private String beanPackage;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置配置文件路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        //设置mapper文件路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_URL_PREFIX+mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置实体类的扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(beanPackage);
        return sqlSessionFactoryBean;

    }
}
