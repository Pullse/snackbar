package nl.mad.snackbar.controller;

import java.util.List;

import nl.mad.snackbar.model.Snack;
import nl.mad.snackbar.service.SnackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller class for the Snack objects.
 * @author Ruben Zorgman
 */
@Controller
@RequestMapping("/snacks")
public class SnackController {

    private final SnackService snackService;

    /**
     * Creates an instance of SnackController.
     * @param snackService SnackService
     */
    @Autowired
    public SnackController(SnackService snackService) {
        this.snackService = snackService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Snack> findAllSnacks() {
        return snackService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void createSnack(@RequestBody Snack snack){
        snackService.createSnack(snack);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public Snack deleteSnack(@RequestBody Snack snack){
        snackService.deleteSnack(snack);
        return snack;
    }

}
