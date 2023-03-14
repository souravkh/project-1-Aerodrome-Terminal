package cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cdac.model.Flight;
import cdac.service.FlightService;
import jakarta.validation.Valid;
//@Controller
//@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService fser;
	

	@GetMapping("/flight/addflight")
	public ModelAndView addFlight() {
		return new ModelAndView("addflight","flight",new Flight());
	}
 
	@PostMapping("/proceesflightaddform")
	public String getsaveFlight(@Valid @ModelAttribute Flight flight,BindingResult br) {
		if(br.hasErrors()) {return "addflight";}
		else {
		fser.flightSave(flight);
		return "/flights/addflight";}
	}
	
	@RequestMapping("/flights")
	public ModelAndView getFlightList() {
		List<Flight> flist= fser.ShowallFlight();
		return new ModelAndView("fdetails","flightlist",flist);
	}
	
	
	@RequestMapping("/searchflight/{flight_no}")
	public ModelAndView editFlight(@PathVariable("flight_no") String  flight_no)
	{
		Flight flight=fser.findflight(flight_no);
		return new ModelAndView("flightupdate","command",flight);
	}
	
	
	 @PostMapping("/updateflight")
	 public String updateflight(@ModelAttribute Flight flight)
	 {
		 
		 fser.flightSave(flight);
		 return "redirect:/flights";
	 }
	
	 @RequestMapping("/deleteflight/{flight_no}")
	 public String deleteFlight(@PathVariable("flight_no")String flight_no)
		{
			fser.deleteFlight(flight_no);
			return "redirect:/flights";
		}
	 
	 @GetMapping("/findflights")
	 public String returnFindFlights(){
		 return "findflights";
	 }
	 
	 @PostMapping("/proceesflightfindform")
	 public ModelAndView processsflightfind(@RequestParam String source,@RequestParam String destination){
		 List<Flight> sdflightlist= fser.showFlightsource2destination(source, destination);
		 return new ModelAndView("flightquery","sdlist",sdflightlist);
	 }
	
}
