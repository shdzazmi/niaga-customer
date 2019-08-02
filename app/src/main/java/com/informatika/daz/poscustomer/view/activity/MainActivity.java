package com.informatika.daz.poscustomer.view.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;
import com.informatika.daz.poscustomer.R;
import com.informatika.daz.poscustomer.adapter.MenuAdapter;
import com.informatika.daz.poscustomer.view.fragment.AchievementFragment;
import com.informatika.daz.poscustomer.view.fragment.EventFragment;
import com.informatika.daz.poscustomer.view.fragment.TokoFragment;

import java.util.ArrayList;
import java.util.Arrays;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;

public class MainActivity extends AppCompatActivity implements DuoMenuView.OnMenuClickListener {

    private MenuAdapter menuAdapter;
    private ArrayList<String> titles = new ArrayList<>();
    private DuoDrawerLayout duoDrawerLayout;
    private DuoMenuView duoMenuView;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titles = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.menuOptions)));

        duoDrawerLayout = findViewById(R.id.duoDrawerLayout);
        duoMenuView = findViewById(R.id.menu);

        snackbar = Snackbar.make(duoDrawerLayout, "Press back again to exit app", Snackbar.LENGTH_SHORT);

        goToFragment(new TokoFragment(), false);
        handleMenu();
    }

    private void handleMenu() {
        menuAdapter = new MenuAdapter(titles);
        duoMenuView.setOnMenuClickListener(this);
        duoMenuView.setAdapter(menuAdapter);
    }

    @Override
    public void onHeaderClicked() {
        Toast.makeText(this, "onHeaderClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFooterClicked() {
        Toast.makeText(this, "onFooterClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        menuAdapter.setViewSelected(position, true);
        setTitle(titles.get(position));
        switch (position) {
            case 0:
                goToFragment(new TokoFragment(), false);
                break;
            case 1:
                goToFragment(new EventFragment(), false);
                break;
            case 2:
                goToFragment(new AchievementFragment(), false);
                break;
        }

        // Close the drawer
        duoDrawerLayout.closeDrawer();
    }

    private void goToFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.replace(R.id.container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        if (duoDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            duoDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (fragments > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            if (snackbar.isShown()) {
                super.onBackPressed();
            } else {
                snackbar.show();
            }
        }
    }
}
