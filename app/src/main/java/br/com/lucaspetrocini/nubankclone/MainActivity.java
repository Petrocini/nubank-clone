package br.com.lucaspetrocini.nubankclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.lucaspetrocini.nubankclone.adapter.AccountOptionAdapter;
import br.com.lucaspetrocini.nubankclone.adapter.ProductAdapter;
import br.com.lucaspetrocini.nubankclone.databinding.ActivityMainBinding;
import br.com.lucaspetrocini.nubankclone.model.AccountOption;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private final List<AccountOption> accountOptionList = new ArrayList<>();
    private final List<String> productsList = new ArrayList<>();
    private Boolean viewMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        viewMoney = true;
        Objects.requireNonNull(getSupportActionBar()).hide();
        configureRecyclerViewAccountOptions();
        configureRecyclerViewProducts();
        fillOutListOfAccountOption();
        fillOutListOfProduct();
        configureOnClickListener();
    }

    private void configureRecyclerViewAccountOptions() {
        activityMainBinding.rvAccountChoicesOptions.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        activityMainBinding.rvAccountChoicesOptions.setHasFixedSize(true);
        AccountOptionAdapter adapter = new AccountOptionAdapter(this, accountOptionList);
        activityMainBinding.rvAccountChoicesOptions.setAdapter(adapter);
    }

    private void configureRecyclerViewProducts() {
        activityMainBinding.rvProducts.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        activityMainBinding.rvProducts.setHasFixedSize(true);
        ProductAdapter adapter = new ProductAdapter(this, productsList);
        activityMainBinding.rvProducts.setAdapter(adapter);
    }

    private void fillOutListOfAccountOption() {
        if (accountOptionList != null) {
            accountOptionList.add(new AccountOption(R.drawable.ic_baseline_pix_24, "Área Pix"));
            accountOptionList.add(new AccountOption(R.drawable.barcode, "Pagar"));
            accountOptionList.add(new AccountOption(R.drawable.emprestimo, "Pegar \n Emprestado"));
            accountOptionList.add(new AccountOption(R.drawable.transferencia, "Transferir"));
            accountOptionList.add(new AccountOption(R.drawable.depositar, "Depositar"));
            accountOptionList.add(new AccountOption(R.drawable.ic_baseline_phone_android_24, "Recarga de \n Celular"));
            accountOptionList.add(new AccountOption(R.drawable.ic_baseline_monetization_on_24, "Cobrar"));
            accountOptionList.add(new AccountOption(R.drawable.doacao, "Doação"));
        }
    }

    private void fillOutListOfProduct() {
        if (productsList != null) {
            productsList.add("Participe da promoção tudo no roxinho e concorra a prémios");
            productsList.add("Chegou o débito automático da fatura do cartão");
            productsList.add("Conheça a conta PJ: prática e livre de burocracia");
            productsList.add("Salve seus amigos da burocracia: Faça um convite");
        }
    }

    private void configureOnClickListener() {
        activityMainBinding.imgEye.setOnClickListener(onClickListener);
    }

    private final View.OnClickListener onClickListener = view -> {
        int id = view.getId();
        if (id == activityMainBinding.imgEye.getId()) {
            if (!viewMoney) {
                activityMainBinding.txtAccountBalance.setText(getString(R.string.txt_account_balance));
                activityMainBinding.txtCurrentInvoice.setText(getString(R.string.txt_account_balance));
                activityMainBinding.txtAvailableLimit.setText(getString(R.string.txt_account_balance));
                viewMoney = true;
            } else {
                activityMainBinding.txtAccountBalance.setText("******");
                activityMainBinding.txtCurrentInvoice.setText("******");
                activityMainBinding.txtAvailableLimit.setText("******");
                viewMoney = false;
            }
        }
    };
}