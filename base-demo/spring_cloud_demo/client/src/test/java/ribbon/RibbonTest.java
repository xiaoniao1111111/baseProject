package ribbon;

import com.leyou.UserClientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Ribbon负载均衡算法测试
 *
 * @Author WangXinWei
 * @Date 2022/3/19 0:15
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserClientApplication.class)
public class RibbonTest {
    @Autowired
    private RibbonLoadBalancerClient balancerClient;

    @Test
    public void ribbonTest() {
        for (int i = 0; i < 100; i++) {
            ServiceInstance instance = balancerClient.choose("user-server");
            System.out.println(instance.getHost()+":"+instance.getPort());
        }

    }
}
