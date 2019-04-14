import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        String layout = "public/templates/layout.vtl";


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("heroesData", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String superpower = request.queryParams("superpower");
            String weakness = request.queryParams("weakness");
            Hero hero = new Hero(name, age, superpower, weakness);
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("squadssData", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("sname");
            String size = request.queryParams("size");
            String cause = request.queryParams("cause");
            Squad squad = new Squad(name, size, cause);
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}