package cn.ziroom.mybatis.ms;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 
* @ClassName DataSourceAspect 
* @Description  通过切面动态配置数据源 
* @author dfx
* @date 2015年12月16日 下午1:18:03 
*
 */
public class DataSourceAspect {

    public void before(JoinPoint point)
    {
        Object target = point.getTarget();
        String method = point.getSignature().getName();

        Class<?>[] classz = target.getClass().getInterfaces();

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(data.value());
                System.out.println("++++++++++++"+data.value());
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
