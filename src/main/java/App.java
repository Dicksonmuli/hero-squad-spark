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
		post("/squads", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			String team = request.queryParams("team");
			String reason = request.queryParams("reason");
			Integer max = Integer.parseInt(request.queryParams("max"));
			Squad newSquad = new Squad(team, max, reason);
			model.put("template", "templates/squad-success.vtl");
			// System.out.println(newSquad);
			// response.redirect("/squads/"+newSquad.getId());
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		//details of a specific squad
		get("/squads/:id", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
			model.put("squad", squad);
			model.put("template", "templates/squad.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("squads/:id/heroes/new", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
			model.put("squad", squad);
			model.put("template", "templates/hero-form.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		//heroes route-adding heroes to a squad
		post("/heroes", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			Integer squadId = Integer.parseInt(request.queryParams("squadId"));
			Squad squad = Squad.find(squadId);
			//params from heroes form
			String name = request.queryParams("name");
			int age = Integer.parseInt(request.queryParams("age"));
			String strength = request.queryParams("strength");
			String weakness = request.queryParams("weakness");
			Hero newHero = new Hero(name, age, strength, weakness);
			squad.addHero(newHero);

			model.put("squad", squad);
			response.redirect("/squads/" + squadId);
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		//search route
		get("squads/search", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("template", "templates/search.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
	}
}
