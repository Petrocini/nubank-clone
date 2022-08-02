package br.com.lucaspetrocini.nubankclone.adapter;

import android.accounts.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.lucaspetrocini.nubankclone.databinding.AdapterAccountOptionBinding;
import br.com.lucaspetrocini.nubankclone.model.AccountOption;

public class AccountOptionAdapter extends RecyclerView.Adapter<AccountOptionAdapter.MyViewHolder> {

    private final Context context;
    private final List<AccountOption> accountOptionList;

    public AccountOptionAdapter(Context context, List<AccountOption> accountOptionList) {
        this.context = context;
        this.accountOptionList = accountOptionList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterAccountOptionBinding adapterAccountOptionBinding = AdapterAccountOptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(adapterAccountOptionBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.adapterAccountOptionBinding.imgOption.setBackgroundResource(accountOptionList.get(position).getOptionIcon());
        holder.adapterAccountOptionBinding.txtOptionName.setText(accountOptionList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return accountOptionList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final AdapterAccountOptionBinding adapterAccountOptionBinding;

        public MyViewHolder(@NonNull AdapterAccountOptionBinding adapterAccountOptionBinding) {
            super(adapterAccountOptionBinding.getRoot());
            this.adapterAccountOptionBinding = adapterAccountOptionBinding;
        }
    }
}
