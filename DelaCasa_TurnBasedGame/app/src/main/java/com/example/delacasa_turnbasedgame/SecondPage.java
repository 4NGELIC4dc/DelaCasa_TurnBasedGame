package com.example.delacasa_turnbasedgame;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondPage extends AppCompatActivity implements View.OnClickListener {

    TextView heroName, monsName, heroHP, heroEN, heroDMG, monsHP, monsDMG, combatLogtxt;
    Button attackBtn;
    ImageButton skill1Btn, skill2Btn, skill3Btn;

    //Hero Class
    int heroHealth = 2000;
    int heroMinDMG = 100;
    int heroMaxDMG = 150;
    int heroEnergy = 1000;
    String heroNN = "Tabby Cat";

    //Monster Class
    int monsHealth = 2000;
    int monsMinDMG = 80;
    int monsMaxDMG = 120;
    String monsNN = "Wild Cat";


    //Game Turns
    int turnNumber = 1;

    boolean disabledstatus = false;
    int statuscounter = 0;
    int skillcounter1 = 0;
    int skillcounter2 = 0;
    int skillcounter3 = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_second_page);


        //Text and one Attack XML
        heroName = findViewById(R.id.heroName);
        monsName = findViewById(R.id.monsName);
        heroHP = findViewById(R.id.heroHP);
        heroDMG = findViewById(R.id.heroDMG);
        heroEN = findViewById(R.id.heroEN);
        monsHP = findViewById(R.id.monsHP);
        monsDMG = findViewById(R.id.monsDMG);
        attackBtn = findViewById(R.id.attackBtn);
        //Hero and Enemy info XML
        heroName.setText(heroNN);
        heroHP.setText(String.valueOf(heroHealth));
        heroEN.setText(String.valueOf(heroEnergy));
        monsName.setText(monsNN);
        monsHP.setText(String.valueOf(monsHealth));
        //Damage XML
        heroDMG.setText(heroMinDMG + " ~ " + heroMaxDMG);
        monsDMG.setText(monsMinDMG + " ~ " + monsMaxDMG);
        //Skill XML
        skill1Btn = (findViewById(R.id.skill1Btn));
        skill2Btn = (findViewById(R.id.skill2Btn));
        skill3Btn = (findViewById(R.id.skill3Btn));
        //Button onClick Listeners
        attackBtn.setOnClickListener(this);
        skill1Btn.setOnClickListener(this);
        skill2Btn.setOnClickListener(this);
        skill3Btn.setOnClickListener(this);



        MediaPlayer mediaPlayer = MediaPlayer.create(SecondPage.this, R.raw.second_bgm);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        mediaPlayer.setOnErrorListener((mediaPlayer1, what, extra) -> {
            switch (extra) {
                case MediaPlayer.MEDIA_ERROR_IO:
                case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                case MediaPlayer.MEDIA_ERROR_TIMED_OUT:
                case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                case MediaPlayer.MEDIA_ERROR_UNSUPPORTED:
                case MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:
                case MediaPlayer.MEDIA_ERROR_MALFORMED:
                    break;
            }
            return true;

        });
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {

        //Combat Log XML
        combatLogtxt = findViewById(R.id.combatLogtxt);

        Random randomizer = new Random();
        int heroDPS = randomizer.nextInt(heroMaxDMG - heroMinDMG) + heroMinDMG;
        int monsDPS = randomizer.nextInt(monsMaxDMG - monsMinDMG) + monsMinDMG;

        if (turnNumber % 2 != 1) { //if enemy's turn, disable button
            skill1Btn.setEnabled(false);
            skill2Btn.setEnabled(false);
            skill3Btn.setEnabled(false);
        }
        else if (turnNumber % 2 == 1) { //if your turn, enable button
            skill1Btn.setEnabled(true);
            skill2Btn.setEnabled(true);
            skill3Btn.setEnabled(true);
        }
            if (skillcounter1 > 0) {
                skill1Btn.setEnabled(false);
            }
            else if (skillcounter1 == 0) {
                skill1Btn.setEnabled(true);
            }
            else {
                combatLogtxt.setText("Wait for your turn!");
            }
            if (skillcounter2 > 0) {
                skill2Btn.setEnabled(false);
            }
            else if (skillcounter2 == 0) {
                skill2Btn.setEnabled(true);
            }
            else {
                combatLogtxt.setText("Wait for your turn!");
            }
            if (skillcounter3 > 0) {
                skill3Btn.setEnabled(false);
            }
            else if (skillcounter3 == 0) {
                skill3Btn.setEnabled(true);
            }
            else {
                combatLogtxt.setText("Wait for your turn!");
            }

        switch (view.getId()) {

            case R.id.skill1Btn:

                turnNumber++;
                monsHP.setText(String.valueOf(monsHealth));
                attackBtn.setText("Attack (" + turnNumber + ")");
                combatLogtxt.setText("Your " + heroNN + " used Scratch! It dealt " + 100 + "damage to the enemy!");

                if (monsHealth < 0) {
                    combatLogtxt.setText("Your " + heroNN + " dealt " + heroDPS + " damage to the enemy! You win!");
                    heroHealth = 2000;
                    heroEnergy = 1000;
                    monsHealth = 2000;
                    turnNumber = 1;
                    attackBtn.setText("Restart?");
                }
                if (heroEnergy > 100) {
                    heroEnergy -= 50;
                    monsHealth -= 100;
                    skillcounter1 = 15;
                }

                break;

            case R.id.skill2Btn:

                turnNumber++;
                monsHP.setText(String.valueOf(monsHealth));
                attackBtn.setText("Attack (" + turnNumber + ")");
                combatLogtxt.setText("Your " + heroNN + " used Bite! It dealt " + 150 + "damage to the enemy!");


                if (monsHealth < 0) {
                    combatLogtxt.setText("Your " + heroNN + " dealt " + heroDPS + " damage to the enemy! You win!");
                    heroHealth = 2000;
                    heroEnergy = 1000;
                    monsHealth = 2000;
                    turnNumber = 1;
                    attackBtn.setText("Restart?");

                }

                if (heroEnergy > 250) {
                    heroEnergy -= 100;
                    monsHealth -= 200;
                    skillcounter2 = 10;
                }

                break;

            case R.id.skill3Btn:

                turnNumber++;
                monsHP.setText(String.valueOf(monsHealth));
                attackBtn.setText("Attack (" + turnNumber + ")");
                combatLogtxt.setText("Your " + heroNN + " used Pounce! It dealt " + 300 + "damage to the enemy!");


                if (monsHealth < 0) {
                    combatLogtxt.setText("Your " + heroNN + " dealt " + heroDPS + " damage to the enemy! You win!");
                    heroHealth = 2000;
                    heroEnergy = 1000;
                    monsHealth = 2000;
                    turnNumber = 1;
                    attackBtn.setText("Restart?");
                }
                if (heroEnergy > 500) {
                    heroEnergy -= 150;
                    monsHealth -= 300;
                    skillcounter3 = 5;
                }

                break;
            case R.id.attackBtn:

                if (turnNumber % 2 == 1) {
                    monsHealth = monsHealth - heroDPS;
                    turnNumber++;
                    monsHP.setText(String.valueOf(monsHealth));
                    attackBtn.setText("Attack (" + turnNumber + ")");
                    combatLogtxt.setText("Your " + heroNN + " dealt " + heroDPS + " damage to the enemy.");

                if (monsHealth < 0) {
                    combatLogtxt.setText("Your " + heroNN + " dealt " + heroDPS + " damage to the enemy. You win!");
                    heroHealth = 2000;
                    heroEnergy = 1000;
                    monsHealth = 2000;
                    turnNumber = 1;
                    attackBtn.setText("Restart?");
                }
                    skillcounter1--;
                    skillcounter2--;
                    skillcounter3--;

                }
                else if (turnNumber % 2 != 1) {
                    if (disabledstatus == true) {
                        combatLogtxt.setText("The " + monsNN + " is still stunned for " + statuscounter + "turns.");
                        statuscounter--;
                        turnNumber++;
                        attackBtn.setText("Attack ( " + turnNumber + " )");
                        if (statuscounter == 0) {
                            disabledstatus = false;
                        }
                    }
                    else {
                        heroHealth = heroHealth - monsDPS;
                        turnNumber++;
                        heroHP.setText(String.valueOf(heroHealth));
                        attackBtn.setText("Attack ( " + turnNumber + " )");
                        combatLogtxt.setText("The enemy " + monsNN + " dealt " + monsDPS + "to you.");

                        if (heroHealth < 0) {
                            attackBtn.setText("The enemy " + monsNN + " dealt " + monsDPS + "to you. You lost.");
                            heroHealth = 2000;
                            heroEnergy = 1000;
                            monsHealth = 2000;
                            attackBtn.setText("Restart?");

                        }

                    }

                }
                break;
        }

    }

}


