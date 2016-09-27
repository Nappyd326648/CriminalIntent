package com.eugenestewart.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nappy on 9/24/2016.
 */

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private TextView mTitleTextView;
    private TextView mDateTextView;
    private CheckBox mSolvedCheckBox;

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{


        private static final int REQUEST_CRIME = 1;

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent,int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_crime,parent,false);
            return new CrimeHolder(view);
        }
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position){
            Crime crime = mCrimes.get(position);
            holder.mTitleTextView.setText(crime.getmTitle());

        }
        @Override
        public int getItemCount(){
            return mCrimes.size();
        }

        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes){
            mCrimes=crimes;
        }
    }
    private class CrimeHolder extends RecyclerView.ViewHolder{
        public TextView mTitleTextView;
        private Crime mCrime;
        public void bindCrime(Crime crime){
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateTextView.setText(mCrime.getDate().toString());
            mSolvedCheckBox.setChecked(mCrime.isSolved());
        }
        public CrimeHolder(View itemView){
            mTitleTextView = (TextView) itemView;
        }
    }
    private RecyclerView mCrimeRecyclerView;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view  = inflater.inflate(R.layout.fragment_crime_list, container,false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }
    public CrimeHolder(View itemView){
        super(itemView);
        mTitleTextView =(TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
        mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
        mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);
    }
}
