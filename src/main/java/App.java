import static spark.Spark.*;

import models.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get: Homepage
        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> allSightings = Sighting.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        //get: New Sighting Form
        get("/sighting/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sighting.all());
            return new ModelAndView(model,"sighting-form.hbs");
        },new HandlebarsTemplateEngine());

        //Post: Sighting Submission
        post("/sighting/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String rangerName = request.queryParams("rangerName").trim();
            String animalName = request.queryParams("animalName").trim();
            String animalAge = request.queryParams("animalAge").trim();
            String animalHealth = request.queryParams("animalHealth").trim();
            String location = request.queryParams("location").trim();
            String animalType = request.queryParams("animalType").trim();

            Ranger newRanger = new Ranger(rangerName);
            newRanger.save();

            if(animalType.equalsIgnoreCase("endangered")){
                EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName,animalHealth,animalAge);
                endangeredAnimal.save();
                Sighting newSighting = new Sighting(endangeredAnimal.getName(),location,newRanger.getId());
                newSighting.save();
            }
            else{
                NormalAnimal normalAnimal = new NormalAnimal(animalName,animalHealth,animalAge);
                normalAnimal.save();
                Sighting newSighting = new Sighting(normalAnimal.getName(),location,newRanger.getId());
                newSighting.save();
            }
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());


    }
}
