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
public class TrousersFragment extends Fragment {

    public interface MyListener{
        public void cartAdd(int price);

    }

    private MyListener myListener;

    /**
     * image is for the onClicked event,count is for the click count
     */
    private TextView trousersimage1,trousersimage2,trousersimage3;
    private TextView trouserscount1,trouserscount2,trouserscount3;

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
       View view = inflater.inflate(R.layout.fragment_trousers,null);
       return view;

    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        trousersimage1 = (TextView)getActivity().findViewById(R.id.trousersimage1);
        trouserscount1 = (TextView)getActivity().findViewById(R.id.trouserscount1);
        trousersimage1.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                trouserscount1.setVisibility(View.VISIBLE);
                trouserscount1.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        trousersimage2 = (TextView)getActivity().findViewById(R.id.trousersimage2);
        trouserscount2 = (TextView)getActivity().findViewById(R.id.trouserscount2);
        trousersimage2.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                trouserscount2.setVisibility(View.VISIBLE);
                trouserscount2.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        trousersimage3 = (TextView)getActivity().findViewById(R.id.trousersimage3);
        trouserscount3 = (TextView)getActivity().findViewById(R.id.trouserscount3);
        trousersimage3.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                trouserscount3.setVisibility(View.VISIBLE);
                trouserscount3.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });
    }

}
