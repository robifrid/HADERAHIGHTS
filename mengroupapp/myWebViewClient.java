package com.example.dor.mengroupapp;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Dor on 06/01/2018.
 */

public class myWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String urlRequest) {
        view.loadUrl(urlRequest);
        return true;
    }
}
