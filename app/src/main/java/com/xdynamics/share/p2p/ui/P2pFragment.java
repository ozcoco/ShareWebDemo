package com.xdynamics.share.p2p.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.WriterException;
import com.xdynamics.share.R;
import com.xdynamics.share.qr.QrUtils;
import com.xdynamics.share.utils.NetworkUtils;

import java.util.concurrent.Executors;

public class P2pFragment extends Fragment implements View.OnClickListener {

    private P2pViewModel mVm;

    private AppCompatImageView img_qr;

    private AppCompatTextView tv_url;

    public static P2pFragment newInstance() {
        return new P2pFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.p2p_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_start_server).setOnClickListener(this);
        view.findViewById(R.id.btn_stop_server).setOnClickListener(this);
        img_qr = view.findViewById(R.id.img_qr);
        tv_url = view.findViewById(R.id.tv_url);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mVm = ViewModelProviders.of(this).get(P2pViewModel.class);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_start_server:

                mVm.startServer();

                Executors.newSingleThreadExecutor().execute(() -> {

                    if (img_qr != null) {
                        try {

                            String url = "http://" + NetworkUtils.getIpAddress() + ":" + mVm.SERVER_PORT;

                            Bitmap bmp = QrUtils.createQR(url, new Size(800, 800));

                            img_qr.post(() -> img_qr.setImageBitmap(bmp));

                            tv_url.post(() -> tv_url.setText(url));

                        } catch (WriterException e) {
                            e.printStackTrace();
                        }
                    }

                });

                break;

            case R.id.btn_stop_server:

                mVm.stopServer();

                break;
        }

    }
}
