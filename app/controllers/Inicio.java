package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by danilo on 15/03/14.
 */
public class Inicio extends Controller {

    public static Result index(){
        return ok(views.html.inicio.render());
    }
}
