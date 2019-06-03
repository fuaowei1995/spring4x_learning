import com.spring4x_learning.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class UserBeanTest {

    @Test
    public void userTest(){
        String resourcePath = "classpath:applicationContext.xml";
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource(resourcePath);
        try {
            System.out.println(resource.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        System.out.println("init BeanFactory");
        User user = factory.getBean("userObject",User.class);
        System.out.println("userId: "+user.getId().toString()+"username: "+user.getUsername()+"userpassword: "+user.getPassword());

    }



}
