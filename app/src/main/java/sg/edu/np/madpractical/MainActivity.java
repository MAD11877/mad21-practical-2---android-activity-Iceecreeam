package sg.edu.np.madpractical;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.AutofillService;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private  final static String TAG = "Main Activity";
    User user = new User("MAD", "lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 1, false);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button followButton = findViewById(R.id.buttonF);


        TextView tvName = (TextView)findViewById(R.id.textView);
        tvName.setText(user.getName());
        TextView tvDesc = (TextView)findViewById(R.id.textView2);
        tvDesc.setText(user.getDescription());

        if (user.isFollowed()){
            followButton.setText("UNFOLLOW");
        }
        else{
            followButton.setText("FOLLOW");
        }

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.buttonF) {
                    if (user.isFollowed()){
                        followButton.setText("FOLLOW");
                        user.setFollowed(false);
                    }
                    else{
                        followButton.setText("UNFOLLOW");
                        user.setFollowed(true);
                    }
                }
            }
        });



    }





    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "Start");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v(TAG, "Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }
}
