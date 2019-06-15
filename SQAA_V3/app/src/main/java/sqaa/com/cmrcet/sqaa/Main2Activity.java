package sqaa.com.cmrcet.sqaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String server_url="http://192.168.1.102:7777/usercontrol.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DetailsFragment detailsFragment=new DetailsFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,detailsFragment,detailsFragment.getTag()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            CameraFragment cameraFragment=new CameraFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,cameraFragment,cameraFragment.getTag()).commit();

        }
        else if (id == R.id.nav_video) {
            VideoCameraFragment videoCameraFragment = new VideoCameraFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,videoCameraFragment,videoCameraFragment.getTag()).commit();


        }else if (id == R.id.nav_History) {
            HistoryFragment historyFragment=new HistoryFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,historyFragment,historyFragment.getTag()).commit();


        } else if (id == R.id.nav_school) {

            SchoolsFragment schoolsFragment=new SchoolsFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,schoolsFragment,schoolsFragment.getTag()).commit();

        }  else if (id == R.id.nav_send) {

            Intent i = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(i);
//            SendFragment sendFragment=new SendFragment();
//            FragmentManager fragmentManager=getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,sendFragment,sendFragment.getTag()).commit();

//       } else if(id==R.id.nav_comments){
//            TextFragment textFragment=new TextFragment();
//            FragmentManager fragmentManager=getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,textFragment,textFragment.getTag()).commit();
        }else if(id==R.id.ic_menu_details){
            DetailsFragment detailsFragment=new DetailsFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,detailsFragment,detailsFragment.getTag()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
