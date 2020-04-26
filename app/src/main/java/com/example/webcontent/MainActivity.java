package com.example.webcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView downloadedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadedImage = (ImageView) findViewById(R.id.imageView);

        String result = null;
        DownloadTask downloadTask = new DownloadTask();
        try {
            result = downloadTask.execute("https://www.ecowebhosting.co.uk/").get();
            Log.i("Contenets of Url", result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void downloadImage(View view) {
        Log.i("Interaction", "Button tapped");
        //https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png

        ImageDownloader imageDownloader = new ImageDownloader();
        Bitmap myImage;

        try {
            myImage = imageDownloader.
                    execute("https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png").get();
            downloadedImage.setImageBitmap(myImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
