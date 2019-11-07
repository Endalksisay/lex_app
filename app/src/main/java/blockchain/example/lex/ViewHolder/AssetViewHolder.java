package blockchain.example.lex.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PublicKey;

import blockchain.example.lex.Interface.ItemClickListner;
import blockchain.example.lex.R;

public class AssetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

{
   public TextView txtCompanyName, txtCompanyDescription,txtCompanyAsset ;
   public ImageView imageView;
   public ItemClickListner listner;



    public AssetViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.company_image);
        txtCompanyName = (TextView) itemView.findViewById(R.id.company_name);
        txtCompanyDescription = (TextView) itemView.findViewById(R.id.company_description);
        txtCompanyAsset = (TextView) itemView.findViewById(R.id.company_asset);

    }

    public  void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;

    }

    @Override
    public void onClick(View view)
    {
     listner.onClick(view, getAdapterPosition(), false);

    }
}
