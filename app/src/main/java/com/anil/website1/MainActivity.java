package com.anil.website1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        w= (WebView) findViewById(R.id.webView);
        w.setWebViewClient(new myWebClient());
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl("http://anilraj.pythonanywhere.com/m_slogin");
    }
    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;

        }
    }

    @Override
    // This method is used to detect back button
    public void onBackPressed() {

        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("");
        ab.setMessage("Are you sure to exit?");
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //if you want to kill app . from other then your main avtivity.(Launcher)
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

                //if you want to finish just current activity

                MainActivity.this.finish();
            }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        ab.show();
      /*  if(w.canGoBack()) {
            w.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }*/
    }
}
