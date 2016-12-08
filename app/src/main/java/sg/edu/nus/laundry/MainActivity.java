package sg.edu.nus.laundry;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by hugh on 2015-07-22.
 */
public class MainActivity extends Activity implements ShirtsFragment.MyListener,SuitsFragment.MyListener,DressFragment.MyListener,TrousersFragment.MyListener,KnitwearFragment.MyListener,AccessoriesFragment.MyListener,OutdoorFragment.MyListener {

    Intent intent;
    private TextView cart_number;
    private int cartTotal = 0;
    MyBroadcastReceiver myReceiver;
    IntentFilter myIntentFilter;

    ShirtsFragment shirtsFragment = new ShirtsFragment();
    SuitsFragment suitsFragment = new SuitsFragment();
    DressFragment dressFragment = new DressFragment();
    TrousersFragment trousersFragment = new TrousersFragment();
    KnitwearFragment knitwearFragment = new KnitwearFragment();
    AccessoriesFragment accessoriesFragment = new AccessoriesFragment();
    OutdoorFragment outdoorFragment = new OutdoorFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyBroadcastReceiver();
        myIntentFilter = new IntentFilter("Broadcast");

        //initView();
        /**
         * to make it is easy to control the fragment
         * initialize all the Fragment and hide others
         */

        getFragmentManager().beginTransaction().add(R.id.content, shirtsFragment,"shirts").commit();
        getFragmentManager().beginTransaction().add(R.id.content, suitsFragment,"suits").hide(suitsFragment).commit();
        getFragmentManager().beginTransaction().add(R.id.content, dressFragment, "dress").hide(dressFragment).commit();
        getFragmentManager().beginTransaction().add(R.id.content, trousersFragment, "trousers").hide(trousersFragment).commit();
        getFragmentManager().beginTransaction().add(R.id.content, knitwearFragment, "knitwear").hide(knitwearFragment).commit();
        getFragmentManager().beginTransaction().add(R.id.content, accessoriesFragment, "accessories").hide(accessoriesFragment).commit();
        getFragmentManager().beginTransaction().add(R.id.content, outdoorFragment, "outdoor").hide(outdoorFragment).commit();

        ImageView user = (ImageView) findViewById(R.id.user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        ImageView cart = (ImageView) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    public void shirtsClicked(View v){
        //getFragmentManager().beginTransaction().replace(R.id.content,new ShirtsFragment()).commit();
        //Toast.makeText(getFragmentManager(), shirtsFragment.getText().toString(), Toast.LENGTH_SHORT).show();
        /*FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content, shirtsFragment);
        transaction.commit();*/

        /*getFragmentManager().beginTransaction().hide(suitsFragment).show(shirtsFragment).commit();
        matchFragment("ShirtsFragment", "shirts");*/

        Intent i = new Intent("Broadcast");
        i.putExtra("key", "SHIRTS clicked");
        sendBroadcast(i);

        hideAllFragment();
        getFragmentManager().beginTransaction().show(shirtsFragment).commit();

    }

    public void suitsClicked(View v){

        Intent i = new Intent("Broadcast");
        i.putExtra("key", "SUITS clicked");
        sendBroadcast(i);

        hideAllFragment();
        getFragmentManager().beginTransaction().show(suitsFragment).commit();
    }

    public void dressClicked(View view) {

        Intent i = new Intent("Broadcast");
        i.putExtra("key", "DRESS clicked");
        sendBroadcast(i);

        hideAllFragment();
        getFragmentManager().beginTransaction().show(dressFragment).commit();
    }

    public void trousersClicked(View view) {

        Intent i = new Intent("Broadcast");
        i.putExtra("key", "TROUSERS clicked");
        sendBroadcast(i);

        hideAllFragment();
        getFragmentManager().beginTransaction().show(trousersFragment).commit();
    }

    public void knitwearClicked(View view) {

        Intent i = new Intent("Broadcast");
        i.putExtra("key", "KNITWEAR clicked");
        sendBroadcast(i);

        hideAllFragment();
        getFragmentManager().beginTransaction().show(knitwearFragment).commit();
    }

    public void accessoriesClicked(View view) {

        Intent i = new Intent("Broadcast");
        i.putExtra("key", "ACCESSORIES clicked");
        sendBroadcast(i);

        hideAllFragment();
        getFragmentManager().beginTransaction().show(accessoriesFragment).commit();
    }

    public void outdoorClicked(View view) {

        Intent i = new Intent("Broadcast");
        i.putExtra("key", "OUTDOOR clicked");
        sendBroadcast(i);

        hideAllFragment();
        getFragmentManager().beginTransaction().show(outdoorFragment).commit();
    }

    public boolean matchFragment(String regular,String tagName){
        /*
        Fragment mContent = getFragmentManager().findFragmentByTag("suits");
        Pattern pattern = Pattern.compile("^SuitsFragment.*");
        Matcher matcher = pattern.matcher(String.valueOf(mContent));
        boolean result = matcher.matches();
        */

        /**
         * to see if an fragment added
         * that is the same as the above
         */
        boolean result = Pattern.compile("^"+regular+".*").matcher(String.valueOf(getFragmentManager().findFragmentByTag(tagName))).matches();
        return result;
    }

    /**
     * to avoid replace the fragment which could refresh the data
     * so just hide the fragment
     */
    public void hideAllFragment(){
        getFragmentManager().beginTransaction().hide(shirtsFragment).commit();
        getFragmentManager().beginTransaction().hide(suitsFragment).commit();
        getFragmentManager().beginTransaction().hide(dressFragment).commit();
        getFragmentManager().beginTransaction().hide(trousersFragment).commit();
        getFragmentManager().beginTransaction().hide(knitwearFragment).commit();
        getFragmentManager().beginTransaction().hide(accessoriesFragment).commit();
        getFragmentManager().beginTransaction().hide(outdoorFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cart_number = (TextView)findViewById(R.id.cart_number);
        //Toast.makeText(this, cart_number.getText(), Toast.LENGTH_SHORT).show();

        registerReceiver(myReceiver, myIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }

    @Override
    public void cartAdd(int index) {
        //Toast.makeText(this, cart_number.getText(), Toast.LENGTH_SHORT).show();
        cart_number.setVisibility(View.VISIBLE);
        cart_number.setText(Integer.toString(++cartTotal));
    }


    public class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent i) {
            Toast.makeText(context, "Received Broadcast:" + i.getStringExtra("key"), Toast.LENGTH_SHORT).show();

        }
    }


}