package org.smart4j.framework.aop.aspect;

import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.aop.Advice.Advice;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * 抽象模板类
 */
public abstract class AbstractAspectJAdvice implements Advice, AspectJPrecedenceInformation, Serializable {
    private String aspectName = "";

    protected Object invokeAdviceMethod(MethodProxy method, Object[] args, Object target) {
        Object invoke;
        try {
            invoke = method.invokeSuper(target, args);
        } catch (Throwable e) {
            throw new RuntimeException();
        }
        return invoke;
    }

    //    private final String methodName;
    @Override
    public String getAspectName() {
        return this.aspectName;
    }

    public void setAspectName(String name) {
        this.aspectName = name;
    }

    @Override
    public int getDeclarationOrder() {
        return 0;
    }

    public void begin() {

    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable {
        return true;
    }

    public void end() {

    }
}
