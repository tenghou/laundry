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
public class ShirtsFragment extends Fragment {

    public interface MyListener{
        public void cartAdd(int price);

    }

    private MyListener myListener;

    /**
     * image is for the onClicked event,count is for the click count
     */
    private TextView image1,image2,image3,image4,image5,image6,image7;
    private TextView count1,count2,count3,count4,count5,count6,count7;

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
       View view = inflater.inflate(R.layout.fragment_shirts,null);
       return view;

    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        image1 = (TextView)getActivity().findViewById(R.id.image1);
        count1 = (TextView)getActivity().findViewById(R.id.count1);
        image1.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                count1.setVisibility(View.VISIBLE);
                count1.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        image2 = (TextView)getActivity().findViewById(R.id.image2);
        count2 = (TextView)getActivity().findViewById(R.id.count2);
        image2.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                count2.setVisibility(View.VISIBLE);
                count2.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        image3 = (TextView)getActivity().findViewById(R.id.image3);
        count3 = (TextView)getActivity().findViewById(R.id.count3);
        image3.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                count3.setVisibility(View.VISIBLE);
                count3.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        image4 = (TextView)getActivity().findViewById(R.id.image4);
        count4 = (TextView)getActivity().findViewById(R.id.count4);
        image4.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                count4.setVisibility(View.VISIBLE);
                count4.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        image5 = (TextView)getActivity().findViewById(R.id.image5);
        count5 = (TextView)getActivity().findViewById(R.id.count5);
        image5.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                count5.setVisibility(View.VISIBLE);
                count5.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });


    }

}
