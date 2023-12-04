package day2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int numberOfGames = 0;
    private int id;
    private List<Round> rounds;

    public Game(List<Round> rounds) {
        this.id = ++numberOfGames;
        this.rounds = rounds;
    }

    public int playGameOne(GameRequirement gameRequirement) {
        for (Round round : rounds) {
            if (!isPlayable(round, gameRequirement)) {
                return 0;
            }
        }
        return this.id;
    }

    public int playGameTwo(GameRequirement gameRequirement) {
        gameRequirement.reset();
        getMinDices(gameRequirement);
        return gameRequirement.powerOfDices();
    }

    /**
     * finds the minimum amount of dices that are needed
     * 
     * @param gameRequirement
     */
    private void getMinDices(GameRequirement gameRequirement) {
        for (Round round : rounds) {
            if (round.getRed() > gameRequirement.getMinRed()) {
                gameRequirement.setMinRed(round.getRed());
            }
            if (round.getBlue() > gameRequirement.getMinBlue()) {
                gameRequirement.setMinBlue(round.getBlue());
            }
            if (round.getGreen() > gameRequirement.getMinGreen()) {
                gameRequirement.setMinGreen(round.getGreen());
            }
        }
    }

    public static List<Round> formatRounds(String fileInput) {
        String[] gameData = fileInput.split(":");
        List<Round> rounds = new ArrayList<>();

        String[] roundsData = gameData[1].split(";");
        for (int i = 0; i < roundsData.length; i++) {
            String[] roundData = roundsData[i].split(",");
            Round round = setDiceValuesOfRoundByColor(roundData);
            rounds.add(round);
        }
        return rounds;
    }

    private static Round setDiceValuesOfRoundByColor(String[] roundData) {
        String pattern = "[a-zA-Z ]";
        Round round = new Round();
        for (int k = 0; k < roundData.length; k++) {
            String s = roundData[k];
            if (s.indexOf("red", 0) != -1) {
                s = s.replaceAll(pattern, "");
                round.setRed(Integer.parseInt(s));
            } else if (s.indexOf("green", 0) != -1) {
                s = s.replaceAll(pattern, "");
                round.setGreen(Integer.parseInt(s));
            } else {
                s = s.replaceAll(pattern, "");
                round.setBlue(Integer.parseInt(s));
            }
        }
        return round;
    }

    private boolean isPlayable(Round round, GameRequirement gameRequirement) {
        return !(round.getBlue() > gameRequirement.getBlue() || round.getRed() > gameRequirement.getRed()
                || round.getGreen() > gameRequirement.getGreen());
    }

    public static int getNumberOfGames() {
        return numberOfGames;
    }

    public List<Round> getRounds() {
        return rounds;
    }

}
