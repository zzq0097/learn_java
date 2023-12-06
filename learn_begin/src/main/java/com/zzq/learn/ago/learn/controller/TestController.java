package com.zzq.learn.ago.learn.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zzq.learn.ago.learn.bean.R;
import com.zzq.learn.ago.learn.test.WYTest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final ApplicationEventPublisher eventPublisher;
    private final WYTest wyTest;

    //    @Value("${test}")
//    private String test;
    @Value("${nacos.discovery.server-addr}")
    private String test2;

//    private final SysUserExtMapper sysUserExtMapper;

    @GetMapping("textTest")
    public JSONObject textTest(String text) {
        try {
            return JSONUtil.parseObj(wyTest.test(text));
        } catch (Exception e) {
            return new JSONObject().set("error", e.getMessage());
        }
    }

    @GetMapping("test")
    public R textTest() {
//        JdbcRealm jdbcRealm = new JdbcRealm();
//        jdbcRealm.setDataSource(DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://192.168.31.168:3306/shiro_jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC")
//                .username("root")
//                .password("Wise123++")
//                .build());
//
//        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        defaultSecurityManager.setRealm(jdbcRealm);
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
//
//        Subject subject = SecurityUtils.getSubject();
//
//        subject.login(new UsernamePasswordToken("admin", "admin"));
//
//        System.out.println(subject.isAuthenticated());


//        return R.ok(sysUserExtMapper.selectTest());
        return R.ok();
    }


    @PostMapping("test2")
    public R test2(@RequestBody JSONObject obj) {

        System.out.println(obj);
        return R.ok();
    }


//    @PersistenceContext
//    private EntityManager entityManager;
//
////    @Autowired
////    TestJPA testJPA;
////
////    @Autowired
////    UserDao userDao;
//
////    @Autowired
////    KafkaTemplate<String, Object> kafkaTemplate;
//
//    @Autowired
//    ApplicationContext ctx;
//
//    @PostConstruct
//    public void test() {
////        System.out.println(ctx.getBean("str2"));
////        for (String name : ctx.getBeanDefinitionNames()) {
////            System.out.println(name);
////        }
//    }
//
//
//    @NacosInjected
//    NamingService namingService;

    @RequestMapping("/test")
    public R<?> test() {
//        String sql = "select start_time , end_time from project where project_id = ?";
//        Query query = entityManager.createNativeQuery(sql);
//        query.setParameter(1, 2);
//        List<?> resultList = query.getResultList();
//        if (resultList.size() < 1) {
//            throw new RuntimeException("项目不存在");
//        }
//        Object[] arr = (Object[]) resultList.get(0);
//        LocalDate startTime = LocalDate.parse(arr[0].toString());
//        LocalDate endTime = LocalDate.parse(arr[1].toString());
//        return R.success(new JSONObject().set("startTime", startTime).set("endTime", endTime));
        eventPublisher.publishEvent("test");
        return R.ok();
    }


    public void s(JSONObject jsonObj, String name, BigDecimal curr) {
        String count = "count";
        String totalAmount = "totalAmount";
        if (jsonObj.get(name) == null) {
            jsonObj.set(name, new JSONObject().set(totalAmount, curr).set(count, 1));
        } else {
            JSONObject parseObj = JSONUtil.parseObj(jsonObj.get(name));
            BigDecimal old = parseObj.get(totalAmount, BigDecimal.class);
            parseObj.set(totalAmount, old.add(curr));
            Integer oldCount = parseObj.getInt(count);
            parseObj.set(count, oldCount + 1);
        }
    }

//    @RequestMapping("test")
//    public Object test(MultipartFile file) {
//        String str = "{}";
//        try {
//            str = new String(file.getBytes(), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return Test.parse(str);
//    }
//
//    @RequestMapping("test2")
//    public Object test(String url){
//        String str = HttpUtil.get(url);
//        return Test.parse(str);
//    }

//    @KafkaListener(topics = "kafkatest123")
//    public void receive(ConsumerRecord<String, Object> consumer) {
//        log.info("消息已消费：topic为[{}]-key为[{}]-value为[{}]", consumer.topic(), consumer.key(), consumer.value());
//    }
//    @RequestMapping(value = "test2")
//    public void test2() {
//        Page<User2> all = testJPA.findAll(PageRequest.of(0,10));
//
//
//        System.out.println(all.getTotalElements());
//        System.out.println(all.getContent());
//    }

}
