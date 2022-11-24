package org.idnp.lab07_idnp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentStatistics extends Fragment {
    TextView statistics_TextView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("confirmation",
                this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                statistics_TextView.setText(result.getString("message"));
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText statistics_Edit = (EditText) view.findViewById(R.id.statisticsED);
        statistics_TextView = (TextView) view.findViewById(R.id.statisticsTV);
        Button statistics_btn = (Button) view.findViewById(R.id.statisticsBtn);
        statistics_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle info = new Bundle();
                info.putString("message", statistics_Edit.getText().toString());
                getParentFragmentManager().setFragmentResult("notification", info);
            }
        });

    }
}