package com.example.notificationprog6a;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
 Button but;
 Context context=MainActivity.this;
 String CHANNEL_ID="my_channel_01";
 CharSequence name = "my_channel";
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 but= findViewById(R.id.buttonNotify);
 NotificationManager notificationManager = (NotificationManager) 
context.getSystemService(Context.NOTIFICATION_SERVICE);
 but.setOnClickListener(v -> {
 NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, 
NotificationManager.IMPORTANCE_HIGH);
 notificationManager.createNotificationChannel(mChannel);
 Intent notificationIntent = new Intent(context, MainActivity.class);
 TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
 stackBuilder.addParentStack(MainActivity.class);
 stackBuilder.addNextIntent(notificationIntent);
 PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, 
PendingIntent.FLAG_IMMUTABLE);
NotificationCompat.Builder builder = new 
NotificationCompat.Builder(context,CHANNEL_ID);
 Notification notification = builder.setContentTitle("Notification Title")
 .setContentText("Notification Text")
 .setTicker("Test!")
 .setSmallIcon(R.mipmap.ic_launcher)
 .setAutoCancel(true)
 .setContentIntent(pendingIntent).build();
 notificationManager.notify(0, notification);
 });
 }
}

// MainActivity.java(6b):
// package com.example.contentprovider6b;
// import android.Manifest;
// import android.annotation.SuppressLint;
// import android.app.Activity;
// import android.content.Intent;
// import android.database.Cursor;
// import android.net.Uri;
// import android.os.Bundle;
// import android.provider.ContactsContract;
// import android.widget.Button;
// import android.widget.Toast;
// import androidx.appcompat.app.AppCompatActivity;
// import androidx.core.app.ActivityCompat;
// @SuppressWarnings("ALL")
// public class MainActivity extends AppCompatActivity {
//  public static final int RequestPermissionCode = 1 ;
//  @Override
// protected void onCreate(Bundle savedInstanceState) {
//  super.onCreate(savedInstanceState);
//  setContentView(R.layout.activity_main);
//  Button button = findViewById(R.id.button);
//  EnableRuntimePermission();
//  button.setOnClickListener(v -> {
//  Intent intent = new Intent(Intent.ACTION_PICK, 
// ContactsContract.Contacts.CONTENT_URI);
//  startActivityForResult(intent, 1);
//  });
//  }
//  public void EnableRuntimePermission(){
//  if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, 
// Manifest.permission.READ_CONTACTS))
//  {
//  Toast.makeText(MainActivity.this,"CONTACTS permission allows us to Access 
// CONTACTS app", Toast.LENGTH_LONG).show();
//  } else {
//  ActivityCompat.requestPermissions(MainActivity.this,new String[]{ 
// Manifest.permission.READ_CONTACTS}, RequestPermissionCode);
//  }
//  }
//  @Override
//  public void onActivityResult(int reqCode, int resultCode, Intent data){
//  super.onActivityResult(reqCode, resultCode, data);
//  if (reqCode == 1) {
//  if (resultCode == Activity.RESULT_OK) {
//  Uri contactData = data.getData();
//  try (Cursor c = managedQuery(contactData, null, null, null, null)) {
//  if (c.moveToFirst()) {
//  String id = 
// c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
//  @SuppressLint("Range")
//  String hasPhone = 
// c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
//  if (hasPhone.equalsIgnoreCase("1")) {
//  Cursor phones = 
// getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
// null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
//  phones.moveToFirst();
//  @SuppressLint("Range")
//  String cNumber = 
// phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//  Toast.makeText(getApplicationContext(), cNumber, 
// Toast.LENGTH_SHORT).show();
//  phones.close();
//  }
//  }
//  }
//  catch(Exception e)
//  {
//  e.printStackTrace();
//  }
//  }
//  }
//  }
// }
// AndriodManifest.xml
// <uses-permission android:name="android.permission.READ_CONTACTS"/>
