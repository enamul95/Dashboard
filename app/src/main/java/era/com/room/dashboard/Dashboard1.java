package era.com.room.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Dashboard1 extends AppCompatActivity {
    era.com.room.dashboard.FixedGridView menuGridView;
    GridView productGridView;

    CustomBottomNavigationView customBottomNavigationView;
    ArrayList<WelcomeMenuModel> list = new ArrayList<>();

   // HorizontalScrollView product_horizontalScrollView;
   private LinearLayout linearLayout_gridtableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        menuGridView = findViewById(R.id.menuGridView);
        productGridView = findViewById(R.id.productGridView);
        //product_horizontalScrollView = findViewById(R.id.product_horizontalScrollView);
        customBottomNavigationView = findViewById(R.id.customBottomBar);
        linearLayout_gridtableLayout = findViewById(R.id.linearLayout_gridtableLayout);

        customBottomNavigationView.inflateMenu(R.menu.bottom_menu);






        list.add(new WelcomeMenuModel("Account Opening", R.drawable.r_account, "ACCOPEN"));
        list.add(new WelcomeMenuModel("A/c Balance", R.drawable.r_balance, "ACBAL"));
        list.add(new WelcomeMenuModel("A/c Statement", R.drawable.r_account, "ACSTMT"));
        list.add(new WelcomeMenuModel("Fund Transfer", R.drawable.r_fund_transfer, "FTHOME"));
        list.add(new WelcomeMenuModel("Mobile Recharge", R.drawable.mobile_recharge, "TOPUP2"));
        list.add(new WelcomeMenuModel("Utility Bill", R.drawable.r_bills, "UTBHOME"));
        list.add(new WelcomeMenuModel("Card Payment", R.drawable.r_card, "CARD"));
        list.add(new WelcomeMenuModel("Cheque Book", R.drawable.cheque, "CHEQUE"));


        UsersAdapter adapter = new UsersAdapter(this, list);
        menuGridView.setAdapter(adapter);


        ViewGroup.LayoutParams params = linearLayout_gridtableLayout.getLayoutParams();
        params.width = 250*list.size();
        linearLayout_gridtableLayout.setLayoutParams(params);

        UsersAdapter2 productAdapter = new UsersAdapter2(this, list);
        productGridView.setAdapter(productAdapter);


        customBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_menu_home:
                        Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.bottom_menu_qr:
                        Toast.makeText(getApplicationContext(),"QR",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.bottom_menu_inbox:
                        Toast.makeText(getApplicationContext(),"inbox",Toast.LENGTH_LONG).show();
                        return true;
                }
                return true;
            }
        });

    }


    public class UsersAdapter extends ArrayAdapter<WelcomeMenuModel> {

        // View lookup cache

        private  class ViewHolder {

            ImageView menu_icon;
            TextView menu_name;
            TextView menu_soft_code ;


        }



        public UsersAdapter(Context context, ArrayList<WelcomeMenuModel> welcomeMenuModels) {

            super(context, R.layout.row_dashboard_1, welcomeMenuModels);

        }



        @Override

        public View getView(int position, View convertView, ViewGroup parent) {

            // Get the data item for this position

            WelcomeMenuModel model = getItem(position);

            UsersAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

            if (convertView == null) {

                viewHolder = new UsersAdapter.ViewHolder();

                LayoutInflater inflater = LayoutInflater.from(getContext());

                convertView = inflater.inflate(R.layout.row_dashboard_1, parent, false);

                viewHolder.menu_icon = (ImageView) convertView.findViewById(R.id.menu_icon);
                viewHolder.menu_name = (TextView) convertView.findViewById(R.id.menu_name);
                viewHolder.menu_soft_code = (TextView) convertView.findViewById(R.id.menu_soft_code);

                convertView.setTag(viewHolder);

            } else {

                viewHolder = (UsersAdapter.ViewHolder) convertView.getTag();

            }


            viewHolder.menu_icon.setImageResource(model.getImageId());


                viewHolder.menu_name.setText(model.getMenuName());


            viewHolder.menu_soft_code.setText(model.getSoftcode());



            return convertView;

        }

    }

    public class UsersAdapter2 extends ArrayAdapter<WelcomeMenuModel> {

        // View lookup cache

        private  class ViewHolder {

            ImageView menu_icon;
            TextView menu_name;
            TextView menu_soft_code ;


        }



        public UsersAdapter2(Context context, ArrayList<WelcomeMenuModel> welcomeMenuModels) {

            super(context, R.layout.row_dashboard_1, welcomeMenuModels);

        }



        @Override

        public View getView(int position, View convertView, ViewGroup parent) {

            // Get the data item for this position

            WelcomeMenuModel model = getItem(position);

            UsersAdapter2.ViewHolder viewHolder; // view lookup cache stored in tag

            if (convertView == null) {

                viewHolder = new UsersAdapter2.ViewHolder();

                LayoutInflater inflater = LayoutInflater.from(getContext());

                convertView = inflater.inflate(R.layout.row_dashboard_1, parent, false);

                viewHolder.menu_icon = (ImageView) convertView.findViewById(R.id.menu_icon);
                viewHolder.menu_name = (TextView) convertView.findViewById(R.id.menu_name);
                viewHolder.menu_soft_code = (TextView) convertView.findViewById(R.id.menu_soft_code);

                convertView.setTag(viewHolder);

            } else {

                viewHolder = (UsersAdapter2.ViewHolder) convertView.getTag();

            }


            viewHolder.menu_icon.setImageResource(model.getImageId());


            viewHolder.menu_name.setText(model.getMenuName());


            viewHolder.menu_soft_code.setText(model.getSoftcode());



            return convertView;

        }

    }

    private void gridViewSetting(GridView gridview) {

        int size=list.size();
        // Calculated single Item Layout Width for each grid element ....
        int width =0;

        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;

        int totalWidth = (int) (width * size * density);
        int singleItemWidth = (int) (width * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                totalWidth, LinearLayout.LayoutParams.MATCH_PARENT);

        gridview.setLayoutParams(params);
        gridview.setColumnWidth(singleItemWidth);
        gridview.setHorizontalSpacing(2);
        gridview.setStretchMode(GridView.STRETCH_SPACING);
        gridview.setNumColumns(size);
    }
}