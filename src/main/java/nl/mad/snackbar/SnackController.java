package nl.mad.snackbar;

import java.util.List;

import nl.mad.snackbar.model.Snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
     * Creates an instance of SynchController.
     * @param synchService SynchService
     */
    @Autowired
    public SnackController(SnackService snackService) {
        this.snackService = snackService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Snack> getAllSnacks() {
        return snackService.findAll();
    }

}
