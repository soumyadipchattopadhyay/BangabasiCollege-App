package com.bangabasi_college.ui.slideshow;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;

import com.bangabasi_college.R;

import static android.content.Context.DOWNLOAD_SERVICE;

public class SlideshowFragment extends Fragment {

    private Bundle webviewstate;
    private SlideshowViewModel slideshowViewModel;
    public  WebView mywebView;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);


        mywebView = root.findViewById(R.id.mywebview);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        mywebView.getSettings().setAppCacheEnabled(true);
        //mywebView.getSettings().setBlockNetworkLoads(false);
        mywebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mywebView.getSettings().setAllowFileAccess(true);
        mywebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        mywebView.getSettings().setLoadWithOverviewMode(true);
        mywebView.getSettings().setUseWideViewPort(true);

        mywebView.canGoBack();
        mywebView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && mywebView.canGoBack()) {
                    mywebView.goBack();
                    return true;
                }
                return false;
            }
        });

        mywebView.getSettings().setSupportZoom(true);
        mywebView.getSettings().setBuiltInZoomControls(true);
        mywebView.getSettings().setDisplayZoomControls(false);

        mywebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mywebView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                //view.loadUrl(url);
                System.out.println("hello");
                return false;
            }
        });
        mywebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request( Uri.parse(url));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                DownloadManager dm = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
            }
        });



        if(webviewstate==null){
            mywebView.loadUrl("https://www.cuexamwindow.in/");  //Load the page for first time
        }else{
            mywebView.restoreState(webviewstate);    // Restore the state
        }


        return root;
    }

    @Override
    public void onPause(){
        super.onPause();
        webviewstate = new Bundle();
        mywebView.saveState(webviewstate);
    }


}