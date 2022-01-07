package main;

import checker.Checker;
import checker.Checkstyle;
import common.Constants;
import fileio.Input;
import fileio.InputLoader;
//import fileio.Writer;

import org.json.simple.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/** The entry point to this homework. It runs the checker that tests your implentation. */
public final class Main {
    /** for coding style */
    private Main() {
    }
    /**
     * Call the main checker and the coding style checker
     *
     * @param args from command line
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.RESULT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        File outputDirectory = new File(Constants.RESULT_PATH);

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filename = file.getPath().substring(10);
            System.out.println(filename);
            String filepath = Constants.OUTPUT_PATH + filename;
            File out = new File(filepath);
            System.out.println(filepath);

            boolean isCreated = out.createNewFile();

            // TODO: delete fisierele puli
            //if (isCreated) {
                action(file.getAbsolutePath(), filepath);
            //}
        }

        Checker.calculateScore();
    }

    /**
     * @param filePath1 for input file
     * @param filePath2 for output file
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void action(final String filePath1, final String filePath2) throws IOException {
        InputLoader inputLoader = new InputLoader(filePath1);
        Input input = inputLoader.readData();
        System.out.println(input);
//        Writer fileWriter = new Writer(filePath2);
//        JSONArray arrayResult;
//
//        Database videoPlatform = Database.getInstance();
//        videoPlatform.addActors(input.getActors());
//        videoPlatform.addMovies(input.getMovies());
//        videoPlatform.addShows(input.getSerials());
//        videoPlatform.addVideos();
//        videoPlatform.addUsers(input.getUsers());
//
//        arrayResult = videoPlatform.addCommands(input.getCommands());
//        videoPlatform.clear();
//
//        fileWriter.closeJSON(arrayResult);
    }
}
