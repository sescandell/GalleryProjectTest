package org.sescandell.galleryproject;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.AbsListView;

import com.android.volley.RequestQueue;

import org.sescandell.galleryproject.Adapter.PictureAdapter;
import org.sescandell.galleryproject.Model.Picture;
import org.sescandell.galleryproject.app.Application;

import java.util.ArrayList;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Picture> pictures = new ArrayList<Picture>();

        for (int i=0; i<200; i++) {
            pictures.add(new Picture(Integer.toString(i)));
        }

        setListAdapter(new PictureAdapter(this, pictures, ((Application)this.getApplication()).getImageLoader()));
    }
}
