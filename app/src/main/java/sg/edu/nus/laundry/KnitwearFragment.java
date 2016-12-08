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
public class KnitwearFragment extends Fragment {

    public interface MyListener{
        public void cartAdd(int price);

    }

    private MyListener myListener;

    /**
     * image is for the onClicked event,count is for the click count
     */
    private TextView knitwearimage1,knitwearimage2,knitwearimage3;
    private TextView knitwearcount1,knitwearcount2,knitwearcount3;

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
       View view = inflater.inflate(R.layout.fragment_knitwear,null);
       return view;

    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        knitwearimage1 = (TextView)getActivity().findViewById(R.id.knitwearimage1);
        knitwearcount1 = (TextView)getActivity().findViewById(R.id.knitwearcount1);
        knitwearimage1.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                knitwearcount1.setVisibility(View.VISIBLE);
                knitwearcount1.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        knitwearimage2 = (TextView)getActivity().findViewById(R.id.knitwearimage2);
        knitwearcount2 = (TextView)getActivity().findViewById(R.id.knitwearcount2);
        knitwearimage2.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                knitwearcount2.setVisibility(View.VISIBLE);
                knitwearcount2.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        knitwearimage3 = (TextView)getActivity().findViewById(R.id.knitwearimage3);
        knitwearcount3 = (TextView)getActivity().findViewById(R.id.knitwearcount3);
        knitwearimage3.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                knitwearcount3.setVisibility(View.VISIBLE);
                knitwearcount3.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });
    }

}
