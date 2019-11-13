
package blockchain.example.lex;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import blockchain.example.lex.Model.Transaction;
import blockchain.example.lex.ui.Aboutus;
import io.paperdb.Paper;

import androidx.core.view.GravityCompat;





public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private AppBarConfiguration mAppBarConfiguration;
    private double currentCurrency = 0;
    private Button currencyButton;
    private Button btn1;
    private ArrayList<Button> companyButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//    currencyButton = findViewById(R.id.currency_button);
//    String btnSetText = String.format(Locale.US, "$%.2f", currentCurrency);
//        currencyButton.setText(btnSetText);
//       for (int i = 1; i <= 20; i++) {
//          LinearLayout linear = findViewById(R.id.companyButtonLayout);
//           LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                  LinearLayout.LayoutParams.MATCH_PARENT,
//                   LinearLayout.LayoutParams.WRAP_CONTENT);
//            Button btn = new Button(this);
//          btn.setId(i);
//           final int id_ = btn.getId();
//           String btnText = "button " + id_;
//            btn.setText(btnText);
//           linear.addView(btn, params);
//           btn1 = (findViewById(id_));
//           btn1.setOnClickListener(new View.OnClickListener() {
//               public void onClick(View view) {
//                   Toast.makeText(view.getContext(),
//                          "Button clicked index = " + id_, Toast.LENGTH_SHORT)
//                           .show();
//               }
//          });
//       }
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("LEX");
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Refresh new contents.....", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_Lex, R.id.nav_Merchants, R.id.nav_transaction,
                R.id.nav_settings, R.id.nav_contact, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public  boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);

    }


    public boolean onNavigationItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id==R.id.nav_Lex)
        {

        }

        else if (id == R.id.nav_Merchants)
        {

        }
        else if (id == R.id.nav_transaction)
        {
            Intent intent = new Intent(HomeActivity.this, Transaction.class);
            startActivity(intent);

        }

         else if (id == R.id.nav_settings)
        {
            Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        else if (id==R.id.nav_contact)
        {
            Intent intent = new Intent(HomeActivity.this, ContactActivity.class);
            startActivity(intent);

        }
        else if (id==R.id.nav_aboutus)
        {
            Intent intent = new Intent(HomeActivity.this, Aboutus.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_logout)
        {
            Paper.book().destroy();

            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;



    }

}





