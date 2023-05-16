package com.example.dungeonadventure2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    ImageView gameImage;
    TextView gameText, gamePlayerHealth, gamePlayerGold;
    TextView gameMonsterTitle, gameMonsterHealthTitle, gameMonsterHealth;
    Button gameButton1, gameButton2, gameButton3, gameButton4;

    Story story = new Story(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);


        gamePlayerHealth = (TextView) findViewById(R.id.gamePlayerHealthValueTextView);
        gamePlayerGold = (TextView) findViewById(R.id.gamePlayerGoldValueTextView);
        gameMonsterTitle = (TextView) findViewById(R.id.gameMonsterTextView);
        gameMonsterHealthTitle = (TextView) findViewById(R.id.gameMonsterHealthTextView);
        gameMonsterHealth = (TextView) findViewById(R.id.gameMonsterHealthValueTextView);
        gameImage = (ImageView) findViewById(R.id.gameImageView);
        gameText = (TextView) findViewById(R.id.gameTextView);
        gameButton1 = (Button) findViewById(R.id.choiceButton1);
        gameButton2 = (Button) findViewById(R.id.choiceButton2);
        gameButton3 = (Button) findViewById(R.id.choiceButton3);
        gameButton4 = (Button) findViewById(R.id.choiceButton4);

        story.startingStory();
    }

    public void button1(View view) {

        story.nextStory(story.getNextButton1());
    }

    public void button2(View view) {

        story.nextStory(story.getNextButton2());
    }

    public void button3(View view) {

        story.nextStory(story.getNextButton3());
    }

    public void button4(View view) {

        story.nextStory(story.getNextButton4());
    }


}