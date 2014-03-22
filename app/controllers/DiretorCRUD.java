package controllers;

import com.avaje.ebean.Ebean;
import models.Diretor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.helper.form;

import java.util.List;

/**
 * Created by danilo on 15/03/14.
 */
public class DiretorCRUD extends Controller {

    private static Form<Diretor> formDiretor = Form.form(Diretor.class);

    public static Result lista(){
        List<Diretor> diretores = Ebean.find(Diretor.class).findList();
        return ok(views.html.diretor.lista.render(diretores));
    }

    public static Result novo(){
        return ok(views.html.diretor.novo.render(formDiretor));
    }

    public static Result detalhar(Long id){
        Diretor diretor = Ebean.find(Diretor.class,id);
        Form<Diretor> form = Form.form(Diretor.class).fill(diretor);
        return ok(views.html.diretor.editar.render(id,form));
    }

    public static Result gravar(){
        Form<Diretor> form = formDiretor.bindFromRequest();
        if(form.hasErrors()){
            flash("erro","Foram identificados problemas no cadastro");
            return ok(views.html.diretor.novo.render(form));
        }
        Diretor diretor = form.get();
        diretor.save();
        flash("sucesso","Registro gravado com sucesso");
        return redirect(routes.DiretorCRUD.lista());
    }

    /*public static Result editar(){
        Form<Diretor> diretorForm = Form.form(Diretor.class).bindFromRequest();
        if (diretorForm.hasErrors()){
            return badRequest(views.html.diretor.editar.render())
        }

    }*/

}
