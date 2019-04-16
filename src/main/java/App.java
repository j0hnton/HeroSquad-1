import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "public/templates/layout.vtl";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", request.session().attribute("heroes"));
            model.put("template", "public/templates/squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            ArrayList<Hero> heroes = request.session().attribute("heroes");

            if (heroes == null) {
                heroes = new ArrayList<Hero>();
                request.session().attribute("heroes", heroes);
            }

            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String superpower = request.queryParams("superpower");
            String weakness = request.queryParams("weakness");
            String cause = request.queryParams("cause");
            Hero newhero = new Hero(name, age, superpower, weakness, cause);
            heroes.add(newhero);

            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}