package com.example.webdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.baoyz.treasure.Treasure;
import com.example.webdemo.bean.CoderInfo;
import com.example.webdemo.interfaces.CodePreferenceInterface;
import com.example.webdemo.interfaces.JssionPreferenceInterface;
import com.example.webdemo.interfaces.TokenPreferenceInterface;
import com.google.gson.Gson;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity2 extends AppCompatActivity {

    Logger logger = Logger.getLogger("aaa");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        new Thread(getNetworkTask8).start();

//        OrderInfo info = new OrderInfo();
//
//        OrderInfo.RowsBean b = new OrderInfo.RowsBean();
//        b.setBatchid(111);
//        List<OrderInfo.RowsBean> as = new ArrayList<>();
//        as.add(b);
//        info.setRows(as);






    }

    Runnable networkTask = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://100.10.1.201/yfjz/sys/login?username=13595942896&password=123456")
                    .method("POST", body)
                    .addHeader("Cookie", "JSESSIONID=123333")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                logger.info(response.body().string());
                int i=0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    Runnable networkTask2 = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://100.10.1.201/yfjz/getTowerList")
                    .method("GET", null)
                    .addHeader("Cookie", "JSESSIONID=73985DB59F8B9DB83BDB94FFDBD9286D")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                logger.info(response.body().string());
                int i=0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };



    Runnable networkTask3 = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
//            Request request = new Request.Builder()
//                    .url("http://100.10.1.201/yfjz/getTowerList")
//                    .method("GET", null)
//                    .addHeader("Cookie", "JSESSIONID=123333")
//                    .build();
            Request request = new Request.Builder()
                    .url("http://100.10.1.201/yfjz/sys/login?username=13595942896&password=123456")
                    .method("POST", body).build();
            try {
                Response response = client.newCall(request).execute();
                //获取session的操作，session放在cookie头，且取出后含有“；”,要处理一下
                Headers headers = response.headers();
                List<String> cookies = headers.values("Set-Cookie");
                String s = cookies.get(0);
                String session = s.substring(0, s.indexOf(";"));
                logger.info(response.body().string());
                logger.info(session);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };



    //金卫信获取JSESSIONID
    Runnable networkTask8 = new Runnable() {
        @Override
        public void run() {
            /*OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
//            Request request = new Request.Builder()
//                    .url("http://100.10.1.201/yfjz/getTowerList")
//                    .method("GET", null)
//                    .addHeader("Cookie", "JSESSIONID=123333")
//                    .build();
            Request request = new Request.Builder()
                    .url("http://222.143.34.184:7080/web/login?username=13595942896&password=123456")
                    .method("POST", body).build();
            try {
                Response response = client.newCall(request).execute();
                //获取session的操作，session放在cookie头，且取出后含有“；”,要处理一下
                Headers headers = response.headers();
                List<String> cookies = headers.values("Set-Cookie");
                String s = cookies.get(0);
                String session = s.substring(0, s.indexOf(";"));
                logger.info(response.body().string());
                logger.info(session);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("userLoginName","42d0a72bb150b3baa4e015e2a124b35be024c84d0f6801e633f3ba71cfc86ccbe35ecc0834f8fc75c2460d1354be9865c4c4c5659887d0363a336e14f89a8ffdc3c5bcd7e2ffc50b6f0b66acff0e04f57b4831d97f624f8ad034a094adb805b68b0014175302da637fa65ebddd5fda52e8c2cf59938a2a3a823f617a5291bf24")
                    .addFormDataPart("userPassword","08106a9ee84ce7a4d407f1640bb1e2a8")
                    .build();
            Request request = new Request.Builder()
                    .url("http://222.143.34.184:7080/web/loginValidate.do")
                    .method("POST", body)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                //获取session的操作，session放在cookie头，且取出后含有“；”,要处理一下
                Headers headers = response.headers();
                List<String> cookies = headers.values("Set-Cookie");
                String s = cookies.get(0);
                String session = s.substring(0, s.indexOf(";"));

                JssionPreferenceInterface jssionPreferenceInterface = Treasure.get(MainActivity2.this,JssionPreferenceInterface.class);
                jssionPreferenceInterface.setJssion(session);
                logger.info(jssionPreferenceInterface.getJssion());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    //获取sso登录的code
    Runnable getNetworkTask7 = new Runnable() {
        @Override
        public void run() {
            /*OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://222.143.34.184:7080/web/bacterinRegister/getVeriCode.do")
                    .method("GET", null)
                    .addHeader("Cookie"
                            ,Treasure.get(MainActivity2.this,JssionPreferenceInterface.class).getJssion() )
                    .build();
            try {
                Response response = client.newCall(request).execute();

                Gson gson = new Gson();
                CoderInfo res = gson.fromJson(response.body().string(), CoderInfo.class);

                logger.info(res.toString());
                Treasure.get(MainActivity2.this, CodePreferenceInterface.class).setCode(res.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("type","3")
                    .build();
            Request request = new Request.Builder()
                    .url("http://222.143.34.184:7080/web/bacterinRegister/getVeriCode.do")
                    .method("POST", body)
                    .addHeader("Cookie", Treasure.get(MainActivity2.this,JssionPreferenceInterface.class).getJssion() )
                    .build();
            try {
                Response response = client.newCall(request).execute();
                Gson gson = new Gson();
                CoderInfo res = gson.fromJson(response.body().string(), CoderInfo.class);

                logger.info(res.toString());
                Treasure.get(MainActivity2.this, CodePreferenceInterface.class).setCode(res.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    //金卫信 sso登录
    Runnable getNetworkTask4 = new Runnable() {
        @Override
        public void run() {
            /*OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://222.143.34.185:10000/shiroserver/sso/login?veriCode="
                            +Treasure.get(MainActivity2.this,CodePreferenceInterface.class).getCode())
                    .method("GET", null)
//                    .addHeader("Cookie", "sid=a0cefb21-a0ef-4a46-a2de-934de9d54ff1; rememberMe=lDyAmgY3szuIOL1I26ruq4WSujgP2MADLgM4a2S46gnan4WyY+NJPPNzDxQOkhnz0K+AK1RjmbmQygWBuLXK6tZhhIvw18AOvGS68BzEkN5Dh9QiR5A+rbQuTGKSlJ/eftQxpCQPJr25Z7794h2jAdxTUXi7BCRv6KE2/R7+ipbqq8idEjO0W2YuTjZ3C96OvN+XtdJZV8D0KPL1b8lRT+iiLyqgJfLpgACJkbGt1a9gScnGumblnPseoQvbl+liSgMirDegnrZ6tWCFHAqrlSsx9UndZ1rXRQYYdtXRoc5kscKBxbrhc0hLvN6vUWgi0TrSr8Gb8TzUYGjs8LdICYeu5sjIIO7kKAnEzQOvFV4W9VYMXfjZJy+FKocjwSWDi3u2ec6CYON2x4VaWtNRb7TbVIHWxLU3AAgIOh8qc5BS8xuLFB0mrp9oBCM9r0bK9lVhzxLO4374CukFkNBBR7fYRVR0jD726TbSXXxQDWLlFSdaNTU1L8B3SUTsHOvxin6yT9W0RW5L1zx8JEckhiGKdmvLAkdzoBjqHmzsrspku0c2hRKCSsk295SYHYk4")
                    .build();
            try {
                Response response = client.newCall(request).execute();
//                logger.info(response.body().string());
                Headers headers = response.headers();
                int code = response.priorResponse().code();
                if (code == 302) {
                    String location =  response.priorResponse().headers().get("Location");
//                    logger.info(location);
                    logger.info("----------"+location.split("=")[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            //http://222.143.34.185:10000/shiroserver/sso/login?veriCode=24C13DCAD356AB68236067B206802F4C_4123282601_gaoyuan1_3_9827_3&userName=gaoyuan1&realName=%E9%AB%98%E5%8E%9F
            String preCode = Treasure.get(MainActivity2.this,CodePreferenceInterface.class).getCode();
            logger.info("preCode is :"+preCode);
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            //24C13DCAD356AB68236067B206802F4C_4123282601_gaoyuan1_3_9827_3&userName=gaoyuan1&realName=%E9%AB%98%E5%8E%9F
            //2D8A08C02D20A6BC10EA7892CCFFF4FC_4123282601_gaoyuan1_null_2251_3&userName=gaoyuan1&realName=%E9%AB%98%E5%8E%9F
            String url = "http://222.143.34.185:10000/shiroserver/sso/login?veriCode="
                   +
                    preCode;
            logger.info("oss login url is :"+url);
            Request request = new Request.Builder()
                    .url(url)
//                    .url("http://222.143.34.185:10000/shiroserver/sso/login?veriCode=5EAA40A24BA2DEC5058DD05DE564B86F_4123282601_gaoyuan1_3_2329_3&userName=gaoyuan1&realName=%E9%AB%98%E5%8E%9F")
                    .method("GET", null)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                logger.info(response.body().string());
                logger.info(String.valueOf(response.code()));
                if (response.priorResponse() == null )
                    return;
                int code = response.priorResponse().code();
                if (code == 302) {
                    String location =  response.priorResponse().headers().get("Location");
//                    logger.info(location);
                    String token = location.split("=")[1].isEmpty()?"":location.split("=")[1];
                    logger.info("10000 token----------"+token);
                    Treasure.get(MainActivity2.this, TokenPreferenceInterface.class).setToken(token);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    //获取运输单详情
    Runnable getNetworkTask5 = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://222.143.34.185:10000/bpms/vmInBillHeaderController/queryBodyList.do?inHeadno=4123280260012021040104&inHeadid=314919")
                    .method("GET", null)
                    .addHeader("Authorization", "Bearer "+Treasure.get(MainActivity2.this, TokenPreferenceInterface.class).getToken())
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String tx = response.body().string();
                logger.info("运输单详情："+tx);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }};

    Runnable getIdentity = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://222.143.34.184:7080/web/completeIdentity.do")
                    .method("POST", body)
                    .addHeader("Cookie", Treasure.get(MainActivity2.this,JssionPreferenceInterface.class).getJssion())
                    .build();
            try {
                Response response = client.newCall(request).execute();
                logger.info(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    Runnable onlineCheck = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://222.143.34.184:7080/web/onlineCheck.do")
                    .method("POST", body)
                    .addHeader("Cookie", Treasure.get(MainActivity2.this,JssionPreferenceInterface.class).getJssion())
                    .build();
            try {
                Response response = client.newCall(request).execute();
                logger.info(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    Runnable beReg = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://222.143.34.184:7080/web/beRegisteredCount.do")
                    .method("GET", null)
                    .addHeader("Cookie", Treasure.get(MainActivity2.this,JssionPreferenceInterface.class).getJssion())
                    .build();
            try {
                Response response = client.newCall(request).execute();
                logger.info("bereg : "+response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    //中科软
    Runnable getNetworkTask8 = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://49.119.98.69:8002/bt_epi/getChildVaccinaAction.action?opType=16&forwordType=99&platId=8a03809778a0d9db0178a0e089580001&curUserId=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4YTAzODA4Zjc3ZTQ3OWQ0MDE3N2U4M2VjMjhiMDI5ZiIsImF1ZCI6ImFkbWluIiwibG9naW5JcCI6IjExMi4yMjQuNzEuNzgsIDEwLjEwLjExLjI0MCIsImlzcyI6ImFkbWluIiwiZXhwIjoxNjE5NTU0MDk1LCJpYXQiOjE2MTk1MTgwOTUsImp0aSI6ImEwOGVhZWE4LTliM2MtNGUzMC04MDBjLWY2YjQ3ZjE2OGEyNjAuMTc2MjYwODc2NDM4OTU3MjcifQ.4owDYCXl9AvrNJ3cx450QEJ_5hYQBrJUM92JciveOOU")
                    .method("POST", body)
                    .addHeader("Cookie", "JSESSIONID=293E1D13304FDF4AAA6126B8E8A9E98F")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                logger.info(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public void login(View paramView){
        new Thread(networkTask8).start();
    }

    public void checkOnline(View view){
//        new Thread(getIdentity).start();
//        new Thread(onlineCheck).start();
//        new Thread(beReg).start();
//        new Thread(getNetworkTask5).start();
    }

    public void getCode(View view){
        new Thread(getNetworkTask7).start();
    }

    public void ossLogin(View view){
        new Thread(getNetworkTask4).start();
    }

}