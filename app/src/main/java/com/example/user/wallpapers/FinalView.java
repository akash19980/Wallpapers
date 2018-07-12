package com.example.user.wallpapers;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class FinalView extends AppCompatActivity {
ImageView imageView;
Button b1;
    WallpaperManager wallpaperManager ;
    Bitmap bitmap1, bitmap2 ;
    DisplayMetrics displayMetrics ;
    int width, height;
    BitmapDrawable bitmapDrawable ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_view);
        b1=(Button)findViewById(R.id.button);
        imageView=(ImageView)findViewById(R.id.imageView3);
        Intent intent = getIntent();

        imageView.setImageResource(intent.getIntExtra("SET",0));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                 bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                bitmap1 = bitmapDrawable.getBitmap();
                GetScreenWidthHeight();

                SetBitmapSize();

                wallpaperManager = WallpaperManager.getInstance(FinalView.this);

                try {

                    wallpaperManager.setBitmap(bitmap2);

                    wallpaperManager.suggestDesiredDimensions(width, height);
                    Toast.makeText(FinalView.this, "WALLPAPER SET", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
    public void GetScreenWidthHeight(){

        displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        width = displayMetrics.widthPixels;

        height = displayMetrics.heightPixels;

    }

    public void SetBitmapSize(){

        bitmap2 = Bitmap.createScaledBitmap(bitmap1, width, height, false);

    }
}
