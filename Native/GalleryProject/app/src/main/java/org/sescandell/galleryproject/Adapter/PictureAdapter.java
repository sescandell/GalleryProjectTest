package org.sescandell.galleryproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import org.sescandell.galleryproject.Model.Picture;
import org.sescandell.galleryproject.R;

import java.util.List;


public class PictureAdapter extends ArrayAdapter<Picture> {
    private ImageLoader imageLoader;

    public PictureAdapter(Context context, List<Picture> pictures, ImageLoader imageLoader) {
        super(context, R.layout.itempicture, R.id.itempicture_name, pictures);
        this.imageLoader = imageLoader;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (null == v) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.itempicture, parent, false);
        }

        ViewHolder viewHolder = (ViewHolder) v.getTag();

        if (null == viewHolder) {
            viewHolder = new ViewHolder(v);
        }

        Picture picture = getItem(position);
        viewHolder.imageView.setImageUrl(picture.getSourceUrl(), imageLoader);
        viewHolder.nameView.setText(picture.getName());

        return v;
    }

    private class ViewHolder {
        public NetworkImageView imageView;
        public TextView nameView;

        public ViewHolder(View view) {
            imageView = (NetworkImageView) view.findViewById(R.id.itempicture_image);
            nameView = (TextView) view.findViewById(R.id.itempicture_name);

            view.setTag(this);
        }
    }
}
