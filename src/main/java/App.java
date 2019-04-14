import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class  App {
    public static void main(String[] args) {
        String layout = "layout.vtl";
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}