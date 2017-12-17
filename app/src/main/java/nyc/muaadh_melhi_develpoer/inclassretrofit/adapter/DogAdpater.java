package nyc.muaadh_melhi_develpoer.inclassretrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import nyc.muaadh_melhi_develpoer.inclassretrofit.R;

/**
 * Created by c4q on 12/17/17.
 */

public class DogAdpater extends RecyclerView.Adapter<DogeViewHolder> {
    List<String> dogsList=new ArrayList<>();
    public DogAdpater(List<String> dogsList) {
        this.dogsList=dogsList;
    }

    @Override
    public DogeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_layout,parent,false);
        return new DogeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DogeViewHolder holder, int position) {
     holder.Bind(dogsList.get(position));
    }

    @Override
    public int getItemCount() {
        return dogsList.size();
    }
}
