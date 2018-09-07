package com.mdx.admin.provider.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
// 扫描 Mapper 接口并容器管理
public class DruidDataSourceConfig {

    @Autowired
    private Environment env;// 配置文件

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        dataSource.setInitialSize(Integer.parseInt(env.getProperty("spring.datasource.druid.initialSize")));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("spring.datasource.druid.maxActive")));

        dataSource.setMinIdle(Integer.parseInt(env.getProperty("spring.datasource.druid.minIdle")));
        dataSource.setMaxWait(Long.parseLong(env.getProperty("spring.datasource.druid.maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getProperty("spring.datasource.druid.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(env.getProperty("spring.datasource.druid.minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery((env.getProperty("spring.datasource.druid.validationQuery")));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("spring.datasource.druid.testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("spring.datasource.druid.testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.parseBoolean(env.getProperty("spring.datasource.druid.testOnReturn")));
        dataSource.setPoolPreparedStatements(Boolean.parseBoolean(env.getProperty("spring.datasource.druid.poolPreparedStatements")));
        dataSource.setMaxOpenPreparedStatements(Integer.parseInt(env.getProperty("spring.datasource.druid.maxOpenPreparedStatements")));

        dataSource.setRemoveAbandoned(Boolean.parseBoolean(env.getProperty("spring.datasource.druid.removeAbandoned")));
        dataSource.setLogAbandoned(Boolean.parseBoolean(env.getProperty("spring.datasource.druid.logAbandoned")));
        dataSource.setRemoveAbandonedTimeout(Integer.parseInt(env.getProperty("spring.datasource.druid.removeAbandonedTimeout")));
        try {
            dataSource.setFilters(env.getProperty("spring.datasource.druid.filters"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "dataSourceSqlSessionFactory")
    public SqlSessionFactory dataSourceSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DruidDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", env.getProperty("spring.datasource.druid.loginUserName"));
        reg.addInitParameter("loginPassword", env.getProperty("spring.datasource.druid.loginPassword"));
        reg.addInitParameter("logSlowSql", env.getProperty("spring.datasource.druid.logSlowSql"));
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

}