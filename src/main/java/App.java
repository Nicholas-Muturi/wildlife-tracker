import static spark.Spark.*;

import models.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sighting.all());
            model.put("rangers",Ranger.all());
            model.put("animals",Animal.allAnimalNames());
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
    }
}
