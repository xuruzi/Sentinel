package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.*;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Properties;

/**
 * @author xuruzi
 * @data 2021-03-22
 */
@Configuration
public class NacosConfig {

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @Bean
    public ConfigService nacosConfigService() throws Exception {
        Properties properties = new Properties();
        properties.put("serverAddr", nacosConfigManager.getNacosConfigProperties().getServerAddr());
        properties.put("namespace",nacosConfigManager.getNacosConfigProperties().getNamespace());
        return ConfigFactory.createConfigService(properties);
    }


    /**
     * 授权规则
     * @return
     */
    @Bean
    public Converter<List<AuthorityRuleEntity>, String> authRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<AuthorityRuleEntity>> authRuleEntityDecoder() {
        return s -> JSON.parseArray(s, AuthorityRuleEntity.class);
    }

    /**
     * 降级规则
     * @return
     */
    @Bean
    public Converter<List<DegradeRuleEntity>, String> degradeRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<DegradeRuleEntity>> degradeRuleEntityDecoder() {
        return s -> JSON.parseArray(s, DegradeRuleEntity.class);
    }

    /**
     * 流控规则
     * @return
     */
    @Bean
    public Converter<List<FlowRuleEntity>, String> flowRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<FlowRuleEntity>> flowRuleEntityDecoder() {
        return s -> JSON.parseArray(s, FlowRuleEntity.class);
    }

    /**
     * 热点规则
     * @return
     */
    @Bean
    public Converter<List<ParamFlowRuleEntity>, String> paramRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<ParamFlowRuleEntity>> paramRuleEntityDecoder() {
        return s -> JSON.parseArray(s, ParamFlowRuleEntity.class);
    }

    /**
     * 系统规则
     * @return
     */
    @Bean
    public Converter<List<SystemRuleEntity>, String> systemRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<SystemRuleEntity>> systemRuleEntityDecoder() {
        return s -> JSON.parseArray(s, SystemRuleEntity.class);
    }


    /**
     * 网关流控规则
     * @return
     */
    @Bean
    public Converter<List<GatewayFlowRuleEntity>, String> gateWayFlowRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<GatewayFlowRuleEntity>> gateWayFlowRuleEntityDecoder() {
        return s -> JSON.parseArray(s, GatewayFlowRuleEntity.class);
    }

    /**
     * 网关API规则
     * @return
     */
    @Bean
    public Converter<List<ApiDefinitionEntity>, String> gateWayApiDefinitionEncoder() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<ApiDefinitionEntity>> gateWayApiDefinitionDecoder() {
        return s -> JSON.parseArray(s, ApiDefinitionEntity.class);
    }


}
