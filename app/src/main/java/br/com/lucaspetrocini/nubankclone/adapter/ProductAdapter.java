package br.com.lucaspetrocini.nubankclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.lucaspetrocini.nubankclone.databinding.AdapterProductBinding;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private final Context context;
    private final List<String> productList;

    public ProductAdapter(Context context, List<String> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterProductBinding adapterProductBinding = AdapterProductBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(adapterProductBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.adapterProductBinding.txtInformativeText.setText(productList.get(position));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final AdapterProductBinding adapterProductBinding;

        public MyViewHolder(@NonNull AdapterProductBinding adapterProductBinding) {
            super(adapterProductBinding.getRoot());
            this.adapterProductBinding = adapterProductBinding;
        }
    }
}
