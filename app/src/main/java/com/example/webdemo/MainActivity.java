package com.example.webdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.webdemo.common.AndroidInterface;
import com.example.webdemo.config.Config;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebView;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebViewClient;

public class MainActivity extends AppCompatActivity {

    AgentWeb mAgentWeb;

    private LinearLayout mLinearLayout;

    private Button mBtnGetTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayout = (LinearLayout) this.findViewById(R.id.container);
        mBtnGetTxt = findViewById(R.id.getTxt);

        /*mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) mLinearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go("http://222.143.34.184:7080/web/login.do?repeLogin=null");*/

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebViewClient(mWebViewClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl() //拦截找不到相关页面的Scheme
                .createAgentWeb()
                .ready()
                .go("http://222.143.34.184:7080/web/login.do?repeLogin=null");

        if(mAgentWeb!=null){
            //注入对象
            mAgentWeb.getJsInterfaceHolder().addJavaObject("android",new AndroidInterface(mAgentWeb,this));
        }

        mBtnGetTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAgentWeb.getJsAccessEntrace().quickCallJs("sendHelloToAndroid");
            }
        });

    }



    private com.just.agentweb.WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
            Log.i("Info", "BaseWebActivity onPageStarted");
//            mAgentWeb.getJsAccessEntrace().callJs(loadCss(Config.CSS_URL));
            mAgentWeb.getJsAccessEntrace().callJs(loadCss(Config.CSS_URL));
            mAgentWeb.getJsAccessEntrace().callJs(loadJs(""));
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            //引入自己的CSS文件，适配PAD
            mAgentWeb.getJsAccessEntrace().callJs(loadCss(Config.CSS_URL));

            //引入自己JS文件，完成JS-Android的交互
            mAgentWeb.getJsAccessEntrace().callJs(loadJs(""));

        }
    };

    public static String loadCss(String url) {
        return "javascript:var d=document;" +
                "var s=d.createElement('link');" +
                "s.setAttribute('rel', 'stylesheet');" +
                "s.setAttribute('href', '" + url + "');" +
                "d.head.appendChild(s);";
    }

    public static String loadJs(String js){
        return "function sendHelloToAndroid() {\n" +
                "      // body...\n" +
                "      //console.log(\"call android\")\n" +
                "      if(window.android!=null&&typeof(window.android)!=\"undefined\"){\n" +
                "        window.android.callAndroid(document.getElementsByName('userLoginName')[0].value);\n" +
                "      }else{\n" +
                "         alert(typeof(window.android));\n" +
                "      }\n" +
                "     \n" +
                "  }";
    }
}