package com.makuners.android.kickoff;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Arrays to store the differetn values for every team
    int[] teamAScores = new int[]{0,0,0};
    int[] teamBScores = new int[]{0,0,0};
    //Arrays with the id names of the fields where to show the scores
    String[] teamAFields = new String[]{"team_a_score", "fouls_team_a", "corners_team_a"};
    String[] teamBFields = new String[]{"team_b_score", "fouls_team_b", "corners_team_b"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        Intent i = getIntent();
        String teamAName = i.getStringExtra(IntroActivity.TEAM_A_NAME);
        String teamBName = i.getStringExtra(IntroActivity.TEAM_B_NAME);

        // Change the default values of the TextViews and set the names for the teams
        // if not empty
        TextView textViewA = (TextView) findViewById(R.id.team_a_name);
        if (!teamAName.isEmpty()) {
            textViewA.setText(teamAName);
        }
        TextView textViewB = (TextView) findViewById(R.id.team_b_name);
        if(!teamBName.isEmpty()) {
            textViewB.setText(teamBName);
        }

        //Lock screen orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    /**
     * Displays the given scores for Team A.
     *
     * @param n the place in the teamAScores array relative to the different value
     */
    public void displayForTeamA(int n){
        //Target the right field to update the value
        int id = this.getResources().getIdentifier(teamAFields[n],"id", getPackageName());
        TextView textView = (TextView) findViewById(id);
            textView.setText(String.valueOf(teamAScores[n]));
    }
    //Increase Team A score by 1
    public void goalTeamA(View v){
        teamAScores[0]++;
        displayForTeamA(0);
    }
    //Increase Team B fouls counter by 1
    public void foulTeamA(View v){
        teamAScores[1]++;
        displayForTeamA(1);
    }
    //Increase Team A corner kicks counter by 1
    public void cornerTeamA(View v){
        teamAScores[2]++;
        displayForTeamA(2);
    }

    /**
     * Displays the given score for Team B.
     *
     * @param n the place in the teamBScores array relative to the different value
     */
    public void displayForTeamB(int n){
        //Target the right field to update the value
        int id = this.getResources().getIdentifier(teamBFields[n],"id", getPackageName());
        TextView textView = (TextView) findViewById(id);
        textView.setText(String.valueOf(teamBScores[n]));
    }
    //Increase Team B score by 1
    public void goalTeamB(View v){
        teamBScores[0]++;
        displayForTeamB(0);
    }
    //Increase Team B fouls counter by 1
    public void foulTeamB(View v){
        teamBScores[1]++;
        displayForTeamB(1);
    }
    //Increase Team B corner kicks counter by 1
    public void cornerTeamB(View v){
        teamBScores[2]++;
        displayForTeamB(2);
    }
    //Reset every counter to 0
    public void resetScores(View view){
        for ( int i=0; i<3; i++){
            teamAScores[i] = 0;
            teamBScores[i] = 0;
            displayForTeamA(i);
            displayForTeamB(i);
        }

    }


}
