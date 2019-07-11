package android.example.alc40phase1challenge;

import android.net.http.SslError;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AboutAlc extends AppCompatActivity {
    WebView alcWebView;
    ProgressBar progressBar;
    private static final String TAG = "AboutAlc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        setContentView(R.layout.activity_about_alc);
         bindViews();
        loadWebView();
    }


    private void loadWebView() {
        alcWebView.getSettings().setJavaScriptEnabled(true);
        alcWebView.getSettings().setLoadWithOverviewMode(true);
        alcWebView.getSettings().setUseWideViewPort(true);
        alcWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Log.i(TAG, "shouldOverrideUrlLoading: loading the site");
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                Log.i(TAG, "onPageFinished: finished");

            }
        });
//        alcWebView.loadUrl("https://www.google.com");
        alcWebView.loadUrl(getString(R.string.andela_alc_web_link));
    }

    private void bindViews() {
        alcWebView = findViewById(R.id.alcWebView);
        progressBar = findViewById(R.id.progressBar2);
    }
}
