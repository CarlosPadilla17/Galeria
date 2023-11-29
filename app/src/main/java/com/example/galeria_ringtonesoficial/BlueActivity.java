package com.example.galeria_ringtonesoficial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

public class BlueActivity extends AppCompatActivity {

    Button home, blue;
    private TextView textViewShare;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue);
        home = (Button)findViewById(R.id.home);
        blue = (Button)findViewById(R.id.blue);
        textViewShare = findViewById(R.id.textViewShare);
        mediaPlayer = MediaPlayer.create(this, R.raw.bell);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BlueActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                finish();
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BlueActivity.this, "Enviando\nPor favor espere...", Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewShare.setText("Archivo compartido!");
                        Toast.makeText(BlueActivity.this, "Enviado exitosamente!", Toast.LENGTH_SHORT).show();
                        mediaPlayer.start();
                        new AlertDialog.Builder(BlueActivity.this)
                                .setMessage("¡Has conseguido un punto!\n¿Deseas salir de la aplicación?")
                                .setCancelable(false)
                                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        finishAffinity();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(BlueActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        finish();
                                    }
                                })
                                .setTitle("¡Felicidades!")
                                .setIcon(R.drawable.info)
                                .setPositiveButtonIcon(getResources().getDrawable(R.drawable.exit))
                                .setNegativeButtonIcon(getResources().getDrawable(R.drawable.cancel))
                                .show();
                    }
                }, 5000);
            }
        });
    }
    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}