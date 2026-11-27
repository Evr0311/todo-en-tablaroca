package mx.todoentablaroca.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.view.ViewGroup;

public class MainActivity extends Activity {

    private WebView navegador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navegador = new WebView(this);

        navegador.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));

        WebSettings ajustes = navegador.getSettings();
        ajustes.setJavaScriptEnabled(true);
        ajustes.setDomStorageEnabled(true);
        ajustes.setLoadWithOverviewMode(true);
        ajustes.setUseWideViewPort(true);

        navegador.setWebViewClient(new WebViewClient());

        setContentView(navegador);

        navegador.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (navegador != null && navegador.canGoBack()) {
            navegador.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
