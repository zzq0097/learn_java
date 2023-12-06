package com.zzq.learn.ago.learn.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.odiszapc.nginxparser.NgxBlock;
import com.github.odiszapc.nginxparser.NgxEntry;
import com.github.odiszapc.nginxparser.NgxIfBlock;
import com.github.odiszapc.nginxparser.NgxParam;
import com.zzq.learn.ago.learn.bean.ApiItem;
import com.zzq.learn.ago.learn.bean.User;
import com.zzq.learn.ago.learn.bean.UserDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;


public class Test {
    final static Object obj = new Object();

    public static void main(String[] args) throws Exception {
//        System.out.println(EnumTest.PLUS.exec(1, 2));
//        System.out.println(EnumTest.PLUS.toString());
//        System.out.println(EnumTest.PLUS.apply(1, 2));
//        int i = 1<<2;
//        i = 1^2;
//        i = 1%2;
//        i >>= 1;
//        System.out.println(i);

//        List<String> list = new ArrayList<>();
//        list.add("12");
//        list.add("34");
//        Map<String, String> collect = list.stream().collect(Collectors.toMap(Objects::toString, e -> e));
//        System.out.println(collect);
//        Integer[] s = new Integer[]{12,23,45};
//        Integer[] integer = {1,2,3,4,5};
//        String[] sss = {"1","2"};
//        Queue<String> aa = new LinkedList<>(Arrays.asList(sss));
//        System.out.println(aa);

//        String[] s = {"1"};
//        List<String> list = Arrays.asList(s);
//        list.add("");
//        TestService testService = new TestServiceImpl();
//        testService.test2();
//        System.out.println(BaseResponse.SUCCESS);
//        System.out.println(StateCode.SUCCESS.code());

//        String str = "23/Dec/2020:17:19:04 +0800";
//
//        DateTimeFormatter p = DateTimeFormatter.ofPattern(DateUtil.NGINX.toString(), Locale.US);
//        DateTimeFormatter f = DateTimeFormatter.ofPattern(DateUtil.DEFAULT.toString()).withZone(ZoneId.systemDefault());

//        System.out.println(f.format(p.parse(str)));

//        String str = "Active connections: 2 \n" +
//                "server accepts handled requests\n" +
//                " 14 14 17 \n" +
//                "Reading: 0 Writing: 1 Waiting: 1 ";
//        String[] line = str.split("\n");
//        System.out.println(Integer.parseInt(line[0].replace("Active connections: ", "").trim()));
//        String[] num = line[2].trim().split(" ");
//        System.out.println(Integer.parseInt(num[0]));
//        System.out.println(Integer.parseInt(num[1]));
//        System.out.println(Integer.parseInt(num[2]));
//        MailUtil.send("18736271057@163.com","","test",false);
//        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");

//        try {
//            URL url = new URL("https://www.wisesys.com");
//            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
//            connection.connect();
//            for (Certificate certificate : connection.getServerCertificates()) {
//                //第一个就是服务器本身证书，后续的是证书链上的其他证书
//                X509Certificate x509Certificate = (X509Certificate) certificate;
//                System.out.println(x509Certificate.getSubjectDN().getName().split("=")[1]);
//                System.out.println((x509Certificate.getNotAfter().getTime() - x509Certificate.getNotBefore().getTime()));
//                System.out.println(f.format(x509Certificate.getNotBefore().toInstant().atZone(ZoneId.systemDefault())));//有效期开始时间
//                System.out.println(f.format(x509Certificate.getNotAfter().toInstant().atZone(ZoneId.systemDefault())));//有效期结束时间
//            }
//            connection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String path = "D:\\home\\ssl\\5035671_wisesys.top.pem";
//        try {
//            CertificateFactory fact = CertificateFactory.getInstance("X.509");
//            X509Certificate x509Certificate = (X509Certificate) fact.generateCertificate(new FileInputStream(path));
//            System.out.println(x509Certificate.getSubjectDN());
//            System.out.println((x509Certificate.getNotAfter().getTime() - x509Certificate.getNotBefore().getTime()));
//            System.out.println(x509Certificate.getNotBefore());//有效期开始时间
//            System.out.println(x509Certificate.getNotAfter());//有效期结束时间
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("pem","");
//        map.put("key","");
//        HttpUtil.post("",map);
//        String content = "test中文";
//
//        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
//        System.out.println(StrUtil.join(",", key));


//        String str = FileUtil.readUtf8String("D:\\home\\ssl\\5035671_wisesys.top.pem");
//        String s = "0.01";
//        BigDecimal bigDecimal = new BigDecimal(s);
//        System.out.println(bigDecimal.multiply(new BigDecimal(1000)));
//        Map<String, Object> map = new HashMap<>();
//        String path = "D:\\1234.txt";
//        String date = LocalDate.now().toString();
//        FileUtil.rename(new File(path),"access-"+date+".log",true);
//        String path = "D:\\dev\\ngx_conf_test\\nginx.conf";
//        path = "D:\\dev\\ngx_conf_test\\account-web.conf";
//        NgxConfig ngxConfig = NgxConfig.read(path);
//        ays(ngxConfig.getEntries());
//        char a = '\u6211';
//        int k = '我';
//        System.out.println(25105%128);
//        System.out.println(k);
//        System.out.println((int) a);
//        System.out.println((byte) a);

//        System.out.println(LocalDate.now());
//        System.out.println(LocalTime.now());
//        System.out.println(LocalDateTime.now());
//        System.out.println(ZonedDateTime.now());
//        System.out.println(OffsetDateTime.now());
//        System.out.println(Instant.now());
//        System.out.println(OffsetTime.now());
//        LocalDateTime.from(DateTimeFormatter.ofPattern("").parse(""));

//        String name = MsgType.ackHeartBeat.name();
//        int ordinal = MsgType.ackHeartBeat.idx;
//        System.out.println(name);
//        System.out.println(ordinal);
//        String str = "你好,hello";
//        byte[] a = str.getBytes(StandardCharsets.UTF_8);
//        System.out.println(StrUtil.join(",", a));
//        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
//        for (int i = 0; i < a.length; i++) {
//            System.out.print((a[i] & 0xFF)+",");
//        }
//        System.out.println();
//        int temp = 0;
//        while ((temp = in.read()) != -1) {
//            System.out.print(temp+",");
//        }
//        System.out.println(0b01111111111111111111111111111111);
//        int num = 25700;
//        System.out.println(Integer.toBinaryString(-1));
//        System.out.println(Integer.toBinaryString(127 << 24));
//        System.out.println(num >>> 1);
//        System.out.println(Integer.toBinaryString(num));
//        System.out.println(Integer.toBinaryString(num >> 2));
//        System.out.println(Integer.toBinaryString(num >>> 2));
//        System.out.println(Integer.toBinaryString(num << 16));
//        System.out.println(Integer.toBinaryString(num&0xFF));
//        System.out.println(Integer.toBinaryString((num&0xFF) << 16));
//
//        byte[] result = new byte[2];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = (byte) ((num >> 8*(result.length-1-i))&0xFF);
//        }
//        for (byte b : result) {
//            System.out.print(b +",");
//        }

//        System.out.println(StrUtil.join(",",to("你好,hello".getBytes(StandardCharsets.UTF_8))));
//        System.out.println(StrUtil.join(",","你好,hello".getBytes(StandardCharsets.UTF_8)));

//        IntStream.iterate(0, i -> i + 1).forEach(System.out::println);

//        ServerSocketRunner runner = new ServerSocketRunner();
//        Thread.sleep(1000);
//        ClientChannelTest clientChannelTest = new ClientChannelTest();
//        runner.send(0,"hell0,你好");
//        System.out.println(clientChannelTest.clientReceive());

//        int[] arr = {1,5,4,3,48,94,3,4,68,31,30};
//        for(int i =0;i<arr.length-1;i++){
//            for(int j = 0;j<arr.length-1-i;j++){
//                if(arr[j]>arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1]=temp;
//                }
//            }
//        }
//        Arrays.stream(arr).forEach(System.out::println);

//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,5,
//                10,TimeUnit.DAYS,new LinkedBlockingQueue<>());
//        Executors.newSingleThreadExecutor();
//
//        NioServer nioServer = new NioServer(9999);
//        nioServer.setChannelHandler(socketChannel -> {
//            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
//            socketChannel.read(byteBuffer);
//            socketChannel.write(byteBuffer);
//        });
//        nioServer.listen();


//        HttpRequest request = HttpUtil.createGet("http://192.168.31.41:6005/user/login");
//        request.cookie("sessionId=a54117f92c84601d61280fb09a8dbef09eb94f3ada9a12d099ae907f99f0e91de95c7f1645ff275c591d008495f9172d05d196b8b99d3cdf7dc700c0a72555a8f0c9dd4d64dfd27fac7503d95eaec8458843a72c0a43c5dd2fd807f759e278d5297f7179a46cd9a0b3a7ccf1c3f68b15e620cc5f69bfe67402dde5ec4124bf9bf780bdd3dcd0f391eb0a0fc9fa9e6dcf3e584dad220fd8d2dc78cd38b3dbd2c15dd796055962364c096b3cad9d185633113e4236ffb1143d94b285ff0ed71273247e85432503f4136ec0fdb89bc7f2b85cbf6a11e623208118563e29b9077645cf2503674fe5d28f3a08a259ed93ae18e36fbd6a795825e93d418284d82b8b35362c22231e9f824ff60dd49f9a09632aaae83a7357017c70a64843a2d16afe8471d35f8befe361b989fd2d17884ada92c0c10e088486a5dc1fb002c770eb7c4e6da114159734e7e3086789c0eec8049c0ceb34922aa66d5d2bc99c1f8ec3d33c894a5343c14a84031c8bbe0e43a452db5294af696d61a41a98aedac5966d3c9b21f6bad2bb3380efe4fb7bc7eac25e8420ea503adbb74a1b9bd4a2cc4f095b0d;sessionId9=a54117f92c84601d61280fb09a8dbef09eb94f3ada9a12d099ae907f99f0e91df9fab8cf83c696be8fff942fef90117bbb1d3a365b0b7f0eeed159ed292920c8917a6980e13d9e52484552c912a96cf9a0df63e4229904a123930a62383f2e6757915e897c8c139b2ac8b7301aa3666879c88bb15f99d2817ed7fcd1d8a1bf9977987692b4883ec21dc1778d694041dcc7729ad4166c03c39cd61b94ae6843ec0eedf50881c4b2a1165f38052a820213b324028155e85eb2a75339ee6924fbb47f3066310a548520cfa2a8bd95655b0633b7d538fbeecb7d49606664f47342fe7397178f2359fdab9cc7268065e4a59d8dddae45b9617f3a805b88dd976e1747e4b58b9c9ac9b8232292969db7530a78c4baaccdb81b6da465b5f239f202ae7f74802a129082d8db4b5b7809eef0e02e02dbae35078dfea070b232e1c6dba297c02fdb54f0158e95009a9ef7a1b72d4b889d64d846a52f71b35b05effd07f06156d52b0b71d25b14603ddc495a8d234d5fdd0e1324b84d47f4e3a9322e235ebce8c920ba394135427b097d1e9d100c01e1fe8eff7301480c09039e7add473339f9d2b35c9c73f1a66245fcf1569ec583");
//        HttpResponse execute = request.execute();
////        System.out.println(execute);
//        Queue<String> queue = new PriorityQueue<>();
//
//        queue.offer("123");
//        queue.offer("234");
//        queue.offer("345");
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue);


//        Stack<String> stack = new Stack<>();
//
//        stack.push("123");
//        stack.push("234");
////        System.out.println(stack.peek());
////        System.out.println(stack.pop());
//        System.out.println(stack);

//        String s = "()[]{}";
//        Stack<Character> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (stack.empty()) {
//                stack.push(c);
//            } else {
//                if (stack.peek() == c) {
//
//                }
//            }
//        }

//        Stack<Character> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (stack.empty()) {
//                stack.push(c);
//            } else {
//                int i = c - stack.peek();
//                if (i == 1 || i == 2) {
//                    stack.pop();
//                } else {
//                    stack.push(c);
//                }
//            }
//        }
//
//        System.out.println(stack);
//        Stack<Integer> stack = new Stack<>();
//        stack.push(123);
//        stack.push(234);
//        stack.push(345);
//
//        System.out.println(Integer.valueOf("-1"));
//        System.out.println(stack.get(0));
//        stack.stream().reduce(Integer::sum).get();

//        String s = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(parse(15151515));

//        System.out.println(longestPalindrome("aacabdkacaa"));


//        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        int[] nums = {1,2,3,4,5,6};
//        System.arraycopy(nums,0,nums,3,3);
//        for (int num : nums) {
//            System.out.print(num+",");
//        }

//        Mp3Parse mp3 = new Mp3Parse();
//        mp3.parse("D:\\04.mp3");
//        System.out.println(mp3);
//        char a = ' ';
//        ArrayDeque<String> arrayDeque = new ArrayDeque<>();


//        parse(FileUtil.readUtf8String("D:\\api-docs.json")).forEach(System.out::println);
//
//        Map<String, Object> map = new HashMap<>();

//        System.out.println(getChartMap());

//        NioServer nio = new NioServer(9000);
//        nio.setChannelHandler(socketChannel -> {
//            ByteBuffer bb = ByteBuffer.allocate(20);
//            bb.put("qwe".getBytes(StandardCharsets.UTF_8));
//            socketChannel.write(bb);
//        });
//        nio.start();

//        SimpleFtpServer server = new SimpleFtpServer();
//        BaseUser baseUser = new BaseUser();
//        baseUser.setName("zzq");
//        baseUser.setPassword("123456");
//        server.addUser(baseUser);
//        server.start();


//        User2 user1 = new User2();
//        user1.setName("haha");
//        User2 user2 = new User2();
//        user2.setName("xixi");
//
//        Map<String, User2> map = new HashMap<>();
//        map.put("1",user1);
//        map.put("2",user2);
//
//        System.out.println(map);
//        User2 userCopy = new User2();
//        BeanUtils.copyProperties(map.get("1"),userCopy);
//        userCopy.setName("lala");
//
//
//        map.put("2",userCopy);
//        System.out.println(map);
//        String lastVersion = "v";
//
//        boolean matches = Pattern.matches("^v\\d*$", lastVersion);
//
//        System.out.println(matches);
//        String cookie = "sessionId=a54117f92c84601d61280fb09a8dbef09eb94f3ada9a12d099ae907f99f0e91de95c7f1645ff275c591d008495f9172d05d196b8b99d3cdf7dc700c0a72555a82b5ff1ade6323f0ffdd2c7253954bd63be838a7e2adcd25c8c8456231c8f1bb60e7884a147e9d0ec243204528d4b4a895a9b40b71767919c1e61ce74bf20caa2937ecc05a90dfa43bdcb00cd88e428e07186e37e90d045c48fef1c320e35a10a57a42f08c007414569846bf29bec180fe97ab73f560a2b883a84eaefab7036414139c2fd21f975e6785205fb470262ab15572723e2678e04fd96d705bc03560e7c7615ccf978acfbf70a9f4ecb25bdbc5f51412cf945bc834919514538ae7abb1dc77f879b52036ae50122cd619f64354c6c8b9a321b606bfaf25385c11cf1c195855860535ff1cf2c558cd7c6dde83288c36ef27d02e7d6b012863b487755a93a50b367e200725880409b1f0e406f0256185494c339e7ef3f1f0c14981dd53b";
//
//        HttpRequest get = HttpUtil.createGet("http://192.168.31.105:6005/user/login");
//
//        System.out.println("Cookie:------ "+cookie);
//
//        String str = "";
//        try {
//            get.cookie(cookie);
//            str = get.execute().body();
//            JSONObject body = JSONUtil.parseObj(str);
//            System.out.println(body.toStringPretty());
//        } catch (Exception e) {
//            System.out.println(str);
//        }

//        String s = "/usr/local/nginx/sbin/";
//        System.out.println(s.substring(0,s.indexOf("sbin")));

//        User user = new User();
//
//        UserDTO dto = (UserDTO) user;
//        dto.setNickName("哈哈哈");
//        UserDTO dto = new UserDTO();
//        dto.setNickName("hahaha");
//
//        f(dto);

//
//        Operation div = new Operation.Div();
//        div.setValue1(10);
//        div.setValue2(2);
//        System.out.println(div.getResule());
//
//        Operation.Mul mul = new Operation.Mul();
//        mul.setAge(0);
//        System.out.println(mul);

//        for (int i : sort(new int[]{5, 10, 45, 2, 31})) {
//            System.out.print(i);
//            System.out.print(" ");
//        }


//        long start = System.currentTimeMillis();
//        CompletableFuture<?>[] farr = new CompletableFuture[10];
//        for (int i = 0; i < 10; i++) {
//            int j = i;
//            farr[i] = CompletableFuture.supplyAsync(()->{
//                try {
//                    TimeUnit.SECONDS.sleep(10-j);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return j;
//            }).thenAccept(res -> {
//                System.out.println(res);
//            });
//        }
//
//        CompletableFuture<Void> allOf = CompletableFuture.allOf(farr);
//        allOf.thenAccept(done -> {
//            System.out.println("done" + done);
//        });
//
//        allOf.get();

//        ExecutorService pool = Executors.newCachedThreadPool();
//        List<Future<?>> fList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            int j = i;
//            fList.add(pool.submit(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(10-j);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return j;
//            }));
//        }
//
//        for (Future<?> futureTask : fList) {
//            System.out.println(futureTask.get());
//        }
//        System.out.println(System.currentTimeMillis() - start);

//        User user = new User();
//        System.out.println(Optional.ofNullable(user).map(User::getUser2).map(User2::getAge).isPresent());
//
////        System.out.println(get(() -> user.getUser2().getName()).isPresent());
////        get(()-> user.getUser2().getName()).ifPresent(str -> {
////            System.out.println(str);
////        });
//
//        System.out.println(Optional.ofNullable("123").filter(str -> str.equals("1223")).isPresent());


//
//        String bin = "/usr/local/nginx/sbin/nginx";
//        String conf = "/usr/local/nginx/conf/nginx.conf";
//
//
//        System.out.println(NgxCmd.Param1.STOP.cmd(bin));
//        System.out.println(NgxCmd.Param1.CONFIGURE.cmd(bin));
//        System.out.println(NgxCmd.Param2.DUMP_CONF.cmd(bin, conf));
//        System.out.println(NgxCmd.SIGNAL.HUP.cmd("123"));
//        System.out.println(NgxCmd.Param2.RELOAD.cmd(bin, conf));
//        System.out.println(NgxCmd.Param1.REOPEN.cmd(bin));

//        NgxCmd.exec2("1echo 'qwee'");

//        NgxCmd.Param1.STOP.exec(bin);
//
//        NgxCmd.Param1.VERSION.exec(bin);


//        System.out.println(MD5.create().setSalt("nginxwise".getBytes(StandardCharsets.UTF_8)).digestHex("192.168.31.201"));
//
////        List<String> list = Arrays.asList("192.168.31.201","192.168.31.167","192.168.31.166","1.1.1.1");
//        List<Integer> sleep = Arrays.asList(200,3000,400,600,700,30,60,2100);
//
//
//
//        System.out.println("start");
//        long start = System.currentTimeMillis();


//        Future.sequence(sleep.stream().map(s ->
//                Future.of(()->{
//                    Try.run(()->Thread.sleep(s));
//                    return "sleep>>>"+s;
//                })
//        ).collect(Collectors.toList())).await();

//
//        CompletableFuture.allOf(sleep.stream().map(s ->
//                CompletableFuture.supplyAsync(()-> {
//                    Tuple2<String, Exception> tup2;
//                    try {
//                        String t = HttpUtil.get("http://192.168.31.1]");
//                        tup2 = new Tuple2<>(t, null);
//                    } catch (Exception e) {
//                        tup2 = new Tuple2<>(null, e);
//                    }
//                    return tup2;
//                }).thenAccept(tup2 -> {
//                    if (tup2._1 != null) {
//                        System.out.println(tup2._1);
//                    } else {
//                        System.out.println(tup2._2.getMessage());
//                    }
//                })
//        ).toArray(CompletableFuture[]::new)).join();

//        for (Integer s : sleep) {
//            try {
//                HttpUtil.get("http://192.168.31.1]");
//            } catch (Exception e) {
//
//            }
//        }

//        Try.run(()->{
//
//        });

//        Runnable runnable = ()->{
//
//        };
//        runnable.run();
//
//        System.out.println("end>>>"+(System.currentTimeMillis()-start));


//        String cmd = NgxCmd.Param1.VERSION.cmd("");
//        Process process = null;
//        try {
//            process = RuntimeUtil.exec();
//        } catch (IORuntimeException e) {
//            System.out.println(e.getMessage());
//        }
//        if (process != null) {
//            System.out.println(IoUtil.read(process.getInputStream()));
//            System.out.println(process.exitValue());
//
//
//        }


//        System.out.println(NgxUtil.process(StrUtil.join(" ", "echo '123'")));

//        String s = "192.168.31.130||";
//        String s2 = "||";
//
//
//        String[] splitToArray = StrUtil.splitToArray(s2, '|');
//        for (int i = 0, splitToArrayLength = splitToArray.length; i < splitToArrayLength; i++) {
//            String s1 = splitToArray[i];
//            System.out.println(i+1 + ">>" + StrUtil.isBlank(s1));
//        }

        // 端口开启，无法访问
        // IOException

        // 端口未开启
        // SocketTimeoutException

        // 主机不存在
        //

//        String nodeIp = "192.168.31.168";
//        String url = StrUtil.format("http://{}:8899", nodeIp);
//
//        try (HttpResponse response = HttpUtil.createPost(url).timeout(1000).execute()) {
//            System.out.println(response.getStatus());
//            System.out.println(response.body());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//
//        String install = "";
//
//        String cfg = "--prefix=/home/wise/nginx/ --with-http_ssl_module --with-http_realip_module --with-http_gzip_static_module --with-http_gunzip_module --with-http_sub_module --with-http_v2_module --with-http_stub_status_module --with-stream --with-pcre=/home/wise/install//pcre-8.45 --with-zlib=/home/wise/install//zlib-1.2.12 --with-openssl=/home/wise/install//openssl-1.1.1p --add-module=/home/wise/install//nginx-module-vts-0.1.18";
//
//
//        int i = cfg.indexOf("--with-openssl=");
//        int j = cfg.indexOf("/openssl-");
//
//        if (i > 0 && j > 0) {
//            install = cfg.substring(i + "--with-openssl=".length(), j);
//        }
//
//        System.out.println("--prefix=/home/wise/nginx/".substring("--prefix=".length()));
//
//        System.out.println();

//        WYTest wyTest = new WYTest();
//        System.out.println(wyTest.test("fuck"));

//        System.out.println(System.getenv());
//        System.out.println(System.getProperties());

//        getToken("admin");

//        JWT jwt = JWT.create();
//        JWTSigner jwtSigner = new HMacJWTSigner(HmacAlgorithm.HmacMD5.getValue(), "qwe".getBytes());
//        jwt.setPayload("payload", "123");
//        jwt.setHeader("header", "123");
//        jwt.setSigner(jwtSigner);
//
//
//        String sign = jwt.sign();
//        System.out.println(sign);
//
//
//        System.out.println(JWT.of(sign).verify(new HMacJWTSigner(HmacAlgorithm.HmacMD5.getValue(), "asd".getBytes(StandardCharsets.UTF_8))));


//        FileUtil.copy("", "", true);
//        FileUtil.writeUtf8String("", "");
//
//        DateTime monthDate = DateUtil.parse("2022-10", "yyyy-MM");
//
//        DateTime lastYear = new DateTime(monthDate).offset(DateField.YEAR, -1);
//
//        System.out.println(monthDate);
//        System.out.println(lastYear);


//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.offer(1);
//        linkedList.offer(2);
//
//        linkedList.push(1);
//        linkedList.push(2);
//
//        System.out.println(linkedList);

//        new Thread(() -> {
//            synchronized (obj) {
//                System.out.println("T1: start");
//                try {
//                    System.out.println("T1: wait");
//                    obj.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("T1: end");
//            }
//        }).start();
//
//        new Thread(() -> {
//            synchronized (obj) {
//                System.out.println("T2: start, notify");
//                obj.notify();
//                try {
//                    Thread.sleep(2000);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("T2: end");
//            }
//        }).start();

//        Collection<String> collection = Arrays.asList("哈哈", "吼吼", "嘿嘿");
//        Iterator<String> iterator = collection.iterator();
//        String next;
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        String json = "{\"name\": \"hh\", \"age\": 11}";
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(json, User.class);
        System.out.println(user);
        JsonNode jsonNode = objectMapper.readTree(json);
        ObjectNode objectNode = objectMapper.convertValue(jsonNode, ObjectNode.class);


        IterUtil.forEach(objectNode.fields(), entry -> {
            System.out.println(entry.getKey() + "-" + entry.getValue().asText());
        });

        System.out.println(objectNode);


    }

    private static String getToken(String username) {
        String clientId = "nginxwise";

        /** 授权 */
        HttpRequest get = HttpUtil.createGet("http://192.168.31.168:8999/uaa/oauth/authorize" +
                "?client_id=" + clientId + "&redirect_uri=http://example.com&response_type=code&scope=all&authType=self&username=" + username);
        get.disableCookie();
        HttpResponse response = get.execute();
        String code = "";
        if (response.getStatus() == HttpStatus.HTTP_MOVED_TEMP) {
            String location = response.header("Location");

            code = location.substring(location.lastIndexOf('=') + 1);
        }
        if (StrUtil.isBlank(code)) {
            throw new RuntimeException("通行码为空!" + response.body());
        }
        /** 获取token */
        Map<String, Object> map = new HashMap<>();
        map.put("client_id", clientId);
        map.put("client_secret", 123456);
        map.put("grant_type", "authorization_code");
        map.put("redirect_uri", "http://example.com");
        map.put("scope", "all");
        map.put("code", code);
        HttpRequest post = HttpRequest.post("http://192.168.31.168:8999/uaa/oauth/token");
        post.form(map);
        HttpResponse tokenResponse = post.execute();
        return JSONUtil.toJsonPrettyStr(tokenResponse.body());
    }

    public static String reload(String bin, String conf) {
        return StrUtil.format("{} -s reload -c {} ", bin, conf);
    }

    public static String exec(String cmd) {
        return RuntimeUtil.execForStr("/bin/bash", "-c", cmd);
    }

    public static <T> Optional<T> get(Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get());
    }


    // TODO 从模板中生成shell脚本
    static public void todo() throws Exception {
//        NgxModel ngxModel = new NgxModel();
//        ngxModel.setNgx("nginx-1.22.0");
//        ngxModel.setOpenssl("openssl-1.1.1g");
//        ngxModel.setPcre("pcre-8.44");
//        ngxModel.setZlib("zlib-1.2.11");
//        ngxModel.setMods("nginx-module-vts-0.1.18");
        String path = "D:\\test.sh";

        JSONObject jsonObject = JSONUtil.parseObj("{ \"api\": \"update\", \"updateModel\": { \"install\": \"/home/nginx/install\", \"prefix\": \"/home/nginx/nginx\", \"ngx\": \"nginx-1.23.1\", \"serverHost\": \"192.168.31.105\", \"compilerFlags\": \"--prefix=/home/nginx/nginx/ --with-http_ssl_module --with-http_realip_module --with-http_gzip_static_module --with-http_gunzip_module --with-http_sub_module --with-http_v2_module --with-http_stub_status_module --with-stream --with-pcre=/home/nginx/install/pcre-8.45 --with-zlib=/home/nginx/install/zlib-1.2.12 --with-openssl=/home/nginx/install/openssl-1.1.1p --add-module=/home/nginx/install/nginx-module-vts-0.1.18\" } }");
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setClassForTemplateLoading(Test.class, "/templates");
        Template template = configuration.getTemplate("update.ftl");
        FileWriter out = new FileWriter(path);
        template.process(BeanUtil.beanToMap(jsonObject), out);
        out.close();

        System.out.println(FileUtil.readUtf8String(path));
    }


    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void f(User user) {
        s((UserDTO) user);
    }

    public static void s(UserDTO dto) {
        System.out.println(dto);
    }


    public static <T> Map<LocalDateTime, T> getChartMap() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute());
        Map<LocalDateTime, T> map = new TreeMap<>();
        IntStream.range(0, 30).forEach(i -> map.put(mTime.minusMinutes(i), null));
        return map;
    }

    public static List<ApiItem> parse(MultipartFile file) {
        byte[] bytes = null;
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parse(new String(bytes, StandardCharsets.UTF_8));
    }


    public static List<ApiItem> parse(String jsonStr) {
        List<ApiItem> apiList = new ArrayList<>();
        JSONObject swgJson = JSONUtil.parseObj(jsonStr);
        String version = swgJson.getStr("swagger");

        if (version.equals("2.0")) {
            JSONObject paths = swgJson.getJSONObject("paths");
            JSONObject definitions = swgJson.getJSONObject("definitions");
            String basePath = swgJson.getStr("basePath");
            String host = swgJson.getStr("host");
            paths.forEach((path, v) -> {
                JSONObject apiJson = JSONUtil.parseObj(v);
                apiJson.forEach((method, info) -> {
                    ApiItem apiItem = new ApiItem();
                    apiItem.setApiHost(host);
                    apiItem.setApiBasePath(basePath);
                    apiItem.setApiPath(path);
                    JSONObject apiInfo = JSONUtil.parseObj(info);
                    apiItem.setApiDesc(apiInfo.getStr("description"));
                    apiItem.setApiName(apiInfo.getStr("summary"));
                    apiItem.setReqMethod(method);
                    JSONArray consumes = apiInfo.getJSONArray("consumes");
                    if (consumes != null) {
                        apiItem.setReqContentType(consumes.join(";"));
                    }

                    // --
                    JSONArray parameters = apiInfo.getJSONArray("parameters");
                    List<JSONObject> paramList = new ArrayList<>();
                    if (parameters != null) {
                        for (Object paramStr : parameters) {
                            JSONObject param = JSONUtil.parseObj(paramStr);
                            JSONObject param_ = new JSONObject();
                            Object in = param.remove("in");
                            param_.set("in", in);
                            Object paramName = param.remove("name");
                            param_.set("name", paramName);
                            if (in.equals("body")) {
                                JSONObject schema = param.getJSONObject("schema");
                                String schemaType = schema.getStr("type");
                                param_.set("schemaType", schemaType);
                                if (schemaType == null) {
                                    String $ref = schema.getStr("$ref");
                                    String definitionStr = $ref.substring($ref.indexOf("definitions/") + "definitions/".length());
                                    JSONObject definition = definitions.getJSONObject(definitionStr);
                                    param_.set("data", definition);
                                } else if (schemaType.equals("array")) {
                                    JSONObject items = schema.getJSONObject("items");
                                    String $ref = items.getStr("$ref");
                                    String definitionStr = $ref.substring($ref.indexOf("definitions/") + "definitions/".length());
                                    JSONObject definition = definitions.getJSONObject(definitionStr);
                                    param_.set("data", definition);
                                } else if (schemaType.equals("string")) {
//                                    JSONObject items = schema.getJSONObject("items");
//                                    param_.set("enum", items.getJSONArray("enum"));
//                                    param_.set("default", items.getStr("default"));
                                }
                            } else {
                                param_.set("data", param);
                            }
                            paramList.add(param_);
                        }
                        apiItem.setReqLimitParam(new JSONObject().set("params", paramList).toString());
                    }

                    // --
                    JSONObject responses = apiInfo.getJSONObject("responses");
                    List<JSONObject> responsesList = new ArrayList<>();
                    if (responses != null) {
                        responses.forEach((code, data) -> {
                            JSONObject response = JSONUtil.parseObj(data);
                            response.set("code", code);
                            responsesList.add(response);
                        });
                        apiItem.setRespLimitParam(new JSONObject().set("responses", responsesList).toString());
                    }
                    apiList.add(apiItem);
                });
            });
        } else {
            return null;
        }
        return apiList;
    }


    public int lengthOfLastWord(String s) {
        int len = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            if (stack.size() > 0) {
                if (s.charAt(i) == ' ') {
                    return stack.size();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                if (s.charAt(i) != ' ') {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.size();
    }

    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        while (true) try {
            char ch0 = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch0) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        } catch (Exception e) {
            return strs[0].substring(0, i);
        }
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len > 2) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    String subStr = s.substring(j, j + len - i + 1);
                    for (int k = 0; k < subStr.length(); k++) {
                        if (subStr.contains(subStr.substring(k, k))) ;
                    }
                }
            }
            return s.substring(0, 1);
        } else if (len == 2) {
            if (s.charAt(0) == s.charAt(1))
                return s.substring(0, 1);
            return s;
        } else {
            return s;
        }
    }

    public static String parse(double byteLen) {
        String res;
        if (byteLen >= (1 << 30)) {
            res = String.format("%.2f", byteLen / (1 << 30)) + " GiB";
        } else if (byteLen >= (1 << 20)) {
            res = String.format("%.2f", byteLen / (1 << 20)) + " MiB";
        } else if (byteLen >= (1 << 10)) {
            res = String.format("%.2f", byteLen / (1 << 10)) + " KiB";
        } else {
            res = byteLen + " Byte";
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        LinkedList<Character> deque = new LinkedList<>();
        int len = 0;
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty()) {
                if (deque.contains(c)) {
                    for (int i = 0; i < deque.indexOf(c) + 1; i++) {
                        deque.pollFirst();
                    }
                }
            }
            deque.offer(c);
            len = Math.max(len, deque.size());
        }
        return len;
    }

    public static <T> void getVal(T t) throws Exception {
        System.out.println(t.getClass().getTypeName());
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object o = field.get(t);
            System.out.println(o);
        }
    }

    public static int[] to(byte[] bytes) {
        int[] res = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            res[i] = bytes[i] & 0xFF;
        }
        return res;
    }

    public static Collection<NgxEntry> ays(Collection<NgxEntry> entries) {
        for (NgxEntry ngxEntry : entries) {
            if (ngxEntry.getClass().equals(NgxParam.class)) {
                NgxParam param = (NgxParam) ngxEntry;
//                System.out.println(param.getName());
            } else if (ngxEntry.getClass().equals(NgxBlock.class)) {
                NgxBlock ngxBlock = (NgxBlock) ngxEntry;
//                System.out.println(ngxBlock.getName() + " {");
                ays(ngxBlock.getEntries());
            } else if (ngxEntry.getClass().equals(NgxIfBlock.class)) {
                NgxIfBlock ngxIfBlock = (NgxIfBlock) ngxEntry;
                System.out.println(ngxIfBlock.getName());
                System.out.println(ngxIfBlock.getValues());
                System.out.println(ngxIfBlock.getValue());
                System.out.println(ngxIfBlock.getTokens());
                ays(ngxIfBlock.getEntries());
            }
        }
        return entries;
    }

    public static void sava(Collection<NgxEntry> entries) {
        entries.forEach(ngxEntry -> {
            NgxIfBlock block = (NgxIfBlock) ngxEntry;
            System.out.println(block.getName());
            System.out.println(block.getValues());
            System.out.println(block.getValue());
            System.out.println(block.getTokens());
            System.out.println(block.getEntries());
        });
    }

    ;

    public static <E> int len(Collection<E> e) {
        return e.size();
    }
}
