package ca.bcit.movieapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class test extends AppCompatActivity {

    private EditText movieTitle;
    private EditText movieDesc;
    private EditText movieLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        movieTitle = (EditText) findViewById(R.id.movieTitle);
        movieDesc = (EditText) findViewById(R.id.movieDesc);
        movieLink = (EditText) findViewById(R.id.movieLink);
        Button addMovie = (Button) findViewById(R.id.addMovie);

        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = new Movie();
                movie.setTitle(movieTitle.getText().toString());
                movie.setDesc(movieDesc.getText().toString());
                movie.setLink(movieLink.getText().toString());
                new DatabaseHelper().addMovie(movie);
            }
        });
    }
}
