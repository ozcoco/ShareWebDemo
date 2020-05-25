package com.xdynamics.share.p2p;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xdynamics.share.R;
import com.xdynamics.share.p2p.ui.P2pFragment;

public class P2pActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p2p_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, P2pFragment.newInstance())
                    .commitNow();
        }
    }
}
