package com.example.week4task;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SearchFragment extends Fragment {

    private EditText mSearch;
    private Button mBtnSearch;
    private SharedPreferencesHelper mSharedPreferencesHelper;

    private View.OnClickListener mOnSearchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            searchInBrowser();
        }
    };

    private void searchInBrowser() {
        String browser = mSharedPreferencesHelper.getRadioBtnData().toLowerCase();
        String baseUrl = "https://www." + browser + ".com/?q=";
        String query = mSearch.getText().toString();
        Intent browserIntent = new Intent(Intent.ACTION_WEB_SEARCH);
        if (!browser.equals("google")) {
            try {
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(baseUrl + URLEncoder.encode(query, "UTF-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        browserIntent.putExtra(SearchManager.QUERY, query);
        startActivity(browserIntent);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_search, container, false);
        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        mSearch = view.findViewById(R.id.etSearch);
        mBtnSearch = view.findViewById(R.id.btnSearch);

        mBtnSearch.setOnClickListener(mOnSearchClickListener);

        return view;
    }
}
