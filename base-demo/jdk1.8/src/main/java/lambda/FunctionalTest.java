package lambda;

/**
 * 函数式接口
 *
 * @Author: WangXinWei
 * @Date: 2019/12/12 10:39
 * @Version 1.0
 */
@FunctionalInterface
public interface FunctionalTest {
    boolean isSex();

    default String getFuitName() {
        return "水果";
    }
}
