package ca.bcit.movieapp_final;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private List<Movie> movies = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Movie> movies, List<String> keys);
        void DataIsUpdated();
    }

    public DatabaseHelper() {

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("movies");
    }

    public void addMovie(Movie movie){
        String key = myRef.push().getKey();
        myRef.child(key).setValue(movie);
    }
}
