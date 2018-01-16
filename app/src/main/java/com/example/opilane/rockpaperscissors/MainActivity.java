package com.example.opilane.rockpaperscissors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rock,paper,scissors, end;
    ImageView humanView,computerView;
    TextView skoor;
    String humnaChoice,comuterChoice,result;
    Random r;
    int HumanScore,ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissors = findViewById(R.id.scissors);
        skoor = findViewById(R.id.skoor);
        end = findViewById(R.id.end);
        humanView = findViewById(R.id.human);
        computerView = findViewById(R.id.cpu);
        r = new Random();

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humnaChoice = "rock";
                calculate();
                humanView.setImageResource(R.drawable.rock);
                skoor.setText("Human:" + Integer.toString(HumanScore) + "vs. Computer: " + Integer.toString(ComputerScore));



            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humnaChoice = "paper";
                calculate();
                humanView.setImageResource(R.drawable.paper);
                skoor.setText("Human:" + Integer.toString(HumanScore) + "vs. Computer: " + Integer.toString(ComputerScore));



            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humnaChoice = "scissors";
                calculate();
                humanView.setImageResource(R.drawable.scissors);
                skoor.setText("Human:" + Integer.toString(HumanScore) + "vs. Computer: " + Integer.toString(ComputerScore));



            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("lastScore", HumanScore);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });




    }
    public void calculate (){
        int computer = r.nextInt(3);
        if (computer == 0){
            comuterChoice = "rock";
            computerView.setImageResource(R.drawable.rock);

        }
        else if (computer == 1) {
            comuterChoice = "paper";
            computerView.setImageResource(R.drawable.paper);
        }
        else if (computer == 2){
            comuterChoice = "scissors";
            computerView.setImageResource(R.drawable.scissors);
        }
        if (humnaChoice.equals("rock") && comuterChoice.equals("paper")){
            result = "You lose!";
            HumanScore++;

        }
        else if (humnaChoice.equals("rock") && comuterChoice.equals("scissors")){
            result = "You win!";
            HumanScore++;
        }
        else if (humnaChoice.equals("paper") && comuterChoice.equals("scissors")){
            result = "You lose!";
            HumanScore++;
        }
        else if (humnaChoice.equals("paper") && comuterChoice.equals("rock")){
            result = "You win!";
            HumanScore++;
        }
        else if (humnaChoice.equals("scissors") && comuterChoice.equals("rock")){
            result = "You lose!";
            HumanScore++;
        }

        else if (humnaChoice.equals("scissors") && comuterChoice.equals("paper")){
            result = "You win!";
            HumanScore++;
        }
        else if (humnaChoice.equals("rock") && comuterChoice.equals("rock")){
            result = "It`s a tie!";
            HumanScore++;
        }
        else if (humnaChoice.equals("paper") && comuterChoice.equals("paper")){
            result = "It`s a tie!";
            HumanScore++;
        }
        else if (humnaChoice.equals("scissors") && comuterChoice.equals("scissors")){
            result = "It`s a tie!";
            HumanScore++;
        }
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }
}
