package day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import utils.Executable;

public class CubeConundrum implements Executable {
    private static final String PATH_ONE = "src/day2/data/data.csv";
    private static final String PATH_TWO = "src/day2/data/data2.csv";
    private static final GameRequirement GAME_REQ = new GameRequirement(12, 14, 13);
    List<Game> gamesOne = new ArrayList<>();
    List<Game> gamesTwo = new ArrayList<>();

    public static void main(String[] args) {
        CubeConundrum cubeConundrum = new CubeConundrum();

        cubeConundrum.execute();
    }

    public CubeConundrum() {
        init();
    }

    public void init() {
        List<String> fileOne = null;
        List<String> fileTwo = null;
        try {
            fileOne = Files.readAllLines(new File(PATH_ONE).toPath());
            fileTwo = Files.readAllLines(new File(PATH_TWO).toPath());
        } catch (IOException e) {
            System.out.println("Error - file not found");
            e.printStackTrace();
        }
        // add rounds to gameOne
        for (String string : fileOne) {
            List<Round> rounds = Game.formatRounds(string);
            Game game = new Game(rounds);
            gamesOne.add(game);
        }
        // add rounds to gameTwo
        for (String string : fileTwo) {
            List<Round> rounds = Game.formatRounds(string);
            Game game = new Game(rounds);
            gamesTwo.add(game);
        }
    }

    @Override
    public void execute() {
        gameOne(gamesOne, GAME_REQ);
        gameTwo(gamesTwo, GAME_REQ);
    }

    private void gameOne(List<Game> games, GameRequirement gameRequirement) {
        int sumGameOne = 0;
        for (int i = 0; i < games.size(); i++) {
            sumGameOne += games.get(i).playGameOne(gameRequirement);
        }
        System.out.println(sumGameOne);
    }

    private void gameTwo(List<Game> games, GameRequirement gameRequirement) {
        int sumGameTwo = 0;
        for (int i = 0; i < games.size(); i++) {
            sumGameTwo += games.get(i).playGameTwo(gameRequirement);
        }
        System.out.println(sumGameTwo);
    }

}
