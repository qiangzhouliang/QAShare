package com.qzl.androidshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.qzl.qashare.utils.ShareBuilder;
import com.qzl.qashare.utils.UriUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author qiangzhouliang
 * @desc 系统分享
 * @email 2538096489@qq.com
 * @time 2021/3/17 11:12
 * @class SystemShareActivity
 * @package com.qzl.androidshare
 */
public class SystemShareActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnShareText;
    private Button btnShareImage;
    private Button btnShareMultiple;
    private Button btnShareFile;

    public static final int REQUEST_SELECT_FILE = 100;

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, SystemShareActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("系统分享");
        setContentView(R.layout.activity_system_share);
        initView();
    }

    private void initView() {
        btnShareText = findViewById(R.id.btnShareText);
        btnShareImage = findViewById(R.id.btnShareImage);
        btnShareMultiple = findViewById(R.id.btnShareMultiple);
        btnShareFile = findViewById(R.id.btnShareFile);
        btnShareFile.setOnClickListener(this);
        btnShareText.setOnClickListener(this);
        btnShareMultiple.setOnClickListener(this);
        btnShareImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnShareText: {
                new ShareBuilder().setText("This is Share Content!").setChooserTitle("分享").setShareType(ShareBuilder.SHARE_TEXT).build().share(this);
            }
            break;
            case R.id.btnShareImage: {
                Uri fileUri = UriUtils.getUriFromFile(this,"/sdcard/DCIM/Camera/IMG_20181126_012932.jpg");
                new ShareBuilder().setChooserTitle("分享").setShareType(ShareBuilder.SHARE_FILE).setShareFiles(Arrays.asList(fileUri)).build().share(this);
            }
            break;
            case R.id.btnShareMultiple: {
                Uri fileUri = UriUtils.getUriFromFile(this,"/sdcard/DCIM/Camera/IMG_20181126_012933.jpg");
                Uri fileUri2 = UriUtils.getUriFromFile(this,"/sdcard/DCIM/Camera/IMG_20181126_012934.jpg");
                ArrayList<Uri> uris = new ArrayList<>();
                uris.add(fileUri);
                uris.add(fileUri2);
                new ShareBuilder().setChooserTitle("分享").setShareType(ShareBuilder.SHARE_MULTIPLE_FILES).setShareFiles(uris).build().share(this);
            }
            break;
            case R.id.btnShareFile:
                startActivityForResult(FileSelectActivity.createIntent(this, Environment.getExternalStorageDirectory().getAbsolutePath()), REQUEST_SELECT_FILE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_SELECT_FILE:
                    Uri fileUri = UriUtils.getUriFromFile(this,data.getStringExtra(FileSelectActivity.EXTRA_GET_FILE));
                    new ShareBuilder().setChooserTitle("分享").setShareType(ShareBuilder.SHARE_FILE).setShareFiles(Arrays.asList(fileUri)).build().share(this);
                    break;
            }
        }
    }
}
