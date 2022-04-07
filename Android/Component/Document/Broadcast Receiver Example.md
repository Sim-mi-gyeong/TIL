안드로이드 4대 컴포넌트를 정리하면서 각 컴포넌트 별로 예제를 연습하기 위해서 작성하며, 

[Example]

  -  스마트폰에 전원 연결 및 전원 연결 해제 시 Toast Message 출력


  -  방송 버튼 클릭 시 '방송' 에 해당하는 Toast Message 출력



AndroidManifest.xml


  -  브로드캐스트 이벤트를 사용하기 위해서는, AndroidManifest.xml 에 정의



  -  전원 연결과 전원 해제 상태에 해당하는 ACTION_POWER_CONNECTED 와 ACTION_POWER_DISCONNECTED 추가



<!-- 브로드캐스트 리시버 정의 -->
<receiver
    android:name=".TestReceiver"
    android:enabled="true"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.ACTION_POWER_CONNECTED" />
        <action android:name="android.intent.action.ACTION_POWER_DISCONNECTED" />
    </intent-filter>
</receiver>


MainActivity.java


  -  MainActivity 는 방송을 하는 발신자 역할을 하며, 브로드캐스트 리시버를 호출한다.




  1.  브로드캐스트 중에서 어떤 것을 수신할 것인지 등록하는 단계



    -  실제 방송의 채널에 해당하는 action 중 수신을 원하는 action 을 IntentFilter 를 통해 지정 가능



    -> 등록한 채널 중 실제 시청하고 싶은 채널을 고르기 위해서는,



        브로드캐스트 리시버의 onReceiver() 메서드를 통해 구현 가능



IntentFilter filter = new IntentFilter();
filter.addAction(Intent.ACTION_POWER_CONNECTED);
filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
// Local 로 등록
filter.addAction(TestReceiver.TestAction);


  2.  방송을 보내는 단계



    -  인텐트 하나 선언 + 나만의 채널(action, 여기서는 TestAction) 생성



   -> sendBroadcast() 메서드에 intent 를 인자로 넘겨주기



   -> 이 방송을 수신하기 위해서는, 자신이 선언한 action, 여기서는 TestAction 값이 filter에 정확하게 등록되어 있어야 함



    -> filter.addAction(TestReceiver.TestAction) 을 통해 등록



     + ) 특정 패키지에만 전달 시 Intent 에 setPackage() 를 이용해 수신할 패키지 설정 가능



// 브로드캐스트 리시버에 액션 전송 - 버튼 클릭
public void sendTestBroadCast(View view) {
    // Action 을 담아 리시버로 인텐트 발송
    Intent intent = new Intent(TestReceiver.TestAction);
    sendBroadcast(intent);
}


[MainActivity.java 전체 코드]

package com.me.backgrounddetectiontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

// 방송을 하는 발신자 역할
public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mReceiver;   // BroadcastReceiver 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReceiver = new TestReceiver();   // TestReceiver 클래스를 Broadcast Receiver 로 정의
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * IntentFilter : 암시적 인텐트 -> 사용자에게 어느 앱을 사용할지 선택하도록 할 때 사용
         * Ex) 사용자가 다른 사람들과 함께 공유하고자 하는 콘텐츠의 경우
         *  -> ACTION_SEND 라는 Action 이 있는 인텐트 생성 후 -> 공유할 콘텐츠를 지정하는 Extra 추가
         */
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        // Local 로 등록
        filter.addAction(TestReceiver.TestAction);
        registerReceiver(mReceiver, filter);
    }

    // 리시버 해제
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
    // 브로드캐스트 리시버에 액션 전송 - 버튼 클릭
    public void sendTestBroadCast(View view) {
        // Action 을 담아 리시버로 인텐트 발송
        Intent intent = new Intent(TestReceiver.TestAction);
        sendBroadcast(intent);
    }
}


TestReceiver.java


  1.  BroadcastReceiver 의 역할



    -  브로드캐스트 리시버인 TestReceiver 는 수신자 역할을 하며



    -  해당하는 브로드캐스트 이벤트 발생 시 onReceive 에서 정의한 이벤트가 동작한다.



    -  전원 연결 및 해제 시, 방송 버튼 클릭 시 Toast Message 가 출력되도록



    -  BroadcastReciver 라는 안테나에 수신된 전파는, 최종적으로 onReceiver() 라는 셋톱박스로 들어오는 것



   -> onReceiver() 에서 원하는 action에 대한 처리 수행





  2.  Androidmanifest에서 브로드캐스트 리시버 사용



    -  BroadcastReceiver를 상속받은 class = receiver => filter.addAction() 을 통해 수신할 action 지정하는



       코드 레벨이 아닌 아래와 같이 AndroidManifest에 적용 가능



    -> filter.addAction(TestReceiver.TestAction) 대신 TestAction String 을 Manifest 에 지정한 후



    -> intent.setAction(TestAction) 가능 



    -> 그러나, 전체 코드에는 적용하지 않음 !

<receiver
    android:name=".TestReceiver"
    android:enabled="true"
    android:exported="true">
    <intent-filter>
        <action android:name="com.me.backgrounddetectiontest.ACTION_TEST_BROADCAST" />
    </intent-filter>
</receiver>


  3.  액티비티의 생명주기를 이용하는 브로드캐스트



    1)  리시버 등록에 따라 onResume(), onStart(), onPause(), onStop( 에 적절히 추가 / 삭제 



      -  브로드캐스트 사용 시 AndroidManifest.xml에 <intent-filter> 등록 필요



      -  그러나, 암시적 인텐트는 추가 X -> IntentFilter 객체를 만들어 동적으로 만들어야 함



      + ) 명시적 인텐트 Vs 암시적 인텐트

명시적 인텐트(Explicit Intent)



  -  인텐트에 SubActiviti.class 를 인자로 넣는 것과 같이 그 액티비티를 실행할 것을 명확하게 전달



 -> ActivityManager 는 해당 인텐트를 해석하여 SubActivity 실행



Intent intent = new Intent(this, SubActivity.class)
startActivity(intent)


암시적 인텐트(Implicit Intent)



  -  암시적 인텐트는 클래스명이나 패키지명을 넣지 X



     Ex) 디바이스에 설치된 앱들 중 액션이 ACTION_DIAL, Uri가 tel:5551212 인 인텐트를 처리할 수 있는 액티비티를 찾아서 실행



     -> 디바이스에 설치된 전화앱 실행 -> Uri에 입력된 번호 5551212 가 자동으로 입력 됨



     -> 전화앱에서 액티비티가 실행되면서 주어진 Uri를 읽어 번호를 입력하도록 구현된 것 



Intent intent = new Intent(Intent.ACTION_DIAL)
Data TEST_DIAL_VUMBER = Uri.fromParts("tel", "5551212", null)
intent.setData(TEST_DIAL_NUMBER)
startActivity(intent)


    2)  onPause() 에서 리시버 해제


    3)  sendBroadcast() 를 통해 브로드캐스트 리시버에 액션 전달



[TestReceiver.java 전체 코드]



package com.me.backgrounddetectiontest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

// 방송을 받는 수신자 역할
// 해당하는 브로드캐스트 이벤트가 발생하면 onReceive 에 정의한 이벤트가 작동
public class TestReceiver extends BroadcastReceiver {

    // TODO TestAction = 액션 명 => '패키지명.action.액션명(자유롭게)' 형태 지정
    public final static String TestAction = "com.me.backgrounddetectiontest.ACTION_TEST_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // 각 방송 정보가 intent 로 전달
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            Toast.makeText(context, "전원 연결 상태", Toast.LENGTH_SHORT).show();
        } else if(Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())) { 
            Toast.makeText(context, "전원 해제 상태", Toast.LENGTH_SHORT).show(); 
        } else if (TestAction.equals(intent.getAction())) {
            Toast.makeText(context, "방송", Toast.LENGTH_SHORT).show();

        }
    }
}


activity_main.xml


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <Button
        android:id="@+id/button"
        android:onClick="sendTestBroadCast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="방송"/>

</LinearLayout>



참고 



  -  https://brunch.co.kr/@mystoryg/48#comment



  -  https://50billion-dollars.tistory.com/entry/Android-%EB%B8%8C%EB%A1%9C%EB%93%9C%EC%BA%90%EC%8A%A4%ED%8A%B8-%EB%A6%AC%EC%8B%9C%EB%B2%84-Broadcast-Receiver



  -  https://crazykim2.tistory.com/633