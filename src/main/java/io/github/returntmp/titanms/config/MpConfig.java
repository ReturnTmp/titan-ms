package io.github.returntmp.titanms.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {//添加MybatisPlus拦截器，从而新增分页查询功能
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //添加拦截器
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //分页
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //乐观锁
        //mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
