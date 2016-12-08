package sg.edu.nus.laundry;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hugh on 2015-07-23.
 */
public class OutdoorFragment extends Fragment {

    public interface MyListener{
        public void cartAdd(int price);

    }

    private MyListener myListener;

    /**
     * image is for the onClicked event,count is for the click count
     */
    private TextView outdoorimage1,outdoorimage2,outdoorimage3,outdoorimage4,outdoorimage5;
    private TextView outdoorcount1,outdoorcount2,outdoorcount3,outdoorcount4,outdoorcount5;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        myListener = (MyListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       /**
        * both are right
        */
       //View view = inflater.inflate(R.layout.fragment_shirts,container,false);
       View view = inflater.inflate(R.layout.fragment_outdoor,null);
       return view;

    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        outdoorimage1 = (TextView)getActivity().findViewById(R.id.outdoorimage1);
        outdoorcount1 = (TextView)getActivity().findViewById(R.id.outdoorcount1);
        outdoorimage1.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                outdoorcount1.setVisibility(View.VISIBLE);
                outdoorcount1.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        outdoorimage2 = (TextView)getActivity().findViewById(R.id.outdoorimage2);
        outdoorcount2 = (TextView)getActivity().findViewById(R.id.outdoorcount2);
        outdoorimage2.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                outdoorcount2.setVisibility(View.VISIBLE);
                outdoorcount2.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        outdoorimage3 = (TextView)getActivity().findViewById(R.id.outdoorimage3);
        outdoorcount3 = (TextView)getActivity().findViewById(R.id.outdoorcount3);
        outdoorimage3.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                outdoorcount3.setVisibility(View.VISIBLE);
                outdoorcount3.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });


    }

}
