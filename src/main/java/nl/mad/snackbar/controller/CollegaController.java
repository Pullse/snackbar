package nl.mad.snackbar.controller;

import nl.mad.snackbar.model.Collega;
import nl.mad.snackbar.model.Snack;
import nl.mad.snackbar.service.CollegaService;
import nl.mad.snackbar.service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ruben on 12/10/2014.
 */
@RestController
@RequestMapping("collegas")
public class CollegaController {

    private final CollegaService collegaService;

    @Autowired
    private SnackService snackService;

    @Autowired
    public CollegaController (CollegaService collegaService){
        this.collegaService = collegaService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Collega> findAllCollegas() {
        return collegaService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Collega createCollega(@RequestBody Collega collega) {
        Snack snack = snackService.findSnack(collega.getSnack().getId());
        collega.setSnack(snack);
        return collegaService.createCollega(collega);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Collega deleteCollega(@RequestBody Collega collega){
        collegaService.deleteCollega(collega);
        return collega;
    }
}
