package fileio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputLoader {
    private final String inputPath;

    public InputLoader(final String inputPath) { this.inputPath = inputPath; }

    public String getInputPath() {
        return inputPath;
    }

    public Input readData() {
        JSONParser jsonParser = new JSONParser();
        int noYears = 0;
        Double santaBudget = 0.0;
        InitialDataInput initialData = null;
        AnnualChangesInput annualChanges = null;

        try {
            JSONObject jsonObject = (JSONObject) jsonParser
                    .parse(new FileReader(inputPath));

            noYears = Integer.parseInt(jsonObject.get("numberOfYears").toString());
            santaBudget = Double.parseDouble(jsonObject.get("santaBudget").toString());
            JSONObject jsonInitialData = (JSONObject) jsonObject.get("initialData");
            JSONArray jsonChanges = (JSONArray) jsonObject.get("annualChanges");

            if (jsonInitialData != null) {
                ArrayList<ChildrenInput> children = new ArrayList<>();
                ArrayList<GiftInput> gifts = new ArrayList<>();

                JSONArray jsonInitialChildren = (JSONArray) jsonInitialData.get("children");
                for (Object jsonInitKiddo : jsonInitialChildren) {
                    children.add(new ChildrenInput(
                          Integer.parseInt(((JSONObject) jsonInitKiddo).get("id").toString()),
                          (String) ((JSONObject) jsonInitKiddo).get("lastName"),
                          (String) ((JSONObject) jsonInitKiddo).get("firstName"),
                          Integer.parseInt(((JSONObject) jsonInitKiddo).get("age").toString()),
                          (String) ((JSONObject) jsonInitKiddo).get("city"),
                          Double.parseDouble(((JSONObject) jsonInitKiddo).get("niceScore").toString()),
                          Utils.convertJSONArray((JSONArray) ((JSONObject) jsonInitKiddo).get("giftsPreferences"))
                    ));
                }

                JSONArray jsonInitialGifts = (JSONArray) jsonInitialData.get("santaGiftsList");
                for (Object jsonInitGift : jsonInitialGifts) {
                    gifts.add(new GiftInput(
                            (String) ((JSONObject) jsonInitGift).get("productName"),
                            Double.parseDouble(((JSONObject) jsonInitGift).get("price").toString()),
                            (String) ((JSONObject) jsonInitGift).get("category")
                    ));
                }
                initialData = new InitialDataInput(children, gifts);
            } else {
                System.out.println("There isn't any initial data");
            }

            if (jsonChanges != null) {
                List<ChangeOfTheYearInput> changes = new ArrayList<>();

                for (Object jsonChange : jsonChanges) {
                    ArrayList<ChildrenInput> children = new ArrayList<>();
                    ArrayList<GiftInput> gifts = new ArrayList<>();
                    ArrayList<ChildrenUpdatesInput> childrenUpdates = new ArrayList<>();

                    Double newSantaBudget = Double.parseDouble(((JSONObject) jsonChange).get("newSantaBudget").toString());
                    JSONArray jsonNewGifts = (JSONArray) ((JSONObject) jsonChange).get("newGifts");
                    JSONArray jsonNewChildren = (JSONArray) ((JSONObject) jsonChange).get("newChildren");
                    JSONArray jsonChildrenUpdates = (JSONArray) ((JSONObject) jsonChange).get("childrenUpdates");

                    for (Object jsonNewGift : jsonNewGifts) {
                        gifts.add(new GiftInput(
                                (String) ((JSONObject) jsonNewGift).get("productName"),
                                Double.parseDouble(((JSONObject) jsonNewGift).get("price").toString()),
                                (String) ((JSONObject) jsonNewGift).get("category")
                        ));
                    }

                    for (Object jsonNewKiddo : jsonNewChildren) {
                        children.add(new ChildrenInput(
                                Integer.parseInt(((JSONObject) jsonNewKiddo).get("id").toString()),
                                (String) ((JSONObject) jsonNewKiddo).get("lastName"),
                                (String) ((JSONObject) jsonNewKiddo).get("firstName"),
                                Integer.parseInt(((JSONObject) jsonNewKiddo).get("age").toString()),
                                (String) ((JSONObject) jsonNewKiddo).get("city"),
                                Double.parseDouble(((JSONObject) jsonNewKiddo).get("niceScore").toString()),
                                Utils.convertJSONArray((JSONArray) ((JSONObject) jsonNewKiddo).get("giftsPreferences"))
                        ));
                    }

                    for (Object jsonChildrenUpdate : jsonChildrenUpdates) {
                        if (((JSONObject) jsonChildrenUpdate).get("niceScore") == null) {
                            childrenUpdates.add(new ChildrenUpdatesInput(
                                    Integer.parseInt(((JSONObject) jsonChildrenUpdate).get("id").toString()),
                                    0.0,
                                    Utils.convertJSONArray((JSONArray) ((JSONObject) jsonChildrenUpdate).get("giftsPreferences"))
                            ));
                        } else {
                            childrenUpdates.add(new ChildrenUpdatesInput(
                                Integer.parseInt(((JSONObject) jsonChildrenUpdate).get("id").toString()),
                                Double.parseDouble(((JSONObject) jsonChildrenUpdate).get("niceScore").toString()),
                                Utils.convertJSONArray((JSONArray) ((JSONObject) jsonChildrenUpdate).get("giftsPreferences"))
                            ));
                        }
                    }

                    changes.add(new ChangeOfTheYearInput(newSantaBudget, gifts, children, childrenUpdates));
                }
                annualChanges = new AnnualChangesInput(changes);
            } else {
                System.out.println("There aren't new changes");
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return new Input(noYears, santaBudget, initialData, annualChanges);
    }
}
