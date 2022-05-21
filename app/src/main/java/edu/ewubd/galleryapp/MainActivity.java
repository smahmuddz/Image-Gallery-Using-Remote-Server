package edu.ewubd.galleryapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private GridView gridView;
    customImageAdapter customImageAdapter;
    ArrayList<arraylistOfImage> arrayList;

    private String URL = "https://muthosoft.com/univ/photos/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.Gridview);
        arrayList = new ArrayList<>();

        httpRequest();
    }
    @SuppressLint("StaticFieldLeak")
    private void httpRequest(){
        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... param){
                try{
                    String data = JSONParser.getInstance().makeHttpRequest(URL, "POST");
                    return data;
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String data) {
                super.onPostExecute(data);
                //System.out.println(data);
                String[] split = data.split(",");
                ArrayList<arraylistOfImage> arrayList = new ArrayList<>();
                for (String a : split){
                    String[] splitByColon = a.split(":");
                    arraylistOfImage arraylistOfImage = new arraylistOfImage(splitByColon[0], splitByColon[1]);
                    arrayList.add(arraylistOfImage);
                }

                loadData(arrayList);
            }
        }.execute();
    }
    void loadData(ArrayList arrayList){
        customImageAdapter = new customImageAdapter(this,arrayList);
        gridView.setAdapter(customImageAdapter);
        customImageAdapter.notifyDataSetChanged();

    }
}