//6a
package com.example.prog6;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
 Button btn;
 Notification notification;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 btn=findViewById(R.id.btn);
 NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
 notification = new Notification.Builder(MainActivity.this)
 .setContentTitle("Notification")
 .setContentText("Heyy you are notified")
 .setSmallIcon(R.drawable.ic_launcher_background)
 .setChannelId("mychannel")
 .build();
 nm.createNotificationChannel(new NotificationChannel("mychannel","new channel", 
NotificationManager.IMPORTANCE_HIGH));
 }
 else
 {
 notification = new Notification.Builder(MainActivity.this)
 .setContentTitle("Notification")
 .setContentText("Heyy you are notified")
 .setSmallIcon(R.drawable.ic_launcher_background)
 .build();
 }
 nm.notify(100,notification);
 }
}
//6b
package com.example.p6b;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
 Button btn;
 @SuppressLint("MissingInflatedId")
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 btn=findViewById(R.id.btn);
 btn.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 Intent in= new Intent(Intent.ACTION_PICK, 
ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
 startActivityForResult(in,1);
 }
 });
 }
}
