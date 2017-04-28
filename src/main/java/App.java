// importing libraries to be used
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		staticFileLocation("/public");
		String layout = "templates/layout.vtl";
		//root route
		get("/", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("template", "templates/index.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		//displays all squads
		get("/squads", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("squads", Squad.all());
			model.put("template", "templates/squads.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		//retrieves a form to add new squad form
		get("/squads/new", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put ("template", "templates/squads-form.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		//adds new squads with verb post
		// get("/squads", (request, response) -> {
		// 	Map<String, Object> model = new HashMap<String, Object>();
		//
		// })
	}
}
