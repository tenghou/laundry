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
public class SuitsFragment extends Fragment {

    public interface MyListener{
        public void cartAdd(int price);

    }

    private MyListener myListener;

    /**
     * image is for the onClicked event,count is for the click count
     */
    private TextView suitimage1,suitimage2,suitimage3,suitimage4;
    private TextView suitcount1,suitcount2,suitcount3,suitcount4;

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
        View view = inflater.inflate(R.layout.fragment_suits,null);
        return view;

    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        suitimage1 = (TextView)getActivity().findViewById(R.id.suitimage1);
        suitcount1 = (TextView)getActivity().findViewById(R.id.suitcount1);
        suitimage1.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                suitcount1.setVisibility(View.VISIBLE);
                suitcount1.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        suitimage2 = (TextView)getActivity().findViewById(R.id.suitimage2);
        suitcount2 = (TextView)getActivity().findViewById(R.id.suitcount2);
        suitimage2.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                suitcount2.setVisibility(View.VISIBLE);
                suitcount2.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        suitimage3 = (TextView)getActivity().findViewById(R.id.suitimage3);
        suitcount3 = (TextView)getActivity().findViewById(R.id.suitcount3);
        suitimage3.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                suitcount3.setVisibility(View.VISIBLE);
                suitcount3.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        suitimage4 = (TextView)getActivity().findViewById(R.id.suitimage4);
        suitcount4 = (TextView)getActivity().findViewById(R.id.suitcount4);
        suitimage4.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                suitcount4.setVisibility(View.VISIBLE);
                suitcount4.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });




    }

}
