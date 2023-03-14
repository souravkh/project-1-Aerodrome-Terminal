package cdac.controller;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import cdac.dao.PassengerofflineRepo;
import cdac.model.Customer;
import cdac.model.Employee3P;
import cdac.model.Employeemain;
import cdac.model.Flight;
import cdac.model.Food;
import cdac.model.Luggage;
import cdac.model.Passengeroffline;
import cdac.model.Task;
import cdac.model.Vehicle;
import cdac.service.CustomerService;
import cdac.service.Employee3PService;
import cdac.service.EmployeemainService;
import cdac.service.FlightService;
import cdac.service.FoodService;
import cdac.service.LuggageService;
import cdac.service.PassengerService;
import cdac.service.TaskService;
import cdac.service.VehicleService;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String gethome() {
		return "findflights";
	}
	
	@GetMapping("/")
	public String getslash() {return "findflights";}
	
	@GetMapping("/flight")
	public String getfligt() {return "flights";}
	
	
	@GetMapping("/luggage")
	public String getLuggagehome() {return"luggage";}
	
	@GetMapping("/flighthome")
	public String getflighthome() {return "flighthome";}
	
	
	@Autowired
	private FlightService fser;
	
	@Autowired
	private PassengerService pser;
	
	@Autowired
	private LuggageService lser;
	
	@Autowired
	private Employee3PService e3pser;
	
	@Autowired
	private CustomerService cser;
	
	@Autowired
	private FoodService foodser;
	
	@Autowired
	private VehicleService vser;
	
	@Autowired
	private TaskService tser;
	
	@Autowired
	private EmployeemainService emser;
	
	@GetMapping("/addflight")
	public ModelAndView addFlight() {
		return new ModelAndView("addflight","flight",new Flight());
	}
 
	@PostMapping("/proceesflightaddform")
	public String getsaveFlight(@Valid @ModelAttribute("flight") Flight flight,BindingResult br) {
		if(br.hasErrors()) {return "addflight";}
		else {
		fser.flightSave(flight);
		return "redirect:/flights";}
	}
	
	@RequestMapping("/flights")
	public ModelAndView getFlightList() {
		List<Flight> flist= fser.ShowallFlight();
		return new ModelAndView("fdetails","flist",flist);
	}
	
	 @RequestMapping("/deleteflight/{flight_no}")
	 public String deleteFlight(@PathVariable("flight_no")String flight_no)
		{
			fser.deleteFlight(flight_no);
			return "redirect:/flights";
		}
	 
		@RequestMapping("/searchflight/{flight_no}")
		public ModelAndView editFlight(@PathVariable("flight_no") String  flight_no)
		{
			Flight flight=fser.findflight(flight_no);
			return new ModelAndView("flightupdate","flight",flight);
		}
		
		
		 @PostMapping("/updateflight")
		 public String updateflight(@ModelAttribute Flight flight)
		 {
			 
			 fser.flightSave(flight);
			 return "redirect:/flights";
		 }
		 
		 @GetMapping("/findflights")
		 public String returnFindFlights(){
			 return "findflights";
		 }
		 
		 @PostMapping("/proceesflightfindform")
		 public ModelAndView processsflightfind(@RequestParam String source,@RequestParam String destination){
			 List<Flight> sdflightlist= fser.showFlightsource2destination(source, destination);
			 return new ModelAndView("flightquery","sdflightlist",sdflightlist);
		 }
		 
		 
		 @GetMapping("/bookflight/{flight_no}")
			public String bookflight(@PathVariable String flight_no,Model model) {
				Flight flight=fser.findflight(flight_no);
				model.addAttribute("flight", flight);
				return "bookticket";
			}
			
			@PostMapping("/processbookofflineform")
			public String bookticket(@RequestParam String first_name,@RequestParam String last_name,
			@RequestParam String mobile_no,	@RequestParam String flight_no ) {
				Passengeroffline passengeroffline = new Passengeroffline();
				passengeroffline.setAmount(1000);
				passengeroffline.setFirst_name(first_name);
				passengeroffline.setLast_name(last_name);
				passengeroffline.setMobile_no(mobile_no);
				passengeroffline.setFlight(fser.findflight(flight_no));
				pser.savepassenger(passengeroffline);
				fser.flightupdateavailable(flight_no);
				return "PAYMENTgateway";
			}
			
			@GetMapping("/PAYMENTgateway")
			public String getpaymentgateway() {return "PAYMENTgateway";}
			
			@GetMapping("/passengerlist")
			public ModelAndView getPassengerList() {
				List<Passengeroffline> listofpassenger=pser.showallpassenger();
				return new ModelAndView("passengerlist","listofpassenger",listofpassenger);
			}
			
			@GetMapping("/passenger")
			public String getPassenger() {
				return"passenger";
			}
			
			
			@GetMapping("/delete/{passenger_id}")
			public String getdeletepassengerbooking(@PathVariable("passenger_id") int passenger_id){
				int k=passenger_id;
				pser.deletepassenger(k);
				return "redirect:/passengerlist";
			}
			
			@GetMapping("/findticket")
			public String findticket() {return "findticket";}
			
			@PostMapping("/printticket")
			public String printticket(@RequestParam int passenger_id,Model model) {
				Passengeroffline passengeroffline=pser.findusingpassengerofflineid(passenger_id);
				model.addAttribute("passengeroffline", passengeroffline);
				if(passengeroffline==null) {return "redirect:/pagenotfound";}//nothing found
				else{return "printticket";}
			}
	
			@GetMapping("/findpassengerforluggage")
			public String getpassenger() {return "findpassengerforluggage";}
			
			@PostMapping("/bookluggage")
			public ModelAndView bookluggage(@RequestParam int passenger_id) {
				Luggage l = new Luggage();
				l.setPassenger(pser.findusingpassengerofflineid(passenger_id));
				lser.saveLuggage(l);
				List<Luggage> llist=lser.findLuaggagebypassengerid(passenger_id);
				return new ModelAndView("luggagebookedpage","llist",llist);
			}
			
			@GetMapping("/luggagelist")
			public ModelAndView getluggagelist() {
				List <Luggage> llist=lser.getallluggage();
				return new ModelAndView("luggagelist","llist",llist);
			}
			
			@GetMapping("/registercustomer")
			public ModelAndView getcustomerregistrationp() {
				return new ModelAndView("registercustomer","customer",new Customer());
			}
			
			@PostMapping("/processregistercustomer")
			public ModelAndView getprocessregistercustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult br) {
				if(br.hasErrors()) { return new ModelAndView("registercustomer","customer",customer);}
				else {	
					cser.saveCustomer(customer);
				return new ModelAndView("orderfood","customer",customer);}
			}
			
			
			@PostMapping("/processorderfood")
			public ModelAndView getprocessfood(@RequestParam int customer_id,
					@RequestParam String food_name,@RequestParam int price){
				Food f=new Food();
				Customer customer=cser.findbycustomerid(customer_id);
				f.setCustomer(customer);
				f.setFood_name(food_name);
				f.setPrice(price);
				int v=customer_id;
				foodser.savefooditems(f);
				return new ModelAndView("orderfood","customer",customer);
				
			}
			
			
			
			
			 @GetMapping("/listfood")
			 public ModelAndView getfoodlist() { 
				 List<Food>
			 flist=foodser.showall(); 
				 return new ModelAndView("listfood","flist",flist); }
			 
			@GetMapping("/services")
			public String getService() {return "services";}
			
			@GetMapping("/pagenotfound")
			public String getPagenotfound() {return "pagenotfound";}
			
			@GetMapping("/customerlist")
			public ModelAndView getcustomerlist() {
				List<Customer> clist=cser.showallcustomer();
				return new ModelAndView("customerlist","clist",clist);
			}
			
			@GetMapping("/error")
			public String getNoerror() {return "pagenotfound";}
			
			@GetMapping("/empmain")
			public String getEmpmain() {return"empmain";}
			@GetMapping("/parkinghome")
			public String getParkinghome() {return "parkinghome";}
			
			@GetMapping("/parking")
			public ModelAndView getform()
			{
				return new ModelAndView("parking","vehicle",new Vehicle());
			}
			
			@RequestMapping(value= "proceesvehicleform" , method=RequestMethod.POST)
			public String getregister(@Valid @ModelAttribute("vehicle") Vehicle vehicle,BindingResult br)
			{
				if(br.hasErrors()) { return "parking";}
				else {
				vser.savevehicle(vehicle);
				vser.updateAmount(vehicle.getVehicle_no(),vehicle.getDate_from(),
						vehicle.getDate_to(),vehicle.getFrom_time(), vehicle.getTo_time());
				return "/parkinghome";
				}
			}
			
			@GetMapping("/findvehicle")
			public String getfindvehicle()
			{
				return "findvehicle";
			}
			
			@RequestMapping("/findvehicleform")
			public String getvehicle(@RequestParam String vehicle_no,Model model)
			{				
				Vehicle vehicle=vser.validate(vehicle_no);	
				if(vehicle==null) {return "redirect:/findvehicle";}
				else {model.addAttribute("vehicle", vehicle);
				return "vehiclefindresult";}
				
				}
			
			
			
			@GetMapping("/findvehiclebydate")
			public String getfindvehiclebydate()
			{
				return "findvehiclebydate";
			}
			
			@RequestMapping("/proceesvehicledateform")
			public ModelAndView proceesvehicledateform(@RequestParam String date_from,
					@RequestParam String date_to)
			{
				Date df= Date.valueOf(date_from);
				Date dt=Date.valueOf(date_to);
				List<Vehicle> listbydate = vser.getVehiclebyDate(df, dt);
				return new ModelAndView("vdetailsbydate","listbydate",listbydate);
			}
			

			
			
			@RequestMapping("/vehiclelist")
			public ModelAndView getlist()
			{
				List<Vehicle> vlist=vser.showall();
				return new ModelAndView("vehiclelist","vlist",vlist);
			}
			
			@RequestMapping("/deletevehicle/{vehicle_no}")
			public String deletevehicle(@PathVariable("vehicle_no")String vehicle_no)
			{
				vser.delete(vehicle_no);
				return "redirect:/vehiclelist";
			}
			
			@RequestMapping("/searchvehicle/{vehicle_no}")
			public ModelAndView editstudent(@PathVariable("vehicle_no") String  vehicle_no)
			{
				Vehicle vehicle=vser.validate(vehicle_no);
				return new ModelAndView("update","vehicle",vehicle);
			}
			
			
			 @RequestMapping(value="/updatevehicle", method=RequestMethod.POST)
			 public String update(@ModelAttribute Vehicle vehicle)
			 {
				 
				vser.update(vehicle);
				 vser.updateAmount(vehicle.getVehicle_no(),vehicle.getDate_from(), vehicle.getDate_to(), vehicle.getFrom_time(), vehicle.getTo_time());
				 return "redirect:/vehiclelist";
			 }
			
			 @GetMapping("/3rdpartyemployee")
			 public String get3rpartymodule() {
				 return "3rdpartyemployee";
			 }
			 
			 @GetMapping("/3rdpartyEmployeelogin")
			 public ModelAndView get3rdpartyempregistation() {
				 return new ModelAndView("3rdpartyEmployeelogin","employee3P",new Employee3P());
			 }
			 
			 @RequestMapping(value="/3pemployeeregistationform",method=RequestMethod.POST)
			 public String getprocess3pemp(@Valid @ModelAttribute("employee3P") Employee3P employee3P,BindingResult br) {
				 if(br.hasErrors()) {return "/3rdpartyEmployeelogin";}
			 else{e3pser.save(employee3P);
				 return "redirect:/3rdpartyemployee";}
			 }
			 
			 @RequestMapping("/3pemplist")
			 public ModelAndView get3emplist() {
				 List<Employee3P> emplist3 = e3pser.showall3pEmployee();
				 return new ModelAndView("3pempdetails","emplist3",emplist3);
			 }
			 

			 @GetMapping("/find3pemployee")
			 public String getfind3pemployee() {
				 return "find3pemployee";
			 }
			 
			 @PostMapping("/proceesfind3pemployeeform")
			 public ModelAndView getprocessfindemployee3p(@RequestParam String employee_id) {
				 Employee3P employee3p=e3pser.find3p(employee_id);
				 if(employee3p==null) {return new ModelAndView("pagenotfound","employee3p",employee3p);}
				 else return new ModelAndView("foundemployee3p","employee3p",employee3p);
			 }
			 
			 
			 @RequestMapping("/delete3pemployee/{employee_id}")
			 public String getdeleteemployee3p(@PathVariable String employee_id) {
				 e3pser.delete(employee_id);
				 return "redirect:/3pemplist";
			 }
			
			 
				@GetMapping("/employeemainform")
				public ModelAndView getEmployeeMainForm() {
					return new ModelAndView("employeemainform","employeemain",new Employeemain());}
				
				@PostMapping("/employeemainregistrationform")
				public String getEmployeemainregistrationform(@Valid @ModelAttribute("employeemain") Employeemain employeemain,BindingResult br ) {
					if(br.hasErrors()) {return "/employeemainform";}
					else{emser.save(employeemain);
					return "redirect:/empmain";}
				}
				
				
				@GetMapping("/employeemainlist")
				public ModelAndView getEmployeeMainList() {
					List<Employeemain> emlist=emser.showall();
					return new ModelAndView("employeemainlist","emlist",emlist);
				}
				
				
				@GetMapping("/searchemployeemain/{employee_no}")
				public ModelAndView getupdateEmployeemain(@PathVariable int employee_no) {
					Employeemain employeemain=emser.findemployee(employee_no);
					return new ModelAndView("updatemployeemain","employeemain",employeemain);
				}
				
				@PostMapping("/processemployeemainupdate")
				public String processemployeemainupdate(@ModelAttribute Employeemain employeemain) {
					emser.save(employeemain);
					return "redirect:/employeemainlist";
				}
				
				@GetMapping("/deleteemployeemain/{employee_no}")
				public String deleteemployeemain(@PathVariable int employee_no) {
					emser.delete(employee_no);
					return "redirect:/employeemainlist";
				}
				
				@GetMapping("/addemployeemaintask/{employee_no}")
				public ModelAndView addtasktoemployeemain(@PathVariable int employee_no) {
					Employeemain employeemain=emser.findemployee(employee_no);
					return new ModelAndView("addtask","employeemain",employeemain);
				}
				
				@PostMapping("/processaddtask")
				public String processaddtask(@RequestParam int employee_no,@RequestParam String task
						,@RequestParam String status) {
					Task t=new Task();
					Employeemain e= emser.findemployee(employee_no);
					Set<Employeemain> s=new HashSet<Employeemain>();
					t.setEmployee(s);
					s.add(e);
					t.setEmployee(s);
					t.setStatus(status);
					t.setTask(task);
					tser.SaveTask(t);
					return"redirect:/employeemainlist";
				}
				
				
				@GetMapping("/alltask")
				public ModelAndView showalltask() {
					List<Task> tlist=tser.showalltask();
					return new ModelAndView("alltask","tlist",tlist);
				}
				
			 
			
}
