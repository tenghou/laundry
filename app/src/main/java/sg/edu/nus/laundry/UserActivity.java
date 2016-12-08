package sg.edu.nus.laundry;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hugh on 2015-07-23.
 */
public class UserActivity extends Activity{

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        TextView close = (TextView)findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*intent = new Intent(UserActivity.this, MainActivity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });

    }

    public void newAccount(View view) {
        intent = new Intent(UserActivity.this, NewUserActivity.class);
        startActivity(intent);
    }


    public void batteryClicked(View view) {

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null,ifilter);

        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
        String typeofCharging = usbCharge ? "USB Charging" : "AC Charging";
        String charging = isCharging ? typeofCharging : "Not In Charging";

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE,-1);

        float batteryPct = level * 100 / scale;

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));

        ImageView image = (ImageView) layout.findViewById(R.id.toastimage);
        image.setImageResource(R.drawable.ic_battery_toast);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Battery : " + String.valueOf(batteryPct) + "%\n" +
                "Level : " + String.valueOf(level) + "\n" +
                "Scale : " + String.valueOf(scale) + "\n" +
                "Type of charging : " + String.valueOf(charging) + "\n" +
                "Charge Plug : " + String.valueOf(chargePlug) + "\n");
        /*Toast toast = new Toast(getApplicationContext());

        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);

        toast.setView(layout);
        toast.show();*/

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(layout);
        builder.show();
    }



    private void phoneCall() {
        String phoneNumber = "+6598400558";
        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneNumber));
        startActivity(intent);
    }

    private void sendMessage(){
        intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("address","+6598400558");
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }

    public void contactUs(View view) {
        new AlertDialog.Builder(this).setMessage("Contact us via").setPositiveButton("Message", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendMessage();
            }
        }).setNeutralButton("PhoneCall", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                phoneCall();
            }
        }).show();

    }

    public void signin(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view1 = LayoutInflater.from(this).inflate(R.layout.signin, null);

        builder.setView(view1);

        builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setCancelable(false);
        builder.show();


    }
}
