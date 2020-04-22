package com.example.tamronmvpframe.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.adapters.FavouriteListAdaper;
import com.example.tamronmvpframe.adapters.FeedsListAdapter;
import com.example.tamronmvpframe.delegate.FavouriteListDelegate;
import com.example.tamronmvpframe.mvp.view.activity.FeedDetailActivity;
import com.example.tamronmvpframe.vo.FavouriteData;
import com.example.tamronmvpframe.vo.FeedsData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment implements FavouriteListDelegate {
    private RecyclerView rvFavouriteList;
    private FavouriteListAdaper favouriteListAdaper;
    List<FavouriteData> favouriteDataList = new ArrayList<>();


    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        createFavouriteData();
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        rvFavouriteList = view.findViewById(R.id.rv_favouriteList);


        if (getActivity() !=null) {
            favouriteListAdaper = new FavouriteListAdaper(getActivity(), this);
            rvFavouriteList.setAdapter(favouriteListAdaper);
            rvFavouriteList.setLayoutManager(new LinearLayoutManager(getActivity()));
            favouriteListAdaper.setNewData(favouriteDataList);
        }
        return view;

    }

    @Override
    public void onFeedsTap(int id, String title, String date, String img, ImageView itemImage) {
        Intent intent = FeedDetailActivity.intentFromFeedsList(getActivity(),id,title,img);
        ActivityOptionsCompat option = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), itemImage, ViewCompat.getTransitionName(itemImage));
        startActivity(intent,option.toBundle());

    }

    private void createFavouriteData(){

        FavouriteData favouriteData1 = new FavouriteData("Bangladeshis turn to video sites during COVID-19 lockdown","5 April 2020 5:56 GMT","https://globalvoices.org/wp-content/uploads/2020/04/bengalis-1.jpg");
        FavouriteData favouriteData2 = new FavouriteData("Hong Kong government censures public broadcaster for raising question on Taiwan’s WHO membership status","5 April 2020 3:35 GMT ","https://globalvoices.org/wp-content/uploads/2020/04/whob-800x450.jpg");
        FavouriteData favouriteData3 = new FavouriteData("Is India fighting COVID-19 the “mass surveillance” way?","4 April 2020 16:17 GMT","https://globalvoices.org/wp-content/uploads/2020/04/Corona-surveillance-800x450.jpg");
        FavouriteData favouriteData4 = new FavouriteData("COVID-19 diaries from Wuhan: Restrictions tighten","4 April 2020 0:06 GMT","https://globalvoices.org/wp-content/uploads/2020/04/%E5%B0%8F%E5%8D%80%E9%96%80%E5%8F%A3.jpeg");
        FavouriteData favouriteData5 = new FavouriteData("Mozambique and Cape Verde's telcos offer affordable mobile internet as citizens urged to stay home","3 April 2020 23:38 GMT ","https://pt.globalvoices.org/wp-content/uploads/2020/03/Cabo-Verde.jpg");

        favouriteDataList.add(favouriteData1);
        favouriteDataList.add(favouriteData2);
        favouriteDataList.add(favouriteData3);
        favouriteDataList.add(favouriteData4);
        favouriteDataList.add(favouriteData5);

    }
}
