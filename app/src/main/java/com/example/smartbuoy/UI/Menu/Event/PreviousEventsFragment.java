package com.example.smartbuoy.UI.Menu.Event;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartbuoy.DATA.Adapters.PreviousEventsAdapter;
import com.example.smartbuoy.DATA.Adapters.UpComingEventsAdapter;
import com.example.smartbuoy.DATA.Models.Event;
import com.example.smartbuoy.DATA.Retrofite.ApiUtil;
import com.example.smartbuoy.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviousEventsFragment extends Fragment {

    private RecyclerView mRecycleView;
    private PreviousEventsAdapter eventAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView emptyTextView;

    private ShimmerFrameLayout mShimmerViewContainer;



    public PreviousEventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_previous_events, container, false);

        mRecycleView = view.findViewById(R.id.rvPreviousEvents);
        mRecycleView.setHasFixedSize(true);

        mShimmerViewContainer = view.findViewById(R.id.previousEventShimmer);
        emptyTextView = view.findViewById(R.id.etEmptyPrevious);

        listPreviousEvent();
        return view;
    }

    private void listPreviousEvent() {
        ApiUtil.getServiceClass().eventsPrevious().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                final List<Event> listEvent = response.body();

                // Stopping Shimmer Effect's animation after data is loaded to ListView
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);
                if (listEvent.size() == 0) {
                    emptyTextView.setText("no previous events");
                } else {
                    mLayoutManager = new LinearLayoutManager(getContext());
                    eventAdapter = new PreviousEventsAdapter(listEvent);

                    mRecycleView.setLayoutManager(mLayoutManager);
                    mRecycleView.setAdapter(eventAdapter);

                    eventAdapter.setOnItemClickListener(new UpComingEventsAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            //Toast.makeText(getContext(), listEvent.get(position).getId(), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getContext(), DetailEventActivity.class);
                            intent.putExtra("idEventFromUpcoming", listEvent.get(position).getId());
                            startActivity(intent);
                        }
                    });
                }


            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

}
