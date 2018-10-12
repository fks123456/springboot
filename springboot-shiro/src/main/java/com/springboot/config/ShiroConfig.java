package com.springboot.config;

import com.springboot.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public UserRealm getRealm() {
        return new UserRealm();
    }

    @Bean
    public SecurityManager getSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());

        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/main.html");
        // shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized.html");

        Map<String, String> map = new LinkedHashMap<>();
        map.put("/user/login", "anon");
        map.put("/js/**", "anon");
        map.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    /**
     * 开启shiro aop注解支持. 使用代理方式; 所以需要开启代码支持;
     * 如果不生效，在pom文件加上aop支持并配置spring.aop.proxy-target-class=true
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
