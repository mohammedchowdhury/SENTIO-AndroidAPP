package edu.qc.seclass.glm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EvaluationFragment extends Fragment {
    ListView listView;
    NotingFragment arrayOfLogs = new NotingFragment();
    ArrayList<String> ourJournal = arrayOfLogs.getJournal();

    /**
     * Every time we create a new instance of this class we are calling
     * the onCreateView method
     * From my understanding, the returned inflater populates the layout (fragment_search) with
     * the objects we created for it, somewhat of an onCreate method for the fragment
     * This is needed because we are not creating a new activity
     * Creating new activities makes your app slower
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evaluation,container,false);

        TextView evaluationTv = view.findViewById(R.id.evaluation_tv);
        String eval = evaluationTv.getText().toString();
        if (!ourJournal.isEmpty()) {
            eval = eval + arrayOfLogs.getGoodORBad();
            evaluationTv.setText(eval);
        }

        return view;
    }
}
