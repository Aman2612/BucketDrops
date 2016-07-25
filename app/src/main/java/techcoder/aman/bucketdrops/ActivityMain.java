package techcoder.aman.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ActivityMain extends AppCompatActivity {

    Toolbar mtToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtToolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtToolbar);
    }
}
