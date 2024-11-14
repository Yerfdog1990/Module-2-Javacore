package CreateThreadUsingLabda;

import java.util.Random;

public class RandomPlayer {
    void playGame(String gameName) throws InterruptedException {
        System.out.println(gameName+ " started.");
        Thread.sleep(500);
        System.out.println(gameName+ " ended.");
    }
    void playMusic(String musicName) throws InterruptedException{
        System.out.println(musicName+ " started.");
        Thread.sleep(500);
        System.out.println(musicName+ " ended.");
    }
}
class Test{
    static String[] gamesList = {"Football", "Basketball", "Handball", "Rugby", "Tennis"};
    static String[] musicList = {"Gospel", "Rhumba", "RnB", "Country Music", "Benga"};

    public static void main(String[] args) {
        RandomPlayer randomPlayer = new RandomPlayer();
        Random randomSelect = new Random();

        //Create runnable object
        Runnable gamePlayer = () ->{
            try {
                randomPlayer.playGame(gamesList[randomSelect.nextInt(gamesList.length)]);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted.");
            }
        };
        Runnable musicPlayer = () ->{
            try {
                randomPlayer.playMusic(musicList[randomSelect.nextInt(musicList.length)]);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted.");
            }
        };
        //Instantiate thread class and pass runnable object
        Thread gameThread = new Thread(gamePlayer);
        Thread musicThread = new Thread(musicPlayer);

        //Set priority
        gameThread.setPriority(Thread.MAX_PRIORITY);
        musicThread.setPriority(Thread.MIN_PRIORITY);

        //Start thread
        gameThread.start();
        musicThread.start();
    }
}
