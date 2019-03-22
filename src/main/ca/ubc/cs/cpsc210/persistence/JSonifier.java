package ca.ubc.cs.cpsc210.persistence;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.person.Person;
import ca.ubc.cs.cpsc210.model.person.Registry;
import ca.ubc.cs.cpsc210.model.resourcehotspot.ResourceHotSpot;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSonifier {

    public static JSONObject personToJson(Person p){
        JSONObject savePerson = new JSONObject();

        savePerson.put("pos",p.getPos());
        savePerson.put("attack",p.getAttack());
        savePerson.put("curMaxHealth",p.getCurMaxHealth());
        savePerson.put("Health",p.getHealth());

        return savePerson;
    }

    private static JSONArray registryToJson(Registry r){
        JSONArray saveRegistry = new JSONArray();

        for(Person p : r){
            saveRegistry.put(personToJson(p));
        }

        return saveRegistry;
    }

    private static JSONObject townToJson(TownCentre t){

        JSONObject saveTown = new JSONObject();

        saveTown.put("amountFood",t.getAmountFood());
        saveTown.put("amountGold",t.getAmountGold());
        saveTown.put("registry",registryToJson(t.getRegistry()));
        saveTown.put("personID",t.getPersonID());


        return saveTown;
    }

    private static JSONObject resourceHotSpotToJson(ResourceHotSpot r){
        JSONObject saveResourceHotSpot = new JSONObject();

        saveResourceHotSpot.put("resourceRemaining",r.getResourceRemaining());
        return saveResourceHotSpot;
    }

    public static JSONObject gameToJson(Game g){
        JSONObject saveGame = new JSONObject();

        saveGame.put("playerTown",townToJson(g.getPlayerTown()));
        saveGame.put("enemyTown",townToJson(g.getEnemyTown()));
        saveGame.put("goldMine", resourceHotSpotToJson(Game.goldMine));
        saveGame.put("farm",resourceHotSpotToJson(Game.farm));

        return saveGame;
    }
}
