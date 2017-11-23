package cn.zhku.freemarker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerTest {
    @Test
    public void test() {
        Group group = new Group();
        group.setName("group456");

        User user = new User();
        user.setId(123);
        user.setName("哈哈！！！");
        user.setAge(789);
        user.setGroup(group);

        User user1 = new User();
        user1.setId(0000000);
        user1.setName("呵呵!!!");
        user1.setAge(789);
        user1.setGroup(group);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", user);
        System.err.println(FreemarkerUtil.getTemplate("6.html"));
        FreemarkerUtil.print("6.html", root);
        FreemarkerUtil.fprint("6.html", root, "66.html");
    }
}
