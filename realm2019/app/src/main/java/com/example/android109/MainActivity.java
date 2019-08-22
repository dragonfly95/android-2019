package com.example.android109;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android109.realm.UserVO;
import com.example.android109.service.JobSchedulerStart;

import org.w3c.dom.Text;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


/**
 * 출처
 * https://github.com/YunTaeSik/AlarmManagerExample
 */
public class MainActivity extends AppCompatActivity {

  private Realm mRealm;
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      JobSchedulerStart.start(this);
    }

    textView = (TextView) findViewById(R.id.textView);

    init();

  }


  public void println(String msg) {
    textView.setText(msg);
  }

  private void init() {

    mRealm.init(this);

    RealmConfiguration myconfig = new RealmConfiguration.Builder()
        .name("movies.realm")
        .schemaVersion(1)
        .deleteRealmIfMigrationNeeded()
        .build();

    mRealm = (Realm) Realm.getInstance(myconfig);

    mRealm.beginTransaction();
    UserVO user = mRealm.createObject(UserVO.class, UUID.randomUUID().toString());
    user.setName("John");
    user.setAge(27);
    mRealm.commitTransaction();

    String result = "";
    RealmResults<UserVO> userList = mRealm.where(UserVO.class).findAll();
    for (UserVO userVO : userList) {
      result += userVO.toString() + "\n";
    }
    println(result);
  }

}
