package nyc.muaadh_melhi_develpoer.inclassretrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import nyc.muaadh_melhi_develpoer.inclassretrofit.R;
import nyc.muaadh_melhi_develpoer.inclassretrofit.modelpart3.Dogs;

/**
 * Created by c4q on 12/17/17.
 */

class DogeViewHolder extends RecyclerView.ViewHolder {
    public DogeViewHolder(View itemView) {
        super(itemView);
    }

    public void Bind(String s) {
        ImageView imageView= itemView.findViewById(R.id.image);
        Picasso.with(itemView.getContext()).load(s).centerCrop().resize(300,300).into(imageView);
    }
}
