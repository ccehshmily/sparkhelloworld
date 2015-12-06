import static spark.Spark.*;

import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class HelloWorld {
  private static final String LAYOUT_TEMPLATE = "templates/layout.vtl";

  public static void main(String[] args) {
    staticFileLocation("/public");

    get("/", (request, response) ->
        {
          HashMap model = new HashMap();
          model.put("template", "templates/menu.vtl" );
          return new ModelAndView(model, LAYOUT_TEMPLATE);
        },
        new VelocityTemplateEngine());
    get("/hello", (request, response) -> "Welcome Friend!");
    get("/letter", (request, response) ->
        {
          HashMap model = new HashMap();
          model.put("template", "templates/letter.vtl" );
          return new ModelAndView(model, LAYOUT_TEMPLATE);
        },
        new VelocityTemplateEngine());
    get("/photos", (request, response) ->
        {
          HashMap model = new HashMap();
          model.put("template", "templates/photos.vtl" );
          return new ModelAndView(model, LAYOUT_TEMPLATE);
        },
        new VelocityTemplateEngine());
  }
}
