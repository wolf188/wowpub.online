package wowpub.cn;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

public class WebUtil {
	public static <T> T Request2Bean(HttpServletRequest request,Class<T> clazz){
        try{
            T bean = clazz.newInstance();
            Enumeration<String> e = request.getParameterNames(); 
            while(e.hasMoreElements()){
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
//		T bean ;
//		try {
//			bean = clazz.newInstance();
//			Enumeration<String> e = request.getParameterNames();
//			while(e.hasMoreElements()){
//				String name = (String) e.nextElement();
//				String val = request.getParameter(name);
//				try {
//					BeanUtils.setProperty(bean, name, val);
//				} catch (InvocationTargetException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//					System.out.println(e1.getMessage());
//				}
//			}
//			return bean;
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
	}
}
