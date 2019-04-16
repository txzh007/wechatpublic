package link.tanxin.wechatpublic.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanToMap {
    public static final char UNDERLINE = '_';

    /**
     * Map转换成JavaBean.
     *
     * @param type JavaBean的Class
     * @param map  map
     * @return 转换的JavaBean
     * @throws IntrospectionException    无法获取类字段
     * @throws IllegalAccessException    JavaBean无法被实例化
     * @throws InstantiationException    JavaBean无法被实例化
     * @throws InvocationTargetException 调用方法失败
     */
    public static final Object toBean(Map<String, ? extends Object> map, Class<?> type) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取JavaBean其所有属性、公开的方法和事件
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        System.out.println("baseinfo:" + beanInfo.toString());
        //实例化JavaBean对象
        Object obj = type.newInstance();
        //获取属性数组
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            //获取属性名称
            String propertyName = descriptor.getName();
            System.out.println(descriptor.toString());
            //判断属性是否存在于map
            if (map.containsKey(propertyName)) {
                System.out.println("propertyName:" + propertyName);
                //获取属性对应值
                Object value = map.get(propertyName);
                System.out.println("value:" + value);
                Object[] args = new Object[1];
                args[0] = value;
                //把值设置到当前属性
                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    /**
     * JavaBean转换成Map
     *
     * @param bean JavaBean类
     * @return map对象
     * @throws IntrospectionException    无法获取类字段
     * @throws IllegalAccessException    JavaBean无法被实例化
     * @throws InvocationTargetException 调用方法失败
     */
    public static final Map<String, Object> toMap(Object bean) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        //定义Map对象
        Map<String, Object> returnMap = new HashMap<>();
        //获取JavaBean其所有属性、公开的方法和事件
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        //获取属性数组
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {

            //获取属性名称
            String propertyName = descriptor.getName();
            //过滤class
            if (!propertyName.equals("class")) {
                //获取属性方法，用于读取属性值的方法
                Method readMethod = descriptor.getReadMethod();
                //调用方法返回当前属性值
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    //将属性名称和属性对应值放入map
                    returnMap.put(propertyName, result);
                } else {
                    //如果无值，默认为空字符串
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }


    /**
     * 把map的key转换成驼峰命名
     *
     * @param map
     * @return
     */
    public static Map<String, Object> toReplaceKeyLow(Map<String, Object> map) {
        Map re_map = new HashMap();
        if (re_map != null) {
            Iterator var2 = map.entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry) var2.next();
                re_map.put(underlineToCamel((String) entry.getKey()), map.get(entry.getKey()));
            }

            map.clear();
        }

        return re_map;
    }


    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(Character.toLowerCase(param.charAt(i)));
            }
        }
        return sb.toString();
    }
}
