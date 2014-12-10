package nl.mad.snackbar.controller;

import nl.mad.snackbar.model.Collega;
import nl.mad.snackbar.service.CollegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Ruben on 12/10/2014.
 */
@Controller
@RequestMapping("collegas")
public class CollegaController {

    private final CollegaService collegaService;

    @Autowired
    public CollegaController (CollegaService collegaService){
        this.collegaService = collegaService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Collega> findAllCollegas() {
        return collegaService.findAll();
    }
}
