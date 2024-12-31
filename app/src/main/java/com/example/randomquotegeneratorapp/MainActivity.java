package com.example.randomquotegeneratorapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private TextView authorTextView;
    private ArrayList<Quote> quotes;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        quoteTextView = findViewById(R.id.quoteTextView);
        authorTextView = findViewById(R.id.authorTextView);
        Button generateButton = findViewById(R.id.generateButton);
        Button shareButton = findViewById(R.id.shareButton);

        random = new Random();
        quotes = getQuotes();

        // Set up button listeners
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayRandomQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareQuote();
            }
        });

        // Display the first random quote on startup
        displayRandomQuote();
    }

    private void displayRandomQuote() {
        int index = random.nextInt(quotes.size());
        Quote quote = quotes.get(index);
        quoteTextView.setText(quote.getText());
        authorTextView.setText("- " + quote.getAuthor());
    }

    private void shareQuote() {
        String quoteText = quoteTextView.getText().toString();
        String authorText = authorTextView.getText().toString();
        String shareText = quoteText + " " + authorText;

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    private ArrayList<Quote> getQuotes() {
        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("The best way to predict the future is to create it.", "Peter Drucker"));
        quotes.add(new Quote("Life is what happens when you're busy making other plans.", "John Lennon"));
        quotes.add(new Quote("The purpose of our lives is to be happy.", "Dalai Lama"));
        quotes.add(new Quote("Get busy living or get busy dying.", "Stephen King"));
        quotes.add(new Quote("You have within you right now, everything you need to deal with whatever the world can throw at you.", "Brian Tracy"));
        quotes.add(new Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"));
        quotes.add(new Quote("The only impossible journey is the one you never begin.", "Tony Robbins"));
        quotes.add(new Quote("Life is ten percent what happens to us and ninety percent how we respond to it.", "Charles R. Swindoll"));
        quotes.add(new Quote("Keep your face always toward the sunshine—and shadows will fall behind you.", "Walt Whitman"));
        quotes.add(new Quote("Success is not how high you have climbed, but how you make a positive difference to the world.", "Roy T. Bennett"));
        quotes.add(new Quote("Act as if what you do makes a difference. It does.", "William James"));
        quotes.add(new Quote("What you get by achieving your goals is not as important as what you become by achieving your goals.", "Zig Ziglar"));
        quotes.add(new Quote("You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"));
        quotes.add(new Quote("To see what is right and not do it is a lack of courage.", "Confucius"));
        quotes.add(new Quote("What lies behind us and what lies before us are tiny matters compared to what lies within us.", "Ralph Waldo Emerson"));
        quotes.add(new Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"));
        quotes.add(new Quote("The only limit to our realization of tomorrow is our doubts of today.", "Franklin D. Roosevelt"));
        quotes.add(new Quote("It does not matter how slowly you go as long as you do not stop.", "Confucius"));
        quotes.add(new Quote("Everything you’ve ever wanted is on the other side of fear.", "George Addair"));
        quotes.add(new Quote("Success is not final, failure is not fatal: It is the courage to continue that counts.", "Winston Churchill"));
        quotes.add(new Quote("Hardships often prepare ordinary people for an extraordinary destiny.", "C.S. Lewis"));
        quotes.add(new Quote("The future depends on what you do today.", "Mahatma Gandhi"));
        quotes.add(new Quote("Don't watch the clock; do what it does. Keep going.", "Sam Levenson"));
        quotes.add(new Quote("Keep your eyes on the stars, and your feet on the ground.", "Theodore Roosevelt"));
        quotes.add(new Quote("You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"));
        quotes.add(new Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"));
        quotes.add(new Quote("The only impossible journey is the one you never begin.", "Tony Robbins"));
        quotes.add(new Quote("It always seems impossible until it’s done.", "Nelson Mandela"));
        quotes.add(new Quote("What lies behind us and what lies before us are tiny matters compared to what lies within us.", "Ralph Waldo Emerson"));

        // Add more quotes if desired
        return quotes;
    }
}
