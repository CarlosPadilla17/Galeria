package com.example.galeria_ringtonesoficial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class ShareActivity extends AppCompatActivity {

    Button home, face, wsp, twit, insta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        home = (Button)findViewById(R.id.home);
        face = (Button)findViewById(R.id.face);
        wsp = (Button)findViewById(R.id.wsp);
        twit = (Button)findViewById(R.id.twit);
        insta = (Button)findViewById(R.id.insta);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShareActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                finish();
            }
        });

        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Encuentra la mejor variedad de sonidos en http://www.sonidosmp3gratis.com");
                share.setPackage("com.facebook.katana");
                startActivity(Intent.createChooser(share, "Compartir"));
            }
        });

        wsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Encuentra la mejor variedad de sonidos en http://www.sonidosmp3gratis.com");
                share.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(share, "Compartir"));
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Encuentra la mejor variedad de sonidos en http://www.sonidosmp3gratis.com");
                share.setPackage("com.instagram.android");
                startActivity(Intent.createChooser(share, "Compartir"));
            }
        });

        twit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Encuentra la mejor variedad de sonidos en http://www.sonidosmp3gratis.com");
                share.setPackage("com.twitter.android");
                startActivity(Intent.createChooser(share, "Compartir"));
            }
        });
    }
}