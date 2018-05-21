import java.util.HashMap;
import java.util.Map;
import java.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark;

public class App{
    public static void main(String[] args) {
        get("/", (request,response)->{
            Map<String,Object> model = new HashMap<String,Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model , layout);
        }, new VelocityTemplateEngine());
        
       get ("/stylists",(request,response)-.{
           Map<String,Object> model = new HashMap<String,Object>();
           model.put("stylists", Stylist.all());
           model.put(template,"templates/stylist.vtl");
           return new ModelAndView(model, layout);
       },new VelocityTemplateEngine());

       get("/stylist/new",(request, response)->{
           Map<String,Object> model = new HashMap <String,Object>();
           model.put("templates","template/stylistsform.vtl")
           return new ModelAndView(model,layout);
       },new VelocityTemplateEngine());
       post("/stylists" (request,response)->{
           Map<String,Object> model = new HashMap <String,Object>();
           String name = request.queryParams("namee");
           String gender = request.queryParams("gender");
           String  contact= request.queryParams("contact");
           newStylist.save();
           model.put("template","templates/success.vtl");
           return new ModelAndView(model,layout);
       }, new VelocityTemplateEngine());

       get ("/stylists/:id",(request,response)-.{
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("stylists", Stylist.all());
        model.put(template,"templates/stylist.vtl");
        return new ModelAndView(model, layout);
    },  new VelocityTemplateEngine());
    get ("/stylists/:id/client/new",(request,response)->.{
        Map<String,Object> model = new HashMap<String,Object>();
        Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
          model.put("stylist", stylist);
          model.put("stylists", Stylist.all());
        model.put("template", "templates/clientform.vtl");
        return new ModelAndView(model, layout);
    },  new VelocityTemplateEngine());

    }
}
