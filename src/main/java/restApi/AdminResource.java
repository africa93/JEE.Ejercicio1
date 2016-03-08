package restApi;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.ADMINS)
public class AdminResource {

    @RequestMapping(value = Uris.STATE, method = RequestMethod.GET)
    public String start() {
        return "{\"response\":\"OK " + Uris.VERSION + "\"}";
    }
    @RequestMapping(value = Uris.ECHO + Uris.ID, method = RequestMethod.GET)
    public String echo(@RequestHeader(value = "token", required = false) String token, @PathVariable(value = "id") int id,
            @RequestParam(defaultValue = "Non") String param) {
        String response = "{\"id\":%d,\"token\":\"%s\",\"param\":\"%s\"}";
        return String.format(response, id, token, param);
    }

    @RequestMapping(value = Uris.BODY, method = RequestMethod.POST)
    public Wrapper body(@RequestBody Wrapper wrapper) {
        return wrapper;
    }
    
    @RequestMapping(value = Uris.BODY + Uris.STRING_LIST, method = RequestMethod.GET)
    public List<String> bodyStringList() {
        return Arrays.asList("uno", "dos", "tres");
    }

    @RequestMapping(value = Uris.BODY + Uris.WRAPPER_LIST, method = RequestMethod.GET)
    public List<Wrapper> bodyWrapperList() {
        Wrapper wrapper1 = new Wrapper(666, "daemon", Gender.FEMALE, new GregorianCalendar(1979, 07, 22));
        Wrapper wrapper2 = new Wrapper(999, "last", Gender.MALE, new GregorianCalendar(1979, 07, 22));
        Wrapper wrapper3 = new Wrapper(000, "first", Gender.FEMALE, new GregorianCalendar(1979, 07, 22));
        return Arrays.asList(wrapper1, wrapper2, wrapper3);
    }

}
