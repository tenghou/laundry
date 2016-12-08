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
public class AccessoriesFragment extends Fragment {

    public interface MyListener{
        public void cartAdd(int price);

    }

    private MyListener myListener;

    /**
     * image is for the onClicked event,count is for the click count
     */
    private TextView accessoriesimage1,accessoriesimage2;
    private TextView accessoriescount1,accessoriescount2;

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
       View view = inflater.inflate(R.layout.fragment_accessories,null);
       return view;

    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        accessoriesimage1 = (TextView)getActivity().findViewById(R.id.accessoriesimage1);
        accessoriescount1 = (TextView)getActivity().findViewById(R.id.accessoriescount1);
        accessoriesimage1.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                accessoriescount1.setVisibility(View.VISIBLE);
                accessoriescount1.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

        accessoriesimage2 = (TextView)getActivity().findViewById(R.id.accessoriesimage2);
        accessoriescount2 = (TextView)getActivity().findViewById(R.id.accessoriescount2);
        accessoriesimage2.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                accessoriescount2.setVisibility(View.VISIBLE);
                accessoriescount2.setText(Integer.toString(++count));
                myListener.cartAdd(1);
            }
        });

    }

}
