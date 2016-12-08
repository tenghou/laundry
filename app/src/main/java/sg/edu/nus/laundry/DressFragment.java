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
public class DressFragment extends Fragment {

    public interface MyListener{
        public void cartAdd(int price);
    }
    private MyListener myListener;

    /**
     * image is for the onClicked event,count is for the click count
     */
    private TextView dressimage1,dressimage2,dressimage3,dressimage4,dressimage5;
    private TextView dresscount1,dresscount2,dresscount3,dresscount4,dresscount5;

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
       View view = inflater.inflate(R.layout.fragment_dress,null);
       return view;

    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        dressimage1 = (TextView)getActivity().findViewById(R.id.dressimage1);
        dresscount1 = (TextView)getActivity().findViewById(R.id.dresscount1);
        dressimage1.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                dresscount1.setVisibility(View.VISIBLE);
                dresscount1.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        dressimage2 = (TextView)getActivity().findViewById(R.id.dressimage2);
        dresscount2 = (TextView)getActivity().findViewById(R.id.dresscount2);
        dressimage2.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                dresscount2.setVisibility(View.VISIBLE);
                dresscount2.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        dressimage3 = (TextView)getActivity().findViewById(R.id.dressimage3);
        dresscount3 = (TextView)getActivity().findViewById(R.id.dresscount3);
        dressimage3.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                dresscount3.setVisibility(View.VISIBLE);
                dresscount3.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        dressimage4 = (TextView)getActivity().findViewById(R.id.dressimage4);
        dresscount4 = (TextView)getActivity().findViewById(R.id.dresscount4);
        dressimage4.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                dresscount4.setVisibility(View.VISIBLE);
                dresscount4.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        dressimage5 = (TextView)getActivity().findViewById(R.id.dressimage5);
        dresscount5 = (TextView)getActivity().findViewById(R.id.dresscount5);
        dressimage5.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                dresscount5.setVisibility(View.VISIBLE);
                dresscount5.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });


    }

}
