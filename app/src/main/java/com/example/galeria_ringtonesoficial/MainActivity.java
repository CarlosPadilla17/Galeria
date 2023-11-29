package com.example.galeria_ringtonesoficial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    Button play1, play2, play3, play4, play5, play6, download1, download2, download3, download4, download5, download6,
           share1, share2, share3, share4, share5, share6, blue1, blue2, blue3, blue4, blue5, blue6;
    MediaPlayer mp1, mp2, mp3, mp4, mp5, mp6;

    String url1, url2, url3, url4, url5, url6;

    private long downloadID;

    private void downloadFile(String url, String fileName) {
        Uri uri = Uri.parse(url);

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName + ".mp3");

        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadID = downloadManager.enqueue(request);
        registerReceiver(new DownloadReceiver(), new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }
    private class DownloadReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            long receivedID = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (receivedID == downloadID) {
                Toast.makeText(MainActivity.this, "Descarga completada", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play1 = (Button)findViewById(R.id.play1);
        play2 = (Button)findViewById(R.id.play2);
        play3 = (Button)findViewById(R.id.play3);
        play4 = (Button)findViewById(R.id.play4);
        play5 = (Button)findViewById(R.id.play5);
        play6 = (Button)findViewById(R.id.play6);

        download1 = (Button)findViewById(R.id.download1);
        download2 = (Button)findViewById(R.id.download2);
        download3 = (Button)findViewById(R.id.download3);
        download4 = (Button)findViewById(R.id.download4);
        download5 = (Button)findViewById(R.id.download5);
        download6 = (Button)findViewById(R.id.download6);

        share1 = (Button)findViewById(R.id.share1);
        share2 = (Button)findViewById(R.id.share2);
        share3 = (Button)findViewById(R.id.share3);
        share4 = (Button)findViewById(R.id.share4);
        share5 = (Button)findViewById(R.id.share5);
        share6 = (Button)findViewById(R.id.share6);

        blue1 = (Button)findViewById(R.id.blue1);
        blue2 = (Button)findViewById(R.id.blue2);
        blue3 = (Button)findViewById(R.id.blue3);
        blue4 = (Button)findViewById(R.id.blue4);
        blue5 = (Button)findViewById(R.id.blue5);
        blue6 = (Button)findViewById(R.id.blue6);

        mp1 = MediaPlayer.create(this,R.raw.estumujer_);
        mp2 = MediaPlayer.create(this,R.raw.autofantastico_);
        mp3 = MediaPlayer.create(this,R.raw.iphone_);
        mp4 = MediaPlayer.create(this,R.raw.patodonald_);
        mp5 = MediaPlayer.create(this,R.raw.supermariobros_);
        mp6 = MediaPlayer.create(this,R.raw.youtears);

        url1 = "http://www.sonidosmp3gratis.com/sounds/graciosos-alarma-es-tu-mujer-.mp3";
        url2 = "http://www.sonidosmp3gratis.com/sounds/kit-auto-fantastico-series-tv-.mp3";
        url3 = "http://www.sonidosmp3gratis.com/sounds/ringtones-iphone-8-plus.mp3";
        url4 = "http://www.sonidosmp3gratis.com/sounds/ringtones-pato-donald.mp3";
        url5 = "http://www.sonidosmp3gratis.com/sounds/ringtones-super-mario-bros.mp3";
        url6 = "https://files.gospeljingle.com/uploads/music/2023/01/The_Weeknd_Ariana_Grande_-_Save_Your_Tears.mp3";


        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp1.isPlaying()){
                    mp1.pause();
                } else {
                    mp1.start();
                }
                play1.setSelected(mp1.isPlaying());
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp2.isPlaying()){
                    mp2.pause();
                } else {
                    mp2.start();
                }
                play2.setSelected(mp2.isPlaying());
            }
        });
        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp3.isPlaying()){
                    mp3.pause();
                } else {
                    mp3.start();
                }
                play3.setSelected(mp3.isPlaying());
            }
        });
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp4.isPlaying()){
                    mp4.pause();
                } else {
                    mp4.start();
                }
                play4.setSelected(mp4.isPlaying());
            }
        });
        play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp5.isPlaying()){
                    mp5.pause();
                } else {
                    mp5.start();
                }
                play5.setSelected(mp5.isPlaying());
            }
        });
        play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp6.isPlaying()){
                    mp6.pause();
                } else {
                    mp6.start();
                }
                play6.setSelected(mp6.isPlaying());
            }
        });
        download1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile(url1, "estumujer");
            }
        });
        download2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile(url2, "autofantastico");
            }
        });
        download3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile(url3, "iphone");
            }
        });
        download4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile(url3, "patodonald");
            }
        });
        download5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile(url1, "supermariobros");
            }
        });
        download6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile(url6, "saveyoutears");
            }
        });
        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(i);
            }
        });
        share2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(i);
            }
        });
        share3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(i);
            }
        });
        share4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(i);
            }
        });
        share5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(i);
            }
        });
        share6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(i);
            }
        });
        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BlueActivity.class);
                startActivity(intent);
            }
        });
        blue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BlueActivity.class);
                startActivity(intent);
            }
        });
        blue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BlueActivity.class);
                startActivity(intent);
            }
        });
        blue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BlueActivity.class);
                startActivity(intent);
            }
        });
        blue5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BlueActivity.class);
                startActivity(intent);
            }
        });
        blue6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BlueActivity.class);
                startActivity(intent);
            }
        });
    }
}