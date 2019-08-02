package com.informatika.daz.poscustomer.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.informatika.daz.poscustomer.R;
import com.informatika.daz.poscustomer.adapter.TokoAdapter;
import com.informatika.daz.poscustomer.model.Toko;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class TokoFragment extends Fragment {
    private int[] ids;
    private String[] namas;
    private String[] kategoris;
    private String[] fotos;
    private int[] favorites;
    private Context context;
    private Toolbar toolbar;
    private DuoDrawerLayout duoDrawerLayout;
    private RecyclerView recyclerView;
    private List<Toko> tokoList = new ArrayList<>();
    private ImageButton btnSuvenir;

    public TokoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_toko, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getContext();

        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        duoDrawerLayout = Objects.requireNonNull(getActivity()).findViewById(R.id.duoDrawerLayout);

        recyclerView = view.findViewById(R.id.rv_toko);
        handleDrawer();
        inputData();
        handleRecyclerView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toko, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void inputData() {
        ids = getResources().getIntArray(R.array.toko_id);
        namas = getResources().getStringArray(R.array.toko_nama);
        kategoris = getResources().getStringArray(R.array.toko_kategori);
        fotos = getResources().getStringArray(R.array.toko_foto);
        favorites = getResources().getIntArray(R.array.toko_favorit);
    }

    private void handleRecyclerView() {
        TokoAdapter tokoAdapter = new TokoAdapter(context, tokoList);
        for (int i = 0; i < ids.length; i++) {
            tokoList.add(new Toko(ids[i], namas[i], kategoris[i], favorites[i], fotos[i]));
        }
        tokoAdapter.setTokoData(tokoList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(tokoAdapter);
    }

    private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(getActivity(), duoDrawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        duoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();
    }

}