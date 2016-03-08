package restApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.ADMIN)
public class MyResource {
	@RequestMapping(value = Uris.DIVISION, method = RequestMethod.GET)
    public double echo(@RequestParam(value="dividendo", required = true) int param1,
    		@RequestParam(value="divisor", required = true) int param2) {
        return param1/param2;
    }
	
	@RequestMapping(value=Uris.CALCULADORA2, method = RequestMethod.POST)
	public double body(@RequestBody Fraccion fraccion){
		return fraccion.getDividendo()/fraccion.getDivisor();
	}
	
	@RequestMapping(value=Uris.CALCULADORA3, method = RequestMethod.POST)
	public ArrayList<Double> bodyDoubleList(@RequestBody List<Fraccion> fracciones){
		ArrayList<Double> results = new ArrayList<Double>();
		for(int i=0; i<fracciones.size(); i++){
			double result = fracciones.get(i).getDividendo()/fracciones.get(i).getDivisor();
			results.add(result);
		}
		return results;
	}
	
}
