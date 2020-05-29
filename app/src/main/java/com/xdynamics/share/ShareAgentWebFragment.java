package com.xdynamics.share;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.DefaultWebClient;
import com.xdynamics.share.base.IActivity;
import com.xdynamics.share.base.IOnKeyDown;
import com.xdynamics.share.platform.SharePlatform;
import com.xdynamics.share.widget.WebLayout;

import java.util.Objects;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share
 * @ClassName: ShareAgentWebFragment
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/27 11:15
 * @UpdateUser:
 * @UpdateDate: 2020/5/27 11:15
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShareAgentWebFragment extends Fragment implements IOnKeyDown {

    protected AgentWeb mAgentWeb;

    private LinearLayout mLinearLayout;

    private Toolbar mToolbar;

    private TextView mTitleTextView;

    private AlertDialog mAlertDialog;

    private IActivity mActivity;

    private WebLayout mWebLayout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context != null) {
            mActivity = (IActivity) context;
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_share_agent_web, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WebView.setWebContentsDebuggingEnabled(true);

        mLinearLayout = view.findViewById(R.id.container);
        mToolbar = view.findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("");
        mTitleTextView = view.findViewById(R.id.toolbar_title);
        mActivity.setSupportActionBar(mToolbar);
        if (mActivity.getSupportActionBar() != null) {
            // Enable the Up button
            mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mToolbar.setNavigationOnClickListener(v -> showDialog());

        mWebLayout = new WebLayout(Objects.requireNonNull(getContext())){

//            {
//                Objects.requireNonNull(getWebView()).getSettings().setUserAgentString("PC");
//            }
        };

        mWebLayout.getLayout().setOnRefreshListener(() -> {

            if (mAgentWeb != null)
                mAgentWeb.getUrlLoader().reload();

        });

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SharePlatform platform = ShareManager.getInstance().platform();

        platform.client().setOnPageLoadingListener(new ShareWebViewClient.OnPageLoadingListener() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mWebLayout.getLayout().setRefreshing(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mWebLayout.getLayout().setRefreshing(false);
            }
        });

        String cookies = AgentWebConfig.getCookiesByUrl(platform.index());
        AgentWebConfig.syncCookie(platform.index(), cookies);

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(platform.chromeClient())
                .setWebViewClient(platform.client())
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setWebLayout(mWebLayout)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl() //拦截找不到相关页面的Scheme
                .createAgentWeb()
                .ready()
                .go(platform.index());

    }


    private void showDialog() {

        if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog.Builder(Objects.requireNonNull(getContext()))
                    .setMessage("您确定要关闭该页面吗?")
                    .setNegativeButton("再逛逛", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (mAlertDialog != null) {
                                mAlertDialog.dismiss();
                            }
                        }
                    })//
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            if (mAlertDialog != null) {
                                mAlertDialog.dismiss();
                            }
                            Objects.requireNonNull(getActivity()).finish();
                        }
                    }).create();
        }
        mAlertDialog.show();

    }


    @Override
    public void onPause() {
        super.onPause();

        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onPause();
        }
    }


    @Override
    public void onResume() {
        super.onResume();

        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onResume();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onDestroy();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        return mAgentWeb.handleKeyEvent(keyCode, event);
    }
}
