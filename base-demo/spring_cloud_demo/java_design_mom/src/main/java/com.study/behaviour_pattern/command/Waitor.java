package com.study.behaviour_pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务员类(请求者/调用者角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-03-04-20:55
 * @Version 1.0
 */
public class Waitor {
    // 持有多个命令对象
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command command) {
        // 将cmd对象存储到集合中
        commands.add(command);
    }

    public void orderUp() {
        System.out.println("美女服务员: 大厨,新订单来了....");
        // 遍历订单集合
        for (Command command : commands) {
            if (command != null) {
                command.execute();
            }
        }
    }

}
