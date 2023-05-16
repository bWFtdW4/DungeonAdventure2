package com.example.dungeonadventure2;

import android.view.View;

import java.util.Random;

public class Story {

    GameScreen gs;
    String nextButton1, nextButton2, nextButton3, nextButton4;
    String runAwayString = "Run away!";
    String goLeftString = "Go left";
    String goRightString = "Go right";
    String retreatString = "Retreat";
    String goThroughString = "Go through!";
    String attackString = "Attack!";
    String defendString = "Defend yourself";
    String reincarnateString = "Reincarnate";
    String entranceString = "Go back to Entrance";
    String autoString = ">>>AUTO ATTACK >>>>";
    String whatDoYouDo = "\n\n What do you do?";
    int playerGold, playerHealth, monsterHealth;
    boolean newGame;

    public Story(GameScreen gs) {
        this.gs = gs;
    }

    public String getNextButton1() {
        return nextButton1;
    }

    public void setNextButton1(String nextButton1) {
        this.nextButton1 = nextButton1;
    }

    public String getNextButton2() {
        return nextButton2;
    }

    public void setNextButton2(String nextButton2) {
        this.nextButton2 = nextButton2;
    }

    public String getNextButton3() {
        return nextButton3;
    }

    public void setNextButton3(String nextButton3) {
        this.nextButton3 = nextButton3;
    }

    public String getNextButton4() {
        return nextButton4;
    }

    public void setNextButton4(String nextButton4) {
        this.nextButton4 = nextButton4;
    }

    public int getPlayerGold() {
        return playerGold;
    }

    public void setPlayerGold(int playerGold) {
        this.playerGold = playerGold;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }


    public void nextStory(String next) {

        switch (next) {
            case "startingStory"://start
                startingStory();
                break;
            case "entranceStory"://entrance
                entranceStory();
                break;
            case "monster":
                teleportRoomStory();
                break;
            case "bazaarStory"://bazaa
                bazaarStory();
                break;
            case "boss":
                bossStory();
                break;
            case "startFight":
                fightingStory();
                break;
            case "fight":
                fightingSequence();
                break;
            case "runaway":
                runawayStory();
                break;
            case "test":
                test();
                break;
            case "rollCheckPlayerTurn"://playerAttack
                rollCheckPlayerTurn();
                break;
            case "rollCheckMonsterTurn"://playerDefend
                rollCheckMonsterTurn();
                break;
            case "autoBattle":
                autoBattle();
                break;
            case "healthPotionBazaarStory":
                healthPotionBazaarStory();
                break;


        }

    }

    public void test() {
        gs.gameImage.setImageResource(R.drawable.testteslacoil);
        String text = "testtesttesttesttest\ntesttesttesttesttest";
        gs.gameText.setText(text + whatDoYouDo);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton1.setText(entranceString);
        setNextButton1("entranceStory");

    }


    public void startingStory() {
        System.out.println("startingStory() started");

        gs.gameImage.setImageResource(R.drawable.directionsigns);

        gs.gameMonsterTitle.setVisibility(View.INVISIBLE);
        gs.gameMonsterHealthTitle.setVisibility(View.INVISIBLE);
        gs.gameMonsterHealth.setVisibility(View.INVISIBLE);

        playerRecoverFullHealth();

        String text = "You find yourself standing at the entrance of a mysterious dungeon.\n"
                + "Torch in hand, you take your first step into the unknown.\n"
                + "The corridor stretches before you, and as you venture deeper, you come across a fork in the path.\n\n"
                + "Do you go left or right?";
        gs.gameText.setText(text + whatDoYouDo);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.VISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton1.setText(goLeftString);
        gs.gameButton2.setText(goRightString);
        gs.gameButton4.setText(runAwayString);

        setNextButton1("monster");
        setNextButton2("bazaarStory");
        setNextButton3("entranceStory");
        setNextButton4("runaway");

    }

    public void entranceStory() {
        System.out.println("entranceStory() started");

        gs.gameImage.setImageResource(R.drawable.directionsigns);

        gs.gameMonsterTitle.setVisibility(View.INVISIBLE);
        gs.gameMonsterHealthTitle.setVisibility(View.INVISIBLE);
        gs.gameMonsterHealth.setVisibility(View.INVISIBLE);

        String text = "You teleport back to the entrance of this mysterious dungeon.\n"
                + "Torch in hand, you look around.\n"
                + "The corridor seems familiar, as you return to the fork in the path.\n\n"
                + "Do you go left or right?";
        gs.gameText.setText(text + whatDoYouDo);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.VISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton1.setText(goLeftString);
        gs.gameButton2.setText(goRightString);
        gs.gameButton4.setText(runAwayString);

        setNextButton1("monster");
        setNextButton2("bazaarStory");
        setNextButton4("runaway");
    }

    public void teleportRoomStory() {
        System.out.println("teleportStory() started");

        gs.gameImage.setImageResource(R.drawable.magicgate);

        String text = "You cautiously proceed down the left path, wary of any lurking dangers.\n" +
                "The corridor twists and turns until you reach a room.\n" +
                "Inside, you find a magical door.";
        gs.gameText.setText(text + whatDoYouDo);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.INVISIBLE);
        gs.gameButton3.setVisibility(View.VISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);


        gs.gameButton1.setText(goThroughString);
        gs.gameButton3.setText(retreatString);
        gs.gameButton4.setText(runAwayString);

        setNextButton1("startFight");
        setNextButton3("entranceStory");
        setNextButton4("runaway");

    }

    public void fightingStory() {
        System.out.println("fightingStory() started");

        gs.gameImage.setImageResource(R.drawable.minotaur);

        gs.gameMonsterTitle.setVisibility(View.VISIBLE);
        gs.gameMonsterHealthTitle.setVisibility(View.VISIBLE);
        gs.gameMonsterHealth.setVisibility(View.VISIBLE);

        String health = "\n100";
        gs.gameMonsterHealth.setText(health);
        setMonsterHealth(100);

        String text = "Inside, you encounter a fearsome monster!\nYou prepare to battle the monster, summoning your courage and readying your weapon.\n\n" +
                "The fight begins!";
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.VISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton1.setText(attackString);
        gs.gameButton2.setText(autoString);
        gs.gameButton4.setText(runAwayString);

        setNextButton1("rollCheckPlayerTurn");
        setNextButton2("autoBattle");
        setNextButton4("runaway");

    }

    public void fightingSequence() {
        System.out.println("fightingSequence() started");
        System.out.println("Monster health: " + getMonsterHealth());

        gs.gameImage.setImageResource(R.drawable.swordman);

        String text = "You stare at the monster, readying your weapon.\n Monster health:" + getMonsterHealth() + " \n\n" +
                "What do you do?";
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.VISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton1.setText(attackString);
        gs.gameButton2.setText(autoString);
        gs.gameButton4.setText(runAwayString);

        setNextButton1("rollCheckPlayerTurn");
        setNextButton2("autoBattle");
        setNextButton4("runaway");

    }

    public int d6Roll() {
        System.out.println("d6Roll() started");

        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public void rollCheckPlayerTurn() {
        System.out.println("rollCheckPlayerTurn() started");

        int playerRoll = d6Roll() + 2;
        int monsterRoll = d6Roll();

        System.out.println("player turn:");
        System.out.println("player: " + playerRoll + "| monster: " + monsterRoll);

        if (playerRoll > monsterRoll) {
            System.out.println("activating playerAttackMonster()");
            playerAttackMonster();
        } else {
            System.out.println("activating monsterDefendPlayer()");
            monsterDefendPlayer();
        }
    }

    public void rollCheckMonsterTurn() {
        System.out.println("rollCheckMonsterTurn() started");

        int playerRoll = d6Roll() + 2;
        int monsterRoll = d6Roll();

        System.out.println("monster turn:");
        System.out.println("player: " + playerRoll + "| monster: " + monsterRoll);

        if (monsterRoll > playerRoll) {
            System.out.println("activating monsterAttackPlayer()");
            monsterAttackPlayer();
        } else {
            System.out.println("activating playerDefendMonster()");
            playerDefendMonster();
        }
    }

    public void playerAttackMonster() {
        System.out.println("playerAttackMonster() started");

        gs.gameImage.setImageResource(R.drawable.swordman);

        int attackPower = d6Roll() + d6Roll() + d6Roll();
        System.out.println("attackPower: " + attackPower);
        int health = getMonsterHealth() - attackPower;
        if (health > 0) {
            setMonsterHealth(health);
            String healthString = "\n" + getMonsterHealth();
            gs.gameMonsterHealth.setText(healthString);
            System.out.println("monster health: " + getMonsterHealth());

            String text = "You hit the Monster for " + attackPower + " .\nThe Monster is still alive!\n" + "Monster health: " + getMonsterHealth() + "\n\nThe Monster is attacking back!";
            gs.gameText.setText(text);

            gs.gameButton1.setVisibility(View.VISIBLE);
            gs.gameButton2.setVisibility(View.INVISIBLE);
            gs.gameButton3.setVisibility(View.INVISIBLE);
            gs.gameButton4.setVisibility(View.VISIBLE);

            gs.gameButton1.setText(defendString);

            gs.gameButton4.setText(runAwayString);

            setNextButton1("rollCheckMonsterTurn");
            setNextButton4("runaway");
        } else {
            monsterDefeated();
        }


    }

    public void monsterAttackPlayer() {
        System.out.println("monsterAttackPlayer() started");

        gs.gameImage.setImageResource(R.drawable.swordman);

        int attackPower = d6Roll() + d6Roll() + d6Roll();
        System.out.println("attackPower: " + attackPower);
        int health = getPlayerHealth() - attackPower;
        System.out.println("player health: " + health);
        if (health > 0) {
            setPlayerHealth(health);
            String healthString = "" + getPlayerHealth();
            gs.gamePlayerHealth.setText(healthString);
            System.out.println("player health: " + getPlayerHealth());

            String text = "The Monster hit you for " + attackPower + " .\n";
            gs.gameText.setText(text);

            gs.gameButton1.setVisibility(View.VISIBLE);
            gs.gameButton2.setVisibility(View.INVISIBLE);
            gs.gameButton3.setVisibility(View.INVISIBLE);
            gs.gameButton4.setVisibility(View.VISIBLE);

            gs.gameButton1.setText(attackString);
            gs.gameButton4.setText(runAwayString);

            setNextButton1("rollCheckPlayerTurn");
            setNextButton4("runaway");
        } else {
            playerDefeated();
        }

    }

    public void playerDefendMonster() {
        System.out.println("playerDefendMonster() started");

        gs.gameImage.setImageResource(R.drawable.playerdefend);

        String text = "You dogged the hit!\n\nThe Monster is attacking back!";
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.INVISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton1.setText(attackString);
        gs.gameButton4.setText(runAwayString);

        setNextButton1("rollCheckPlayerTurn");
        setNextButton4("runaway");
    }


    public void monsterDefendPlayer() {
        System.out.println("monsterDefendPlayer() started");

        gs.gameImage.setImageResource(R.drawable.monsterdefend);

        String text = "You try to hit the Monster but it dogged! \n\nThe Monster is attacking back!";
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.INVISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton1.setText(defendString);
        gs.gameButton4.setText(runAwayString);

        setNextButton1("rollCheckMonsterTurn");
        setNextButton4("runaway");
    }


    public void bazaarStory() {
        System.out.println("bazaarStory() started");

        gs.gameImage.setImageResource(R.drawable.shop);

        String line1 = "You decide to take the right path instead, curious about what lies ahead.";
        String line2 = "\nAs you move forward, you stumble upon a room with a friendly shopkeeper.";
        String line3 = "\nThe shop has a health potion to sell.";
        String text = line1 + line2 + line3 + whatDoYouDo;
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.INVISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        String healthPotionString = "Buy a health Potion for 50G";

        gs.gameButton1.setText(healthPotionString);
        gs.gameButton4.setText(runAwayString);

        //setNextButton1("healthPotionBazaarStory");
        setNextButton1("test");
        setNextButton4("runaway");

    }

    public void healthPotionBazaarStory() {
        System.out.println("healthPotionBazaarStory() started");

        gs.gameImage.setImageResource(R.drawable.shop);

        if (getPlayerGold() >= 50){
            System.out.println("Player has Gold: " + getPlayerGold());

            gs.gameImage.setImageResource(R.drawable.healthpotion);

            setPlayerGold(getPlayerGold() - 50);
            playerRecoverFullHealth();

            String line1 = "You paid 50 Gold and received the potion.";
            String line2 = "\nAs you drink the potion you feel recovered and ready to fight!";
            String line3 = "\n";

            gs.gameText.setText(line1 + line2 + line3 + whatDoYouDo);

        }else{
            System.out.println("Player has Gold: " + getPlayerGold());

            gs.gameImage.setImageResource(R.drawable.nohealthpotion);

            String line1 = "Looks like you don't have enough Gold!.";
            String line2 = "\nGo fight Monster to earn Gold!";
            String line3 = "\n";

            gs.gameText.setText(line1 + line2 + line3 + whatDoYouDo);

        }
        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.INVISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);
        gs.gameButton1.setText(entranceString);
        gs.gameButton4.setText(runAwayString);
        setNextButton1("entranceStory");
        setNextButton4("runaway");


    }

    public void bossStory() {
        System.out.println("bossStory() started");

        gs.gameImage.setImageResource(R.drawable.boss);

        String text = "After your encounter with the shopkeeper, you press on until you reach the final room.\n" +
                "There, you face the formidable end boss, a monstrous creature ready to do battle.\n\n" +
                "What do you do?";
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.VISIBLE);
        gs.gameButton2.setVisibility(View.VISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton1.setText("Engage in direct combat");
        gs.gameButton2.setText("Use a special ability or item");
        gs.gameButton4.setText(runAwayString);

        setNextButton1("entranceStory");
        setNextButton2("entranceStory");
        setNextButton4("runaway");
    }

    public void runawayStory() {
        System.out.println("runawayStory() started");

        gs.gameImage.setImageResource(R.drawable.run);

        String text = "Why you ran away??\n\n" +
                "WOW!\n\nThe End.\n\n";
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.INVISIBLE);
        gs.gameButton2.setVisibility(View.INVISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton4.setText(entranceString);
        setNextButton4("entranceStory");
    }

    public void playerDefeated() {
        System.out.println("playerDefeated() started");

        gs.gameImage.setImageResource(R.drawable.backstab);

        String health = "0";
        gs.gamePlayerHealth.setText(health);
        setPlayerHealth(0);

        String text = "You died!";
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.INVISIBLE);
        gs.gameButton2.setVisibility(View.INVISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton4.setText(reincarnateString);
        setNextButton4("startingStory");

    }

    public void monsterDefeated() {
        System.out.println("monsterDefeated() started");

        gs.gameImage.setImageResource(R.drawable.monstergrave);

        String health = "\n0";
        gs.gameMonsterHealth.setText(health);
        setMonsterHealth(0);

        setPlayerGold(getPlayerGold() + 10);
        String gold = "" + getPlayerGold();
        gs.gamePlayerGold.setText(gold);

        String text = "You defeated the Monster!\nYou received 10 Gold!\n\nWhat next?";
        gs.gameText.setText(text);

        gs.gameButton1.setVisibility(View.INVISIBLE);
        gs.gameButton2.setVisibility(View.INVISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.VISIBLE);

        gs.gameButton4.setText(entranceString);
        setNextButton4("entranceStory");

    }

    public void autoBattle(){
        System.out.println("autoBattle() started");

        gs.gameButton1.setVisibility(View.INVISIBLE);
        gs.gameButton2.setVisibility(View.VISIBLE);
        gs.gameButton3.setVisibility(View.INVISIBLE);
        gs.gameButton4.setVisibility(View.INVISIBLE);

        gs.gameButton2.setText(autoString);

        setNextButton2("autoBattle");

        int turn = 0;
        boolean auto = true;
        while (auto == true){
            ++turn;
            System.out.println("Turn: " + turn);
            String line1 = "Turn: " + turn;
            String line2 = "\n";
            String line3 = "\n";
            String text = line1 + line2 + line3;
            gs.gameText.setText(text);

            if (getMonsterHealth() > 0){
                rollCheckPlayerTurn();

            }else {
                monsterDefeated();
                auto = false;
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (getPlayerHealth() > 0){
                rollCheckMonsterTurn();
            }else {
                playerDefeated();
                auto = false;
                break;
            }
            //auto = false;
        }
    }

    public void playerRecoverFullHealth(){
        System.out.println("playerRecoverFullHealth() started");

        String health = "100";
        gs.gamePlayerHealth.setText(health);
        setPlayerHealth(100);
    }


}
