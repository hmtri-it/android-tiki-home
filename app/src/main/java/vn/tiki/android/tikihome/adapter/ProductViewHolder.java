package vn.tiki.android.tikihome.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.tiki.android.tikihome.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    public TextView productName;
    public LinearLayout lnLayout;
    public int[] androidColors;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        lnLayout = itemView.findViewById( R.id.lnLayout);
        productName = itemView.findViewById(R.id.productName);
        androidColors = itemView.getResources().getIntArray(R.array.androidcolors);
    }
}
