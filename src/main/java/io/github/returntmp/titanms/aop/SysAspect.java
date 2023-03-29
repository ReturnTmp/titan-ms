package io.github.returntmp.titanms.aop;

import cn.hutool.system.SystemUtil;
import io.github.returntmp.titanms.annotation.Operation;
import io.github.returntmp.titanms.domain.OpItem;
import io.github.returntmp.titanms.domain.SysLog;
import io.github.returntmp.titanms.domain.Ticket;
import io.github.returntmp.titanms.service.ISysLogService;
import lombok.val;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.Objects;


/**
 * 系统切面
 *
 * @author ReturnTmp
 * @date 2023/03/29
 */
@Aspect
@Component
public class SysAspect {

    /**
     * 系统日志服务
     */
    @Autowired
    private ISysLogService sysLogService;

    @Pointcut("@annotation(io.github.returntmp.titanms.Operation)")
    public void logPointCut() {
    }

    @AfterReturning("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();


        //获取操作
        Operation operation = method.getAnnotation(Operation.class);
        if (operation != null) {
            String value = operation.value();
            sysLog.setRequestDesc(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();

        //注入Syslog对象
        //username应从session里取出
        //TODO:从session里取出username
        sysLog.setUserName("Sinya");

        //IP地址获取工具为HUtooljar包,自行添加依赖
        sysLog.setUserIp(SystemUtil.getHostInfo().getAddress());
        sysLog.setRequestMethod(className + "." + methodName);

        //获取操作对象的id（若有）
        Parameter[] parameters = method.getParameters();
        if (parameters[0].getName().equals("id")) {
            Object arg = joinPoint.getArgs()[0];
            sysLog.setObId((Long) arg);
        } else if (parameters[0].getName().equals("ticket")) {
            Object arg = joinPoint.getArgs()[0];
            Ticket ticket = (Ticket) arg;
            sysLog.setObId(ticket.getId());
        } else if (parameters[0].getName().equals("opItem")) {
            Object arg = joinPoint.getArgs()[0];
            OpItem opItem = (OpItem) arg;
            int id = opItem.getId();
            Integer id1 = Integer.valueOf(id);
            Long value = id1.longValue();
            sysLog.setObId(value);
        }

        sysLog.setCreateTime(new Date());

        //调用service保存SysLog实体类到数据库
        sysLogService.saveLog(sysLog);
    }
}
