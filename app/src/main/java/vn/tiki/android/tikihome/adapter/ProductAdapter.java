package vn.tiki.android.tikihome.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

import vn.tiki.android.tikihome.R;
import vn.tiki.android.tikihome.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_product_view, parent, false);
        return new ProductViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productHolder, int position) {
        final Product product = products.get(position);
        int randomAndroidColor = productHolder.androidColors[new Random ().nextInt(productHolder.androidColors.length)];

        productHolder.lnLayout.setBackgroundColor(randomAndroidColor);
        productHolder.productName.setText(product.getNameProduct());
        productHolder.productName.setTextColor( Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
