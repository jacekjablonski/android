package company.playerek;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;


public class MyActivity extends Activity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener{

    ImageButton bprev;
    ImageButton bpause;
    ImageButton bstart;
    ImageButton bstop;
    ImageButton bnext;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mp=MediaPlayer.create(this, R.raw.acdc);

        bprev= (ImageButton) findViewById(R.id.imageButton);
        bpause = (ImageButton) findViewById(R.id.imageButton2);
        bstart= (ImageButton) findViewById(R.id.imageButton3);
        bstop= (ImageButton) findViewById(R.id.imageButton4);
        bnext= (ImageButton) findViewById(R.id.imageButton5);

        bprev.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Poprzedni utwór ", Toast.LENGTH_LONG).show();
            }
        });

        bpause.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Pauza", Toast.LENGTH_LONG).show();
            }
        });

        bstart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(mp==null){
                    mp.start();
                    Toast.makeText(getApplicationContext(), "Odtwarzacz uruchomiony", Toast.LENGTH_LONG).show();
                }
                else{
                    bprev.setEnabled(false);
                }
            }
        });

        bstop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mp.stop();
                Toast.makeText(getApplicationContext(), "Odtwarzanie zakończone", Toast.LENGTH_LONG).show();
            }
        });

        bnext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Następny utwór", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void playlist(View view){
        Intent intent =new Intent(this, PlaylistActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
