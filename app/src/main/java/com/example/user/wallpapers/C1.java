package com.example.user.wallpapers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class C1 extends AppCompatActivity {
    GridView audi;
    int[]wallpapers;



@Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1);

        //-----------------------------------gettin---------------------//
    Intent intent=getIntent();

   int aa =intent.getIntExtra("array",0);

    //----------------switch statement started---------//
    switch (aa)
    {
        case 0:
            wallpapers= new int[]{R.drawable.audi1, R.drawable.audi2, R.drawable.audi3, R.drawable.audi4, R.drawable.audi5, R.drawable.audi6, R.drawable.audi7, R.drawable.audi8};
            break;
        case 1:
            wallpapers=new int[]{R.drawable.cod1,R.drawable.cod2,R.drawable.cod3,R.drawable.cod4,R.drawable.cod5,R.drawable.cod6,R.drawable.cod7,R.drawable.cod8};
       break;
        case 2:
            wallpapers=new int[]{R.drawable.cs1,R.drawable.cs2,R.drawable.cs3,R.drawable.cs4,R.drawable.cs5,R.drawable.cs6,R.drawable.cs7,R.drawable.cs8};
break;
        case 3:
            wallpapers=new int[]{R.drawable.hd1,R.drawable.hd2,R.drawable.hd3,R.drawable.hd4,R.drawable.hd5,R.drawable.hd6,R.drawable.hd7,R.drawable.hd8};
            break;
        case 4:
            wallpapers=new int[]{R.drawable.dota1,R.drawable.dota2,R.drawable.dota3,R.drawable.dota4};
      break;
        case 6:
            wallpapers=new int[]{R.drawable.pubg1,R.drawable.pubg2,R.drawable.pubg3,R.drawable.pubg4,R.drawable.pubg5,R.drawable.pubg6,R.drawable.pubg7,R.drawable.pubg8};
            break;
        case 5 :
            wallpapers=new int[]{R.drawable.nature1,R.drawable.nature2,R.drawable.nature3,R.drawable.nature4,R.drawable.nature5,R.drawable.nature6,R.drawable.nature7,R.drawable.nature8};
            break;
        case 7:
            wallpapers=new int[]{R.drawable.vector1,R.drawable.vector2,R.drawable.vector3,R.drawable.vector4,R.drawable.vector5,R.drawable.vector6,R.drawable.vector7,R.drawable.vector8};
    break;
    }
       audi = (GridView)findViewById(R.id.gridView);
        audi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(C1.this,FinalView.class);
                intent.putExtra("SET",wallpapers[i]);
                startActivity(intent);
            }
        });


    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
    for(int i=0;i<wallpapers.length;i++)
    {
        HashMap<String,String> join= new HashMap<>();
        join.put("IMAGE",wallpapers[i]+"");
        arrayList.add(join);
    }
    String[] from ={"IMAGE"};
    int[] to ={R.id.imageView2};
    final SimpleAdapter sa = new SimpleAdapter(this,arrayList,R.layout.wallpapergrid,from,to);
    audi.setAdapter(sa);

    }
}
