package com.example.cashregister;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    Database db;

    Context context;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        db = Database.getInstance();
        context = this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);


        ListView categoryListView = view.findViewById(R.id.category_list_view);
        ListView productListView = view.findViewById(R.id.product_list_view);

        productListView.setVisibility(View.GONE);
        ArrayList<Category> categoryList = db.getCategories(); // Populate the category list as needed


        ArrayAdapter<Category> categoryAdapter = new ArrayAdapter<>(
                context,
                R.layout.category_list_item,
                R.id.category_name,
                categoryList
        );

        categoryListView.setAdapter(categoryAdapter);

        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("SearchFragment", "Category selected: " + position);
                Category category = (Category) parent.getItemAtPosition(position);
                List<Product> productList = category.getProducts(); // Retrieve the product list for this category

                categoryListView.setVisibility(View.GONE);
                productListView.setVisibility(View.VISIBLE);
                ArrayAdapter<Product> productAdapter = new ArrayAdapter<>(
                        context,
                        R.layout.product_list_item,
                        R.id.product_name,
                        productList
                );

                productListView.setAdapter(productAdapter);
            }
        });

        return view;
    }
}