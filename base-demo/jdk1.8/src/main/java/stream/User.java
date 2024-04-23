package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户
 *
 * @Author: WangXinWei
 * @Date: 2019/12/12 13:44
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class User {
    private String userName;
    private String sex;
    private String like;
}
